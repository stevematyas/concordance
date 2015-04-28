import com.google.common.base.Function;
import com.google.common.collect.Ordering;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by smatyas on 4/27/15.
 */
public class ConcordanceImpl implements Concordance {

    public static final Ordering<String> STRING_NULLS_LAST = Ordering.natural().nullsLast();

    private Ordering ASC_INS_WORD = STRING_NULLS_LAST.onResultOf(new Function<WordContext, String>() {
        public String apply(WordContext wordContext) {
            return wordContext.getWord().toLowerCase();
        }
    });

    private List<WordContext> words;

    public ConcordanceImpl(Collection<WordContext> words) {
        this.words = new ArrayList<WordContext>(words);
        if (null != words) {
            Collections.sort(this.words, ASC_INS_WORD);
        }
    }

    public List<WordContext> getConcordance() {
        return words;
    }

    @Override
    public String toString() {
        return "Concordance:" + "\n" +
                words.stream()
                        .map(i -> i.toString())
                        .collect(Collectors.joining("\n"));

    }
}
