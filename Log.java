package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Log {
    private static String userprofile = System.getenv("USERPROFILE");

    public static void logStatistics() throws IOException {
        //Calling variables to be sent to the log
        String dataRecieved = Integer.toString(DataInput.getDataRecieved());
        dataRecieved += " of records received";
        String invalidData = Integer.toString(DataInput.getInvalidData());
        invalidData += " of records failed";
        String validData = Integer.toString(DataInput.getValidData());
        validData += " of records successful";

        //Sending finished variables to the log
        Files.write(Paths.get(userprofile + "\\Documents\\Statistics.log"), dataRecieved.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        Files.write(Paths.get(userprofile + "\\Documents\\Statistics.log"), "\n".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(userprofile + "\\Documents\\Statistics.log"), validData.getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(userprofile + "\\Documents\\Statistics.log"), "\n".getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(userprofile + "\\Documents\\Statistics.log"), invalidData.getBytes(), StandardOpenOption.APPEND);
    }
}