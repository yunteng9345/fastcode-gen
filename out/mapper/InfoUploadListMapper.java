
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author：yunteng
 * @CreateTime：2021-08-05 14:13:27
 * @Description: ${remark}
*/
@Mapper
public interface InfoUploadListMapper {
    /**插入数据**/
    int insert(InfoUploadList infoUploadList);
    /**按ID查询**/
    InfoUploadList getById(String id);
    /**根据主主键更新**/
    int updateNotNull(InfoUploadList infoUploadList);
    /**根据主主键更新**/
    int update(InfoUploadList infoUploadList);
    /**查询列表**/
    List<InfoUploadList> listInfoUploadList(InfoUploadList infoUploadList);
    /**分页查询列表**/
    List<InfoUploadList> listInfoUploadListByPage(InfoUploadList infoUploadList, PageBounds pageBounds);
}