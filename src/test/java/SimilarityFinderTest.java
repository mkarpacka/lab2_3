import edu.iis.mto.search.SearchResult;
import edu.iis.mto.similarity.SimilarityFinder;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SimilarityFinderTest {

    Map<Integer, SearchResult> valueMap = new HashMap<>();

    private void addToHashmap(int[] integer, Boolean[] b){
        for(int i=0; i<integer.length; i++) {
            valueMap.put(integer[i], SearchResult.builder().withFound(b[i]).build());
        }
    }


    @Test
    public void isReturnedValueEqualOneWithTheSameSequences(){
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {1, 2, 3};

        Boolean[] b = {true, true, true};

        addToHashmap(seq1, b);

        SequenceSearcherDoubler sequenceSearcher = new SequenceSearcherDoubler(valueMap);

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        double jackardSimilarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(jackardSimilarity, Matchers.equalTo(1.0));

    }

    @Test
    public void isReturnedValueEqualOneWithEmptySequences(){
        int[] seq1 = {};
        int[] seq2 = {};

        SequenceSearcherDoubler sequenceSearcherDoubler = new SequenceSearcherDoubler();
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherDoubler);
        double jackardSimilarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(jackardSimilarity, Matchers.equalTo(1.0));
    }

    @Test
    public void isReturnedValueEqualZeroWithDifferentSequences(){
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {4, 5, 6};

        Boolean[] b = {false, false, false};

        addToHashmap(seq1, b);

        SequenceSearcherDoubler sequenceSearcher = new SequenceSearcherDoubler(valueMap);

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        double jackardSimilarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(jackardSimilarity, Matchers.equalTo(0.0));
    }

    @Test
    public void isReturnedValueEqualZeroIfOneSequenceIsEmpty(){
        int[] seq1 = {};
        int[] seq2 = {4, 5, 6};

        Boolean[] b = {false, false, false};

        addToHashmap(seq2, b);

        SequenceSearcherDoubler sequenceSearcher = new SequenceSearcherDoubler(valueMap);

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);
        double jackardSimilarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(jackardSimilarity, Matchers.equalTo(0.0));
    }

    @Test(expected = NullPointerException.class)
    public void isThrownNullPointerExceptionIfArgumentIsNull() {
        int[] seq1 = {1, 2, 3};

        Boolean[] b = {false, false, false};

        addToHashmap(seq1, b);

        SequenceSearcherDoubler sequenceSearcher = new SequenceSearcherDoubler(valueMap);

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        similarityFinder.calculateJackardSimilarity(seq1, null);
    }

    @Test
    public void isReturnedZeroPointTwoWithGivenSequences(){
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {4, 2, 5};

        Boolean[] b = {false, true, false};

        addToHashmap(seq1, b);

        SequenceSearcherDoubler sequenceSearcher = new SequenceSearcherDoubler(valueMap);

        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);


        double jackardSimilarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(jackardSimilarity, Matchers.equalTo(0.2));


    }


}
