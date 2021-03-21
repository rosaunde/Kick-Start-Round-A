import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            String input = in.next();
            int left = 0;
            n = n -1;
            int diff = 0;
            while(left < n){
                if(input.charAt(left) != input.charAt(n)){
                    diff = diff + 1;
                }
                left++;
                n--;
            }
            System.out.println("Case #" + i + ": " + Math.abs(diff - k));
        }
    }
}