#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
#include<stack>

/*
제목: 연산자 끼워넣기
문제: 삼성전자 SW 역량테스트
유형: BFS/DFS
날짜: 2021-05-28
이름: @namgonkim

*/

using namespace std;

int n;
vector<int> num;
// 덧셈 뺄셈 곱셈 나눗셈
vector<int> oper;

void dfs(vector<int>& answer, int i, int now) {
	
	// 모든 연산자를 다 사용했을 경우
	if (i == n) {
		// 최대값, 최소값 입력
		answer[0] = max(answer[0], now);
		answer[1] = min(answer[1], now);
	}
	// 연산이 진행중일 경우 재귀적으로 수행
	else {
		// 덧셈
		if (oper[0] > 0) {
			oper[0] -= 1;
			dfs(answer, i + 1, now + num[i]);
			oper[0] += 1;
		}
		// 뺄셈
		if (oper[1] > 0) {
			oper[1] -= 1;
			dfs(answer, i + 1, now - num[i]);
			oper[1] += 1;
		}
		// 곱셈
		if (oper[2] > 0) {
			oper[2] -= 1;
			dfs(answer, i + 1, now * num[i]);
			oper[2] += 1;
		}
		// 나눗셈
		if (oper[3] > 0) {
			oper[3] -= 1;
			dfs(answer, i + 1, now / num[i]);
			oper[3] += 1;
		}
	}
}

vector<int> solution() {
	vector<int> answer;
	// 최대값[0], 최소값[1] 처음 값으로 가장 큰 값 세팅
	answer.push_back(-1e9);
	answer.push_back(1e9);
	// DFS
	dfs(answer, 1, num[0]);

	return answer;
}

int main() {

	// 수열 길이
	cin >> n;
	// 수열 입력
	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		num.push_back(a);
	}
	// 연산자 입력
	for (int i = 0; i < 4; i++) {
		int op;
		cin >> op;
		oper.push_back(op);
	}
	// 결과
	vector<int> answer = solution();
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i] << endl;
	}
	
	return 0;
}