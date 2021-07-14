package service

import (
	"fastcode-gen/db"
	"fmt"
	"log"
	"os"
	"text/template"
)

func GenServiceCode(table db.Table) {
	tmpl, err := template.ParseFiles("./template/XXXIService.java")
	if err != nil {
		fmt.Println("Error happened..")
	}
	out, err := os.Create("./out/service/I" + table.Name + "Service.java")
	defer out.Close()
	if err != nil {
		log.Println("create file: ", err)
		return
	}
	tmpl.Execute(out, table)
	//tmpl.Execute(os.Stdout, table)

	tmplService, err := template.ParseFiles("./template/XXXServiceImpl.java")
	if err != nil {
		fmt.Println("Error happened..")
	}
	outImpl, err := os.Create("./out/service/impl/" + table.Name + "ServiceImpl.java")
	defer outImpl.Close()
	if err != nil {
		log.Println("create file: ", err)
		return
	}
	tmplService.Execute(outImpl, table)
	//tmplService.Execute(os.Stdout, table)
}
