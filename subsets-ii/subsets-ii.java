​
   class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(new LinkedList<>());
        
        int prevSize = 0;
        int prevNum = -1;
        
        for(int num : nums) {
            int size = result.size();
            int start = prevNum == num ? prevSize : 0;
            
            for(int i = start; i < size; i++) {
                List<Integer> copy = new LinkedList<>();
                copy.addAll(result.get(i));
                copy.add(num);
                result.add(copy);
            }
            
            prevSize = size;
            prevNum = num;
        }
        
        return result;
    }
}
​
