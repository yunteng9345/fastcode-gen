package main

import (
	"fastcode-gen/core/mapper"
	"fastcode-gen/core/model"
	"fastcode-gen/core/service"
	"fastcode-gen/core/test"
	"fastcode-gen/core/xml"
	"fastcode-gen/utils"
	"log"
	"strings"

	conf "fastcode-gen/config"
	"fastcode-gen/db"
	"fastcode-gen/db/oracle"
)

func main() {
	//author := ""
	//packageName := "com.jlpay.manage.sim"
	generateFolder("./out/")
	tables := GetTable()
	for _, table := range tables {
		model.GenModelCode(table)
		service.GenServiceCode(table)
		mapper.GenMapperCode(table)
		xml.GenXmlCode(table)
		test.GenTestCode(table)
		//controller.GenServiceCode(table)
	}
}

func GetTable() []db.Table {
	t := strings.Split(conf.Config.Tables, ",")
	sqls := getTableStructOracleSql(t)
	DB := oracle.GetDB()
	var tables []db.Table
	for _, sql := range sqls {
		var table db.Table
		table.Author = conf.Config.Author
		rows, err := DB.Query(sql)
		if err != nil {
			log.Fatal("connect database fail!", err)
		}
		defer rows.Close()
		var tableStructs []db.TableStruct
		for rows.Next() {
			var tableStruct db.TableStruct
			err := rows.Scan(&table.Name, &tableStruct.Column, &tableStruct.Type, &tableStruct.Comment)
			if err != nil {
				log.Fatal(err)
			}
			table.TableName = table.Name
			tableStruct.OriColumn = strings.ToUpper(tableStruct.Column)
			table.Name = utils.Case2Camel(table.Name)[1:]
			tableStruct.Name = utils.Case2Camel(table.Name)[1:]
			table.LowName = utils.LowerFirst(table.Name)
			tableStruct.LowName = utils.LowerFirst(table.Name)
			tableStruct.FirstUpperName = strings.ReplaceAll(tableStruct.Column, "_", "")
			tableStruct.Column = utils.LowerFirst(strings.ReplaceAll(tableStruct.Column, "_", ""))
			tableStruct.Type = utils.GetType(tableStruct.Type)
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
