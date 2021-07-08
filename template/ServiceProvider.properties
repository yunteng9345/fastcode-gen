package com.jiwu.tradingcloud.net.http.tradingcloud.${zujian};

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.jiwu.tradingcloud.model.${zujian}.${Table};
import com.jiwu.tradingcloud.net.http.IHttpService;
import com.jiwu.tradingcloud.net.http.TradingCloud${Zujian}HttpService;
import com.jiwu.tradingcloud.Pagination;

public class ${Table}ServiceProvider {

	private static IHttpService httpService = new TradingCloud${Zujian}HttpService();

	public static Pagination searchPage(Pagination pagination) throws Exception{

		return (Pagination) httpService.post("/${zujian}/${table}/search/page", pagination,Pagination.class);
	}
	
	public static ${Table} query(Integer id) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id+"");
		return (${Table}) httpService.post("/${zujian}/${table}/query", map,${Table}.class);
	} 
	
	public static ${Table} saveOrUpdate(${Table}  ${table} ) throws Exception{
		return (${Table}) httpService.post("/${zujian}/${table}/saveOrUpdate", ${table},${Table}.class);
	} 
} 
