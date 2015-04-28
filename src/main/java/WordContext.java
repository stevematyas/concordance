import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by smatyas on 4/27/15.
 */

public class WordContext {
    private String word;
    private int frequency;
    private List<Integer> sentencesAppearedIn = new ArrayList<Integer>();

    public WordContext(String word, int occurredInSentenceNumber) {
        this.word = word;
        frequency = 1;
        sentencesAppearedIn.add(occurredInSentenceNumber);
    }

    public void foundAgain(int occurredAgainInSentenceNumber) {
        this.frequency++;
        sentencesAppearedIn.add(occurredAgainInSentenceNumber);
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    public List<Integer> getSentencesAppearedIn() {
        return sentencesAppearedIn;
    }

    public String toString() {
        return word + "\t" + "{" + frequency + ":" + sentencesAppearedIn.stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(",")) + "}";
    }
}
