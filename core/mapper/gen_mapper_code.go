package mapper

import (
	"fastcode-gen/db"
	"fmt"
	"os"
	"text/template"
)

func GenMapperCode(table db.Table) {
	tmpl, err := template.ParseFiles("./template/Mapper.java")
	if err != nil {
		fmt.Println("Error happened..")
	}
	tmpl.Execute(os.Stdout, table)
}
