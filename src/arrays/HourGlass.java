package arrays;

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

class Result extends HourGlass {


    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    Result(){

    }
    Result(int a){
        this();


    }

    public static int hourglassSum(List<List<Integer>> arr) {
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=4; i++){
            for (int j=1; j<=4; j++){
                int sum = arr.get(i).get(j) +
                        arr.get(i-1).get(j-1) + arr.get(i-1).get(j) + arr.get(i-1).get(j+1) +
                        arr.get(i+1).get(j-1) + arr.get(i+1).get(j) + arr.get(i+1).get(j+1) ;
                if (sum> max)
                    max = sum;
            }
        }
        return max;

    }

}

public class HourGlass {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);
        System.out.println(result);
        bufferedReader.close();
    }
}
