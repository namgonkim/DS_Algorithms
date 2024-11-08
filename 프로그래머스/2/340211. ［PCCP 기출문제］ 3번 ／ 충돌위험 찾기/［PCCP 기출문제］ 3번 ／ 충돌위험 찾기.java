import java.util.*;
class Solution {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Point) {
                if(this.x == ((Point) o).x && this.y == ((Point) o).y) return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }
    public static Map<Integer, Point> robotMap = new HashMap<>();
    public static Map<Integer, List<Point>> robotTimeMap = new HashMap<>();

    public int solution(int[][] points, int[][] routes) {
        int maxLen = 0;
        for(int i=0;i<routes.length;i++) {
            // routes[i][0] -> 로봇의 시작점
            // routes[i][0]-1 -> 시작점의 좌표를 찾는 인덱스 값
            // points[routes[i][0]-1] -> 로봇 시작점의 좌표
            int y = points[routes[i][0] - 1][0];
            int x = points[routes[i][0] - 1][1];

            // 현재 위치 저장
            robotMap.put(i+1, new Point(x,y));
            List<Point> robotSnapShot = new ArrayList<>();
            robotSnapShot.add(new Point(x,y));
            robotTimeMap.put(i+1, robotSnapShot);

            // 로봇이 가야할 경로를 모두 간다
            for(int j=1;j<routes[i].length;j++) {
                // 로봇을 하나씩 움직여본다
                int endY = points[routes[i][j] - 1][0];
                int endX = points[routes[i][j] - 1][1];
                while(true) {
                    // 로봇 이동 - (r,c)로 갈때 r먼저 이동 후 c 이동
                    if(y > endY) y--;
                    else if(y < endY) y++;
                    else if(x > endX) x--;
                    else x++;
                    // 이동과 함께 데이터 저장
                    robotSnapShot.add(new Point(x,y));
                    // 현재 로봇의 포인터가 도착지에 도달하면 반복문 종료
                    if (x == endX && y == endY) {
                        break;
                    }
                }
            }
            maxLen = Math.max(maxLen,robotSnapShot.size());
        }

//        System.out.println(robotTimeMap.size());
        Map<Integer, Map<Point, Integer>> timestampMap = new HashMap<>();
        for(int i=0;i< robotTimeMap.size();i++) {
            List<Point> robotSnapShot = robotTimeMap.get(i+1);
            int time = 0;
            for(Point p : robotSnapShot) {
                Map<Point, Integer> pointRobotCnt;
                if(timestampMap.containsKey(time)) {
                    pointRobotCnt = timestampMap.get(time);
                } else {
                    pointRobotCnt = new HashMap<>();
                }
                pointRobotCnt.put(p, pointRobotCnt.getOrDefault(p, 0) + 1);
                timestampMap.put(time++, pointRobotCnt);
            }

        }
//        System.out.println(timestampMap.size());
        int answer = 0;
        for(int key : timestampMap.keySet()) {
            for(int count : timestampMap.get(key).values()) {
                if(count >= 2) answer++;
            }
        }

        return answer;
    }
}