package dsa_java25;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class roman_number {
	public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                result -= romanMap.get(s.charAt(i));
            } else {
                result += romanMap.get(s.charAt(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        roman_number sol = new roman_number();

        System.out.print("Enter a Roman numeral: ");
        String roman = scanner.nextLine().toUpperCase(); // Convert input to uppercase for consistency

        int result = sol.romanToInt(roman);
        System.out.println("Integer value: " + result);

        scanner.close(); // Close the scanner to prevent memory leaks
    }

}
