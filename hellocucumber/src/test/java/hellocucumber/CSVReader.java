package hellocucumber;

import org.apache.commons.csv.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {


    String[] HEADERS;


    Map<String, String> AUTHOR_BOOK_MAP = new HashMap<String, String>() {
        {
            put("Dan Simmons", "Hyperion");
            put("Douglas Adams", "The Hitchhiker's Guide to the Galaxy");
        }
    };


    public void createCSVFile() throws IOException {
        FileWriter out = new FileWriter("book_new.csv");
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                .withHeader(HEADERS))) {
            AUTHOR_BOOK_MAP.forEach((author, title) -> {
                try {
                    printer.printRecord(author, title);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
