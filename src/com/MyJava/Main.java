package com.MyJava;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.File;
import java.time.Month;



public class Main {


    public static String getCreationDetails(String filename) throws IOException {
        File myfile = new File(filename);
        Path path = myfile.toPath();

        BasicFileAttributes fatr = Files.readAttributes(path,
                BasicFileAttributes.class);

        return fatr.lastAccessTime().toString();

    }


    public static void upadteMonthsArray(String monthStr, int[] months){
        switch (monthStr) {
            case "JANUARY":
                months[0]++;
                break;
            case "FEBRUARY":
                months[1]++;
                break;
            case "MARCH":
                months[2]++;
                break;
            case "APRIL":
                months[3]++;
                break;
            case "MAY":
                months[4]++;
                break;
            case "JUNE":
                months[5]++;
                break;
            case "JULY":
                months[6]++;
                break;
            case "AUGUST":
                months[7]++;
                break;
            case "SEPTEMBER":
                months[8]++;
                break;
            case "OCTOBER":
                months[9]++;
                break;
            case "NOVEMBER":
                months[10]++;
                break;
            case "DECEMBER":
                months[11]++;
                break;
        }
    }


    public static void main(String[] args) {
	// write your code here
        int months[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("C:\\Users\\Amer\\Desktop\\input"));
            for (Path path : directoryStream) {
//              //Splitting String to get month Value
                String splittedStr[] = getCreationDetails((path.toString())).split("-");

                //Checking if 0 exist in string of a month ( example : 04, 07 etc)
                if(splittedStr[1].charAt(0) == '0'){
                    // Create a month instance
                    int monthValue = Integer.parseInt(splittedStr[1]);
                    Month month = Month.of(monthValue);
                    String monthStr = month.toString();

                    // Method to update Count of respective month
                       upadteMonthsArray(monthStr, months);

                } else{
                    // Create a month instance
                    int monthValue = Integer.parseInt(splittedStr[1]);
                    Month month = Month.of(monthValue);
                    String monthStr = month.toString();

                    // Method to update Count of respective month
                    upadteMonthsArray(monthStr, months);
                }

            }

        } catch (IOException ex) {
        }


        String[] monthNames = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JULY", "AUG", "SEPT", "OCT", "NOV", "DEC"};
         for(int i = 0; i < months.length; i++){
             System.out.println("files created in " + monthNames[i] + " : " + months[i]);
         }


    }

}
