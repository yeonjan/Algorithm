import java.util.*;
class Solution {
    public String solution(long n, String[] bans) {
        List<Long> banNums=getBanNums(bans);
        int cntBan=countBan(n,banNums);
        n+=cntBan;
        String answer =getString(n);
        
        
        
        return answer;
    }
    public String getString(long n){
        StringBuilder sb=new StringBuilder();
        
        //자릿수 구하기
        int digit= getDigit(n);
        
        //숫자 구하기
        while(n>0){
            n--;
            sb.append((char)('a'+n%26));
            n/=26;
        }
        
        
        
        return sb.reverse().toString();
        
        
    }
    public int getDigit(long n){
        int digit = 1;
        while((long)Math.pow(26,digit)<n){
            n-=(long)Math.pow(26,digit);
            digit++;
        }
        return digit;
    }
    public int countBan(long n, List<Long> banNums){
        int cntBan=0;
        for(Long ban:banNums){
            if(ban<=n+cntBan){
                cntBan++;
            }
        }
        return cntBan;
        
        
    }
    public List<Long> getBanNums(String[] bans){
        List<Long> banNums=new ArrayList<>();
        for(String ban:bans){
            banNums.add(getNum(ban));
        }
        Collections.sort(banNums);
        return banNums;
    }
    public long getNum(String ban){
        char[] banArr=ban.toCharArray();
        int size=ban.length();
        long num=0;
        for(int i=1;i<=size;i++){
            int digit=size-i;
            num+=(long)Math.pow(26,digit)*(banArr[i-1]-'a'+1);
        }
        return num;
    }
}
//1. 영향을 미치는 금지 주문 갯수 countBan
//  1-1. 정식 숫자가 n+countBan보다 작거나 같으면 영향을 줌..
//2. 구해야할 주문 n'=n+countBan
//3. n'의 자릿수 확인 -> 10^15라 log(n)불가능
//4. n' 알파벳 구하기


// a-z 1-26 (26가지)
// aa-zz 27-702 (676가지) 
// aaa-zzz 703-18278 (17576가지))
//

//_a => 26*(숫자-1)
// a_ => 27-52 = 26*1 + 1
// b_ => 53-78 = 26*2 + 1
// c_ => 79-105 = 26*3 + 1
// aaa => 703-1378 => (26^2)*1 + (26^1)*1 + (26^0)*1 = 676+26+1
// b__ => 1379- => (26^2)*2 + (26^1)*1 + (26^0)*1 = 1352+26+1 =1379


