// https://leetcode.com/problems/combination-sum-ii/

class Solution {
    /*
        ?
        n: array len
        k: average len of a combination
        m: average combination count
        time: O(n m)
        space: O(m k)
    */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(results, candidates, target, 0, new ArrayList<>());
        return results;
    }
    
    private void backtrack(
        List<List<Integer>> results,
        int[] candidates, 
        int target,
        int curr,
        List<Integer> result) {
        if(target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        
        if(target < 0) return;
        
        for(int i=curr; i<candidates.length; i++) {
            if(i > curr && candidates[i-1] == candidates[i]) continue;
            result.add(candidates[i]);
            backtrack(results, candidates, target - candidates[i], i+1, result);
            result.remove(result.size()-1);
        }
    }
}
