
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
* @Author： yunteng
* @CreateTime：2021-07-19 15:09:34
* @Description: AlarmInfo
*/
@Data
public class AlarmInfo implements Serializable  {
	private static final long serialVersionUID = 1L;
    
    /**id**/
	private String id;
    
    /**商户号**/
	private String merchantNo;
    
    /**终端号**/
	private String terminalNo;
    
    /**商户系统定义的风控等级**/
	private String riskRank;
    
    /**人行定义的风控等级**/
	private String bankRiskRank;
    
    /**告警时间**/
	private Date alarmTime;
    
    /**告警类型**/
	private String alarmType;
    
    /**告警来源**/
	private String alarmSource;
    
    /**告警规则编码**/
	private String alarmrulecode;
    
    /**银行风控规则编码**/
	private String bankrulecode;
    
    /**系统定义的规则编码**/
	private String sysrulecode;
    
    /**审查状态 0-未审核， 1-已初审， 2-已复审**/
	private String checkStatus;
    
    /**初审记录**/
	private String checkRecord;
    
    /**初审时间**/
	private Date checkTime;
    
    /**初审人的联系电话**/
	private String checkTel;
    
    /**初审人**/
	private String checkUser;
    
    /**是否生成案件:0-不生成，1-生成**/
	private String isCase;
    
    /**复审记录**/
	private String recheckRecord;
    
    /**风控措施**/
	private String riskCtrl;
    
    /**复审时间**/
	private Date recheckTime;
    
    /**复审人的联系电话**/
	private String recheckTel;
    
    /**复审人**/
	private String recheckUser;
    
    /**创建时间**/
	private Date createTime;
    
    /**记录创建者**/
	private String createUser;
    
    /**预警处理日期**/
	private Date processDate;
    
    /**右端商户号**/
	private String chanMerchNo;
    
    /**右端终端号**/
	private String chanTermNo;
    
    /**系统定义的规则编码的描述**/
	private String sysruledesc;
    
    /**装机地区编码**/
	private String areaCode;
    
    /**交易地区编码**/
	private String transAreaCode;
    
}