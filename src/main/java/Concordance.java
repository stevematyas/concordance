import java.util.List;

/**
 * Created by smatyas on 4/27/15.
 */
public interface Concordance {
    List<WordContext> getConcordance();

    String toString();
}
