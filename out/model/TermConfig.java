
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
* @Author： yunteng
* @CreateTime：2021-07-16 11:15:09
* @Description: TermConfig
*/
@Data
public class TermConfig implements Serializable  {
	private static final long serialVersionUID = 1L;
    
    /**商户号**/
	private String termNo;
    
    /**配置的键**/
	private String key;
    
    /**配置的值**/
	private String value;
    
    /**创建时间**/
	private Date creatTime;
    
    /**修改时间**/
	private Date updateTime;
    
    /**创建人**/
	private String creatUser;
    
    /**修改人**/
	private String updateUser;
    
    /**备注**/
	private String remark;
    
}