#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
/*
제목: 곱하기 혹은 더하기
문제: 숫자로된 문자열을 가지고 가장 큰 수를 구하기
유형: 그리디
날짜: 2021-05-07
이름: @namgonkim
*/

using namespace std;

/* 0과 1인 경우에는 덧셈을, 나머지 경우엔 곱셈을 진행한다 */
int solution(vector<int> data){
	int answer = 0;
	// 가장 첫 수 파악을 위해 지정
	answer = data[0];
	// 왼쪽부터 하나씩 비교
	for (int i = 1; i < data.size(); i++) {
		// 0과 1인 경우엔 덧셈을 해주는게 큰 값을 낼 수 있음
		if (answer == 0 || answer == 1) {
			answer = answer + data[i];
		}
		else {
			answer = answer * data[i];
		}
	}
	return answer;
}

int main() {
	
	string num;
	vector<int> data;
	cin >> num;
	for (int i = 0; i < num.size(); i++) {
		// 문자 -> 숫자를 하기 위해서 -'0' 처리
		data.push_back(num[i]-'0');
	}
	int answer = solution(data);
	cout << answer << endl;

	return 0;
}