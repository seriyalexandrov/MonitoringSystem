import com.kalashnikov.monitoring.parser.wireshark.Parser;
import com.kalashnikov.monitoring.parser.wireshark.PackageFromWireShark;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ParserTest {


    public final String path = "src\\main\\resources\\traffic.cap";
    //    public final String path = "D:\\GitHub\\traffic.txt";
    public final double timeInterval = 1;

    @Test
    public void parserTest() throws IOException, InterruptedException {
        ArrayList<ArrayList<PackageFromWireShark>> values = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Parser parser = new Parser(br, values, 0, 10);
            Thread thread = new Thread(parser);
            thread.start();
            thread.join();
        }
        int counter = 0;
        for (ArrayList<PackageFromWireShark> al : values) {
            System.out.println("Test:" + al.size());
            counter += al.size();
        }
        System.out.println("Number");
        System.out.println(counter);
    }


}