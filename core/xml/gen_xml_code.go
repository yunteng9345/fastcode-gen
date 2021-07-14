package xml

import (
	"fastcode-gen/db"
	"fmt"
	"log"
	"os"
	"text/template"
)

func GenXmlCode(table db.Table) {
	tmpl, err := template.ParseFiles("./template/XXXMapper.xml")
	if err != nil {
		fmt.Println("Error happened..")
	}
	out, err := os.Create("./out/xml/" + table.Name + "Mapper.xml")
	defer out.Close()
	if err != nil {
		log.Println("create file: ", err)
		return
	}
	tmpl.Execute(out, table)
}
