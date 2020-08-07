package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class DataInput {
    private static String userprofile = System.getenv("USERPROFILE");
    //Data collection for the log
    private static int dataRecieved = 0, validData = 0, invalidData = 0;
    private static Scanner input = new Scanner(System.in);


    public static void Data() throws IOException {
        //Retrieving the provided data and feeding that into a list for iteration
        String[] userProfile = new String[10];
        List<String> userData = Files.readAllLines(Paths.get(userprofile + "\\Documents\\" + dataSet() + ".csv"));

        //Iterating through the data and setting each row to an array to help determine whether the data in either valid or invalid
        for (String iterate: userData) {
            userProfile = iterate.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            dataRecieved += 1;
            //Iterate through the array to identify any blank (null) pieces of data, if found move data to invalid-bad.csv
            int count = 0;
            for (int i = 0; i < 10; i++) {
                if (userProfile[i].equals("")) {
                    CSV.invalidData(userProfile);
                    invalidData += 1;
                    break;
                }
                count++;
            }
            //if nothing is found it will be moved to the database and processed
            if (count == 10) {
                Database.dataEntry(userProfile);
                validData += 1;
            }
        }
    }
    //Getting the name of the data-set while leaving the option for addition data-sets
    public static String dataSet() {
        System.out.print("Enter your data-set: ");
        return input.nextLine();
    }
    //Sending Log Data
    public static int getDataRecieved() {return dataRecieved;}
    public static int getValidData() {return validData;}
    public static int getInvalidData() {return invalidData;}
}
