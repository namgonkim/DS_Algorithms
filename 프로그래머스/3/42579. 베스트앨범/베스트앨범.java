import java.util.*;
class Solution {
    static class Music implements Comparable<Music> {
        int idx;
        int play;
        
        public Music(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music o) {
            // 장르 내에서 가장 많이 재생된 노래 순이지만, 재생된 횟수가 같으면 고유번호가 낮은 노래 먼저 
            if(this.play == o.play) {
                return Integer.compare(this.idx, o.idx);
            }
            return Integer.compare(o.play, this.play);
        }
    }
    public static Map<String, Integer> gPlayMap = new HashMap<>();
    public static Map<String, PriorityQueue<Music>> gMusicMap = new HashMap<>();
    public int[] solution(String[] genres, int[] plays) {
        for(int i=0;i<genres.length;i++) {
            // 장르별 재생횟수 맵에 삽입 
            if(!gPlayMap.containsKey(genres[i])) {
                gPlayMap.put(genres[i], plays[i]);
            } else {
                gPlayMap.put(genres[i], gPlayMap.get(genres[i]) + plays[i]);
            }
            // System.out.println("genre: " + genres[i] + ", play: " + gPlayMap.get(genres[i]));
            // 장르별 노래 삽입 
            Music music = new Music(i, plays[i]);
            PriorityQueue<Music> pq;
            if(!gMusicMap.containsKey(genres[i])) {
                pq = new PriorityQueue<>();
            } else {
                pq = gMusicMap.get(genres[i]);
            }
            pq.offer(music);
            gMusicMap.put(genres[i], pq);
        }
        // System.out.println(gPlayMap.size());
        
        // 장르별 재생횟수 키셋 정렬 
        List<String> keyList = new ArrayList<>(gPlayMap.keySet());
        keyList.sort((o1, o2) -> gPlayMap.get(o1).compareTo(gPlayMap.get(o2)));
        
        List<Integer> result = new ArrayList<>();
        
        // 장르별 재생횟수가 가장 많은 곳부터 탐색 
        for(int i=keyList.size()-1; i>=0; i--) {
            String genre = keyList.get(i);
            // System.out.println(genre);
            // 가장 많이 재생된 노래 두개
            PriorityQueue<Music> pq = gMusicMap.get(genre);
            // 재생된 노래가 하나뿐이라면 하나의 곡만 선택 
            if(pq.size() == 1) {
                result.add(pq.poll().idx);
            } else {
                result.add(pq.poll().idx);
                result.add(pq.poll().idx);
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}