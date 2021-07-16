package com.jlpay.service;

 /**
  * @Author：yunteng
  * @CreateTime：2021-07-16 11:15:09
  * @Description: ${remark}
 */
public interface ITermConfigService {
	
	String SERVER_NAME = "TermConfigService";

	TermConfig get(String id);

	int save(TermConfig termConfig);
	
	int update(TermConfig termConfig);

	int updateNotNull(TermConfig termConfig);

    List<TermConfig> listTermConfig(TermConfig termConfig);

    int listTermConfigByPage(TermConfig termConfig, Pagination pagination);
}
