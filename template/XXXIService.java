
 /**
  * @Author：{{.Author}}
  * @CreateTime：{{ .Time }}
  * @Description: ${remark}
 */
public interface I{{ .Name }}Service {
	
	String SERVER_NAME = "{{ .Name}}Service";

	{{.Name}} get(String id);

	int save({{.Name}} {{.LowName}});
	
	int update({{.Name}} {{.LowName}});

	int updateNotNull({{.Name}} {{.LowName}});

    List<{{.Name}}> list{{.Name}}({{.Name}} {{.LowName}});

    void list{{.Name}}ByPage({{.Name}} {{.LowName}}, Pagination pagination);
}
