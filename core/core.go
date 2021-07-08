package main

import (
	"fastcode-gen/utils"
	"fmt"
	"log"

	"fastcode-gen/db"
	"fastcode-gen/db/oracle"
)

func main() {
	tables := GetTable()
	for _, table := range tables {
		//todo generate folder
		//todo generate code
		fmt.Println(table)
	}
	//fmt.Println("dbname:", conf.Config.Db.Dbname)
}

func GetTable() []*db.Table {
	t := []string{"T_SIM_CARD_DEVICE_PKG", "T_SIM_CRAD_HISTORY_FLOW_202104"}
	sql := getTableStructSql(t)
	var tables []*db.Table
	DB := oracle.GetDB()
	rows, err := DB.Query(sql)
	if err != nil {
		log.Fatal("connect database fail!", err)
	}
	defer DB.Close()
	defer rows.Close()
	for rows.Next() {
		var table db.Table
		err := rows.Scan(&table.Name, &table.Column, &table.Type, &table.Column)
		if err != nil {
			log.Fatal(err)
		}
		tables = append(tables, &table)
	}
	err = rows.Err()
	if err != nil {
		log.Fatal(err)
	}
	return tables
}

func getTableStructSql(t []string) string {
	tableNames := utils.GetInSqlTableNames(t)
	return "SELECT t.table_name, initcap(t.colUMN_NAME), t.DATA_TYPE || '(' || t.DATA_LENGTH || ')', t1.COMMENTS FROM User_Tab_Cols t,  User_Col_Comments t1 WHERE t.table_name = t1.table_name   AND t.column_name = t1.column_name(+)  AND t.table_name in (" + tableNames + ") order by t.column_id asc"
}
