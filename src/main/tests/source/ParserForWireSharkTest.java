import com.kalashnikov.monitoring.parser.wireshark.PackageFromWireShark;
import com.kalashnikov.monitoring.parser.wireshark.ParserForWireSharkFiles;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParserForWireSharkTest {
    private int a;
    private int b;
    @Before
    public void initTest() {
        a = 39;
        b = 0;
    }

    @Test
    public void testRealPath() {
        String path = "src\\main\\resources\\traffic.cap";
        ParserForWireSharkFiles parser = new ParserForWireSharkFiles();
        List<PackageFromWireShark> list = parser.getPackageListFromFile(path);
        for(PackageFromWireShark pack : list){
            System.out.println(pack.toString());
        }
        assertEquals(list.size(), a);
    }
    @Test
    public void wrongWay() {
        String path = "path";
        ParserForWireSharkFiles parser = new ParserForWireSharkFiles();
        List<PackageFromWireShark> list = parser.getPackageListFromFile(path);
        assertEquals(list.size(), b);

    }
}
