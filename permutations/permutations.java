class Solution {
   public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
        // Initiate permutations starting with all digits
        permute(permutations, new ArrayList<>(), nums, i);
    }
    return permutations;
}
​
private void permute(List<List<Integer>> permutations, List<Integer> permutation, int[] nums, int idx) {
    // Add to our permutation.
    permutation.add(nums[idx]);
​
    // Is it complete? Add to the list of permutations if so.
    if (permutation.size() == nums.length) {
        permutations.add(permutation);
        return;
    }
​
    // Otherwise backtrack, and look for the solution with all other indices.
    for (int i = 0; i < nums.length; i++) {
        if (i != idx && !permutation.contains(nums[i])) {
            permute(permutations, new ArrayList<>(permutation), nums, i);
        }
    }
}
}
