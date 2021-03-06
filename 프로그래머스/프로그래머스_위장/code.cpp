#include <string>
#include <vector>
#include <map>

using namespace std;

// clothes가 들어올때 [청바지, 하의] 식으로 들어옴.
// 그러니까 뒤에 있는 놈이 의상 type이 되는거임.
int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> hash; // 맵을 이용해서 의상 종류별 갯수를 파악함.

    for(int i=0; i<clothes.size(); i++) {
	// 같은 의상 타입이 있으면 ++ 해준다
	// 이러면 clothes[청바지][하의], [반바지][하의]가 있으면 -> hash[하의] = 2가 되는거임.
        hash[clothes[i][1]] ++;
    }

	// 종류별 착용 경우의 수 더하면 된다.
	// hash의 second는 종류별 갯수니까 여기서 착용 x 경우까지 고려해서 second+1
	// 이제 모든 경우의 수를 다 곱해줌.

    for(auto it = hash.begin(); it != hash.end(); it++) {
        answer = answer *((it->second) + 1);
    }
	// 모두 안입었을 경우를 위해 -1을 함.
    return answer-1;
}

	// 상의	[긴팔티셔츠, 반팔]
	// 하의	[청바지, 반바지] 일때.
	// 긴팔+반팔+미착용 X 청바지+반바지+미착용
	// 3 x 3 = 9
	// 9가지 경우의 수가 나옴 아래를 보면 됨.
	// [미착용, 미착용]
	// [긴팔, 미착용][반팔,미착용][청바지,미착용][반바지,미착용]
	// [긴팔,청바지][긴팔,반바지][반팔,청바지][반팔,반바지]
	// 미착용, 미착용 은 제외해줘야 하니까
	//  return에서 -1함.
