import java.util.*;
class Solution {
    class Table{
        int size;
        int curRow;
        Stack<Integer> deletedStack;
        public Table(int n,int row){
            this.size=n;
            this.curRow=row;
            this.deletedStack=new Stack<>();
        }

        public void cmd(String cmd){
            String[] cmds=cmd.split(" ");
            switch (cmds[0]){
                case "U":
                    up(Integer.valueOf(cmds[1]));
                    break;
                case "D":
                    down(Integer.valueOf(cmds[1]));
                    break;
                case "C":
                    c();
                    break;
                case "Z":
                    z();
                    break;
            }
            
            
        }
        private void up(int m){
            curRow-=m;
            
        }
        private void down(int m){
            curRow+=m;
        }
        private void c(){
            deletedStack.push(curRow);
            size--;
            if(size==curRow){
                curRow--;
            }
        }
        private void z(){
            int restore=deletedStack.pop();
            if(restore<=curRow) curRow++;
            size++;
        }
        public String getInfo(){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<size;i++){
                sb.append("O");
            }
            while(!deletedStack.isEmpty()){
                sb.insert(deletedStack.pop(),"X");
            }
            return sb.toString();
        }

    }
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        Table table=new Table(n,k);
        for(String c:cmd){
            table.cmd(c);
        }
        
        return table.getInfo();
    }
}
//스택만 쓸 때의 핵심원리 
//삭제 스택의 데이터는 최근에 삭제된 것부터 복구 -> 제일 처음 삭제된 데이터를 복구할 시점에는 이후의 삭제내용은 이미 복구되어있음 == 즉, 현재의 인덱스를 저장해도 됨. 

//Z행위로 어떤 파일이 복구되었는지는 중요 X, 그 행위로 선택행 위치가 바뀌는게 중요
