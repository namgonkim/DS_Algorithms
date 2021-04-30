#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<stdio.h>
/*
제목: 개미 전사
문제: 서로 인접하지 않은 식량창고를 약탈해 얻을 수 있는 식량의 최대값을 구하는 프로그램
유형: 다이나믹 프로그래밍
날짜: 2021-04-30
이름: @namgonkim
*/
using namespace std;

const int MAX = 100;
int dp[MAX] = { 0, };


/* dp[i] = max(dp[i-1], dp[i-2] + map[i]) */
int solution(vector<int>& map, int n) {
    int answer = 0;
    // 1. dp 테이블 초기값 세팅
    dp[0] = map[0];
    dp[1] = max(dp[0], map[1]);
    // 2. dp 바텀업 진행
    for (int i = 2; i < n; i++) {
        // 3. max(바로 전에까지 털었던 루트, 지금 창고와 건너뛰어 전에 있는 창고 털기)
        dp[i] = max(dp[i - 1], (dp[i - 2] + map[i]));
    }
    // 4. 0부터 시작했으니까 n-1번째가 정답
    answer = dp[n - 1];
    
    return answer;
}

int main() {
    int n;
    cin >> n;
    vector<int> map(n);
    for (int i = 0; i < n; i++) {
        cin >> map[i];
    }
    int answer = solution(map, n);
    cout << answer << endl;
    return 0;
}