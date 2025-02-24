# Wildcard-Matching
Given two strings, s (the input string) and p (the pattern), implement wildcard matching with support for two special characters:
Explanation:
Dynamic Programming (DP) Table Setup:

dp[i][j] is a boolean that is true if the substring s[0...i-1] matches the subpattern p[0...j-1].
The table is of size (m + 1) x (n + 1) to handle empty substrings.
Initialization:

dp[0][0] = true because an empty string matches an empty pattern.
For the first row, only '*' in p can match an empty s.
Filling the DP Table:

If the pattern character pc is '*', it can either match no characters (dp[i][j-1]) or one more character from s (dp[i-1][j]).
If pc is '?' or equals the current character in s, carry forward the result from dp[i-1][j-1].
Otherwise, the current characters do not match.
Result:

The final result is in dp[m][n], indicating whether the entire string s matches the pattern p.
