
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
public class {{ .Name }}ServiceTest {
    @Autowired
    private I{{ .Name }}Service i{{ .Name }}Service;

    @Test
    public void saveTest() {
        {{ .Name }} {{ .LowName }} = new {{ .Name }}();
       {{range $i, $el := .TableStruct}} {{$el.LowName}}.set{{$el.FirstUpperName}}("{{$el.FirstUpperName}}");
       {{end}}
        Assert.assertEquals(1, i{{ .Name }}Service.save({{ .LowName }}));
    }

    @Test
    public void updateTest(){
        {{ .Name }} {{ .LowName }} = new {{ .Name }}();
       {{range $i, $el := .TableStruct}} {{$el.LowName}}.set{{$el.FirstUpperName}}("{{$el.FirstUpperName}}");
       {{end}}
        Assert.assertEquals(1, i{{ .Name }}Service.update({{ .LowName }}));
    }

    @Test
    public void queryTest(){
        Assert.assertEquals("id", i{{ .Name }}Service.get("id").get{{range $i, $el := .TableStruct}}{{if eq $i 0}}{{$el.FirstUpperName}}{{end}}{{end}}());
    }
}