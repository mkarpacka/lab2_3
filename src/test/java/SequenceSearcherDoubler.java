import java.util.ArrayList;
import java.util.List;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SearchResult.Builder;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDoubler implements SequenceSearcher{

    public static int searchMethodCounter = 0;

    @Override public SearchResult search(int key, int[] seq) {
        Builder builder = SearchResult.builder();
        searchMethodCounter++;
        int position = 0;
        for(int i = 0; i < seq.length; i++) {
            if(key == seq[i]) {
                builder.withFound(true);
                builder.withPosition(i);
            }
        }
        return builder.build();
    }
}
