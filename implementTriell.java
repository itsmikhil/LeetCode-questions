
import java.util.*;
import java.io.*;

public class Trie {

    // explanation on 150

    class node {
        node links[];
        int numOfWordsCompleted;
        int numOfWordStartingWith;

        public node() {
            links = new node[26];
            numOfWordsCompleted = 0;
            numOfWordStartingWith = 0;
        }

        boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }

        void putChar(char ch) {
            links[ch - 'a'] = new node();
        }

        node getNext(char ch) {
            return links[ch - 'a'];
        }

        void incrementStartsWith() {
            numOfWordStartingWith++;
        }

        void incrementNumOfWordsEnding() {
            numOfWordsCompleted++;
        }

        void decrementStartsWith() {
            numOfWordStartingWith--;
        }

        void decrementNumOfWordsEnding() {
            numOfWordsCompleted--;
        }

        int getNumOfWordsEnding() {
            return numOfWordsCompleted;
        }

        int getNumOfWordsStarting() {
            return numOfWordStartingWith;
        }
    }

    node root;

    public Trie() {
        root = new node();
    }

    public void insert(String word) {
        node temp = root;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            if (!temp.contains(curr)) {
                temp.putChar(curr);
            }

            temp = temp.getNext(curr);
            temp.incrementStartsWith();
        }

        temp.incrementNumOfWordsEnding();
    }

    public int countWordsEqualTo(String word) {
        node temp = root;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            if (!temp.contains(curr)) {
                return 0;
            }

            temp = temp.getNext(curr);
        }

        return temp.getNumOfWordsEnding();
    }

    public int countWordsStartingWith(String word) {
        node temp = root;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            if (!temp.contains(curr)) {
                return 0;
            }

            temp = temp.getNext(curr);
        }

        return temp.getNumOfWordsStarting();
    }

    public void erase(String word) {
        if (countWordsEqualTo(word) == 0) {
            return;
        }

        node temp = root;

        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);

            temp = temp.getNext(curr);
            temp.decrementStartsWith();
        }

        temp.decrementNumOfWordsEnding();
    }
}
