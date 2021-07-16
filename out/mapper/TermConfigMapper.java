
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author：yunteng
 * @CreateTime：2021-07-16 11:15:09
 * @Description: ${remark}
*/
@Mapper
public interface TermConfigMapper {
    /**插入数据**/
    int insert(TermConfig termConfig);
    /**按ID查询**/
    TermConfig getById(String id);
    /**根据主主键更新**/
    int updateNotNull(TermConfig termConfig);
    /**根据主主键更新**/
    int update(TermConfig termConfig);
    /**查询列表**/
    List<TermConfig> listTermConfig(TermConfig termConfig);
    /**分页查询列表**/
    List<TermConfig> listTermConfigByPage(TermConfig termConfig, PageBounds pageBounds);
}