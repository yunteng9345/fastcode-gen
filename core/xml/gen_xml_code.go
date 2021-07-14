package xml

import (
	"fastcode-gen/db"
	"fmt"
	"os"
	"text/template"
)

func GenXmlCode(table db.Table) {
	tmpl, err := template.ParseFiles("./template/XXXMapper.xml")
	if err != nil {
		fmt.Println("Error happened..")
	}
	tmpl.Execute(os.Stdout, table)
}
