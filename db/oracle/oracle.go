package oracle

import (
	"database/sql"
	"fmt"
	"log"

	conf "fastcode-gen/config"
	_ "github.com/godror/godror"
)

var DB *sql.DB

// get oracle DB connect
func GetDB() *sql.DB {
	return DB
}

func init() {
	// 用户名/密码@IP:端口/实例名
	osqlInfo := fmt.Sprintf("%s/%s@%s:%s/%s", conf.Config.Db.User, conf.Config.Db.Password, conf.Config.Db.Ip,
		conf.Config.Db.Port, conf.Config.Db.Dbname)
	log.Println(osqlInfo)
	DB, _ = sql.Open("godror", osqlInfo)
	//defer DB.Close()
	if err := DB.Ping(); err != nil {
		log.Println("connect oracle database fail!")
		return
	}
	log.Println("connect oracle database success!")
}
