package ${packageName}.db.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import ${packageName}.db.mapper.{{ .Name }}Mapper;
import ${packageName}.db.model.{{ .Name }};
import lombok.extern.slf4j.Slf4j;
import com.jlpay.utils.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * @Author：{{ .Author}}
 * @CreateTime：${createTime}
 * @Description: ${remark}
 */
@Slf4j
@Service
public class I{{ .Name }}Service {

	@Autowired
    private {{ .Name }}Mapper mapper;

	public {{ .Name }} get{{ .Name }}(String id) {
		return mapper.getById(id);
	}
	
	public void save({{ .Name }} {{ .LowName }}){
		{{ .LowName }}.setCreateTime(new Date());
		{{ .LowName }}.setUpdateTime(new Date());
		mapper.insert({{ .LowName }});
	}

	public void updateNotNull({{ .Name }} {{ .LowName }}) {
		mapper.updateNotNull({{ .LowName }});
	}

	public List<{{ .Name }}> list{{ .Name }}({{ .Name }} queryParam) {
		return mapper.list{{ .Name }}(queryParam);
	}
	
	public void list{{ .Name }}ByPage({{ .Name }} queryParam, Pagination pagination) {
		List<{{ .Name }}> list = mapper.list{{ .Name }}ByPage(queryParam, pagination.getPageBounds());
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
