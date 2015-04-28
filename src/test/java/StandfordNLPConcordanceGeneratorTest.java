import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * Created by smatyas on 4/27/15.
 */
public class StandfordNLPConcordanceGeneratorTest {

    @Test
    public void homeworkCorpus() {
        String text = "Given an arbitrary text document written in English, write a program that will generate a \n" +
                "concordance, i.e. an alphabetical list of all word occurrences, labeled with word frequencies. \n" +
                "Bonus: label each word with the sentence numbers in which each occurrence appeared.";
        Concordance concordance = new StandfordNLPConcordanceGenerator().generate(text);

        assertEquals(34, concordance.getConcordance().size());

        Iterator<WordContext> iterator = concordance.getConcordance().iterator();
        assertEquals("a\t{2:1,1}", iterator.next().toString());
        assertEquals("all\t{1:1}", iterator.next().toString());
        assertEquals("alphabetical\t{1:1}", iterator.next().toString());
        assertEquals("an\t{2:1,1}", iterator.next().toString());
        assertEquals("appeared\t{1:2}", iterator.next().toString());
        assertEquals("arbitrary\t{1:1}", iterator.next().toString());
        assertEquals("bonus\t{1:2}", iterator.next().toString());
        assertEquals("concordance\t{1:1}", iterator.next().toString());
        assertEquals("document\t{1:1}", iterator.next().toString());
        assertEquals("each\t{2:2,2}", iterator.next().toString());
        assertEquals("english\t{1:1}", iterator.next().toString());
        assertEquals("frequencies\t{1:1}", iterator.next().toString());
        assertEquals("generate\t{1:1}", iterator.next().toString());
        assertEquals("given\t{1:1}", iterator.next().toString());
        assertEquals("i.e.\t{1:1}", iterator.next().toString());
        assertEquals("in\t{2:1,2}", iterator.next().toString());
        assertEquals("label\t{1:2}", iterator.next().toString());
        assertEquals("labeled\t{1:1}", iterator.next().toString());
        assertEquals("list\t{1:1}", iterator.next().toString());
        assertEquals("numbers\t{1:2}", iterator.next().toString());
        assertEquals("occurrence\t{1:2}", iterator.next().toString());
        assertEquals("occurrences\t{1:1}", iterator.next().toString());
        assertEquals("of\t{1:1}", iterator.next().toString());
        assertEquals("program\t{1:1}", iterator.next().toString());
        assertEquals("sentence\t{1:2}", iterator.next().toString());
        assertEquals("text\t{1:1}", iterator.next().toString());
        assertEquals("that\t{1:1}", iterator.next().toString());
        assertEquals("the\t{1:2}", iterator.next().toString());
        assertEquals("which\t{1:2}", iterator.next().toString());
        assertEquals("will\t{1:1}", iterator.next().toString());
        assertEquals("with\t{2:1,2}", iterator.next().toString());
        assertEquals("word\t{3:1,1,2}", iterator.next().toString());
        assertEquals("write\t{1:1}", iterator.next().toString());
        assertEquals("written\t{1:1}", iterator.next().toString());
    }

