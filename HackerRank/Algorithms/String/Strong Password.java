//https://www.hackerrank.com/challenges/strong-password/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        //길이
        //1.대문자
        //2.소문자
        //3.특수문자
        int result = 0;
        
        Pattern patternNbr = Pattern.compile("(\\d)");
        Pattern patternUpper = Pattern.compile("([A-Z])");
        Pattern patternLower = Pattern.compile("([a-z])");
        Pattern patternSpecial = Pattern.compile("(\\W)");
        
        Matcher matcherDigit = patternNbr.matcher(password);
        Matcher matcherUpper = patternUpper.matcher(password);
        Matcher matcherLower = patternLower.matcher(password);
        Matcher matcherSpecial = patternSpecial.matcher(password);
        
        if (!matcherDigit.find()) {
            result++;
        }
        if (!matcherUpper.find()) {
            result++;
        }
        if (!matcherLower.find()) {
            result++;
        }
        if (!matcherSpecial.find()) {
            result++;
        }
        if ((result+password.length())<6) {
            result = result + 6-(result+password.length());
        }
        return result;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
