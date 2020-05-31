// https://leetcode.com/problems/palindrome-partitioning/

class Solution {
    /*
        ?
        s: str len
        p: num of permutations
        time: O(s p)
        space: O(s p)
    */
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        backtrack(results, s, 0, new ArrayList<>());
        return results;
    }
    
    private void backtrack(
        List<List<String>> results,
        String s,
        int curr,
        List<String> result) {
        if(curr == s.length()) {
            results.add(new ArrayList<>(result));
            return;
        }
        
        for(int i=curr; i<s.length(); i++) {
            if(isPalindrome(s, curr, i)) {
                result.add(s.substring(curr, i+1));
                backtrack(results, s, i+1, result);
                result.remove(result.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        
        return true;
    }
}
