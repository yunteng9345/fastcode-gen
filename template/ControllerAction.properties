package com.jiwu.tradingcloud.controller.${zujian};

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiwu.tradingcloud.controller.BaseController;
import com.jiwu.tradingcloud.model.${zujian}.${Table};
 
import com.jiwu.tradingcloud.net.http.tradingcloud.${zujian}.${table}Service;
import com.jiwu.tradingcloud.Pagination;
import com.jiwu.tradingcloud.model.LoginUserEntity;
import com.jiwu.tradingcloud.model.order.vo.QueryVo;
import com.jiwu.tradingcloud.model.settle.${Table};
import com.jiwu.tradingcloud.service.settle.Motan${Table}Service;
  
/**
* Copyright © 嘉联有限公司<br>
* Author：{author}
* CreateTime：2016年07月22 11:52:28
* Description: ${annotation}配置表
*/
@Controller
@RequestMapping("/${zujian}/${table}/")
public class  ${Table}Controller extends BaseController {
	
	@Autowired
	private Motan${Table}Service ${table}Service;
	
	@RequestMapping("edit")
	public String edit(Integer id ,ModelMap modelMap)throws Exception{
		if(id != null){
			${Table} ${table} = ${table}Service.query(new LoginUserEntity(TradingCloudContext.get(), id));
			modelMap.put("${table}",${table});   
		}  
		return "${zujian}/${table}/${Table}Edit"; 
	} 
	
	
	@RequestMapping("save")
	public String save( ${Table} ${table},ModelMap modelMap) throws Exception{
		String error="";   
		if(${table} != null){ 
			${table}.setCuserid(getUser().getId());//获取登录人id
			${table}Service.saveOrUpdate(new LoginUserEntity(TradingCloudContext.get(), ${table})); 
			error="保存成功";     
		} 
		return "${zujian}/${table}/${Table}Manager";    
	} 
	 
	@ResponseBody
	@RequestMapping("search/page")
	public Map<String, Object> searchPage(Integer limit,Integer offset,QueryVo queryVo){
		 try {     
			Pagination page1 = getPagination(offset,limit); 
			page1.setMap(queryVo.getQueryMap()); 
			Pagination page = (Pagination)${table}Service.searchPage(page1);
			
			return parse2BootstrapTable(page);
		} catch (Exception e) { 
			e.printStackTrace(); 
		}    
		return null;
	} 
	
	@RequestMapping("list")
	public String list${Table}(){
		 return "${zujian}/${table}/${Table}Manage";     
	}	    
	
	@RequestMapping("delete")
	public String delete(${Table} ${table},ModelMap modelMap)throws Exception{
		if(${table}.getId() != null){
			${table}Service.saveOrUpdate(new LoginUserEntity(TradingCloudContext.get(), ${table})); 
		}     
		modelMap.put("msg", "操作成功！");
		return "${zujian}/${table}/${Table}Manage";     
	}
	
}



