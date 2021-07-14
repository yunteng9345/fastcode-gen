package test

import (
	"fastcode-gen/db"
	"fmt"
	"log"
	"os"
	"text/template"
)

func GenTestCode(table db.Table) {
	tmpl, err := template.ParseFiles("./template/XXXServiceTest.java")
	if err != nil {
		fmt.Println("Error happened..")
	}
	out, err := os.Create("./out/test/" + table.Name + "ServiceTest.java")
	defer out.Close()
	if err != nil {
		log.Println("create file: ", err)
		return
	}
	tmpl.Execute(out, table)
}
