import java.util.*;
import java.io.*;
public class Solution2 {
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
            int[][] rights = new int[grid.length][grid[0].length];
            int[][] downs = new int[grid.length][grid[0].length];
            int[][] ups = new int[grid.length][grid[0].length];
            for (int q = 0; q < grid.length; q++){
                rights[q] = Arrays.copyOf(grid[q], grid[q].length);
                downs[q] = Arrays.copyOf(grid[q], grid[q].length);
                ups[q] = Arrays.copyOf(grid[q], grid[q].length);
            }


            int segments = 0;
            for(int j = 0; j < r; j++){
                int left = 0;
                for(int k = 0; k < c; k++){
                    if(grid[j][k] != 0){
                        left++;
                        int right = 1;
                        if(k> 0 && rights[j][k-1] > 1){
                            rights[j][k] = rights[j][k-1]-1;
                            right = rights[j][k];
                        } else{
                            int track = k;
                            while(track<grid[j].length-1 && grid[j][track+1] == 1){
                                right++;
                                track++;
                            }
                            rights[j][k] = right;
                        }
                        int down = 1;
                        if(j> 0 && downs[j-1][k] > 1){
                            downs[j][k] = downs[j-1][k]-1;
                            down = downs[j][k];
                        } else{
                            int track = j;
                            while(track<grid.length-1 && grid[track+1][k] == 1){
                                down++;
                                track++;
                            }
                            downs[j][k] = down;
                        }
                        int up = 1;
                        if(j>0){
                            up = ups[j-1][k] + 1;
                            ups[j][k] = up;
                        }

                        if(up >= 4){
                            if(left >= 2){
                                int tempUp = up;
                                int tempLeft = left;
                                while(tempUp >= 4 && tempLeft >= 2){
                                    if(tempUp/2 == tempLeft) {
                                        segments++;
                                        tempUp--;
                                        tempLeft--;
                                    }else if(tempUp/2 > tempLeft){
                                        tempUp--;
                                    } else{
                                        tempLeft--;
                                    }
                                }
                            }

                            if(right >= 2){
                                int tempUp = up;
                                int tempRight = right;
                                while(tempUp >= 4 && tempRight >= 2){
                                    if(tempUp/2 == tempRight) {
                                        segments++;
                                        tempUp--;
                                        tempRight--;
                                    }else if(tempUp/2 > tempRight){
                                        tempUp--;
                                    } else{
                                        tempRight--;
                                    }
                                }
                            }
                        }

                        if(down >= 4){
                            if(left >= 2){
                                int tempDown = down;
                                int tempLeft = left;
                                while(tempDown >= 4 && tempLeft >= 2){
                                    if(tempDown/2 == tempLeft) {
                                        segments++;
                                        tempDown--;
                                        tempLeft--;
                                    }else if(tempDown/2 > tempLeft){
                                        tempDown--;
                                    } else{
                                        tempLeft--;
                                    }
                                }
                            }

                            if(right >= 2){
                                int tempDown = down;
                                int tempRight = right;
                                while(tempDown >= 4 && tempRight >= 2){
                                    if(tempDown/2 == tempRight) {
                                        segments++;
                                        tempDown--;
                                        tempRight--;
                                    }else if(tempDown/2 > tempRight){
                                        tempDown--;
                                    } else{
                                        tempRight--;
                                    }
                                }
                            }
                        }

                        if(right >= 4){
                            if(up >= 2){
                                int tempRight = right;
                                int tempUp = up;
                                while(tempRight >= 4 && tempUp >= 2){
                                    if(tempRight/2 == tempUp) {
                                        segments++;
                                        tempUp--;
                                        tempRight--;
                                    }else if(tempRight/2 > tempUp){
                                        tempRight--;
                                    } else{
                                        tempUp--;
                                    }
                                }
                            }

                            if(down >= 2){
                                int tempRight = right;
                                int tempDown = down;
                                while(tempRight >= 4 && tempDown >= 2){
                                    if(tempRight/2 == tempDown) {
                                        segments++;
                                        tempRight--;
                                        tempDown--;
                                    }else if(tempRight/2 > tempDown){
                                        tempRight--;
                                    } else{
                                        tempDown--;
                                    }
                                }
                            }
                        }

                        if(left >= 4){
                            if(up >= 2){
                                int tempLeft = left;
                                int tempUp = up;
                                while(tempLeft >= 4 && tempUp >= 2){
                                    if(tempLeft/2 == tempUp) {
                                        segments++;
                                        tempLeft--;
                                        tempUp--;
                                    }else if(tempLeft/2 > tempUp){
                                        tempLeft--;
                                    } else{
                                        tempUp--;
                                    }
                                }
                            }

                            if(down >= 2){
                                int tempLeft = left;
                                int tempDown = down;
                                while(tempLeft >= 4 && tempDown >= 2){
                                    if(tempLeft/2 == tempDown) {
                                        segments++;
                                        tempLeft--;
                                        tempDown--;
                                    }else if(tempLeft/2 > tempDown){
                                        tempLeft--;
                                    } else{
                                        tempDown--;
                                    }
                                }
                            }
                        }


                    } else{
                        left = 0;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + segments);
        }
    }

    private static int resolve(int[][] grid, int j, int k){
        int boxesToAdd = 0;
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