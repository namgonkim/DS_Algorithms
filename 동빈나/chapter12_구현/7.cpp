#include<iostream>
#include<vector>
#include<string>
#include<stdio.h>

using namespace std;

string solution(string n) {
    string answer = "";
    int left = 0;
    int right = 0;
    for (int i = 0; i < n.length() / 2; i++) {
        left = left + (n[i] - '0');
        right = right + (n[n.length() - 1 - i] - '0');
    }
    if (left == right) answer = "LUCKY";
    else answer = "READY";

    return answer;
}

int main() {

    string n = "";
    cin >> n;
    string answer = solution(n);
    cout << answer << endl;
    return 0;

}