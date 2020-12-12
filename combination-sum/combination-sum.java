class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 1st, the solution could apply backtracking.
        // 2nd, the key is how to identify a List<Integer> from another one (check if they are the same) is sort hash them to string
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        backtracking(candidates, target, res, stack, set);
        
        return res;
    }
    
    public void backtracking(int[] candidates, int target, List<List<Integer>> res, Deque<Integer> stack, Set<String> set) {
        if (target == 0) {
            if (stack.isEmpty()) return;
            List<Integer> list = new ArrayList<>(stack);
            Collections.sort(list);
            String hash = list.toString();
            if (set.contains(hash)) return;
            set.add(hash);
            res.add(list);
            return;
        }
        for (int c : candidates) {
            if (c <= target) {
                stack.offerLast(c);
                backtracking(candidates, target-c, res, stack, set);
                stack.pollLast();
            }
        }
        return;
    }
}
