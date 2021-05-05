#include<iostream>
#include<vector>
#include<string>
#include<utility>
#include<algorithm>

using namespace std;

string solution(string new_id) {
	string answer = new_id;
	int len = answer.length();
	// 1단계. 모든 대문자를 소문자로 바꾼다
	for (int i = 0; i < len; i++) {
		// 대문자에 속하는 값을 가진다면, 소문자로 변경
		if (answer[i] >= 65 && answer[i] <= 90) {
			answer[i] += 32;
		}
	}
	// 2단계. new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
	for (int i = 0; i < len; i++) {
		if (((answer[i] >= 97 && answer[i] <= 122) || (answer[i] >= 48 && answer[i] <= 57) || (answer[i] == 45) || (answer[i] == 95) || (answer[i] == 46))) {
			continue;
		}
		else if (answer[i] == '\0')
			break;
		else {
			answer.replace(i, 1, "");
			i = i - 1;
		}
	}
	// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	string::size_type pos = 0;
	while ((pos = answer.find("..")) != string::npos) {
		answer.replace(pos, 2, ".");
	}
	// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
	if (answer.length() >= 1) {
		if (answer[0] == '.')
			answer.replace(0, 1, "");
	}
	if (answer.length() >= 1) {
		if (answer[answer.length() - 1] == '.')
			answer.replace(answer.length() - 1, 1, "");
	}
	// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
	if (answer == "")
		answer = "a";
	// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	string six_answer = "";
	if (answer.length() >= 16){
		six_answer = answer.substr(0, 15);
		// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if (six_answer[six_answer.length() - 1] == '.') {
			six_answer.replace(six_answer.length() - 1, 1, "");
		}
	}
	else {
		six_answer = answer;
	}
	// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	if (six_answer.length() <= 2) {
		while (six_answer.length() != 3) {
			six_answer = six_answer + six_answer[six_answer.length() - 1];
		}
	}

	answer = six_answer;

	return answer;
}

int main() {

	string id = "abcdefghijklmn.p";
	string ans = solution(id);
	cout << ans << endl;

	return 0;
}
