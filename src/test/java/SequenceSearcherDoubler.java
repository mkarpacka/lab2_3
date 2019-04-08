import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SearchResult.Builder;
import edu.iis.mto.search.SequenceSearcher;

public class SequenceSearcherDoubler implements SequenceSearcher{

    public static int counter = 0;
    private Map<Integer, SearchResult> map;

    public SequenceSearcherDoubler() {
        this.map = null;
        counter = 0;
    }

    public SequenceSearcherDoubler(Map<Integer, SearchResult> valueMap) {
        this.map = valueMap;
        counter = 0;
    }

    @Override public SearchResult search(int key, int[] seq) {
        if (map.get(key).isFound()) {
            counter++;
        }
        return map.get(key);
    }
}
