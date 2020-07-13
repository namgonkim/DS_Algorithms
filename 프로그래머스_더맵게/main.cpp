#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> score;

    for (int i = 0; i < scoville.size(); i++) {
        score.push(scoville[i]);
    }

    while (!score.empty()) {
        if (score.top() >= K) {
            score.pop();
        }
        else {
            int small1 = score.top();
            score.pop();
            if (score.empty()) return -1;
            int small2 = score.top();
            score.pop();
            int res = small1 + (small2 * 2);
            score.push(res);
            answer++;
        }

    }
    return answer;
}

int main() {

    int a;
    vector<int> c;
    a = 7;
    //[1, 2, 3, 9, 10, 12]
    c.push_back(1);
    c.push_back(2);
    c.push_back(3);
    c.push_back(9);
    c.push_back(10);
    c.push_back(12);
    int res = solution(c, a);

    cout << res << endl;

    return 0;
}