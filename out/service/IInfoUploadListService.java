
 /**
  * @Author：yunteng
  * @CreateTime：2021-08-05 14:13:27
  * @Description: ${remark}
 */
public interface IInfoUploadListService {
	
	String SERVER_NAME = "InfoUploadListService";

	InfoUploadList get(String id);

	int save(InfoUploadList infoUploadList);
	
	int update(InfoUploadList infoUploadList);

	int updateNotNull(InfoUploadList infoUploadList);

    List<InfoUploadList> listInfoUploadList(InfoUploadList infoUploadList);

    void listInfoUploadListByPage(InfoUploadList infoUploadList, Pagination pagination);
}
