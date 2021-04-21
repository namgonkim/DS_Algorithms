#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
#include <string>

using namespace std;
/*
문제: 왕실의 나이트
유형: 구현(좌표 이동)
날짜: 2021-04-21
이름: @namgonkim
 */

// 나이트가 이동할 수 있는 방향 //
int dx[8] = {-2,-1, 1, 2, 2, 1,-1,-2};
int dy[8] = {-1,-2,-2,-1, 1, 2, 2, 1};

// 나이트의 움직임에 벗어나는 좌표를 제거한다.
int solution(string point) {
    int answer = 0;
    // 1. 나이트의 현재 위치를 좌표상으로 변경
    int px = (point[0] - 96);
    int py = (point[1] - 48);
    // 2. 나이트가 움직일 수 있는 범위 내의 경우의 수를 찾는다
    for (int i = 0; i < 8; i++) {
        // 3. 모든 방향에 대해 조사.
        int nx = px + dx[i];
        int ny = py + dy[i];
        // 4. 범위를 벗어나지 않는다면 경우의 수로 포함.
        if ((nx <= 8 && nx >= 1) && (ny <= 8 && ny >= 1)) {
            answer = answer + 1;
        }
        
    }
    
    
    return answer;
}
int main() {

    string point = "";
    cin >> point;
    int answer = solution(point);
    cout << answer << endl;

    return 0;
}