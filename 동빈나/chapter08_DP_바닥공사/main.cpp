#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<stdio.h>
/*
제목: 바닥 공사
문제: 3가지 덮개를 이용해 바닥을 채우는 모든 경우의 수 구하기
유형: 다이나믹 프로그래밍
날짜: 2021-04-30
이름: @namgonkim
*/
using namespace std;

const int MAX = 1001;
int dp[MAX] = { 0, };

/* dp[i] = dp[i-1] + (dp[i-2] + dp[i-2]) */
int solution(int n) {
    int answer = 0;
    dp[1] = 1;
    dp[2] = 3;
    // 1. dp 진행
    for (int i = 3; i <= n; i++) {
        // 2. 점화식 % 796796
        dp[i] = (dp[i - 1] + 2*(dp[i - 2])) % 796796;
        /*
        dp[i-1]: 왼쪽부터 i-1까지가 덮개로 채워져 있으면 2x1 채우는 하나의 경우의 수
        dp[i-2]: 왼쪽부터 i-2까지가 덮개로 채워져 있으면 [1x2 두개, 2x2 한개] 로 2개의 경우의 수
                 2x1은 dp[i-1]에서 고려가 되었음.
        */
    }
    answer = dp[n];
    return answer;
}

int main() {
    int n;
    cin >> n;
    int answer = solution(n);
    cout << answer << endl;
    return 0;
}