import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Assert;

public class TestNextGreaterElement{

  @Test
  public void test1(){
      NextGreaterElement c = new NextGreaterElement();
      int[] nums1 = {4,1,2};
      int[] nums2 = {1,3,4,2};
      int[] expectedResult = {-1,3,-1};
      Assert.assertArrayEquals(expectedResult, c.nextGreaterElement(nums1, nums2));
  }

  @Test
  public void test2(){
      NextGreaterElement c = new NextGreaterElement();
      int[] nums1 = {2,4};
      int[] nums2 = {1,2,3,4};
      int[] expectedResult = {3,-1};
      Assert.assertArrayEquals(expectedResult, c.nextGreaterElement(nums1, nums2));
  }


  @Test
  public void test3(){
      NextGreaterElement c = new NextGreaterElement();
      int[] nums1 = {4};
      int[] nums2 = {4};
      int[] expectedResult = {-1};
      Assert.assertArrayEquals(expectedResult, c.nextGreaterElement(nums1, nums2));
  }

  @Test
  public void test4(){
      NextGreaterElement c = new NextGreaterElement();
      int[] nums1 = {4};
      int[] nums2 = {4,1};
      int[] expectedResult = {-1};
      Assert.assertArrayEquals(expectedResult, c.nextGreaterElement(nums1, nums2));
  }
}
