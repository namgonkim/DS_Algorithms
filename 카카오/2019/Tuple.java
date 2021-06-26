package kakao.intern2019;


import java.util.ArrayList;

/*
문제: 튜플
설명: 2019 카카오 겨울 인턴십
유형: 탐색
날짜: 2021.06.26 토
 */
public class Tuple {
    public static void main(String[] args) {
        //s	result
        //"{{2},{2,1},{2,1,3},{2,1,3,4}}"	[2, 1, 3, 4]
        //"{{1,2,3},{2,1},{1,2,4,3},{2}}"	[2, 1, 3, 4]
        //"{{20,111},{111}}"	[111, 20]
        //"{{123}}"	[123]
        //"{{4,2,3},{3},{2,3,4,1},{2,3}}"	[3, 2, 4, 1]
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] answer = solution(s);
        for(int item : answer){
            System.out.println(item);
        }
    }

    public static int[] solution(String s) {
        int[] answer;
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<String> set = new ArrayList<>();
        String[] record = s.split("},");
        // 집합 정리 및 스트링 어레이리스트에 저장
        for(String item : record) {
            item = item.replace("{", "");
            item = item.replace("}", "");
            item = item.replace(",","");
            set.add(item);
        }
        // 리스트 순회하며 가장 작은 길이를 가지는 스트링 찾아 그 원소 저장하고 지우기
        while(!set.isEmpty()){
            int min = 1000001;
            String val = "";
            // 가장 작은 길이를 가지는 스트링 찾기
            for(String item : set) {
                if(min > item.length()) {
                    min = item.length();
                    val = item;
                }
            }
            // 집합 리스트에 있는 원소 지우기
            for(int idx=0;idx < set.size(); idx++) {
                String item = set.get(idx);
                item = item.replace(val, "");
                set.set(idx,item);
                // 집합 리스트 내 스트링 길이가 0이면 집합 완전히 삭제
                if(item.length() == 0){
                    set.remove(idx);
                    idx--;
                }
            }
            // 튜플을 표현하는 원소 저장하기
            res.add(Integer.parseInt(val));
        }
        answer = new int[res.size()];
        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }

        return answer;
    }
}
