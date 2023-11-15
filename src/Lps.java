public class Lps {
    // complexity = O(N)
    public static int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int len = 0; // Length of the previous longest prefix suffix

        lps[0] = 0; // lps[0] is always 0

        int i = 1;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // Move back to the previous longest prefix suffix
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    static void matchKps(String x,String pattern){
        int len1 = x.length();
        int len2 = pattern.length();

        //create lps array that will hold longest prefix sufix values

        int[] lps = computeLPS(pattern);
        int j=0; //index for pat[]
        int i=0; // index for txt[]
        boolean found = false; // var to find pattern

        while(i<len1){
            if(pattern.charAt(j)== x.charAt(i)){
                j++;
                i++;
            }
            if(j==len2){
                found=true;
                System.out.println("Pattern found at: "+(i-j));
                j=lps[j-1];
                //mismatches after j index
            } else if (i<len1 && pattern.charAt(j)!= x.charAt(i)) {
                // donot match lps[0...lps[j-1]] chars
                if(j!=0){
                    j= lps[j-1];
                }
                else{
                    i=i+1;
                }
            }
        }
        if (!found) System.out.println();
    }

    public static void main(String[] args) {
        String pattern = "aacaaa";
        int[] lps = computeLPS(pattern);
        matchKps("abcjdhkaacaaalppi",pattern);
        System.out.print("LPS array for '" + pattern + "': ");
        for (int value : lps) {
            System.out.print(value + " ");
        }
    }
}