    @Test
    public void homeworkCorpusWithoutNewlines() {
        String text = "Given an arbitrary text document written in English, write a program that will generate a " +
                "concordance, i.e. an alphabetical list of all word occurrences, labeled with word frequencies. " +
                "Bonus: label each word with the sentence numbers in which each occurrence appeared.";
        Concordance concordance = new StandfordNLPConcordanceGenerator().generate(text);

        assertEquals(34, concordance.getConcordance().size());

        Iterator<WordContext> iterator = concordance.getConcordance().iterator();
        assertEquals("a\t{2:1,1}", iterator.next().toString());
        assertEquals("all\t{1:1}", iterator.next().toString());
        assertEquals("alphabetical\t{1:1}", iterator.next().toString());
        assertEquals("an\t{2:1,1}", iterator.next().toString());
        assertEquals("appeared\t{1:2}", iterator.next().toString());
        assertEquals("arbitrary\t{1:1}", iterator.next().toString());
        assertEquals("bonus\t{1:2}", iterator.next().toString());
        assertEquals("concordance\t{1:1}", iterator.next().toString());
        assertEquals("document\t{1:1}", iterator.next().toString());
        assertEquals("each\t{2:2,2}", iterator.next().toString());
        assertEquals("english\t{1:1}", iterator.next().toString());
        assertEquals("frequencies\t{1:1}", iterator.next().toString());
        assertEquals("generate\t{1:1}", iterator.next().toString());
        assertEquals("given\t{1:1}", iterator.next().toString());
        assertEquals("i.e.\t{1:1}", iterator.next().toString());
        assertEquals("in\t{2:1,2}", iterator.next().toString());
        assertEquals("label\t{1:2}", iterator.next().toString());
        assertEquals("labeled\t{1:1}", iterator.next().toString());
        assertEquals("list\t{1:1}", iterator.next().toString());
        assertEquals("numbers\t{1:2}", iterator.next().toString());
        assertEquals("occurrence\t{1:2}", iterator.next().toString());
        assertEquals("occurrences\t{1:1}", iterator.next().toString());
        assertEquals("of\t{1:1}", iterator.next().toString());
        assertEquals("program\t{1:1}", iterator.next().toString());
        assertEquals("sentence\t{1:2}", iterator.next().toString());
        assertEquals("text\t{1:1}", iterator.next().toString());
        assertEquals("that\t{1:1}", iterator.next().toString());
        assertEquals("the\t{1:2}", iterator.next().toString());
        assertEquals("which\t{1:2}", iterator.next().toString());
        assertEquals("will\t{1:1}", iterator.next().toString());
        assertEquals("with\t{2:1,2}", iterator.next().toString());
        assertEquals("word\t{3:1,1,2}", iterator.next().toString());
        assertEquals("write\t{1:1}", iterator.next().toString());
        assertEquals("written\t{1:1}", iterator.next().toString());
    }

    @Test
    public void emptyCorpus() {
        String text = "";
        Concordance concordance = new StandfordNLPConcordanceGenerator().generate(text);
        assertEquals(0, concordance.getConcordance().size());
    }

    @Test
    public void simpleAbcCorpus() {
        String text = "a b c";
        Concordance concordance = new StandfordNLPConcordanceGenerator().generate(text);
        assertEquals(3, concordance.getConcordance().size());

        Iterator<WordContext> iterator = concordance.getConcordance().iterator();
        assertEquals("a\t{1:1}", iterator.next().toString());
        assertEquals("b\t{1:1}", iterator.next().toString());
        assertEquals("c\t{1:1}", iterator.next().toString());
    }

    @Test
    public void complexAbcCorpus() {
        String text = "a b cc.\n\n a b cc.";
        Concordance concordance = new StandfordNLPConcordanceGenerator().generate(text);
        assertEquals(3, concordance.getConcordance().size());

        Iterator<WordContext> iterator = concordance.getConcordance().iterator();
        assertEquals("a\t{2:1,2}", iterator.next().toString());
        assertEquals("b\t{2:1,2}", iterator.next().toString());
        assertEquals("cc\t{2:1,2}", iterator.next().toString());
    }

    @Test
    public void simpleSentenceWordsReversed() {
        String text = "a boy could. could a boy.";
        Concordance concordance = new StandfordNLPConcordanceGenerator().generate(text);
        assertEquals(3, concordance.getConcordance().size());

        Iterator<WordContext> iterator = concordance.getConcordance().iterator();
        assertEquals("a\t{2:1,2}", iterator.next().toString());
        assertEquals("boy\t{2:1,2}", iterator.next().toString());
        assertEquals("could\t{2:1,2}", iterator.next().toString());
    }

}
