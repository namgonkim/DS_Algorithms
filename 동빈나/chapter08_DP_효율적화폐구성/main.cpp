#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<stdio.h>
/*
제목: 효율적인 화폐 구성
문제: n가지 종류의 화폐들을 최소한으로 이용해 합이 m원이 되도록 필요한 화폐의 개수를 구하는 프로그램
유형: 다이나믹 프로그래밍
날짜: 2021-04-30
이름: @namgonkim
*/
using namespace std;

const int MAX = 10001;
vector<int> dp(MAX, 10001);

/* 작은 금액부터 큰 금액까지 확인하면서 차례대로 만들 수 있는 최소한의 화폐 개수를 찾는다.  */
int solution(vector<int>& list, int n, int m) {
    int answer = 0;
    
    // 1. dp 초기값
    dp[0] = 0;
    // 2. 화폐 리스트를 순차적으로 올리며 찾는다
    for (int i = 0; i < n; i++) {
        // 3. 화폐 만들 수 있는 경우의 수를 찾는다
        for (int j = list[i]; j <= m; j++) {
            // 4. 화폐를 조합해서 해당 금액을 만들 수 있는 방법이 존재하는 경우
            if (dp[j - list[i]] != 10001) {
                // 점화식. dp[금액] = min(dp[금액], dp[금액-화폐의단위] + 1)
                dp[j] = min(dp[j], dp[j - list[i]] + 1);
            }
        }
    }
    if (dp[m] == 10001)
        answer = -1;
    else
        answer = dp[m];

    return answer;
}

int main() {
    int n,m;
    cin >> n >> m; // 화폐 종류, 화폐의 합
    vector<int> list(n);
    for (int i = 0; i < n; i++) {
        cin >> list[i];
    }
    int answer = solution(list, n, m);
    cout << answer << endl;
    return 0;
}