#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 문자열 뒤집기
문제: 문자열을 뒤집어 같은 숫자로 만들기
유형: 그리디
날짜: 2021-05-07
이름: @namgonkim
*/

using namespace std;

/* 전부 0혹은 1로 바뀌는 경우 중에서 더 적은 횟수를 가지는 경우가 정답 */
int solution(vector<int> data){
	int answer = 0;
	int zero = 0, one = 0;

	// 첫번째 수 처리
	if (data[0] == 1) zero += 1;
	else one += 1;

	for (int i = 0; i < data.size() - 1; i++) {
		if (data[i] != data[i + 1]) {
			// 1로 바뀌는 경우
			if (data[i + 1] == 1)
				zero += 1;
			// 0으로 바뀌는 경우
			else
				one += 1;
		}
	}
	// 0과 1로 바뀌는 것 중에 더 작은 값으로 줌.
	answer = min(zero, one);
	return answer;
}

int main() {
	string s;
	cin >> s;
	vector<int> data;
	for (int i = 0; i < s.size(); i++) {
		data.push_back(s[i] - '0');
	}
	int answer = solution(data);
	cout << answer << endl;
	return 0;
}