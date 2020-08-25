//https://www.hackerrank.com/challenges/pangrams/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pangrams function below.
    static String pangrams(String s) {      
        String result = "pangram";
        
        s = s.replaceAll(" ","").toLowerCase();
        char str[] = s.toCharArray();
        
        Arrays.sort(str);
        
        Set set = new LinkedHashSet<>();
        
        for (int i = 0; i < str.length; i++) {
            char c = s.charAt(i);
            if(!set.contains(c)) {
                set.add(c);
            }
        }

        if(set.size() <26) {
            result = "not pangram";
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
