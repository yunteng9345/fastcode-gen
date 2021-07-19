package main

import (
	"database/sql"
	"log"
	"strings"
	"time"

	conf "fastcode-gen/config"
	"fastcode-gen/core/mapper"
	"fastcode-gen/core/model"
	"fastcode-gen/core/service"
	"fastcode-gen/core/test"
	"fastcode-gen/core/xml"
	"fastcode-gen/db"
	"fastcode-gen/db/mysql"
	"fastcode-gen/db/oracle"
	"fastcode-gen/utils"
)

func main() {
	generateFolder("./out/")
	tables := GetOracleTable()
	for _, table := range tables {
		model.GenModelCode(table)
		service.GenServiceCode(table)
		mapper.GenMapperCode(table)
		xml.GenXmlCode(table)
		test.GenTestCode(table)
		//controller.GenServiceCode(table)
	}
}

func GetDialect() (DB *sql.DB, sqls []string) {
	t := strings.Split(conf.Config.Tables, ",")
	sqls = getTableStructSql(t, conf.Config.Db.Dialect)
	if utils.IsMysql(conf.Config.Db.Dialect) {
		DB = mysql.GetDB()
	} else {
		DB = oracle.GetDB()
	}
	return
}

func GetOracleTable() []db.Table {
	DB, sqls := GetDialect()
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
			if utils.IsMysql(conf.Config.Db.Dialect) {
				tableStruct.Column = utils.UpperToCamel(tableStruct.Column)
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
			table.Time = time.Now().Format("2006-01-02 15:04:05")
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
