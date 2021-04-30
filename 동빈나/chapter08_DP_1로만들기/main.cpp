#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<stdio.h>
/*
제목: 1로 만들기
문제: 연산을 사용하는 횟수의 최소값 출력
유형: 다이나믹 프로그래밍
날짜: 2021-04-30
이름: @namgonkim
*/
using namespace std;

const int MAX = 30001;
int dp[MAX] = { 0, };

/* dp[i] = min(dp[i-1], dp[i/2], dp[i/3], dp[i/5] ) + 1 [추가 호출] */
int solution(int x) {
    int answer = 0;
    // DP 초기값 세팅
    dp[0] = 0; dp[1] = 1; 
    // DP 바텀업 진행
    for (int i = 2; i <= x; i++) {
        // 1. 현 수에서 1을 빼는 경우
        dp[i] = dp[i - 1] + 1;
        // 2. 현 수가 2로 나누어 떨어지는 경우
        if (i % 2 == 0) {
            dp[i] = min(dp[i], dp[i / 2] + 1);
        }
        // 3. 현 수가 3로 나누어 떨어지는 경우
        if (i % 3 == 0) {
            dp[i] = min(dp[i], dp[i / 3] + 1);
        }
        // 4. 현 수가 5로 나누어 떨어지는 경우
        if (i % 5 == 0) {
            dp[i] = min(dp[i], dp[i / 5] + 1);
        }
    }
    answer = dp[x];
    return answer;
}

int main() {
    int x;
    cin >> x;
    int answer = solution(x);
    cout << answer << endl;
    return 0;
}