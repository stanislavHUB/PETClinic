package print;

import com.itextpdf.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
public class CreatorPdfController {
    private final MysqlPropertyConfiguration mysqlPropertyConfiguration;
    @RequestMapping("/sendCommandToCreateFile")
    public void sendCommandToCreateFile() throws SQLException, DocumentException, FileNotFoundException {
        ConverterToPdf converter = new ConverterToPdf();
        converter.convertFromDbToPdf(mysqlPropertyConfiguration);
        System.out.println("File created");
    }
}
