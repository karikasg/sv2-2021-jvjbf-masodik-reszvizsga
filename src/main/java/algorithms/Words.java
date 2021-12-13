package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public void addWord(String word) {
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        } else if (!word.equals(word.toLowerCase())) {
            throw new IllegalArgumentException("Word should be lower case!");
        } else {
            words.add(word);
        }
    }

    public boolean isThereAWordTwice() {
        for (int i = 0; i < words.size()-1; i++) {
            for (int j = i+1; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<String> getWords() {
        return words;
    }
}
