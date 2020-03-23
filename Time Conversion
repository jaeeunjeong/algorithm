//https://www.hackerrank.com/challenges/time-conversion/problem
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String returnTime = s.toUpperCase().substring(2, s.length()-2);
        int hour = Integer.parseInt(s.split(":")[0]);
        boolean flag = false;
        if(hour % 12 != 0) {
            flag = true;
        }
        
        if(flag && s.endsWith("PM")) {
            hour = hour + 12;
        }
        if(!flag && s.endsWith("AM")) {
            hour = hour - 12;
        }

        String returnHour = String.valueOf(hour);
        if(hour < 10) returnHour = "0" + returnHour;
        returnTime = returnHour.concat(s.substring(2, s.length()-2));

        return returnTime;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
