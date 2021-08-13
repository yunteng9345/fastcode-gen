
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author：yunteng
 * @CreateTime：2021-08-05 14:13:27
 * @Description: ${remark}
 */
@Slf4j
@Service
public class InfoUploadListServiceImpl implements IInfoUploadListService {

	@Resource
    private InfoUploadListMapper mapper;

	@Override
	public int save(InfoUploadList infoUploadList){
		infoUploadList.setCreateTime(new Date());
		infoUploadList.setUpdateTime(new Date());
		return mapper.insert(infoUploadList);
	}

	@Override
	public InfoUploadList get(String id) {
		return mapper.getById(id);
	}

    @Override
    public int update(InfoUploadList infoUploadList) {
         return mapper.update(infoUploadList);
    }

	@Override
	public int updateNotNull(InfoUploadList infoUploadList) {
		return mapper.updateNotNull(infoUploadList);
	}

	@Override
	public List<InfoUploadList> listInfoUploadList(InfoUploadList queryParam) {
		return mapper.listInfoUploadList(queryParam);
	}
	
	@Override
	public void listInfoUploadListByPage(InfoUploadList queryParam, Pagination pagination) {
		List<InfoUploadList> list = mapper.listInfoUploadListByPage(queryParam, pagination.getPageBounds());
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
