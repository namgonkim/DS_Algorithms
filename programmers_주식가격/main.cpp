#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    queue<int> q;
    for (int i = 0; i < prices.size(); i++) {
        q.push(prices[i]);
    }
    int cnt = 0;
    int i = 0;
    while (!q.empty()) {
        for (int j = i + 1; j < prices.size(); j++) {
            if (q.front() > prices[j]) {
                cnt++;
                break;
            }
            cnt++;
        }
        answer.push_back(cnt);
        q.pop();
        cnt = 0;
        i++;
    }

    return answer;
}