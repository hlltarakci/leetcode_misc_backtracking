// https://leetcode.com/problems/combinations/

class Solution {
    /*
        time: O(k kOfn)
        space: O(kOfn)
    */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, n, k, 1, new ArrayList<>());
        return results;
    }
    
    public void backtrack(List<List<Integer>> results, int n, int k, int curr, List<Integer> result) {
        if(result.size() == k) {
            results.add(new ArrayList<>(result));
            return;
        }
        
        for(int i=curr; i<=n; i++) {
            result.add(i);
            backtrack(results, n, k, i+1, result);
            result.remove(result.size()-1);
        }
    }
}
