package model

import (
	"fastcode-gen/db"
	"fastcode-gen/utils"
	"fmt"
	"log"
	"os"
	"text/template"
)

func GenModelCode(table db.Table) {
	tmpl, err := template.ParseFiles("./template/Model.java")
	if err != nil {
		fmt.Println("Error happened..")
	}
	table.Name = utils.Case2Camel(table.Name)
	//for _,v := range table.TableStruct {
	//}

	//out, err := os.Create("./out/model/"+ table.Name + ".java")
	//defer out.Close()
	if err != nil {
		log.Println("create file: ", err)
		return
	}
	tmpl.Execute(os.Stdout, table)
	log.Printf("gen model code %s.java has succeed!\n", table.Name)
}
