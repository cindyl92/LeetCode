/**
    1046. Last Stone Weight
    
    We have a collection of stones, each stone has a positive integer weight.

    Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

    If x == y, both stones are totally destroyed;
    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
    At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
    
    Input: [2,7,4,1,8,1]
    Output: 1
    Explanation: 
    We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
    we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
    we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
    we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
    
    Note:
        1 <= stones.length <= 30
        1 <= stones[i] <= 1000
    
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        // check base case
        if (stones == null || stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];
        
        // sort the array in ascending order
        Arrays.sort(stones);
        
        // points to the last element of stones
        int n = stones.length - 1;
        
        for (int i=0; i < n; i++) {
            // always compare the last two elements because the array is sorted
            if (stones[n] == stones[n-1]) {
                stones[n] = 0;
                stones[n-1] = 0;
                i++;
                
            } else {
                stones[n-1] = stones[n] - stones[n-1];
                stones[n] = 0;
            }
            
            Arrays.sort(stones);
        }
        
        return stones[n];
    }
}