import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class Seq0 implements SequenceSearcher {

    @Override public SearchResult search(int key, int[] seq) {
        SearchResult.Builder builder = SearchResult.builder();

        builder.withFound(false);


        return builder.build();
    }
}
