class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] point = new int[2];
        // 시작점 찾기 
        int m = park[0].length();
        int n = park.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(park[i].charAt(j) == 'S') {
                    point[0] = i;
                    point[1] = j;
                    break;
                }
            }
        }
        // 시작점에서 route 명령어를 통해 움직이기 시작 
        // 다만 길을 벗어나거나, 가려는 길에! 장애물이 있다면 움직임 금지 
        for(String route : routes) {
            String[] cmd = route.split(" ");
            int ny = point[0];
            int nx = point[1];
            if(cmd[0].equals("E")) {
                nx += Integer.parseInt(cmd[1]);
            } else if(cmd[0].equals("W")) {
                nx -= Integer.parseInt(cmd[1]);
            } else if(cmd[0].equals("S")) {
                ny += Integer.parseInt(cmd[1]);
            } else {
                ny -= Integer.parseInt(cmd[1]);
            }
            // 벽을 넘는 조건 확인 
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            // 장애물 만나는지 확인 
            boolean isMove = true;
            if(nx > point[1]) {
                for(int k=point[1]; k <= nx; k++) {
                    if(park[ny].charAt(k) == 'X') {
                        isMove = false;
                        break;
                    }
                }
                if(!isMove) continue;
            } 
            else {
                for(int k=nx; k<=point[1]; k++) {
                    if(park[ny].charAt(k) == 'X') {
                        isMove = false;
                        break;
                    }
                }
                if(!isMove) continue;
            }
            if(ny > point[0]) {
                for(int k=point[0]; k <= ny; k++) {
                    if(park[k].charAt(nx) == 'X') {
                        isMove = false;
                        break;
                    }
                }
                if(!isMove) continue;
            }
            else {
                for(int k=ny; k<=point[0]; k++) {
                    if(park[k].charAt(nx) == 'X') {
                        isMove = false;
                        break;
                    }
                }
                if(!isMove) continue;
            }
            
            point[0] = ny;
            point[1] = nx;
            // System.out.println(point[0] + ", " + point[1]);
        }
        return point;
    }
}