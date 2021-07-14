package ${packageName}.db.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import ${packageName}.db.mapper.${Table}Mapper;
import ${packageName}.db.model.${Table};
import lombok.extern.slf4j.Slf4j;
import com.jlpay.utils.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * @Author：${author}
 * @CreateTime：${createTime}
 * @Description: ${remark}
 */
@Slf4j
@Service
public class ${Table}Service {

	@Autowired
    private ${Table}Mapper mapper;

	public ${Table} get${Table}(String id) {
		return mapper.getById(id);
	}
	
	public void save(${Table} ${table}){
		${table}.setCreateTime(new Date());
		${table}.setUpdateTime(new Date());
		mapper.insert(${table});
	}

	public void updateNotNull(${Table} ${table}) {
		mapper.updateNotNull(${table});
	}

	public List<${Table}> list${Table}(${Table} queryParam) {
		return mapper.list${Table}(queryParam);
	}
	
	public void list${Table}ByPage(${Table} queryParam, Pagination pagination) {
		List<${Table}> list = mapper.list${Table}ByPage(queryParam, pagination.getPageBounds());
		pagination.setRows(list);
		try {
			PageList pageList = (PageList)list;
			pagination.setTotal(pageList.getPaginator().getTotalCount());
			pagination.setTotalPage(pageList.getPaginator().getTotalPages());
		}catch (Exception e){
			pagination.setTotal(list.size());
		}
	}

}
