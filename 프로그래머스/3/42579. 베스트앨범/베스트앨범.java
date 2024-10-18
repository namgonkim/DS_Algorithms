import java.util.*;
class Solution {
    static class Music implements Comparable<Music> {
        int index;
        int play;
        int genrePlay;
        
        public Music(int index, int play) {
            this.index = index;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music o) {
            if(this.play == o.play) {
                return Integer.compare(this.index, o.index);
            } else {
                return Integer.compare(o.play, this.play);
            }
        }
    }
    // 노래 장르 별 재생 횟수 
    public static Map<String, Integer> gmap = new HashMap<>();
    public static Map<String, PriorityQueue<Music>> mmap = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        for(int i=0; i<genres.length; i++) {
            if(!gmap.containsKey(genres[i])) {
                gmap.put(genres[i], plays[i]);
                PriorityQueue<Music> pq = new PriorityQueue<>();
                pq.offer(new Music(i, plays[i]));
                mmap.put(genres[i], pq);
            } else {
                gmap.put(genres[i], gmap.get(genres[i])+plays[i]);
                PriorityQueue<Music> pq = mmap.get(genres[i]);
                pq.offer(new Music(i, plays[i]));
                mmap.put(genres[i], pq);
            }
        }
        
        List<String> genreSet = new ArrayList<>(gmap.keySet());
        genreSet.sort((o1, o2) -> gmap.get(o2).compareTo(gmap.get(o1)));
        
        List<Integer> result = new ArrayList<>();
        for(String genre : genreSet) {
            PriorityQueue<Music> pq = mmap.get(genre);
            int cnt = 2;
            while(!pq.isEmpty()) {
                Music music = pq.poll();
                result.add(music.index);
                cnt--;
                if(cnt == 0) {
                    break;
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}