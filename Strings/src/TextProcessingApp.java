import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextProcessingApp {
    public static void main(String[] args) {
    String str ="""
                   In this application, we'll create a text processing tool that performs various operations on input text such as:
                   
                   Counting the number of characters, words, and lines in the text.
                   Reversing the text.
                   Converting the text to uppercase.
                   Removing duplicate words from the text.
                   """;
        System.out.println(countWords(str));
        System.out.println(countLines(str));
        System.out.println(reverseText(str));
        System.out.println(removeDuplicates(str));


    }

    // Method to count words in the text
    private static int countWords(String text) {
        String[] S = text.split(" ");
        return S.length;
    }

    // Method to count lines in the text
    private static int countLines(String text) {
        String[] S = text.split("\n");
        return S.length;
    }

    // Method to reverse the text
    private static String reverseText(String text) {
        return new StringBuilder(text).reverse().toString();
    }

//     Method to remove duplicate words from the text
    private static String removeDuplicates(String text) {
        String[] S = text.split(" ");
        String result="";
        List<String> set= new Set<>();
        for(String s:S){
            if(!set.contains(s)) {
                result=result.concat(s);
                set.add(s);
            }
        }
        return result;
    }
}