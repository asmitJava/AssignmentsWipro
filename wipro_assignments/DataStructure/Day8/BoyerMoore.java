package dsa.assignment;

import java.util.Arrays;

public class BoyerMoore {

    public static int lastOccurrence(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m == 0) return 0;

        int[] last = buildLast(pattern);

        int i = m - 1;
        int j = m - 1;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == 0) {
                    return i;
                }
                i--;
                j--;
            } else {
                i = i + m - Math.min(j, 1 + last[text.charAt(i)]);
                j = m - 1;
            }
        }

        return -1;
    }

    private static int[] buildLast(String pattern) {
        int[] last = new int[256];

        Arrays.fill(last, -1);

        for (int i = 0; i < pattern.length(); i++) {
            last[pattern.charAt(i)] = i;
        }

        return last;
    }

    public static void main(String[] args) {
        String text = "abracadabra";
        String pattern = "abra";

        int lastIndex = lastOccurrence(text, pattern);

        if (lastIndex != -1) {
            System.out.println("Last occurrence found at index: " + lastIndex);
        } else {
            System.out.println("Pattern not found in text.");
        }
    }
}
