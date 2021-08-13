
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
public class InfoUploadListServiceTest {
    @Autowired
    private IInfoUploadListService iInfoUploadListService;

    @Test
    public void saveTest() {
        InfoUploadList infoUploadList = new InfoUploadList();
        infoUploadList.setIpcType("IpcType");
        infoUploadList.setRequestId("RequestId");
        infoUploadList.setRequestTime("RequestTime");
        infoUploadList.setRequestUrl("RequestUrl");
        infoUploadList.setResponseCode("ResponseCode");
        infoUploadList.setResponseTime("ResponseTime");
        infoUploadList.setSource("Source");
        infoUploadList.setStatus("Status");
        infoUploadList.setUploadFlag("UploadFlag");
       
        Assert.assertEquals(1, iInfoUploadListService.save(infoUploadList));
    }

    @Test
    public void updateTest(){
        InfoUploadList infoUploadList = new InfoUploadList();
        infoUploadList.setIpcType("IpcType");
        infoUploadList.setRequestId("RequestId");
        infoUploadList.setRequestTime("RequestTime");
        infoUploadList.setRequestUrl("RequestUrl");
        infoUploadList.setResponseCode("ResponseCode");
        infoUploadList.setResponseTime("ResponseTime");
        infoUploadList.setSource("Source");
        infoUploadList.setStatus("Status");
        infoUploadList.setUploadFlag("UploadFlag");
       
        Assert.assertEquals(1, iInfoUploadListService.update(infoUploadList));
    }

    @Test
    public void queryTest(){
        Assert.assertEquals("id", iInfoUploadListService.get("id").getIpcType());
    }
}