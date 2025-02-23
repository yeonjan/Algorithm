import java.util.*;
class Solution{
    static int size;
    static int ans=0;
    static char[] arr;
    public int solution(String s){
        size=s.length();
        arr=s.toCharArray();
        for(int i=0;i<size;i++){
            int cnt1=findPalindrome1(i);
            int cnt2=findPalindrome2(i);
            ans=Math.max(ans,Math.max(cnt1,cnt2));


        }

        return ans;
    }
    public static int findPalindrome1(int mid){
        int cnt=1;
        int offset=Math.min(Math.abs(size-1-mid),mid);
        for(int i=1;i<=offset;i++){
            if(arr[mid-i]==arr[mid+i]){
                cnt+=2;
            }else{
                break;
            }
        } 
        return cnt;
    }
    public static int findPalindrome2(int mid){
        int cnt=0;
        int offset=Math.min(Math.abs(size-mid),mid);
        for(int i=1;i<=offset;i++){
            if(arr[mid-i]==arr[mid-1+i]){
                cnt+=2;
            }else{
                break;
            }
        } 
        return cnt==0?1:cnt;
    }
}