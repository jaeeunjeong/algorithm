//https://www.hackerrank.com/challenges/repeated-string
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

            // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        
        long m = n/s.length();
        long div = n%s.length();//0<s.charAt(i)<div
        long max = 0;
        char key ='a';
        Map map = new HashMap<Character, Long>();
        

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'a') max++;
        }
        
        Map mapResult = new HashMap<Character, Long>();
        long maxD = 0;
        for (int i = 0; i < div; i++) {
            char c = s.charAt(i);
            if('a' == c) {
            maxD++;
            }
        }
        
        long result = max*m+maxD;
        return result;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
