import java.util.*;

class Solution {
    static class Job implements Comparable<Job> {
        int requestTime;
        int durationTime;

        public Job(int requestTime, int durationTime) {
            this.requestTime = requestTime;
            this.durationTime = durationTime;
        }

        @Override
        public int compareTo(Job o) {
            return Integer.compare(this.durationTime, o.durationTime);
        }
    }
    public int solution(int[][] jobs) {
        // jobs 배열 정렬
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        PriorityQueue<Job> pq = new PriorityQueue<>();
        int idx = 0;
        int count = 0; // 수행된 요청 갯수
        int end = 0; // 수행되고 난 뒤 시간
        int time = 0;
        // 잡이 모두 끝날때까지 반복
        while(count < jobs.length) {
            // 수행시간 사이에 들어온 잡
            while(idx < jobs.length && jobs[idx][0] <= end) {
                pq.add(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            // 작업이 끝나기 전 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
            if(!pq.isEmpty()) {
                Job job = pq.poll();
                time += job.durationTime + end - job.requestTime;
                end += job.durationTime;
                count++;
            }
            // 큐가 비었다. 작업 완료 후에 다시 요청이 들어온다.
            else {
                end = jobs[idx][0];
            }
        }
        int answer = time / jobs.length;
        return answer;
    }
}