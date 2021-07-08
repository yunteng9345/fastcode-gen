package oracle

import (
	"database/sql"
	"fmt"
	"testing"

	_ "github.com/godror/godror"
)

func TestOracleConnect(t *testing.T) {
	// 用户名/密码@IP:端口/实例名
	osqlInfo := fmt.Sprintf("%s/%s@%s:%d/%s", nil, nil, nil, nil, nil)
	fmt.Println(osqlInfo)
	db, err := sql.Open("godror", osqlInfo)
	if err != nil {
		panic(err)
	}
	defer db.Close()
	err = db.Ping()
	if err != nil {
		panic(err)
	}
	fmt.Println("链接成功")
}
