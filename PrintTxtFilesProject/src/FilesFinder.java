import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesFinder {
    public static void main(String[] args) throws IOException {

        /*Files.list(Paths.get("."))
                .forEach(temp -> System.out.println(temp) );*/

        Files.list(Paths.get("."))
                .filter(path -> String.valueOf(path).contains(".txt"))
                .forEach(temp -> System.out.println(temp) );
    }
}
