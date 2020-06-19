import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static HashMap<Character, Integer> getCharCountMap(String inputString) {
        // character->frequency map
        // example a->2
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();

        for(int idx = 0; idx < inputString.length() ; idx ++) {
            char currentCharacter = inputString.charAt(idx);
            // check in hash map if cc key exists
            // if not, insert it with value 1
            // if yes, get value, add one and put it back in the map
            Integer charCount = countMap.get(currentCharacter);

            if(charCount == null) {
                countMap.put(currentCharacter, 1);
            } else {
                countMap.put(currentCharacter, charCount + 1);
            }
        }

        return countMap;

    }

    static int makeAnagram(String a, String b) {

        HashMap<Character, Integer> aMap = getCharCountMap(a);
        HashMap<Character, Integer> bMap = getCharCountMap(b);
        int result = 0;
        // iterate and compare both hashmap
        for (Character charKey : aMap.keySet()) {  
            
            Integer aCount = aMap.get(charKey);
            Integer bCount = bMap.get(charKey);

            if(bCount != null) {
                result += Math.abs(aCount - bCount);
                bMap.remove(charKey);
            } else {
                result += aCount;
            }

        }

        for(Character charKey: bMap.keySet() ) {
            result += bMap.get(charKey);
        }

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    private Long testing() {
        Long a = 10;
        Long b = 20;
        Long c = a + b;
        return c;
    }
}
