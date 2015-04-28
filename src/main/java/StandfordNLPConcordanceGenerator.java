import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by smatyas on 4/27/15.
 */
public class StandfordNLPConcordanceGenerator implements ConcordanceGenerator {

    public Concordance generate(String corpus) {

        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit");
        props.setProperty("tokenize.whitespace", Boolean.FALSE.toString());
        props.setProperty("ssplit.tokenPatternsToDiscard", "\\p{Punct}");

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // create an empty Annotation just with the given corpus
        Annotation document = new Annotation(corpus);

        // run all Annotators on corpus (document)
        pipeline.annotate(document);

        // these are all the sentences in this document
        // a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

        //define a HashMap to hold the words found with contextual information: frequencies, sentences found in.
        Map<String, WordContext> words = new HashMap<String, WordContext>();

        //loop over sentences and grab the tokens ("words")
        int sentenceNumber = 1;
        for(CoreMap sentence: sentences) {
            // traversing the words in the current sentence
            // a CoreLabel is a CoreMap with additional token-specific methods
            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // this is the corpus of the token
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                word = word.toLowerCase(); //ignore case for this homework problem
                if (!words.containsKey(word)) {
                    words.put(word, new WordContext(word, sentenceNumber));
                } else {
                    words.get(word).foundAgain(sentenceNumber);
                }
            }

            sentenceNumber++;
        }

        return new ConcordanceImpl(words.values());
    }
}
