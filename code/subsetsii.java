// https://leetcode.com/problems/subsets-ii/

class Solution {
    /*
        n: array length
        time: O(n 2^n) --> 2^n subsets, each call takes O(n) time
        space: O(n 2^n) --> 2^n subsets, each has up to n elements
    */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(results, nums, 0, new ArrayList<>());
        return results;
    }
    
    private void backtrack(
        List<List<Integer>> results,
        int[] nums,
        int curr,
        List<Integer> result) {
        
        results.add(new ArrayList<>(result));
        
        for(int i=curr; i<nums.length; i++) {
            if(i > curr && nums[i-1] == nums[i]) continue;
            result.add(nums[i]);
            backtrack(results, nums, i+1, result);
            result.remove(result.size()-1);
        }
    }
}
