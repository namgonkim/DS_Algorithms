#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 만들 수 없는 금액
문제: 
유형: 그리디
날짜: 2021-05-07
이름: @namgonkim
*/

using namespace std;

// 작은 값부터 더해가면서 목표 금액을 만들 수 있는지 확인한다
int solution(vector<int> data, int n){
	int answer = 0;
	// 가장 최소 값인 1을 설정하고 진행
	int target = 1;
	// 오름차순 정렬
	sort(data.begin(), data.end());
	// 작은 동전부터 탐색
	for (int i = 0; i < n; i++) {
		// 목표 금액이 될 수 없는 경우
		if (target < data[i]) {
			answer = target;
			break;
		}
		// 1 < data[0] = 1 
		// 1+1 = 2 < data[1] = 1
		// 1+1+1 = 3 < data[2] = 2
		// 1+1+1+2 = 5 < data[3] = 3
		// 1+1+1+2+3 = 8 < data[4] = 9
		target += data[i];
	}
	
	answer = target;
	return answer;
}

int main() {
	int n;
	cin >> n;
	vector<int> data;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		data.push_back(num);
	}
	int answer = solution(data, n);
	cout << answer << endl;
	return 0;
}