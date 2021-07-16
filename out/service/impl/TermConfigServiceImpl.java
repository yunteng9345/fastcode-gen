package ${packageName}.db.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;

import lombok.extern.slf4j.Slf4j;
import com.jlpay.utils.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author：yunteng
 * @CreateTime：2021-07-16 11:15:09
 * @Description: ${remark}
 */
@Slf4j
@Service
public class TermConfigServiceImpl implements ITermConfigService {

	@Resource
    private TermConfigMapper mapper;

	@Override
	public int save(TermConfig termConfig){
		termConfig.setCreateTime(new Date());
		termConfig.setUpdateTime(new Date());
		return mapper.insert(termConfig);
	}

	@Override
	public TermConfig get(String id) {
		return mapper.getById(id);
	}

    @Override
    public int update(TermConfig termConfig) {
         mapper.update(termConfig);
    }

	@Override
	public int updateNotNull(TermConfig termConfig) {
		return mapper.updateNotNull(termConfig);
	}

	@Override
	public List<TermConfig> listTermConfig(TermConfig queryParam) {
		return mapper.listTermConfig(queryParam);
	}
	
	@Override
	public int listTermConfigByPage(TermConfig queryParam, Pagination pagination) {
		List<TermConfig> list = mapper.listTermConfigByPage(queryParam, pagination.getPageBounds());
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
