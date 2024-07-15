package com.gfg;

public class IsSubsetSum {


//    recursion
    static Boolean isSubsetSum(int n, int set[], int sum){
        // code here
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);

        // Else, check if sum can be obtained
        // by any of the following
        // (a) including the last element
        // (b) excluding the last element
        return isSubsetSum(set, n - 1, sum)
                || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }


//    memoization
static int subsetSum(int a[], int n, int sum)
{
    // Storing the value -1 to the matrix
    int tab[][] = new int[n + 1][sum + 1];
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= sum; j++) {
            tab[i][j] = -1;
        }
    }

    // If the sum is zero it means
    // we got our expected sum
    if (sum == 0)
        return 1;

    if (n <= 0)
        return 0;

    // If the value is not -1 it means it
    // already call the function
    // with the same value.
    // it will save our from the repetition.
    if (tab[n - 1][sum] != -1)
        return tab[n - 1][sum];

    // If the value of a[n-1] is
    // greater than the sum.
    // we call for the next value
    if (a[n - 1] > sum)
        return tab[n - 1][sum]
                = subsetSum(a, n - 1, sum);
    else {

        // Here we do two calls because we
        // don't know which value is
        // full-fill our criteria
        // that's why we doing two calls
        if (subsetSum(a, n - 1, sum) != 0
                || subsetSum(a, n - 1, sum - a[n - 1])
                != 0) {
            return tab[n - 1][sum] = 1;
        }
        else
            return tab[n - 1][sum] = 0;
    }
}

// dp
static boolean isSubsetSum(int set[], int n, int sum)
{
    // The value of subset[i][j] will be
    // true if there is a subset of
    // set[0..j-1] with sum equal to i
    boolean subset[][] = new boolean[sum + 1][n + 1];

    // If sum is 0, then answer is true
    for (int i = 0; i <= n; i++)
        subset[0][i] = true;

    // If sum is not 0 and set is empty,
    // then answer is false
    for (int i = 1; i <= sum; i++)
        subset[i][0] = false;

    // Fill the subset table in bottom
    // up manner
    for (int i = 1; i <= sum; i++) {
        for (int j = 1; j <= n; j++) {
            subset[i][j] = subset[i][j - 1];
            if (i >= set[j - 1])
                subset[i][j]
                        = subset[i][j]
                        || subset[i - set[j - 1]][j - 1];
        }
    }

    return subset[sum][n];
}

// dp space optimised
static boolean isSubsetSum(int[] set, int n, int sum) {
    boolean[] prev = new boolean[sum + 1];

    // If the sum is 0, the answer is true
    for (int i = 0; i <= n; i++)
        prev[0] = true;

    // If the sum is not 0 and the set is empty,
    // the answer is false
    for (int i = 1; i <= sum; i++)
        prev[i] = false;

    // curr array to store the current row result generated
    // with the help of the prev array
    boolean[] curr = new boolean[sum + 1];

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= sum; j++) {
            if (j < set[i - 1])
                curr[j] = prev[j];
            if (j >= set[i - 1])
                curr[j] = prev[j] || prev[j - set[i - 1]];
        }
        // now curr becomes prev for (i + 1)th element
        prev = Arrays.copyOf(curr, curr.length);
    }

    return prev[sum];
}
}
