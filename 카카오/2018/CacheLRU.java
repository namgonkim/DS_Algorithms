package kakao.blind2018;

import java.util.*;

/*
문제: 캐시(LRU)
유형: 큐, 구현
날짜: 2021.07.14 (수)
 */
class CacheLRU {

    public int solution(int cacheSize, String[] cities) {
        // lru 가장 오랫동안 참조되지 않은 캐시를 변경
        int answer = 0;
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        LinkedList<String> caches = new LinkedList<>();
        for(String city : cities) {
            city = city.toLowerCase();
            // cache hit
            if(caches.remove(city)) {
                caches.addFirst(city);
                answer += 1;
            }
            // cache miss
            else {
                // 캐시가 가득차 있으면 마지막 하나 버린다.
                if(caches.size() == cacheSize){
                    caches.pollLast();
                }

                caches.addFirst(city);
                answer += 5;
            }

        }

        return answer;
    }
}