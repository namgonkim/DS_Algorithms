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
제목: 문자열 압축
문제: 2020 카카오 신입 공채
유형: 구현
날짜: 2021-05-10
이름: @namgonkim
*/

using namespace std;

string buildWord(string text, int len) {
	string word = "";
	for (int i = 0; i < len; i++) {
		word = word + text[i];
	}
	return word;
}

int solution(string s) {
	int answer = 0;
	string word = "";
	// 단어 단위별로 압축한 문자열의 길이와 문자열 저장하는 변수
	vector<pair<int,string>> map;
	// 문자가 하나라면 1 반환
	if (s.length() == 1) return 1;
	
	// 압축하려는 크기를 하나씩 늘려나간다.
	for (int i = 1; i <= s.length() / 2; i++) {
		string newtext = "";
		string text = s;
		// i개 단위로 잘라 압축
		while (text.length() >= i) {
			// 압축할 단어 만들기
			word = buildWord(text, i);
			int prev = text.find(word), pCur = 0;
			int count = 0;
			// 단어 찾고 압축하기
			while ((pCur = text.find(word)) != string::npos) {
				// 연속된 단어가 있는 경우, 압축 진행
				if (pCur == prev) {
					text.replace(pCur, word.length(), "");
					count += 1;
				}
				// 더이상 연속된 단어가 없다면 종료
				else {
					break;
				}
				
			}
			// 단어가 2번 이상 쓰였을때와 아닐때를 나누어 스트링 저장
			if (count > 1)
				newtext = newtext + (to_string(count) + word);
			else
				newtext = newtext + word;
		}
		// 압축이 성공적으로 된 케이스를 가져온다
		if(text == "")
			map.push_back({ newtext.length(), newtext });
		// 남은 text가 있다면 뒤에 붙여준다.
		else {
			newtext = newtext + text;
			map.push_back({ newtext.length(), newtext });
		}
	}
	// 길이가 가장 짧은 압축 문자열의 길이를 반환한다.
	pair<int, string> res = *min_element(map.begin(), map.end());
	answer = res.first;
	return answer;
}

int main() {

	string s = "a";

	int answer = solution(s);
	cout << answer << endl;
	
	return 0;

}

