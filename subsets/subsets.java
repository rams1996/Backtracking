import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
​
public class Solution {
​
    public void add(int[] array, int[] nums, List<List<Integer>> result) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < array.length; j++) {
            if (array[j] == 1) {
                list.add(nums[j]);
            }
        }
        result.add(list);
    }
​
    public List<List<Integer>> combine(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int[] array = new int[n];
        Arrays.fill(array, 0, k, 1);
        add(array, nums, result);
​
        boolean hasMore = true;
        while (hasMore) {
            hasMore = false;
            for (int i = 0; i < n - 1; i++) {
                if (array[i] == 1 && array[i + 1] == 0) {
                    hasMore = true;
                    array[i] = 0;
                    array[i + 1] = 1;
​
                    if (array[0] == 0) {
                        for (int j = 0, m = 0; m < i; m++) {
                            if (array[m] == 1) {
                                array[j++] = 1;
                                array[m] = 0;
                            }
                        }
                    }
                    add(array, nums, result);
​
                    break;
                }
            }
