package problem001_100;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最长回文子串
 * Created by zjw on 2017/6/26 10:26.
 */
public class P1032 {

    public static int longestPalindromicSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int n = 2 * s.length() + 1;
        char[] sc = new char[n];
        int[] p = new int[n];
        sc[n - 1] = '#';
        for(int i = 0; i < s.length(); i++) {
            sc[i * 2 + 1] = s.charAt(i);
            sc[i * 2] = '#';
        }

        p[0] = 1;
        int right = 1, id = 0, max = 1;
        for(int i = 1; i < n; i++) {
            p[i] = right > i ? Math.min(right - i, p[2 * id - i]) : 1;
            // System.out.printf("%d %d %d\n", p[i], right, id);
            while(i - p[i] >= 0 && i + p[i] < n && sc[i + p[i]] == sc[i - p[i]]) {
                p[i]++;
            }
            max = Math.max(max, p[i] - 1);
            if(i + p[i] > right) {
                right = i + p[i];
                id = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        for(int i = 1; i <= num; i++) {
            String s = sc.nextLine();
            System.out.println(longestPalindromicSubstring(s));
        }
    }

}
