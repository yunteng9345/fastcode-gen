package mysql

import (
	"database/sql"
	conf "fastcode-gen/config"
	"log"
	"strings"

	_ "github.com/go-sql-driver/mysql"
)

const (
	userName = "loan"
	password = "JLpaymysql8.0!"
	ip       = "172.20.2.131"
	port     = "3506"
	dbName   = "score"
)

// Db数据库连接池
var DB *sql.DB

// get mysql DB
func GetDb() *sql.DB {
	return DB
}

// 注意方法名大写，就是public
func MysqlInit() {
	// 构建连接："用户名:密码@tcp(IP:端口)/数据库?charset=utf8"
	path := strings.Join([]string{conf.Config.Db.User, ":", conf.Config.Db.Password, "@tcp(", conf.Config.Ip, ":",
		conf.Config.Db.Port, ")/", conf.Config.Db.Dbname, "?charset=utf8"}, "")
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
