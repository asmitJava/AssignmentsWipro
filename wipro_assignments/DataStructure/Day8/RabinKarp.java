package dsa.assignment;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {

    private static final int PRIME = 101;
    private static final int BASE = 256;

    public static List<Integer> search(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();

        int patternHash = calculateHash(pattern, m);
        int textHash = calculateHash(text, m);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && checkEqual(text, i, pattern, 0, m)) {
                result.add(i);
            }
            if (i < n - m) {
                textHash = recalculateHash(text, textHash, i, m);
            }
        }

        return result;
    }

    private static int calculateHash(String str, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * BASE + str.charAt(i)) % PRIME;
        }
        return hash;
    }

    private static int recalculateHash(String str, int oldHash, int oldIndex, int m) {
        int newHash = oldHash - str.charAt(oldIndex) * pow(BASE, m - 1);
        newHash = newHash * BASE + str.charAt(oldIndex + m);
        newHash = (newHash % PRIME + PRIME) % PRIME;
        return newHash;
    }

    private static int pow(int base, int exp) {
        int result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % PRIME;
            }
            base = (base * base) % PRIME;
            exp /= 2;
        }
        return result;
    }

    private static boolean checkEqual(String text, int start1, String pattern, int start2, int length) {
        for (int i = 0; i < length; i++) {
            if (text.charAt(start1 + i) != pattern.charAt(start2 + i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        List<Integer> result = search(text, pattern);
        System.out.println("Pattern found at indexes: " + result);
    }
}