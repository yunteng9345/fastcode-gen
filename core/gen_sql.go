package main

import (
	"fastcode-gen/utils"
	"strings"
)

func getTableStructSql(tables []string, dialect string) (sqls []string) {
	if utils.IsMysql(dialect) {
		for _, t := range tables {
			s := "SELECT table_name, colUMN_NAME, concat(DATA_TYPE, IF(CHARACTER_MAXIMUM_LENGTH IS NULL," +
				" '', CONCAT('(', CHARACTER_MAXIMUM_LENGTH, ')'))), COLUMN_COMMENT FROM information_schema.columns" +
				" WHERE table_schema = 'eu_posp_risk'  AND table_name = '" + strings.TrimSpace(t) + "'"
			sqls = append(sqls, s)
		}
	} else {
		for _, t := range tables {
			s := "SELECT t.table_name, initcap(t.colUMN_NAME), t.DATA_TYPE || '(' || t.DATA_LENGTH || ')'," +
				" t1.COMMENTS FROM User_Tab_Cols t,  User_Col_Comments t1 WHERE t.table_name = t1.table_name  " +
				" AND t.column_name = t1.column_name(+)  AND t.table_name = '" + strings.TrimSpace(t) + "' order by" +
				" t.column_id asc"
			sqls = append(sqls, s)
		}
	}
	return
}
