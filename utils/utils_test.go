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

func TestFirstCast2Lower(t *testing.T) {
	require := require.New(t)
	str := "IccId"
	var upperStr string
	vv := []rune(str) // 后文有介绍
	for i := 0; i < len(vv); i++ {
		if i == 0 {
			vv[i] -= 32 // string的码表相差32位
		}
		upperStr += string(vv[i])
	}
	require.Equal("iccId", upperStr)
}
