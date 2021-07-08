package ${packageName}.db.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import ${packageName}.db.model.${Table};
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author：${author}
 * @CreateTime：${createTime}
 * @Description: ${remark}
*/
@Mapper
public interface ${Table}Mapper {
    /**插入数据**/
    int insert(${Table} ${table});
    /**按ID查询**/
    ${Table} getById(String id);
    /**根据主主键更新**/
    int updateNotNull(${Table} ${table});
    /**根据主主键更新**/
    int update(${Table} ${table});
    /**查询列表**/
    List<${Table}> list${Table}(${Table} ${table});
    /**分页查询列表**/
    List<${Table}> list${Table}ByPage(${Table} ${table}, PageBounds pageBounds);
}