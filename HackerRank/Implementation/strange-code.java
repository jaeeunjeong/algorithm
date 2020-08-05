//https://www.hackerrank.com/challenges/strange-code/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        long result = 0;     
        long head = 1;
        long n = 0;
        long value = 0;
        //long pow = 1;

        while(t>=head) {//head 찾기
            //pow = (long) Math.pow(2,n);
            value = 3*(long) Math.pow(2,n);
            head = head + value;
            n++;
        }

        head = head-value;//origen head 찾기 
        result = value - (t-head);
        
        return result;

        /*
        long n = (long) Math.ceil(Math.log((t+3)/3.0)/Math.log(2));
        return (long) (6*(Math.pow(2, n-1)) - t -2);
        */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
