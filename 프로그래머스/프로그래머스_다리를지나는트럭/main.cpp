#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int tbw = 0; // 다리에 있는 전체 트럭 무게
    int i = 0; // 트럭 idx
    queue<int> times; // 트럭이 다리에 존재하는 시간
    queue<int> q; // 트럭이 다리에 들어오는 거 

    while ((!q.empty()) || (i != truck_weights.size())) {
        answer += 1;

        if (!times.empty()) {
            // 현재 시간이 다리에 존재하는 맨 앞 트럭 시간과 같으면 내보냄.
            if (answer == times.front()) {
                tbw -= q.front();
                q.pop();
                times.pop();
            }
        }

        if ((i < truck_weights.size()) && (weight - tbw) >= truck_weights[i]) {
            // 다리에 트럭을 넣어줌
            q.push(truck_weights[i]);
            tbw += truck_weights[i];
            // 트럭이 다리에 존재하는 시간
            times.push(answer + bridge_length);
            i += 1;
        }
    }
    return answer;
}

int main() {

    int a, b;
    vector<int> c;
    a = 2;
    b = 10;
    c.push_back(7);
    c.push_back(4);
    c.push_back(5);
    c.push_back(6);
    int res = solution(a, b, c);
    cout << res << endl;

    return 0;
}