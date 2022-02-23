#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> blocks, int h, int w) {
    int answer = 0;
    
    for(int i=1; i < w-1;i++) {
        int left = 0;
        int right = 0;
        // 기준점에서 왼쪽에 있는 최대 값 찾기
        for(int j=0;j<i;j++) {
            left = max(left, blocks[j]);
        }
        // 기준점에서 오른쪽에 있는 최대 값 찾기
        for(int j=w-1; j>i;j--) {
            right = max(right, blocks[j]);
        }
        // 기준점에 고일 빗물 계산
        answer = answer + max(0, min(left, right) - blocks[i]);
    }

    return answer;
}

int main(void) {

    int h, w;
    cin >> h >> w; // 세로, 가로
    vector<int> blocks;
    for(int i=0;i<w;i++) {
        int block;
        cin >> block;
        blocks.push_back(block);
    }

    int result = solution(blocks, h, w);
    cout << result << "\n";

    return 0;
}