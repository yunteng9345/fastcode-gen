
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class AlarmInfoServiceTest {
    @Autowired
    private IAlarmInfoService iAlarmInfoService;

    @Test
    public void saveTest() {
        AlarmInfo alarmInfo = new AlarmInfo();
        alarmInfo.setId("Id");
        alarmInfo.setMerchantNo("MerchantNo");
        alarmInfo.setTerminalNo("TerminalNo");
        alarmInfo.setRiskRank("RiskRank");
        alarmInfo.setBankRiskRank("BankRiskRank");
        alarmInfo.setAlarmTime("AlarmTime");
        alarmInfo.setAlarmType("AlarmType");
        alarmInfo.setAlarmSource("AlarmSource");
        alarmInfo.setAlarmrulecode("Alarmrulecode");
        alarmInfo.setBankrulecode("Bankrulecode");
        alarmInfo.setSysrulecode("Sysrulecode");
        alarmInfo.setCheckStatus("CheckStatus");
        alarmInfo.setCheckRecord("CheckRecord");
        alarmInfo.setCheckTime("CheckTime");
        alarmInfo.setCheckTel("CheckTel");
        alarmInfo.setCheckUser("CheckUser");
        alarmInfo.setIsCase("IsCase");
        alarmInfo.setRecheckRecord("RecheckRecord");
        alarmInfo.setRiskCtrl("RiskCtrl");
        alarmInfo.setRecheckTime("RecheckTime");
        alarmInfo.setRecheckTel("RecheckTel");
        alarmInfo.setRecheckUser("RecheckUser");
        alarmInfo.setCreateTime("CreateTime");
        alarmInfo.setCreateUser("CreateUser");
        alarmInfo.setProcessDate("ProcessDate");
        alarmInfo.setChanMerchNo("ChanMerchNo");
        alarmInfo.setChanTermNo("ChanTermNo");
        alarmInfo.setSysruledesc("Sysruledesc");
        alarmInfo.setAreaCode("AreaCode");
        alarmInfo.setTransAreaCode("TransAreaCode");
       
        Assert.assertEquals(1, iAlarmInfoService.save(alarmInfo));
    }

    @Test
    public void updateTest(){
        AlarmInfo alarmInfo = new AlarmInfo();
        alarmInfo.setId("Id");
        alarmInfo.setMerchantNo("MerchantNo");
        alarmInfo.setTerminalNo("TerminalNo");
        alarmInfo.setRiskRank("RiskRank");
        alarmInfo.setBankRiskRank("BankRiskRank");
        alarmInfo.setAlarmTime("AlarmTime");
        alarmInfo.setAlarmType("AlarmType");
        alarmInfo.setAlarmSource("AlarmSource");
        alarmInfo.setAlarmrulecode("Alarmrulecode");
        alarmInfo.setBankrulecode("Bankrulecode");
        alarmInfo.setSysrulecode("Sysrulecode");
        alarmInfo.setCheckStatus("CheckStatus");
        alarmInfo.setCheckRecord("CheckRecord");
        alarmInfo.setCheckTime("CheckTime");
        alarmInfo.setCheckTel("CheckTel");
        alarmInfo.setCheckUser("CheckUser");
        alarmInfo.setIsCase("IsCase");
        alarmInfo.setRecheckRecord("RecheckRecord");
        alarmInfo.setRiskCtrl("RiskCtrl");
        alarmInfo.setRecheckTime("RecheckTime");
        alarmInfo.setRecheckTel("RecheckTel");
        alarmInfo.setRecheckUser("RecheckUser");
        alarmInfo.setCreateTime("CreateTime");
        alarmInfo.setCreateUser("CreateUser");
        alarmInfo.setProcessDate("ProcessDate");
        alarmInfo.setChanMerchNo("ChanMerchNo");
        alarmInfo.setChanTermNo("ChanTermNo");
        alarmInfo.setSysruledesc("Sysruledesc");
        alarmInfo.setAreaCode("AreaCode");
        alarmInfo.setTransAreaCode("TransAreaCode");
       
        Assert.assertEquals(1, iAlarmInfoService.update(alarmInfo));
    }

    @Test
    public void queryTest(){
        Assert.assertEquals("id", iAlarmInfoService.get("id").getId());
    }
}