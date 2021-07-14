package com.jlpay.service;

/**
 ** @auther {{.Author}}
 */
public interface {{ .Name }}Service {
	
	public static String SERVER_NAME="{{ .Name}}Service";
	/**
	 * 根据主键id查询
	 * @param orderId
	 * @return
	 */
	public {{.Name}} get(String id);
	
	/**
	 * 保存
	 * @param {{.LowName}}
	 */
	public void save({{.Name}} {{.LowName}});
	
	/**
	 * 修改
	 * @param {{.LowName}}
	 */
	public void update({{.Name}} {{.LowName}});
}
