
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class FileUtilsTest {
    public static void main (String[] args) throws IOException {
        File testFile = new File("C:\\srh\\Test.txt");
        String data = FileUtils.readFileToString(testFile, "UTF-8");
        System.out.println(data);
    }
}
