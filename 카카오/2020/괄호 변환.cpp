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
제목: 괄호 변환
문제: 2020 카카오 신입 공채 1차
유형: 재귀함수 + 구현
날짜: 2021-05-21
이름: @namgonkim

*/

using namespace std;

string solution(string p) {

    int len = p.length();
    // 1. 입력이 빈 문자열인 경우 빈 문자열을 반환
    if (p == "") return p;
    // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다
    int cnt = 0;
    string u = "", v = "";
    for (int i = 0; i < len; i++) {
        if (p[i] == '(') {
            cnt += 1;
        }
        else {
            cnt -= 1;
        }
        if (cnt == 0) {
            u = p.substr(0, i+1);
            v = p.substr(i+1, len);
            break;
        }
    }
    // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
    queue<int> q;
    for (int i = 0; i < u.length(); i++) {
        if (u[i] == '(')
            q.push(u[i]);
        else {
            if (!q.empty()) {
                q.pop();
            }
        }
    }
    if (q.empty()) {
        string temp = solution(v);
        // 3 - 1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        return u + temp;
    }
    // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
    else {
        //  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
        string temp = "(";
        //  4 - 2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        temp = temp + solution(v);
        //  4 - 3. ')'를 다시 붙입니다.
        temp = temp + ")";
        //  4 - 4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        u.replace(0, 1, "");
        u.replace(u.length() - 1, 1, "");
        for (int i = 0; i < u.length(); i++) {
            if (u[i] == '(')
                u[i] = ')';
            else
                u[i] = '(';
        }
        temp = temp + u;
        //  4 - 5. 생성된 문자열을 반환합니다.
        return temp;
    }

}

int main() {

    string p = "()))((()";
    //  "(()())()"	"(()())()"
    //  ")("	    "()"
    //  "()))((()"	"()(())()"

    string answer = solution(p);
    cout << answer << endl;

	return 0;
}