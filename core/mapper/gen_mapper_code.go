package mapper

import (
	"fastcode-gen/db"
	"fmt"
	"log"
	"os"
	"text/template"
)

func GenMapperCode(table db.Table) {
	tmpl, err := template.ParseFiles("./template/XXXMapper.java")
	if err != nil {
		fmt.Println("Error happened..")
	}
	out, err := os.Create("./out/mapper/" + table.Name + "Mapper.java")
	defer out.Close()
	if err != nil {
		log.Println("create file: ", err)
		return
	}
	tmpl.Execute(out, table)
}
