
public class SkillBridgeOptimization {

    // Activity Selection (Greedy)
    static void activitySelection(int start[], int finish[]) {
        int n = start.length;
        System.out.println("Selected Learning Sessions:");

        int i = 0;
        System.out.print("Session " + i);

        for (int j = 1; j < n; j++) {
            if (start[j] >= finish[i]) {
                System.out.print(" -> Session " + j);
                i = j;
            }
        }
        System.out.println();
    }

    // 0/1 Knapsack (Dynamic Programming)
    static int knapsack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }

    // Longest Common Subsequence (LCS)
    static int lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    // Matrix Chain Multiplication (MCM)
    static int matrixChainOrder(int p[]) {
        int n = p.length;
        int dp[][] = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int q = dp[i][k] + dp[k + 1][j]
                            + p[i - 1] * p[k] * p[j];

                    if (q < dp[i][j])
                        dp[i][j] = q;
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {

        // Activity Selection Example
        int start[] = {1, 3, 0, 5, 8, 5};
        int finish[] = {2, 4, 6, 7, 9, 9};

        System.out.println("Activity Selection (Study Sessions):");
        activitySelection(start, finish);

        // Knapsack Example
        int values[] = {60, 100, 120}; // course benefits
        int weights[] = {10, 20, 30};  // course credits
        int capacity = 50;

        System.out.println("\nMaximum Learning Benefit (Knapsack): "
                + knapsack(capacity, weights, values, values.length));

        // LCS Example
        String student1 = "JAVA";
        String student2 = "JAVASCRIPT";

        System.out.println("\nLongest Common Skill Sequence (LCS): "
                + lcs(student1, student2));

        // Matrix Chain Multiplication Example
        int modules[] = {10, 20, 30, 40, 30};

        System.out.println("\nMinimum Module Processing Cost (MCM): "
                + matrixChainOrder(modules));
    }
}