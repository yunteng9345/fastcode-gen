package main

import "strings"

func getTableStructOracleSql(tables []string) (sqls []string) {
	for _, t := range tables {
		s := "SELECT t.table_name, initcap(t.colUMN_NAME), t.DATA_TYPE || '(' || t.DATA_LENGTH || ')'," +
			" t1.COMMENTS FROM User_Tab_Cols t,  User_Col_Comments t1 WHERE t.table_name = t1.table_name  " +
			" AND t.column_name = t1.column_name(+)  AND t.table_name = '" + strings.TrimSpace(t) + "' order by" +
			" t.column_id asc"
		sqls = append(sqls, s)
	}
	return
}
