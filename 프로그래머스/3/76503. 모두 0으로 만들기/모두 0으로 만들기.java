import java.util.*;

class Solution {  
    public class Node{
        int idx;
        long value;
        int depth;
        Node parent;
        
        public Node(int idx,long value,int depth,Node parent){
            this.idx=idx;
            this.value=value;
            this.depth=depth;
            this.parent=parent;
        }
    }
    public class Tree{
        Node root;
        List<List<Node>> tree=new ArrayList<>();
        List<Integer>[] adj;
        public Tree(int[] a, int[][] edges){
            this.root = new Node(0,Long.valueOf(a[0]),0,null);
            int V = a.length;
            setAdj(V,edges);
            setTree(a);
        }
        
        private void setAdj(int V,int[][] edges){
            this.adj=new ArrayList[V];
            for(int i=0;i<V;i++){
                this.adj[i]=new ArrayList<>();
            }
        
            for(int[] edge:edges){
                int u=edge[0];
                int v=edge[1];
                this.adj[u].add(v);
                this.adj[v].add(u);
            }
        }
        
        
        private void setTree(int[] a){
            Queue<Node> queue=new LinkedList<>();
            queue.offer(this.root);
        
            while(!queue.isEmpty()){
                Node node=queue.poll();
                if(tree.size()<node.depth+1){
                    tree.add(new ArrayList<>());
                }
                tree.get(node.depth).add(node);
                //인접 노드 탐색
                for(int nextIdx:this.adj[node.idx]){
                    if(node.parent!=null&&node.parent.idx==nextIdx) continue;
                    Node nextNode=new Node(nextIdx,Long.valueOf(a[nextIdx]),node.depth+1,node);
                    queue.offer(nextNode);
                }
            }
        
        }
        public long getChangedCnt(){
            long total=0;
            int maxDepth=tree.size()-1;
            for(int i=0;i<maxDepth;i++){
                int depth=maxDepth-i;
                for(Node node:tree.get(depth)){
                    Node parent=node.parent;
                    parent.value+=node.value;
                    total+=Math.abs(node.value);
                    node.value=0;
                }
            
            
            }
            return root.value==0?total:-1;
        }
    }
    
    
    public long solution(int[] a, int[][] edges) {
        Tree tree=new Tree(a,edges);
        long ans=tree.getChangedCnt();
        
        return ans;
    }
    
  
}