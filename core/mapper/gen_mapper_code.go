package mapper

import (
	"fastcode-gen/db"
	"fmt"
	"os"
	"text/template"
)

func GenServiceCode(table db.Table) {
	tmpl, err := template.ParseFiles("./template/IService.java")
	if err != nil {
		fmt.Println("Error happened..")
	}
	tmpl.Execute(os.Stdout, table)
}
