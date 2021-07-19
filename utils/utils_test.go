package utils

import (
	"strings"
	"testing"

	"github.com/stretchr/testify/require"
)

// 下划线写法转为驼峰写法
func TestCase2Camel(t *testing.T) {
	require := require.New(t)
	// lower all case
	name := "T_SIM_CARD_DEVICE_PKG"
	name = strings.ToLower(name)
	// rm "T_"
	name = strings.ReplaceAll(name, "T_", "")

	name = strings.Replace(name, "_", " ", -1)

	//name = strings.Title(name)
	require.Equal("SimCardDevicePkg", name)
}

func TestUpperToCamel(t *testing.T) {
	require := require.New(t)
	str := "TERM_NO"
	require.Equal("Term_No", UpperToCamel(str))
}
