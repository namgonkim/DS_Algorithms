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
제목: 국영수
문제: 학생 성적 정렬 프로그램
유형: 정렬
날짜: 2021-06-07
이름: @namgonkim
*/

using namespace std;

class Student {
public:
    string name;
    int k;
    int e;
    int m;
    Student(string name, int k, int e, int m) {
        this->name = name;
        this->k = k;
        this->e = e;
        this->m = m;
    }
};

vector<Student> students;
int n;

bool compare(Student a, Student b) {
    // 국영수 모두 같으면
    if (a.k == b.k && a.e == b.e && a.m == b.m) {
        // 이름 오름차순 정렬
        return a.name < b.name;
    }
    // 국영 같으면
    if (a.k == b.k && a.e == b.e) {
        // 수 내림차순 정렬
        return a.m > b.m;
    }
    // 국 같으면
    if (a.k == b.k) {
        // 영 오름차순 정렬
        return a.e < b.e;
    }
    // 국 내림차순 정렬
    return a.k > b.k;
}

vector<string> solution() {

    vector<string> answer;
    sort(students.begin(), students.end(), compare);
    for (int i = 0; i < n; i++) {
        answer.push_back(students[i].name);
    }
    return answer;
}

int main() {

    cin >> n;
    for (int i = 0; i < n; i++) {
        string name;
        int k, e, m;
        cin >> name >> k >> e >> m;
        students.push_back(Student(name, k, e, m));
    }
    vector<string> answer = solution();
    for (int i = 0; i < n; i++) {
        cout << answer[i] << endl;
    }
    return 0;
}