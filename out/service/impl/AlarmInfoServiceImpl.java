
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author：yunteng
 * @CreateTime：2021-07-19 15:09:34
 * @Description: ${remark}
 */
@Slf4j
@Service
public class AlarmInfoServiceImpl implements IAlarmInfoService {

	@Resource
    private AlarmInfoMapper mapper;

	@Override
	public int save(AlarmInfo alarmInfo){
		alarmInfo.setCreateTime(new Date());
		alarmInfo.setUpdateTime(new Date());
		return mapper.insert(alarmInfo);
	}

	@Override
	public AlarmInfo get(String id) {
		return mapper.getById(id);
	}

    @Override
    public int update(AlarmInfo alarmInfo) {
         return mapper.update(alarmInfo);
    }

	@Override
	public int updateNotNull(AlarmInfo alarmInfo) {
		return mapper.updateNotNull(alarmInfo);
	}

	@Override
	public List<AlarmInfo> listAlarmInfo(AlarmInfo queryParam) {
		return mapper.listAlarmInfo(queryParam);
	}
	
	@Override
	public void listAlarmInfoByPage(AlarmInfo queryParam, Pagination pagination) {
		List<AlarmInfo> list = mapper.listAlarmInfoByPage(queryParam, pagination.getPageBounds());
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
