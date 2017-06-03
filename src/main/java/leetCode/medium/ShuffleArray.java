package leetCode.medium;

/**
 * Created by atare on 6/3/17.
 */
public class ShuffleArray {

  int[] originalNums;

  public ShuffleArray(int[] nums) {
    originalNums = nums;
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return originalNums;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int[] oldArray = originalNums.clone();
    shuffleHelper(originalNums, 0);
    int[] newArray = originalNums.clone();
    originalNums = oldArray.clone();
    return newArray;
  }

  private void swap(int[] nums, int sourceIndex, int destinationIndex){
    int temp = nums[sourceIndex];
    nums[sourceIndex] = nums[destinationIndex];
    nums[destinationIndex] = temp;
  }

  public void shuffleHelper(int[] nums, int index){
    if(index >= nums.length){
      return;
    }
    int randomIndex = (int)(Math.random() * index);
    swap(nums, index, randomIndex);
    shuffleHelper(nums, index + 1);
  }
}
