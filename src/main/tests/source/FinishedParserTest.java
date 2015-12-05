import com.kalashnikov.monitoring.parser.wireshark.FinishedParser;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FinishedParserTest {

    public final String path = "src\\main\\resources\\traffic.cap";
    public final double timeInterval = 1;

    @Test
    public void parserTest() throws IOException, InterruptedException {
        ArrayList<Integer> values = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            FinishedParser parser = new FinishedParser(br,values,timeInterval);
            Thread thread = new Thread(parser);
            thread.start();
            System.out.println(values.toString());
            thread.join(3500);
            System.out.println(values.toString());
            thread.join();
        }
        System.out.println(values.toString());
        Integer result =  0;
        for(Integer value : values){
            result += value;
        }
        System.out.println("The number of packages: " + result);

    }

}