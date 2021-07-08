package utils

// get split table name
func GetInSqlTableNames(tableNames []string) string {
	if len(tableNames) == 0 {
		return ""
	}
	var sqlInTable string
	for _, table := range tableNames {
		sqlInTable += "'" + table + "',"
	}
	return sqlInTable[:len(sqlInTable)-1]
}
