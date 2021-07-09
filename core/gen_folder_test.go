package main

import (
	conf "fastcode-gen/config"
	"fastcode-gen/utils"
	"fmt"
	"log"
	"os"
	"testing"
)

func TestGenerateFolder(t *testing.T) {
	filePath := conf.Config.FilePath
	filePaths := []string{filePath + "\\model", filePath + "\\service", filePath + "\\mapper", filePath + "\\xml"}
	for _, folderPath := range filePaths {
		exist, err := utils.PathExists(folderPath)
		if err != nil {
			log.Fatal(err.Error())
		} else {
			if exist {
				log.Println(filePath, "文件夹已存在！")
			} else {
				// 文件夹名称，权限
				err := os.Mkdir(folderPath, os.ModePerm)
				if err != nil {
					fmt.Println(folderPath+"文件夹创建失败：", err)
				} else {
					fmt.Println(folderPath + "文件夹创建成功！")
				}
			}
		}
	}
}
