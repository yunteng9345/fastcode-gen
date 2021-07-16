package db

// table struct
type Table struct {
	Author string
	// SIM_CARD_DEVICE_PKG
	TableName string
	// SimCardDevicePkg
	Name string
	Time string
	// simCardDevicePkg
	LowName     string
	TableStruct []TableStruct
}

type TableStruct struct {
	Column         string
	OriColumn      string
	Name           string
	FirstUpperName string
	LowName        string
	Type           string
	Comment        string
}
