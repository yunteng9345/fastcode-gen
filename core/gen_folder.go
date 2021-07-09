package main

import (
	"fastcode-gen/db"
	"fastcode-gen/utils"
	"fmt"
	"log"
	"os"
)

func generateFolder(filePath string) {
	filePaths := []string{filePath + "model", filePath + "service", filePath + "mapper", filePath + "xml"}
	for _, folderPath := range filePaths {
		exist, err := utils.PathExists(folderPath)
		if err != nil {
			log.Fatal(err.Error())
		} else {
			if exist {
				log.Println(folderPath, "文件夹已存在！")
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

func generateFile(table db.Table, filePath, author, name string) {
	//for i := 0; i < 4; i++ {
	//if i == 0 {
	//	filePath = filePath + "\\model"
	//} else if i == 1 {
	//	filePath = filePath + "\\service"
	//} else if i == 2 {
	//	filePath = filePath + "\\mapper"
	//} else if i == 3 {
	//	filePath = filePath + "\\xml"
	//}

	//}
}
