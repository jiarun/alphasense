import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            char currentChar = s.charAt(j);
            if (charIndexMap.containsKey(currentChar)) {
                // Moving start of the window to the next position after the repeated character
                i = Math.max(charIndexMap.get(currentChar) + 1, i);
            }
            charIndexMap.put(currentChar, j);
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        scanner.close();
        int result = lengthOfLongestSubstring(userInput);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
