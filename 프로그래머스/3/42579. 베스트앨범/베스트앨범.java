import java.util.*;
class Solution {
    public class Song implements Comparable<Song>{
        int play;
        int id;
        public Song(int p,int i){
            this.play=p;
            this.id=i;
        }
        
        public int compareTo(Song song){
            if(this.play==song.play){
                return Integer.compare(this.id,song.id);
            }
            return -Integer.compare(this.play,song.play);
        }
        
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> playMap=new HashMap<>();
        Map<String,List<Song>> songMap=new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            String genre=genres[i];
            int play=plays[i];
            playMap.put(genre,playMap.getOrDefault(genre,0)+play);
            if(!songMap.containsKey(genre)){
                songMap.put(genre,new ArrayList<>());
            }
            songMap.get(genre).add(new Song(play,i));
        }
        
        List<String> keys=new ArrayList<>(playMap.keySet());
        keys.sort((s1,s2)->{
            return -Integer.compare(playMap.get(s1),playMap.get(s2));
        });
        
        ArrayList<Integer> result=new ArrayList<>();
        for(String genre:keys){
            List<Song> songs=songMap.get(genre);
            Collections.sort(songs);
            int cnt=0;
            for(Song s:songs){
                result.add(s.id);
                cnt++;
                if(2<=cnt) break;
            }
        }
        
        int[] ans=new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }
        return ans;
    }
}