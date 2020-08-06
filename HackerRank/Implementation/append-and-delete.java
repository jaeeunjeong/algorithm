//https://www.hackerrank.com/challenges/append-and-delete/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        String result ="No";
        int cnt = 0;
        int length = Math.min(s.length(), t.length());
        for (int i = 0; i < length; i++) {
            if(s.charAt(i) ==  t.charAt(i)) {
                cnt++;
            }else{
                break;
            }
            
        }    
        if((s.length()+t.length()-2*cnt)>k){
            result = "No";
        }else if(((s.length()+t.length()-2*cnt)%2==k%2)||((s.length()+t.length()-k)<0)) {
            result = "Yes";

        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
