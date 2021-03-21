import java.util.*;
import java.io.*;
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int c = in.nextInt();
            int[][] grid = new int[r][c];
            for(int j = 0; j < r; j++){
                for(int k = 0; k < c; k++){
                    grid[j][k] = in.nextInt();
                }
            }
            long totalBoxesToAdd = 0;
            for(int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    totalBoxesToAdd+=resolve(grid, j, k);
                }
            }


            System.out.println("Case #" + i + ": " + totalBoxesToAdd);
        }
    }

    private static long resolve(int[][] grid, int j, int k){
        long boxesToAdd = 0;
        int maxHeightAround = getMaxHeight(grid, j, k);
        if (maxHeightAround > grid[j][k] + 1) {
            boxesToAdd+= (maxHeightAround - (grid[j][k] + 1));
            grid[j][k] = maxHeightAround - 1;
            if(j>0 && grid[j-1][k] < grid[j][k]-1){
                boxesToAdd+=resolve(grid,j-1, k);
            }

            if(j<grid.length-1 && grid[j+1][k] < grid[j][k]-1){
                boxesToAdd+=resolve(grid,j+1, k);
            }

            if(k>0 && grid[j][k-1] < grid[j][k]-1){
                boxesToAdd+=resolve(grid,j, k-1);
            }

            if(k < grid[j].length-1 && grid[j][k+1] < grid[j][k]-1){
                boxesToAdd+=resolve(grid,j, k+1);
            }
        }

        return boxesToAdd;
    }

    private static int getMaxHeight(int[][] grid, int j, int k){
        int maxHeight = 0;
        if(j>0){
            maxHeight = Math.max(grid[j-1][k], maxHeight);
        }

        if(j < grid.length-1){
            maxHeight = Math.max(grid[j+1][k], maxHeight);
        }

        if(k>0){
            maxHeight = Math.max(grid[j][k-1], maxHeight);
        }

        if(k < grid[j].length-1){
            maxHeight = Math.max(grid[j][k+1], maxHeight);
        }

        return maxHeight;
    }
}