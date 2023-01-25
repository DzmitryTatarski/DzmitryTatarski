package balancedWordsCounter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BalancedWordsCounter {

    public Integer count(String input) {
        if (input == null) {
            throw new RuntimeException();
        }
        char[] characters = input.toCharArray();
        for (char character : characters) {
            if (Character.isDigit(character))
                throw new RuntimeException();
        }
        int count = 0;
        for (int i = 1; i <= characters.length; i++) {
            int start = 0;
            int end = i;

            for (int j = 0; j <= characters.length - i; j++) {
                if (isBalanced(createSubWord(start, end, characters))){
                    count++;
                }
                start++;
                end++;
            }
        }
        return count;
    }

    private boolean isBalanced(String word) {
        if (word.length() > 2) {
            char[] characters = word.toCharArray();
            Map<Character, Integer> charactersMap = new HashMap<>();
            int count = 0;
            Character letter;
            for (int i = 0; i < characters.length; i++) {
                letter = characters[i];
                if (charactersMap.containsKey(letter)) {
                    count = charactersMap.get(letter);
                    charactersMap.put(letter, count + 1);
                } else
                    charactersMap.put(letter, 1);
            }
            Set<Character> keys = charactersMap.keySet();
            for (Character key : keys) {
                if (count + 1 != charactersMap.get(key))
                    return false;
            }
        }
        return true;
    }

    private String createSubWord(int start, int end, char[] chars){
        StringBuilder string = new StringBuilder();
        for (int i = start; i < end; i++) {
            string.append(chars[i]);
        }
        return String.valueOf(string);
    }
}

