package WarGame;

public class Compare {
    public static void main(String[] args) {
        String str1 = "Henry";
        String str2 = "Harry";

        System.out.println(str1.compareTo(str2));

        if (str1.compareTo(str2) < 0) {
            System.out.println("String 1 comes first");
        } else if (str1.compareTo(str2) > 0) {
            System.out.println("String 2 comes first");
        } else {
            System.out.println("String are equal");
        }
    }
}
