package problem001_100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zjw on 2017/6/25 20:48.
 */

// KMP算法
public class P1015 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.valueOf(scan.nextLine());
        KMP kmp = new KMP();
        for(int i = 1; i <= count; i++) {
            String pattern = scan.nextLine(), origin = scan.nextLine();
            System.out.println(kmp.compare(origin, pattern));
        }
    }
}

class KMP {
    public int[] getNextArr(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while(i < next.length - 1) {
            if(j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                next[i] = j;
            }
            else
                j = next[j];
        }
//        System.out.println(Arrays.toString(next));
        return next;
    }

    public int compare(String ori, String pat) {
        int[] next = getNextArr(pat);
        int i = 0, k = 0, count = 0;
        while(i < ori.length()) {
            if(k == -1 || ori.charAt(i) == pat.charAt(k)) {
                if(k == pat.length() - 1) {
                    count++;
                    k = next[k];
                }
                else {
                    i++; k++;
                }
            }
            else{
                k = next[k];
            }
        }
        return count;
    }
}
