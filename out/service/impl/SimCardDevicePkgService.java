package ${packageName}.db.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import ${packageName}.db.mapper.SimCardDevicePkgMapper;
import ${packageName}.db.model.SimCardDevicePkg;
import lombok.extern.slf4j.Slf4j;
import com.jlpay.utils.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * @Author：yunteng
 * @CreateTime：${createTime}
 * @Description: ${remark}
 */
@Slf4j
@Service
public class ISimCardDevicePkgService {

	@Autowired
    private SimCardDevicePkgMapper mapper;

	public SimCardDevicePkg getSimCardDevicePkg(String id) {
		return mapper.getById(id);
	}
	
	public void save(SimCardDevicePkg simCardDevicePkg){
		simCardDevicePkg.setCreateTime(new Date());
		simCardDevicePkg.setUpdateTime(new Date());
		mapper.insert(simCardDevicePkg);
	}

	public void updateNotNull(SimCardDevicePkg simCardDevicePkg) {
		mapper.updateNotNull(simCardDevicePkg);
	}

	public List<SimCardDevicePkg> listSimCardDevicePkg(SimCardDevicePkg queryParam) {
		return mapper.listSimCardDevicePkg(queryParam);
	}
	
	public void listSimCardDevicePkgByPage(SimCardDevicePkg queryParam, Pagination pagination) {
		List<SimCardDevicePkg> list = mapper.listSimCardDevicePkgByPage(queryParam, pagination.getPageBounds());
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
