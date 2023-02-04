package print;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;

@Service
public class ConverterToPdf {
    public void convertFromDbToPdf(MysqlPropertyConfiguration mysqlPropertyConfiguration) throws SQLException, FileNotFoundException, DocumentException {
        Connection conn = DriverManager.getConnection(mysqlPropertyConfiguration.getUrl(), mysqlPropertyConfiguration.getUsername(), mysqlPropertyConfiguration.getPassword());
        Statement stmt = conn.createStatement();
        ResultSet query_set = stmt.executeQuery("SELECT id, first_name, last_name FROM vets");
        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("Veterinarians.pdf"));
        my_pdf_report.open();
        PdfPTable my_report_table = new PdfPTable(3);
        PdfPCell table_cell;

        while (query_set.next()) {
            String id_vet = query_set.getString("ID");
            table_cell=new PdfPCell(new Phrase(id_vet));
            my_report_table.addCell(table_cell);
            String first_name_vet = query_set.getString("FIRST_NAME");
            table_cell=new PdfPCell(new Phrase(first_name_vet));
            my_report_table.addCell(table_cell);
            String last_name_vet = query_set.getString("LAST_NAME");
            table_cell=new PdfPCell(new Phrase(last_name_vet));
            my_report_table.addCell(table_cell);

        }
        my_pdf_report.add(my_report_table);
        my_pdf_report.close();
        query_set.close();
        stmt.close();
        conn.close();
    }
}
