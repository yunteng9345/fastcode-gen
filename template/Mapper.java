package ${packageName}.db.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import ${packageName}.db.model.{{.Name}};
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author：{{.Author}}
 * @CreateTime：${createTime}
 * @Description: ${remark}
*/
@Mapper
public interface {{.Name}}Mapper {
    /**插入数据**/
    int insert({{.Name}} {{.LowName}});
    /**按ID查询**/
    {{.Name}} getById(String id);
    /**根据主主键更新**/
    int updateNotNull({{.Name}} {{.LowName}});
    /**根据主主键更新**/
    int update({{.Name}} {{.LowName}});
    /**查询列表**/
    List<{{.Name}}> list{{.Name}}({{.Name}} {{.LowName}});
    /**分页查询列表**/
    List<{{.Name}}> list{{.Name}}ByPage({{.Name}} {{.LowName}}, PageBounds pageBounds);
}