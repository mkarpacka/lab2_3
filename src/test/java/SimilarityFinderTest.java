import edu.iis.mto.search.SearchResult;
import edu.iis.mto.similarity.SimilarityFinder;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SimilarityFinderTest {

//    SequenceSearcherDoubler sequenceSearcherDoubler = new SequenceSearcherDoubler();
//    SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherDoubler);



    @Test
    public void isReturnedValueEqualOneWithTheSameSequences(){
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {1, 2, 3};

        Map<Integer, SearchResult> valueMap = new HashMap<>();
        valueMap.put(1, SearchResult.builder().withFound(true).build());
        valueMap.put(2, SearchResult.builder().withFound(true).build());
        valueMap.put(3, SearchResult.builder().withFound(true).build());

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

//    @Test
//    public void isReturnedValueEqualZeroWithDifferentSequences(){
//        int[] seq1 = {1, 2, 3};
//        int[] seq2 = {4, 5, 6};
//        SimilarityFinder s = new SimilarityFinder(new SequenceSearcherCaseZero());
//        double jackardSimilarity = s.calculateJackardSimilarity(seq1, seq2);
//        Assert.assertThat(jackardSimilarity, Matchers.equalTo(0.0));
//    }
//
//    @Test
//    public void isReturnedValueEqualZeroIfOneSequenceIsEmpty(){
//        int[] seq1 = {};
//        int[] seq2 = {4, 5, 6};
//
//        SimilarityFinder s = new SimilarityFinder(new SequenceSearcherCaseZero());
//        double jackardSimilarity = s.calculateJackardSimilarity(seq1, seq2);
//        Assert.assertThat(jackardSimilarity, Matchers.equalTo(0.0));
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void isThrownNullPointerExceptionIfArgumentIsNull() {
//        int[] seq1 = {1, 2, 3};
//
//        similarityFinder.calculateJackardSimilarity(seq1, null);
//    }
//
//    @Test
//    public void isReturnedZeroPointTwoWithGivenSequences(){
//        int[] seq1 = {1, 2, 3};
//        int[] seq2 = {4, 2, 5};
//
//        double jackardSimilarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
//        Assert.assertThat(similarityFinder.calculateJackardSimilarity(seq1, seq2), Matchers.equalTo(0.2));
//
//
//    }


}
