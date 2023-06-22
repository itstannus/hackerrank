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

import static java.util.Collections.swap;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
*
*
* input :
2
5
2 1 5 3 4
5
2 5 1 3 4
*
 output :
3

Too chaotic
*
*
* */


public class NewYearChaos {

    public static void minimumBribes(List<Integer> q) {
        int swapCount=0;

        for (int i = q.size()-1 ; i>=0 ; i--){
            if (q.get(i) != (i+1)){
                if(q.get(i-1) == (i+1)){
                    //bribed once
                    swapCount++;
                    //undo the bribe
                    swap(q, i-1, i);
                } else if (q.get(i-2) == (i+1)){
                    //bribed twice
                    swapCount+=2;
                    swap(q, i-2, i-1);
                    swap(q, i-1, i);
                } else {
                    // bribe more than twice
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swapCount);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());
                System.out.println();

                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
