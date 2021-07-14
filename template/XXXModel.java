package com.jlpay.manage.sim.db.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/**
* @Author： {{ .Author }}
* @CreateTime：2021/04/15 14:58:36
* @Description: {{ .Name }}
*/
@Data
public class {{ .Name }} implements Serializable  {
	private static final long serialVersionUID = 1L;
    {{ range .TableStruct }}
    /**{{.Comment}}**/
	private {{.Type}} {{.Column}};
    {{end}}
}