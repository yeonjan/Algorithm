import java.util.*;
class Solution {
    public class Corps{
        int n;
        int des;
        List<List<Integer>> roadAdj;
        
        public Corps(int n, int[][] roads,int destination){
            this.n=n;
            this.des=destination;
            this.roadAdj=new ArrayList<>();
            for(int i=0;i<=n;i++){
                this.roadAdj.add(new ArrayList<Integer>());
            }
            for(int[] road:roads){
                this.roadAdj.get(road[0]).add(road[1]);
                this.roadAdj.get(road[1]).add(road[0]);
            }
            
        }
        public int[] findMembers(int[] sources){
            int totalMember=sources.length;
            int[] minDist=findDist();
            int[] minRoutes=new int[totalMember];
            for(int i=0;i<totalMember;i++){
                int source=sources[i];
                if(minDist[source]==Integer.MAX_VALUE){
                    minRoutes[i]=-1;
                }else minRoutes[i]=minDist[source];
            }
            return minRoutes;
        }

        private int[] findDist(){
            PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));//도착지,거리
            int[] minDist=new int[n+1];
            for(int i=0;i<=n;i++){
                minDist[i]=Integer.MAX_VALUE;
            }

            minDist[this.des]=0;
            pq.offer(new int[]{this.des,0});
            while(!pq.isEmpty()){
                int[] cur=pq.poll();
                int node=cur[0];
                int dist=cur[1];
                for(int next:roadAdj.get(node)){
                    if(dist+1<minDist[next]){
                        minDist[next]=dist+1;
                        pq.offer(new int[]{next,minDist[next]});
                        
                    }
                }
            }
            return minDist;
        }
        
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        Corps corps=new Corps(n,roads,destination);

        return corps.findMembers(sources);
    }
}
// destination에서 모든 지역으로 가는 최단 경로: 다익스트라 O(ElogV) => 2500000 가능가능
// 근데 모든 간선 거리 1 -> BFS가 더 효율적 O(E+V)