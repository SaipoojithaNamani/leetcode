
class Solution {
    public int removeElement(int[] nums, int val) {
        int insert = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[insert] = nums[i];
                insert++;
            }
        }

        return insert;
    }
}
