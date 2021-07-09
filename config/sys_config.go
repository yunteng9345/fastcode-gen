package conf

import (
	"fmt"
	"gopkg.in/yaml.v2"
	"io/ioutil"
)

var Config = &config{}

func init() {
	config, err := ioutil.ReadFile("./conf.yaml")
	if err != nil {
		fmt.Print(err)
	}
	yaml.Unmarshal(config, &Config)
}

type config struct {
	FilePath string `yaml:"filePath"`
	Author   string `yaml:"author"`
	Tables   string `yaml:tables`
	Db       DBConf `yaml:db`
}

type DBConf struct {
	Dialect  string `yaml:dialect`
	Ip       string `yaml:"ip"`
	Port     string `yaml:"port"`
	User     string `yaml:user`
	Password string `yaml:"password"`
	Dbname   string `yaml:"dbname"`
}
