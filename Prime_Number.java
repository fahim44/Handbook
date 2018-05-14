/*
 show Prime number from 1 to n.
 ex: n=9; ans: 2,3,5,7

 Algo: Sieve of Eratosthenes
 O(n log log n)
 */

import java.util.*;

class Solution {
    public static void main(String args[] ) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        if(n<2)
            return;

        boolean[] isNotPrime = new boolean[n+1];

        int root_n = (int)Math.sqrt(n);

        for(int i = 2; i<=root_n;i++){
            if(!isNotPrime[i]){
                for(int j = i+i;j<=n;j+=i){
                    isNotPrime[j]=true;
                }
            }
        }

        for(int i=2;i<=n;i++){
            if(!isNotPrime[i]) {
                System.out.print((i));
                System.out.print(" ");
            }
        }

    }
}
