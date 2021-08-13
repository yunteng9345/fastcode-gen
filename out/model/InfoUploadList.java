
import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
* @Author： yunteng
* @CreateTime：2021-08-05 14:13:27
* @Description: InfoUploadList
*/
@Data
public class InfoUploadList implements Serializable  {
	private static final long serialVersionUID = 1L;
    
    /**业务类型**/
    @JSONField(name = "IPC_TYPE")
	private String ipcType;
    
    /**上送类型**/
    @JSONField(name = "REQUEST_ID")
	private String requestId;
    
    /**请求时间**/
    @JSONField(name = "REQUEST_TIME")
	private Date requestTime;
    
    /**请求url**/
    @JSONField(name = "REQUEST_URL")
	private String requestUrl;
    
    /**返回码**/
    @JSONField(name = "RESPONSE_CODE")
	private String responseCode;
    
    /**返回时间**/
    @JSONField(name = "RESPONSE_TIME")
	private Date responseTime;
    
    /**消息来源标识**/
    @JSONField(name = "SOURCE")
	private String source;
    
    /**请求状态：0-已发送，1-成功，2-失败，3-待确认**/
    @JSONField(name = "STATUS")
	private String status;
    
    /**上送类型**/
    @JSONField(name = "UPLOAD_FLAG")
	private String uploadFlag;
    
}