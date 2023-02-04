package print;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mysql.data.petclinic")
public class MysqlPropertyConfiguration {
    private String url;
    private String username;
    private String password;
}
