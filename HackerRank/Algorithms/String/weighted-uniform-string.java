//https://www.hackerrank.com/challenges/weighted-uniform-string/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {

        Map map  = new HashMap();
        Set set = new HashSet();
        String []result =  new String[queries.length];
        
        //alphabet
        for (int i = 1; i <=26; i++) {
            char c = (char) ('a'+i-1);
            map.put(c, i);
        }
        
        //점수 매기기
        char before = 0;
        int m = 1;
        for (int i = 0; i < s.length(); i++) {
            //중복인 경우
            int cnt = (int) map.get(s.charAt(i));
            if(s.charAt(i) == before) {
                m++;
            }else {
                m = 1;
                before = s.charAt(i);
            }
            set.add(cnt*m);
        }
        
        //proof
        for (int i = 0; i < queries.length; i++) {
            int temp = queries[i];
            if(set.contains(temp)) {
                result[i] = "Yes";
            }else {
                result[i] = "No";
            }
        }
        
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
