public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern.
        dp[0][0] = true;
        
        // Initialize first row: empty string s and pattern p.
        // '*' can match an empty sequence.
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill the DP table.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == '*') {
                    // '*' matches an empty sequence (dp[i][j-1]) or one more character (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (pc == '?' || pc == sc) {
                    // Current characters match, so carry forward the result.
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        WildcardMatching solution = new WildcardMatching();
        
        // Example test cases
        System.out.println("Test Case 1: " + solution.isMatch("aa", "a"));       // Expected: false
        System.out.println("Test Case 2: " + solution.isMatch("aa", "*"));       // Expected: true
        System.out.println("Test Case 3: " + solution.isMatch("cb", "?a"));      // Expected: false
        System.out.println("Test Case 4: " + solution.isMatch("adceb", "*a*b")); // Expected: true
    }
}
