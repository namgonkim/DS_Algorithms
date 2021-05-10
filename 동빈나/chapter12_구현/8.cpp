#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<utility>
#include<stdio.h>
#include<string>
#include<stack>

/*
제목: 문자열 재정렬
문제: 알파벳 대문자와 숫자로만 구성된 문자열을 입력받아 알파벳은 오름차순/숫자는 합한 값을 뒤에 이어 출력
유형: 구현
날짜: 2021-05-10
이름: @namgonkim
*/

using namespace std;

/* 문자열을 정렬하고, 숫자 하나씩 찾아 더하면서 제거한 뒤, 문자열 뒤에 붙인다. */
string solution(string n) {
	string answer = "";
	int sum = 0;
	// 문자열 오름차순 정렬
	sort(n.begin(), n.end());
	// 문자열 내 문자 하나씩 찾으며 숫자 비교 진행
	for (int i = 0; i < n.size(); i++) {
		// 숫자라면 합해주며 제거
		if (n[i] >= '0' && n[i] <= '9') {
			sum = sum + (n[i] - '0');
			n.replace(i, 1, "");
			i = i - 1;
		}
	}
	// 정렬된 문자열 뒤에 숫자 입력
	answer = answer + (n + to_string(sum));

	return answer;
}

int main() {

	string n = "";
	cin >> n;
	string answer = solution(n);
	cout << answer << endl;
	return 0;

}

