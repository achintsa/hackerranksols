import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String isBalanced(String s) {

        HashMap<Character, Character> bracketMap = new HashMap<Character, Character>();
        bracketMap.put('{', '}');
        bracketMap.put('[', ']');
        bracketMap.put('(', ')');

        Stack<Character> bracketStack = new Stack<Character>();
        if(s.length() > 0) {
            bracketStack.add(s.charAt(0));
        } else {
            return "YES";
        }
        
        for(int idx = 1; idx < s.length(); idx++) {
            Character cc = s.charAt(idx);
            if(!bracketStack.empty() && cc == bracketMap.get( bracketStack.peek() ) ) {
                // partner found
                bracketStack.pop();
                    
            } else {
                // matching partner not found
                bracketStack.push(cc);
            }
        }

        if(bracketStack.empty() ) {
            return "YES";
        } else {
            return "NO";
        }


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
