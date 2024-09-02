package dsa.assignment;

public class StringUtil {

    public String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public String concatenate(String str1, String str2) {
        if (str1 == null) 
        {
            str1 = "";
        }
        if (str2 == null) 
        {
            str2 = "";
        }
        return str1 + str2;
    }

   
    public boolean contains(String str, String subStr) {
        return str != null && subStr != null && str.contains(subStr);
    }
}