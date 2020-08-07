package Main;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CSV {
    private static String userprofile = System.getenv("USERPROFILE");

    public static void invalidData(String[] profile) throws IOException {

        //Iterating through the flagged profile and appending each to the Invalid CSV
        for (String iterate: profile) {
            Files.write(Paths.get(userprofile + "\\Documents\\InvalidRecords_bad.csv"), iterate.getBytes(),StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.write(Paths.get(userprofile + "\\Documents\\InvalidRecords_bad.csv"), ", ".getBytes(), StandardOpenOption.APPEND);
        }
        Files.write(Paths.get(userprofile + "\\Documents\\InvalidRecords_bad.csv"), "\n".getBytes(), StandardOpenOption.APPEND);
    }
}