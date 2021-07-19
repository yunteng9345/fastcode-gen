package mysql

import (
	"database/sql"
	conf "fastcode-gen/config"
	"fastcode-gen/utils"
	"fmt"
	_ "github.com/go-sql-driver/mysql"
	"log"
)

// Db数据库连接池
var DB *sql.DB

// get oracle DB connect
func GetDB() *sql.DB {
	return DB
}

// 注意方法名大写，就是public
func init() {
	if !utils.IsMysql(conf.Config.Db.Dialect) {
		return
	}
	// 构建连接："用户名:密码@tcp(IP:端口)/数据库?charset=utf8"
	fmt.Println(conf.Config)

	path := fmt.Sprintf("%s:%s@tcp(%s:%s)/%s?charset=utf8", conf.Config.Db.User, conf.Config.Db.Password, conf.Config.Db.Ip,
		conf.Config.Db.Port, conf.Config.Db.Dbname)

	log.Println(path)
	// 打开数据库,前者是驱动名，所以要导入： _ "github.com/go-sql-driver/mysql"
	DB, _ = sql.Open("mysql", path)
	// 设置数据库最大连接数
	DB.SetConnMaxLifetime(100)
	// 设置上数据库最大闲置连接数
	DB.SetMaxIdleConns(10)
	// 验证连接
	if err := DB.Ping(); err != nil {
		log.Println("connect mysql database fail!")
		return
	}
	log.Println("connect mysql database success!")
}
