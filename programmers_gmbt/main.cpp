#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    sort(people.begin(), people.end());
    int head = 0;
    int tail = people.size() - 1;
    while (head <= tail) {
        if (people[head] + people[tail] <= limit) {
            answer += 1;
            tail -= 1;
            head += 1;
        }
        else {
            answer += 1;
            tail -= 1;
        }
    }
    // 효율성1,3번 실패 코드
    /*
    while (people.size() > 1) {
        
        if (people.size() == 1) {
            return answer + 1;
        }
        int maxx = *(people.end()-1);
        if (people[0] + maxx <= limit) {
            answer += 1;
            people.erase(people.begin() + 0);
            people.erase(people.end() - 1);
        }
        else {
            answer += 1;
            people.erase(people.end() - 1);
        }
    }
    */
    return answer;
}

int main() {
    string num = "17";
    string num1 = "011";
    vector<int>v = { 70, 50, 80, 50 };
    vector<int>v2 = { 70, 80, 50 };
    int l = 100;
    // [70, 50, 80, 50]	100	3
    // [70, 80, 50]	100	3

    int ans = solution(v, l);

    cout << ans << endl;

    return 0;
}