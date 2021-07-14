package db

// table struct
type Table struct {
	Author string
	// SIM_CARD_DEVICE_PKG
	TableName string
	// SimCardDevicePkg
	Name string
	// simCardDevicePkg
	LowName     string
	TableStruct []TableStruct
}

type TableStruct struct {
	Column    string
	OriColumn string
	Type      string
	Comment   string
}
