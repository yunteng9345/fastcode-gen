package db

// table struct
type Table struct {
	Author      string
	Name        string
	TableStruct []TableStruct
}

type TableStruct struct {
	Column  string
	Type    string
	Comment string
}
