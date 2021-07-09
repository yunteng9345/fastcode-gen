package utils

import (
	"os"
	"strings"
)

// get split table name
func GetInSqlTableNames(tableNames []string) string {
	if len(tableNames) == 0 {
		return ""
	}
	var sqlInTable string
	for _, table := range tableNames {
		sqlInTable += "'" + strings.TrimSpace(table) + "',"
	}
	return sqlInTable[:len(sqlInTable)-1]
}

// 判断文件、文件夹是否存在
func PathExists(path string) (bool, error) {
	_, err := os.Stat(path)
	if err == nil {
		return true, nil
	}
	if os.IsNotExist(err) {
		return false, nil
	}
	return false, err
}
