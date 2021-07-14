package com.jlpay.service;

/**
 ** @auther {{.Author}}
 */
public interface I{{ .Name }}Service {
	
	String SERVER_NAME = "{{ .Name}}Service";

	{{.Name}} get(String id);

	int save({{.Name}} {{.LowName}});
	
	int update({{.Name}} {{.LowName}});

	int updateNotNull({{.Name}} {{.LowName}});

    List<{{.Name}}> list{{.Name}}({{.Name}} {{.LowName}});

    int list{{.Name}}ByPage({{.Name}} {{.LowName}}, Pagination pagination);
}