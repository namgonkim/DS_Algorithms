class Solution {
    // 겹치지 않는 간격의 배열이 주어지고, 오름차순으로 정렬되어 있다.
    // 이때 새로운 간격 배열을 주는데 겹치는 구간이 있다면 그 구간을 모두 병합한다.
    // 새로운 배열을 만들어 반환해도 된다.
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 배열 하나를 길게 만들고 간격마다 1을 삽입
        // 간격 구간의 겹치는 현상 조정을 위해 모든 간격 구간에 2를 곱함 
        int n = intervals.length;
        int max = newInterval[1] * 2;
        if(n != 0) {
            // 더 긴 길이로 지정 
            max = Math.max(max, intervals[n-1][1] * 2);
        }

        int[] windows = new int[max+1];
        for(int[] interval : intervals) {
            int start = interval[0] * 2;
            int end = interval[1] * 2;
            for(int i=start; i<=end; i++) {
                windows[i] = 1;
            }
        }
        // 새 구간에 대해 1 삽입
        for(int i=newInterval[0] * 2; i<=newInterval[1] * 2; i++) {
            windows[i] = 1;
        }

        // window에서 1-0일때 queue에 저장
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<windows.length;i++) {
            if(windows[i] == 1) {
                int j=i;
                while(true) {
                    if(j >= windows.length) {
                        break;
                    }
                    if(windows[j] == 0) {
                        break;
                    }
                    j++;
                }
                int[] point = new int[2];
                point[0] = i;
                point[1] = j-1;

                list.add(point);
                i = j-1;
            }
        }

        int[][] result = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            int[] item = list.get(i);
            result[i][0] = item[0] / 2;
            result[i][1] = item[1] / 2;
        }

        return result;
    }
}