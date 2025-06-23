import java.util.*;
class Solution {
    class Person{
        int[] toppings=new int[10001];
        int typeCnt=0;
        
        public void add(int topping){
            if(toppings[topping]==0){
                typeCnt++;
            }
            
            toppings[topping]++;
        }
        public void remove(int topping){
            if(toppings[topping]==0) return;
            toppings[topping]--;
            if(toppings[topping]==0) typeCnt--;
        }
    }
    public int solution(int[] topping) {
        int answer = 0;
        Person cheolsoo=new Person();
        Person brother=new Person();
        
        for(int i=0;i<topping.length;i++){
            if(i==0) cheolsoo.add(topping[i]);
            else brother.add(topping[i]);
        }
        
        for(int i=1;i<topping.length;i++){
            if(cheolsoo.typeCnt==brother.typeCnt) answer++;
            cheolsoo.add(topping[i]);
            brother.remove(topping[i]);
        }
        
        
        
        return answer;
    }
}
//동일한 가짓수의 토핑!
