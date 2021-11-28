#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    vector<int> map;
    for(int i=0;i<dungeons.size();i++) {
        map.push_back(i+1);
    }
    do {
        int result = k;
        int counts = 0;
        for(int i=0;i<map.size();i++) {
            // 현재 피로도(result)가 던전 입장을 위한 최소 피로도(던전[[i]-1][0]) 보다 크거나 같다면
            if(result >= dungeons[map[i]-1][0]) {
                // 던전에 입장하고 피로도 차감, 입장 횟수 증가
                result = result - dungeons[map[i]-1][1];
                counts ++;
            }
            // 입장하지 못한다면 종료
            else {
                break;
            }
        }
        answer = max(counts, answer);

    } while(next_permutation(map.begin(), map.end()));

    return answer;
}