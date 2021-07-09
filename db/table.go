package db

// table struct
type Table struct {
	TableStruct []TableStruct
}

type TableStruct struct {
	Name    string
	Column  string
	Type    string
	Comment string
}

func main() {
	var tables []Table

	var table Table
	var tableStruct1 TableStruct
	tableStruct1.Comment = "Comment"
	tableStruct1.Column = "Column"
	tableStruct1.Type = "type"
	tableStruct1.Name = "name"

	var tableStruct2 TableStruct
	tableStruct2.Comment = "Comment"
	tableStruct2.Column = "Column"
	tableStruct2.Type = "type"
	tableStruct2.Name = "name"

	table.TableStruct = append(table.TableStruct, tableStruct1)
	table.TableStruct = append(table.TableStruct, tableStruct2)

	var tablesStructs []TableStruct
	tablesStructs = append(tablesStructs, tableStruct1)
	tablesStructs = append(tablesStructs, tableStruct2)

	tables = append(tables, table)

}
