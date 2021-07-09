package main

import (
	"log"
	"strings"

	conf "fastcode-gen/config"
	"fastcode-gen/db"
	"fastcode-gen/db/oracle"
)

func main() {
	//author := ""
	//packageName := "com.jlpay.manage.sim"
	generateFolder(conf.Config.FilePath)
	tables := GetTable()
	for _, table := range tables {
		log.Println(table)
		log.Println("-------------")
		//generateFile(table, filePath, author, packageName)
	}
}

func GetTable() []db.Table {
	t := strings.Split(conf.Config.Tables, ",")
	sqls := getTableStructOracleSql(t)
	DB := oracle.GetDB()
	var tables []db.Table
	for _, sql := range sqls {
		var table db.Table
		rows, err := DB.Query(sql)
		if err != nil {
			log.Fatal("connect database fail!", err)
		}
		defer rows.Close()
		var tableStructs []db.TableStruct
		for rows.Next() {
			var tableStruct db.TableStruct
			err := rows.Scan(&tableStruct.Name, &tableStruct.Column, &tableStruct.Type, &tableStruct.Comment)
			if err != nil {
				log.Fatal(err)
			}
			tableStructs = append(tableStructs, tableStruct)
		}
		table.TableStruct = append(table.TableStruct, tableStructs...)
		tables = append(tables, table)
		err = rows.Err()
		if err != nil {
			log.Fatal(err)
		}
	}
	defer DB.Close()
	return tables
}
