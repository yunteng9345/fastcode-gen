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
	 * @param ${table}
	 */
	public void save({{.Name}} ${table});
	
	/**
	 * 修改
	 * @param ${table}
	 */
	public void update({{.Name}} ${table});
}
