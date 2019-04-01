import edu.iis.mto.similarity.SimilarityFinder;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class SimilarityFinderTest {

    SimilarityFinder similarityFinder = new SimilarityFinder(new SequenceSearcherDoubler());
    SequenceSearcherDoubler sequenceSearcherDoubler = new SequenceSearcherDoubler();

    @Test
    public void isReturnedValueEqualOneWithTheSameSequences(){
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {1, 2, 3};

        double jackardSimilarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(jackardSimilarity, Matchers.equalTo(1.0));

    }

    @Test
    public void isReturnedValueEqualOneWithEmptySequences(){
        int[] seq1 = {};
        int[] seq2 = {};

        double jackardSimilarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(jackardSimilarity, Matchers.equalTo(1.0));
    }

    @Test
    public void isReturnedValueEqualZeroWithDifferentSequences(){
        int[] seq1 = {1, 2, 3};
        int[] seq2 = {4, 5, 6};

        double jackardSimilarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(jackardSimilarity, Matchers.equalTo(0.0));
    }

    @Test
    public void isReturnedValueEqualZeroIfOneSequenceIsEmpty(){
        int[] seq1 = {};
        int[] seq2 = {4, 5, 6};

        double jackardSimilarity = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        Assert.assertThat(jackardSimilarity, Matchers.equalTo(0.0));
    }



}
