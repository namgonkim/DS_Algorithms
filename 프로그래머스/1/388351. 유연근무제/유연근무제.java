class Solution {
    // 직원: 출근 희망 시간, 실제 출근 시간 
    // 전체 직원 중에 직원 별 출근 시간과 희망 시간을 요일별로 비교해가며 +10분안에 도착했는지를 검증
    // 하루라도 검증에 실패하면 더이상 검증하지 않는 것이 포인트 
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i=0; i<schedules.length; i++) {
            int schedule = getMaxSchedule(schedules[i]);
            int day = startday;
            boolean event = true;
            for(int j=0; j<timelogs[i].length; j++) {
                if(day != 6 && day != 7) {
                    // 10분을 초과해버리면 실패 
                    // 855 -> 865 -> 905 < 904
                    // System.out.println(schedule + " vs " + timelogs[i][j]);
                    if(schedule < timelogs[i][j]) {
                        event = false;
                        break;
                    }
                }
                
                day++;
                // 날짜가 7을 벗어나면 1로 
                if(day > 7) {
                    day = 1;
                }
            }
            if(event) {
                answer++;
            }
        }
        return answer;
    }
    
    public int getMaxSchedule(int time) {
        time += 10;
        // 865 -> 8 h 65 m
        int hour = time / 100;
        int minute = time % 100;
        // System.out.println("hour" + hour + ", min" + minute);
        
        if(minute >= 60) {
            minute -= 60;
            hour += 1;
        }
        // System.out.println("hour" + hour + ", min" + minute);
        return (hour * 100) + minute;
    }
}