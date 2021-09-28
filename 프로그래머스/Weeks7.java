import java.util.*;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int user = enter.length;
        int[] answer = new int[user];
        Map<Integer, Integer> rooms = new HashMap<>();
        int in = 0;
        int out = 0;
        // 입실과 퇴실이 모두 이루어질 때까지 진행한다.
        while (in != user && out != user) {
            // 입실
            rooms.put(enter[in], enter[in]);
            // 만난 사람 체크하기
            if (rooms.size() > 1) {
                // 방 안에 2명 이상 동시에 존재하면 무조건 만난다.
                // map형태의 room 순회하면서 answer 찾기
                for (int key : rooms.keySet()) {
                    // System.out.print(key + "/");
                    answer[key - 1] += 1;
                }
                // 현재 3명 이상 입실해 있는 경우, 최근에 들어온 인원은 모두 만났어야 한다.
                // 따라서 room에 있는 전체 사람의 수 - 2명 만큼 더해준다.
                answer[enter[in] - 1] += rooms.size() - 2;
                // System.out.println();

            }

            // 퇴실할 사람이 있으면 반복해서 퇴실
            while (true) {
                if (out < user && rooms.containsKey(leave[out])) {
                    rooms.remove(leave[out]);
                    out += 1;
                }
                // 더이상 퇴실할 사람이 없으면 루프탈출
                else
                    break;
            }
            // 다음 입실 손님 받기
            in += 1;
        }
        return answer;
    }
}