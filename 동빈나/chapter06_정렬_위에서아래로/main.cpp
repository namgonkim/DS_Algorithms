#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<vector>
#include<algorithm>
#include<utility>
#include<queue>
#include<stdio.h>
/*
제목: 위에서 아래로
문제: 수열을 내림차순으로 정렬하는 프로그램
유형: 정렬
날짜: 2021-04-28
이름: @namgonkim
*/
using namespace std;

vector<int> solution(vector<int>& array) {
    // 1. 내림차순 정렬
    sort(array.begin(), array.end(), greater<>());
    return array;
}
int main() {
    int n;
    cin >> n;
    vector<int> array(n);
    for (int i = 0; i < n; i++) {
        cin >> array[i];
    }
    vector<int> answer = solution(array);
    for (int i = 0; i < n; i++) {
        cout << array[i] << " ";
    }
    cout << endl;
    return 0;
}