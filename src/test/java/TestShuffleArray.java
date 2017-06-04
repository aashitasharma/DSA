/**
 * Created by atare on 6/3/17.
 */

import leetCode.medium.ShuffleArray;
import org.junit.Test;
import org.junit.Before;

public class TestShuffleArray {

  private ShuffleArray shuffleArray;
  private int[] a = {1,2,3,4};

  @Before
  public void init(){
    shuffleArray = new ShuffleArray(a);
  }

  @Test
  public void testShuffleArray(){
    System.out.println("Running testShuffleArray");
    int[] c = shuffleArray.shuffle();
    for(int i : c){
      System.out.println(i);
    }
  }

  @Test
  public void testReset(){
    System.out.println("Running testReset");
    int[] b = shuffleArray.reset();
    for(int i : b){
      System.out.println(i);
    }
  }

  @Test
  public void testShuffleEmptyArray(){
    System.out.println("Running testShuffleEmptyArray");
    int[] b = {};
    shuffleArray = new ShuffleArray(b);
    int[] c = shuffleArray.shuffle();
    for(int i : c){
      System.out.println(i);
    }
  }

}
