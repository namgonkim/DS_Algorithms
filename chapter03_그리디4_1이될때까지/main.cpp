#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>

using namespace std;
/*
문제: 1이 될 때 까지
유형: 그리디
날짜: 2021-04-16
이름: @namgonkim
 */

// 나눌 수 있는 상황이면 최대한 나누도록 한다.
int solution(int n, int k) {
    int answer = 0;
    while (n != 1) {
        // 1. n에서 k를 나눈 나머지가 0이 아니라면 1을 빼준다.
        if (n % k != 0) {
            n = n - 1;
            answer = answer + 1;
        }
        // 2. 나눌 수 있는 상황이라면 나눠준다.
        else {
            n = n / k;
            answer = answer + 1;
        }
    }
    
    return answer;
}
int main() {
    int n, k;
    int answer = 0;
    cin >> n >> k;
    answer = solution(n, k);

    cout << answer << endl;

    return 0;
}