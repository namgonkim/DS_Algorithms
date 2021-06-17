#include <string>
#include <vector>

using namespace std;

// 로또 번호와 당첨 번호를 비교해 zero 개수와 당첨 개수를 계산해서 조건에 따라 다르게 출력한다.
vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    int count = 0;
    int zero = 0;
    
    // 번호 비교 및 개수 추출
    for(int i=0;i<6;i++) {
        // 로또 번호가 0인 경우(찢어진 경우)
        if(lottos[i] == 0){
            zero += 1;
            continue;
        }
        // 0이 아니면 당첨 번호인지 확인한다.
        int match = lottos[i];
        for(int j=0;j<win_nums.size();j++) {
            if(match == win_nums[j]){
                count += 1;
                break;
            }
        }
    }
    // 당첨 번호도 없고 제로도 없는 경우
    if(count == 0 && zero == 0) {
        answer.push_back(6);
        answer.push_back(6);
    }
    // 그 외의 경우
    else{
        answer.push_back(7 - (count + zero));
        // 전부 다 찢어진 경우 - 전부 다 틀리는게 최소
        if(zero == 6)
            answer.push_back(6);
        else
            answer.push_back(7 - count);
    }
    
    
    
    return answer;
}