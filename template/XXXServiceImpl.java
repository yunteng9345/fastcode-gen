package ${packageName}.db.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;

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
public class {{ .Name }}ServiceImpl implements I{{ .Name }}Service {

	@Resource
    private {{ .Name }}Mapper mapper;

	@Override
	public int save({{ .Name }} {{ .LowName }}){
		{{ .LowName }}.setCreateTime(new Date());
		{{ .LowName }}.setUpdateTime(new Date());
		return mapper.insert({{ .LowName }});
	}

	@Override
	public {{ .Name }} get(String id) {
		return mapper.getById(id);
	}

    @Override
    public int update({{ .Name }} {{ .LowName }}) {
         mapper.update(termConfig);
    }

	@Override
	public int updateNotNull({{ .Name }} {{ .LowName }}) {
		return mapper.updateNotNull({{ .LowName }});
	}

	@Override
	public List<{{ .Name }}> list{{ .Name }}({{ .Name }} queryParam) {
		return mapper.list{{ .Name }}(queryParam);
	}
	
	@Override
	public int list{{ .Name }}ByPage({{ .Name }} queryParam, Pagination pagination) {
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
