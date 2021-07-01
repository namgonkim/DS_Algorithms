package backjoon;

import java.util.*;
/*
제목: 회의실 배정
유형: 자바, 그리디
날짜: 2020.07.01(목)
 */

class Pair implements Comparable<Pair>{
    public Integer a;
    public Integer b;
    public Pair(Integer a, Integer b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.a == p.a) {
            return Integer.compare(this.b, p.b);
        }
        return 0;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();

            Pair pair = new Pair(b,a);
            list.add(pair);
        }

        Collections.sort(list);

        int meeting = 0;
        int answer = 0;
        for(Pair item : list){
            if(meeting <= item.b){
                meeting = item.a;
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
