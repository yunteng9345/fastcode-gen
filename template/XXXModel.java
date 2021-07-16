
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
* @Author： {{ .Author }}
* @CreateTime：{{ .Time }}
* @Description: {{ .Name }}
*/
@Data
public class {{ .Name }} implements Serializable  {
	private static final long serialVersionUID = 1L;
    {{ range .TableStruct }}
    /**{{.Comment}}**/
	private {{.Type}} {{.Column}};
    {{end}}
}