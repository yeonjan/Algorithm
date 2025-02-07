class Solution {
    static int size;
    static int target;
    static int ans = 0;
    public int solution(int[] numbers, int targett) {
        size=numbers.length;
        target=targett;
        dfs(numbers,0,0);
        
        return ans;
    }
    public void dfs(int[] numbers,int idx,int sum){
        if(idx>=size){
            if(sum==target){
                ans++;
            }
            return;
        }
        dfs(numbers,idx+1,sum+numbers[idx]);
        dfs(numbers,idx+1,sum-numbers[idx]);
    }
}