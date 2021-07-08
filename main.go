package main

import (
	"log"

	"fastcode-gen/db"
	"fastcode-gen/db/oracle"
)

func main() {
	tableName := "T_SIM_CARD_DEVICE_PKG"
	sql := "SELECT t.table_name, initcap(t.colUMN_NAME), t.DATA_TYPE || '(' || t.DATA_LENGTH || ')', t1.COMMENTS FROM User_Tab_Cols t,  User_Col_Comments t1 WHERE t.table_name = t1.table_name   AND t.column_name = t1.column_name(+)  AND t.table_name = NLS_UPPER('" + tableName + "') order by t.column_id asc"
	var table db.Table
	db := oracle.GetDB()
	rows, err := db.Query(sql)
	if err != nil {
		log.Fatal("connect mysql database fail!", err)
	}
	defer db.Close()
	defer rows.Close()
	for rows.Next() {
		err := rows.Scan(&table.Name, &table.Column, &table.Type, &table.Column)
		if err != nil {
			log.Fatal(err)
		}
		log.Println(table.Name, table.Column, table.Type, table.Column)
	}
	err = rows.Err()
	if err != nil {
		log.Fatal(err)
	}
}
