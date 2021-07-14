package utils

import (
	"os"
	"strings"
	"unicode"
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

// 下划线写法转为驼峰写法
func Case2Camel(name string) string {
	// lower all case
	name = strings.ToLower(name)
	// rm "T_"
	name = strings.ReplaceAll(name, "T_", " ")
	name = strings.Replace(name, "_", " ", -1)

	name = strings.Title(name)
	return strings.Replace(name, " ", "", -1)
}

// 首字母大写
func UpperFirst(str string) string {
	for i, v := range str {
		return string(unicode.ToUpper(v)) + str[i+1:]
	}
	return ""
}

// 首字母小写
func LowerFirst(str string) string {
	for i, v := range str {
		return string(unicode.ToLower(v)) + str[i+1:]
	}
	return ""
}

func GetType(tp string) string {
	if strings.Contains(tp, "DATE") {
		return "Date"
	} else if strings.Contains(tp, "NUMBER") {
		return "BigDecimal"
	} else {
		return "String"
	}
}
