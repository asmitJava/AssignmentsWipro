package dsa.assignment;

import java.util.*;

public class KMPPatternSrch {

    
    private int[] computeLPSArray(String pattern) {
        int len = pattern.length();
        int[] lps = new int[len];
        int j = 0;  

        lps[0] = 0; 

        int i = 1;
        while (i < len) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }


    public List<Integer> search(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int M = pattern.length();
        int N = text.length();
        int[] lps = computeLPSArray(pattern);
        int i = 0;  
        int j = 0;  

        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == M) {
                indices.add(i - j);
                j = lps[j - 1];
            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return indices;
    }

  
    public static void main(String[] args) {
        Assignment1D8 kmp = new Assignment1D8();
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        List<Integer> indices = kmp.search(text, pattern);
        if (indices.isEmpty()) {
            System.out.println("Pattern not found in the text");
        } else {
            System.out.print("Pattern found at indices: ");
            for (int index : indices) {
                System.out.print(index + " ");
            }
        }
    }
}