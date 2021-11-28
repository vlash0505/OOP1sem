package mytimeorganizer.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DBConfigurator {
    public DBConfigurator (File config) {
        try {
            FileReader fr = new FileReader(config);
            BufferedReader br = new BufferedReader(fr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
