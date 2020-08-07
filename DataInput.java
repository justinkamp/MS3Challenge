package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataInput {
    private static String userprofile = System.getenv("USERPROFILE");
    //Data collection for the log
    private static int dataRecieved = 0, validData = 0, invalidData = 0;

    public static void Data() throws IOException {
        //Retrieving the provided data and feeding that into a list for iteration
        String[] userProfile = new String[10];
        List<String> userData = Files.readAllLines(Paths.get(userprofile + "\\Documents\\ms3Interview.csv"));

        //Iterating through the data and setting each row to an array to help determine whether the data in either valid or invalid
        for (String iterate: userData) {
            userProfile = iterate.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            dataRecieved += 1;
            //Iterate through the array to identify any blank (null) pieces of data, if found move data to invalid-bad.csv
            for (int i = 0; i < 10; i++) {
                if (userProfile[i].equals("")) {
                    CSV.invalidData(userProfile);
                    invalidData += 1;
                    break;
                }
            }
            //if nothing is found it will be moved to the database and processed
            Database.dataEntry(userProfile);
            validData += 1;
        }
    }
    //Sending Log Data
    public static int getDataRecieved() {return dataRecieved;}
    public static int getValidData() {return validData;}
    public static int getInvalidData() {return invalidData;}
}
