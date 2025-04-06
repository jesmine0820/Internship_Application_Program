package Utility;

/**
 * 
 * Author - JesmineTeyKhaiJing
 * 
 * Explanations:
 * 1. Searching Module
 * 2. Fuzzy Matching
 * 
 */

public class Searching {

    // Search by using Knuth-Morris-Pratt
    public boolean search(String text, String pattern) {
        if (pattern == null || pattern.isEmpty() || text == null || text.isEmpty()) return false;

        int[] lps = computeLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) return true;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return false;
    }

    // Calculate the LPS Distance
    private int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = ++j;
            }
        }
        return lps;
    }

    // Fuzzy Matching by using Levenshtein Distance
    public int fuzzyMatching(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1),
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }
}
