#include <iostream>
#include <vector>
#include <queue>

using namespace std;

/* 
제목: 카드 정렬하기
설명: N개의 숫자 카드 묶음의 크기가 각각 주어질 때, 최소한 몇 번의 비교가 필요한지를 구하는 프로그램
유형: 정렬
날짜: 2021.06.17
*/

int N;
priority_queue<int> card;

// 우선순위 큐에 오름차순으로 저장하고, 큐의 우선순위 대로 뽑아 합쳐나가면 최소한의 비교를 구할 수 있다.
int solution() {
    int answer = 0;
    int sum = 0;
    // 큐의 원소가 1개 남을 때까지 pop
    while(card.size() != 1){
        // 원소 2개 pop
        int one = -card.top();
        card.pop();
        int two = -card.top();
        card.pop();
        // 두 원소를 더해 큐에 다시 저장
        sum = one + two;
        card.push(-sum);
        // 정답 추출
        answer = answer + sum;
    }
    return answer;
}

int main() {
    
    cin >> N;
    for(int i=0;i<N;i++){
        int c;
        cin >> c;
        card.push(-c); // 오름차순 정렬을 위함
    }
    
    int sol = solution();
    cout << sol << endl;
    
    return 0;
}