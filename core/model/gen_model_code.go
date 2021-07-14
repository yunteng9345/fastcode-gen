package model

import (
	"fastcode-gen/db"
	"fmt"
	"log"
	"os"
	"text/template"
)

func GenModelCode(table db.Table) {
	tmpl, err := template.ParseFiles("./template/XXXModel.java")
	if err != nil {
		fmt.Println("Error happened..")
	}
	if err != nil {
		log.Println("create file: ", err)
		return
	}
	out, err := os.Create("./out/model/" + table.Name + ".java")
	defer out.Close()
	if err != nil {
		log.Println("create file: ", err)
		return
	}
	tmpl.Execute(out, table)
	//tmpl.Execute(os.Stdout, table)
	log.Printf("gen model code %s.java has succeed!\n", table.Name)
}
