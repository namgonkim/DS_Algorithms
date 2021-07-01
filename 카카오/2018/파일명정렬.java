package kakao.blind2018;

import java.util.ArrayList;
import java.util.Collections;

/*
문제: 파일명 정렬
유형: 정렬, 문자열
날짜: 2021.07.01 (목)
 */
class File implements Comparable<File> {
    public String head;
    public String number;
    public String tail;
    public Integer index;

    public File(String head, String number, String tail, Integer index){
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.index = index;
    }

    @Override
    public int compareTo(File file1) {
        // 파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬(대소문자 구분 x)
        // 같을 경우, NUMBER의 숫자 순으로 정렬
        // 9 < 10 < 0011 < 012 < 13 < 014 순
        // 같을 경우, 원래 입력에 주어진 순서를 유지
        // head : f- , number: 50, tail : 나머지
        String head1 = this.head.toLowerCase(); // 이전 문자열
        String head2 = file1.head.toLowerCase(); // 이후 문자열
        System.out.println(head1 + "/" + head2);
        if(head1.compareTo(head2) == 0){
            int num1 = Integer.parseInt(this.number);
            int num2 = Integer.parseInt(file1.number);
            if(num1 == num2){
                return this.index - file1.index;
            }else return num1 - num2;
        }
        else {
            return head1.compareTo(head2);
        }
    }
}

public class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        //입력: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
        //출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
        //
        //입력: ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]
        //출력: ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
        String[] files = {
                "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
        };
        System.out.println(s.solution(files));
    }

    public String[] splitFile(String item) {
        // 0: head 1: number 2: tail
        String[] splits = {"","",""};

        int idx = 0;
        // head
        for(;idx<item.length();idx++){
            // item이 0~9를 만나면 head종료
            if(item.charAt(idx) >= '0' && item.charAt(idx) <= '9'){
                break;
            }
            splits[0] = splits[0] + item.charAt(idx);
        }
        // number
        int count = 0;
        for(;idx<item.length();idx++){
            // item의 숫자가 5개를 넘기거나, 문자를 만나면 종료
            if(count >= 5) break;
            else if(item.charAt(idx) >= '0' && item.charAt(idx) <= '9'){
                splits[1] = splits[1] + item.charAt(idx);
            }
            else{
                break;
            }
        }
        // tail
        for(;idx<item.length();idx++){
            splits[2] = splits[2] + item.charAt(idx);
        }

        return splits;
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<File> list = new ArrayList<>();
        int idx = 0;
        for(String item : files) {
            String[] file = splitFile(item);
            File data = new File(file[0],file[1],file[2],idx++);
            list.add(data);
        }

        Collections.sort(list);
        for(int item=0;item < list.size();item++) {
            //System.out.println(item.head + " " + item.number + " " + item.tail);
            String s = list.get(item).head + list.get(item).number + list.get(item).tail;
            answer[item] = s;
        }

        return answer;
    }
}
