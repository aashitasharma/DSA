import org.junit.Test;
import org.junit.Before;
import java.util.*;

public class TestSortCharacterByFrequency{

  @Test
  public void testGetFrequecyMap(){
    SortCharacterByFrequency scbf = new SortCharacterByFrequency();
    String test = "qcb";
    System.out.println(scbf.getFreqeuncyMap(test));
  }

  @Test
  public void testGetInvertedMap(){
    SortCharacterByFrequency scbf = new SortCharacterByFrequency();
    String test =
        "q";
    System.out.println(scbf.getInvertedMap(scbf.getFreqeuncyMap(test)));
  }

  @Test
  public void testFrequencySort(){
    SortCharacterByFrequency scbf = new SortCharacterByFrequency();
    String test = "aaaannkit";
    System.out.println(scbf.frequencySort(test));
    test = "tree";
    System.out.println(scbf.frequencySort(test));
    test = "cccaaa";
    System.out.println(scbf.frequencySort(test));
    test = "Aabb";
    System.out.println(scbf.frequencySort(test));
    test = "ankit";
    System.out.println(scbf.frequencySort(test));
    test = "a";
    System.out.println(scbf.frequencySort(test));
    test = "aaaa";
    System.out.println(scbf.frequencySort(test));
    test = "ghabbcccdddd";
    System.out.println(scbf.frequencySort(test));
    test =
        "qh";
    System.out.println(scbf.frequencySort(test));
  }

}
