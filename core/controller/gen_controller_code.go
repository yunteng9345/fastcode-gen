package controller

import (
	"fastcode-gen/db"
	"fmt"
	"log"
	"os"
	"text/template"
)

func GenServiceCode(table db.Table) {
	tmpl, err := template.ParseFiles("./template/XXXController.java")
	if err != nil {
		fmt.Println("Error happened..")
	}
	out, err := os.Create("./out/controller/" + table.Name + "XXXController.java")
	defer out.Close()
	if err != nil {
		log.Println("create file: ", err)
		return
	}
	tmpl.Execute(out, table)
}
