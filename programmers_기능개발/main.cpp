#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> q;
    int cnt = 0;
    for (int i = 0; i < progresses.size();i++) {
        q.push(i);
    }
    while (!q.empty()) {
        for (int i = 0; i < progresses.size(); i++) {
            if (progresses[i] < 100) {
                progresses[i] += speeds[i];
            }
        }
        while (progresses[q.front()] >= 100) {
            cnt += 1;
            q.pop();
            if (q.empty()) break;
        }
        if (cnt != 0) {
            answer.push_back(cnt);
            cnt = 0;
        }
    }
    return answer;
}

int main() {
    vector<int> v1;
    vector<int> v2;
    vector<int> res;
    v1.push_back(93);
    v1.push_back(30);
    v1.push_back(55);
    v2.push_back(1);
    v2.push_back(30);
    v2.push_back(5);
    res = solution(v1, v2);
    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << " ";
    }
    return 0;
}