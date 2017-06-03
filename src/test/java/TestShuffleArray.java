/**
 * Created by atare on 6/3/17.
 */

import leetCode.medium.ShuffleArray;
import org.junit.Test;

public class TestShuffleArray {

  @Test
  public void testShuffleArray(){
    int[] a = {1,2,3};
    ShuffleArray shuffleArray = new ShuffleArray(a);
    shuffleArray.shuffle();
    for(int i : a){
      System.out.println(i);
    }
  }

}
