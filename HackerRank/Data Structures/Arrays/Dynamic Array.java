//https://www.hackerrank.com/challenges/dynamic-array/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
        List<Integer> result = new ArrayList<Integer>(); 
        int lastAnswer = 0;
        List<List<Integer>> s = new ArrayList<>();
        //List<Integer> seq0 = new ArrayList<Integer>();
        //List<Integer> seq1 = new ArrayList<Integer>();
        
        for (int i = 0; i < n; i++) {
            s.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < queries.size(); i++) {
            int query = queries.get(i).get(0);
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            
            //find Seq
            int seq = (x^lastAnswer)%n;
            //query1
            if(1 == query) {
                /*
                if(0 == seq) {
                    seq0.add(y);
                }else {
                    seq1.add(y);
                }
                */
                s.get(seq).add(y);
            }
            //query2
            if(2 == query) {
                int index =  y %  s.get(seq).size();
                /*if(0 == seq) {
                    lastAnswer = seq0.get(index);
                }else {
                    lastAnswer = seq1.get(index);
                }*/
                lastAnswer = s.get(seq).get(index);
                result.add(lastAnswer);
            }
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
