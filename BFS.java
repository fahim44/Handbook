/*
Hackerrank ques: KnightL on a Chessboard
 */

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the knightlOnAChessboard function below.
    static int[][] knightlOnAChessboard(int n) {
        int[][] result = new int[n-1][n-1];

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                if(result[i][j]==0){
                    int k = new Solution().BFS(n,i+1,j+1);
                    result[i][j]=k;
                    result[j][i]=k;
                }
            }
        }

        return result;
    }

    class Point{
        public int x;
        public int y;

        public Point(int a, int b){
            x= a;
            y=b;
        }
    }

     int BFS(int height,int mov1,int mov2){
        int[] x = {mov1,-mov1,mov1,-mov1,mov2,-mov2,mov2,-mov2};  // knight can move to this x directions
        int[] y = {mov2,mov2,-mov2,-mov2,mov1,mov1,-mov1,-mov1};  // knight can move to this y directions

        int[][]dist = new int[height][height];
        for(int []a : dist){
            Arrays.fill(a,-1);
        }
        LinkedList<Point> list =new LinkedList<>();
        list.add(new Point(0,0));
        dist[0][0]=0;
        boolean foundSolution = false;

        while (!list.isEmpty()){
            Point p = list.removeFirst();
            for(int i=0;i<x.length;i++){
                int a = p.x + x[i];
                int b = p.y + y[i];
                if(a >= 0 && b >= 0 && a < height && b < height && dist[a][b] == -1 ){
                    dist[a][b] = 1 + dist[p.x][p.y];
                    list.add(new Point(a,b));

                    if(a==height-1 && b==height-1) {    //stop checking if knight reach the destination <destination is endPoint of the board>
                        foundSolution = true;
                        break;
                    }
                }
            }
            if(foundSolution)
                break;
        }
        return dist[height-1][height-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] result = knightlOnAChessboard(n);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                //bufferedWriter.write(String.valueOf(result[i][j]));
                System.out.print(String.valueOf(result[i][j]));

                if (j != result[i].length - 1) {
                    //bufferedWriter.write(" ");
                    System.out.print(" ");
                }
            }

            if (i != result.length - 1) {
                //bufferedWriter.write("\n");
                System.out.println();
            }
        }

        //bufferedWriter.newLine();
        System.out.println();

        //bufferedWriter.close();

        scanner.close();
    }
}
