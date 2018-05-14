/*

    1 1 0 0
    1 1 0 0
    0 0 0 1
    0 0 1 1

    find the largest culster of 1. Ans: 4
 */



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {

        int result = 0;
        int row = matrix.length;
        int column = 0;

        if(row>0)
            column = matrix[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(matrix[i][j]==1){
                    int count = DFS(matrix,i,j,row,column,0);
                    if(count>result)
                        result = count;
                }
            }
        }

        return result;

    }

    static int DFS(int[][] matrix,int x,int y,int row, int column,int count){
        matrix[x][y]=0;
        count++;
        for(int dx=-1;dx<=1;dx++){
            if(x+dx>-1 && x+dx<row){
                for(int dy=-1;dy<=1;dy++){
                    if(y+dy>-1 && y+dy<column){
                        if(matrix[x+dx][y+dy]==1){
                            count = DFS(matrix,x+dx,y+dy,row,column,count);
                        }
                    }
                }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();*/

        System.out.println(String.valueOf(result));

     //   bufferedWriter.close();

        scanner.close();
    }
}
