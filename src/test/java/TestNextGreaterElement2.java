import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Assert;

public class TestNextGreaterElement2{

  @Test
  public void test1(){
      NextGreaterElement2 c = new NextGreaterElement2();
      int[] nums = {1,2,1};
      int[] expectedResult = {2,-1,2};
      Assert.assertArrayEquals(expectedResult, c.nextGreaterElements(nums));
  }

  @Test
  public void test2(){
      NextGreaterElement2 c = new NextGreaterElement2();
      int[] nums = {2,2,2};
      int[] expectedResult = {-1,-1,-1};
      Assert.assertArrayEquals(expectedResult, c.nextGreaterElements(nums));
  }

  @Test
  public void test3(){
      NextGreaterElement2 c = new NextGreaterElement2();
      int[] nums = {2,3,4};
      int[] expectedResult = {3,4,-1};
      Assert.assertArrayEquals(expectedResult, c.nextGreaterElements(nums));
  }

  @Test
  public void test4(){
      NextGreaterElement2 c = new NextGreaterElement2();
      int[] nums = {4,3,2};
      int[] expectedResult = {-1,4,4};
      Assert.assertArrayEquals(expectedResult, c.nextGreaterElements(nums));
  }

  @Test
  public void test5(){
      NextGreaterElement2 c = new NextGreaterElement2();
      int[] nums = {4};
      int[] expectedResult = {-1};
      Assert.assertArrayEquals(expectedResult, c.nextGreaterElements(nums));
  }

}
