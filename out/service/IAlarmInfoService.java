
 /**
  * @Author：yunteng
  * @CreateTime：2021-07-19 15:09:34
  * @Description: ${remark}
 */
public interface IAlarmInfoService {
	
	String SERVER_NAME = "AlarmInfoService";

	AlarmInfo get(String id);

	int save(AlarmInfo alarmInfo);
	
	int update(AlarmInfo alarmInfo);

	int updateNotNull(AlarmInfo alarmInfo);

    List<AlarmInfo> listAlarmInfo(AlarmInfo alarmInfo);

    void listAlarmInfoByPage(AlarmInfo alarmInfo, Pagination pagination);
}
