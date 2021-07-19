
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author：yunteng
 * @CreateTime：2021-07-19 15:09:34
 * @Description: ${remark}
*/
@Mapper
public interface AlarmInfoMapper {
    /**插入数据**/
    int insert(AlarmInfo alarmInfo);
    /**按ID查询**/
    AlarmInfo getById(String id);
    /**根据主主键更新**/
    int updateNotNull(AlarmInfo alarmInfo);
    /**根据主主键更新**/
    int update(AlarmInfo alarmInfo);
    /**查询列表**/
    List<AlarmInfo> listAlarmInfo(AlarmInfo alarmInfo);
    /**分页查询列表**/
    List<AlarmInfo> listAlarmInfoByPage(AlarmInfo alarmInfo, PageBounds pageBounds);
}