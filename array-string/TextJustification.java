/*
 * LeetCode Problem: #68 - Text Justification
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Core Idea:
 * 1. Greedily pack as many words as possible into a line.
 * 2. If last line or single word → left justify.
 * 3. Otherwise:
 *      - Distribute spaces evenly.
 *      - Extra spaces go to leftmost gaps.
 * 4. Repeat until all words are processed.
 *
 * Pattern: Greedy + String Construction
 */

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        if (words == null || words.length == 0 || maxWidth <= 0) {
            return result;
        }

        int index = 0;

        while (index < words.length) {

            int lineLength = words[index].length();
            int last = index + 1;

            // Determine how many words fit in current line
            while (last < words.length) {
                if (lineLength + 1 + words[last].length() > maxWidth) {
                    break;
                }
                lineLength += 1 + words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder();
            int numberOfWords = last - index;
            int numberOfGaps = numberOfWords - 1;

            // Case 1: Last line OR single word → left justify
            if (last == words.length || numberOfGaps == 0) {

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        line.append(" ");
                    }
                }

                appendSpaces(line, maxWidth - line.length());

            } else {

                int totalSpaces = maxWidth - (lineLength - numberOfGaps);
                int spacesPerGap = totalSpaces / numberOfGaps;
                int extraSpaces = totalSpaces % numberOfGaps;

                for (int i = index; i < last; i++) {

                    line.append(words[i]);

                    if (i < last - 1) {
                        appendSpaces(line,
                                spacesPerGap + (i - index < extraSpaces ? 1 : 0));
                    }
                }
            }

            result.add(line.toString());
            index = last;
        }

        return result;
    }

    private void appendSpaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
    }

    public static void main(String[] args) {

        TextJustification solution = new TextJustification();

        String[] words = {
                "This", "is", "an", "example",
                "of", "text", "justification."
        };

        int maxWidth = 16;

        List<String> result = solution.fullJustify(words, maxWidth);

        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
    }
}