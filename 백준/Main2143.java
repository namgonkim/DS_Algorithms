package backjoon;

import java.util.*;
import java.io.*;
/*
문제: 두 배열의 합 (백준 2143)
유형: 부분 합, 두 배열의 투 포인터 알고리즘
날짜: 2021.08.12 (목)
*/

class Main2143{
    public static long t;
    public static int n, m;
    public static int[] a, b;    // a, b 배열
    public static ArrayList<Integer> lista, listb; // a,b 배열에 대한 부분 합 배열

    // 부분 합 구하기 - 1, 12, 123, 1234, 2, 23, 234, 3, 34, 4 ....
    public static void partialSum() {
        // a 배열
        for(int i=0;i<n;i++) {
            int sum = 0;
            for(int j=i;j<n;j++) {
                sum += a[j];
                lista.add(sum);
            }
        }
        // b 배열
        for(int i=0;i<m;i++) {
            int sum = 0;
            for(int j=i;j<m;j++) {
                sum += b[j];
                listb.add(sum);
            }
        }
    }
    // t보다 작으면 a 인덱스를 올리고, t보다 크면 b 인덱스를 내린다.
    public static long twoPointer() {
        long counts = 0;
        // a는 앞에서부터, b는 뒤에서부터 시작
        int pa = 0;
        int pb = listb.size()-1;

        while(pa < lista.size() && pb >= 0) {
            // 두 부분 배열의 합
            long sum = lista.get(pa) + listb.get(pb);
            // sum이 t보다 작으면 pa + 1
            if(sum < t) {
                pa += 1;
            }
            // sum이 t보다 크면 pb - 1
            else if(sum > t) {
                pb -= 1;
            }
            // sum == t이면
            else {
                // 같은 값을 가지는 경우 확인해 카운트 해주기
                int a = lista.get(pa);
                int b = listb.get(pb);
                long cnta = 0;
                long cntb = 0;
                // 기존에 찾은 부분합과 같은 값을 가지는 배열 내 데이터를 찾는다.
                while(pa < lista.size() && lista.get(pa) == a) {
                    cnta += 1;
                    pa += 1;
                }
                while(pb >= 0 && listb.get(pb) == b) {
                    cntb += 1;
                    pb -= 1;
                }
                // a를 가지는 값이 2개, b를 가지는 값이 3개가 있다면 그 경우의 수는 2*3 = 6개
                counts += (cnta * cntb);
            }
        }

        return counts;
    }

    public static long solution() {
        long answer = 0;
        lista = new ArrayList<>();
        listb = new ArrayList<>();
        // 두 배열의 부분합 구해놓기
        partialSum();
        // 부분 합 배열 정렬
        Collections.sort(lista);
        Collections.sort(listb);
        // 투 포인터 알고리즘 사용해 부분합이 t가 되는 경우 + 하기
        answer = twoPointer();

        return answer;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        // a 배열
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        String[] str_a = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            a[i] = Integer.parseInt(str_a[i]);
        }
        // b 배열
        m = Integer.parseInt(br.readLine());
        b = new int[m];
        String[] str_b = br.readLine().split(" ");
        for(int i=0;i<m;i++) {
            b[i] = Integer.parseInt(str_b[i]);
        }
        // 결과
        System.out.println(solution());
    }
}