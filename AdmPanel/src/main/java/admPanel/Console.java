package admPanel;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Scanner;

@Service
public class Console {
    public static void consoleForAdmPanel(){
        System.out.println("===============Menu================");
        System.out.println("=  Write 1 if you want to create  =\n" +
                "= PDF File with information about =\n" +
                "=           Veterinarian          =\n" +
                "=         Write 0 for exit        =");
        System.out.println("=---------------------------------=");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        System.out.println("=---------------------------------=");
        switch (command) {
            case "1":
                System.out.println("= Creating pdf file in progress.. =");
                SendingCommandToPrint.createPdfFile();
                System.out.println("===================================");
                Console.consoleForAdmPanel();
            case "0":
                System.out.println("=            Closing...           =");
                System.out.println("===================================");
                break;
            default:
                System.out.println("=       Something went wrong      =");
                scanner.close();
                System.out.println("===================================");
                break;
        }
    }
}
