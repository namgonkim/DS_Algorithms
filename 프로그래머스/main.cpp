#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <utility>
#include <sstream>
/*
문제: 오픈채팅방
설명: 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때,
    모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성
유형: 구현
날짜: 2021.06.19
*/
using namespace std;

// 문자열 분리하기
vector<string> spliter(string log) {
    vector<string> splits;
    istringstream ss(log);
    string log_buf;
    while(getline(ss, log_buf, ' ')) {
        splits.push_back(log_buf);
    }

    return splits;
}

vector<string> solution(vector<string> record)
{
    vector<string> answer;
    vector<pair<string, string>> loadmap;
    // map : key(uid) , value (nickname)
    multimap<string, string> user;

    for(int i=0; i < record.size(); i++) {
        // 문자열 분리 [유저 행위 / 유저 고유 번호 / 유저 이름]
        vector<string> items = spliter(record[i]);
        // 유저가 들어온 경우
        if(items[0][0] == 'E') {
            // 유저가 없다면
            auto it = user.find(items[1]);
            if (it == user.end())
            {
                // 유저 생성 (uid / 닉네임)
                user.insert({items[1], items[2]});
                cout << items[1] << " / " << items[2] << "유저 없이 들어옴 + 생성됨" << endl;
                // uid 유저가 들어왔다
                loadmap.push_back({it->first, items[0]});
            }
            // 유저가 있다면
            else
            {
                // 유저 닉네임 변경
                it->second = items[2];
                cout << it->first << " / " << it->second << "유저 있음 들어옴 + 닉네임 변경" << endl;
                // uid 유저가 들어왔다
                loadmap.push_back({it->first, items[0]});
            }
            
        }
        // 유저 닉네임을 변경한 경우
        else if(items[0][0] == 'C') {
            auto it = user.find(items[1]);
            it->second = items[2];
            cout << it->first << " / " << it->second << "유저 닉네임 변경" << endl;
        }
        // 유저가 나간 경우
        else {
            auto it = user.find(items[1]);
            // uid 유저가 나갔다.
            loadmap.push_back({it->first, items[0]});
            cout << it->first << " / " << it->second << "유저 나감" << endl;
        } 
    }

    // 유저 uid에 대해 들어오고 나갔는지 확인
    for(int i=0; i < loadmap.size(); i++) {
        cout << loadmap[i].first << " / " << loadmap[i].second << endl;
        pair<string, string> finder = loadmap[i];
        auto it = user.find(finder.first);
        // 유저가 들어갔다면
        if(finder.second[0] == 'E') {
            answer.push_back(it->second + "님이 들어왔습니다.");
        }
        // 유저가 나갔다면
        else {
            answer.push_back(it->second + "님이 나갔습니다.");
        }
    }

    return answer;
}

int main() {

    // ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
    // ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
    vector<string> record = { "Enter uid1234 Muzi",
                              "Enter uid4567 Prodo",
                              "Leave uid1234",
                              "Enter uid1234 Prodo",
                              "Change uid4567 Ryan" };
    vector<string> answer = solution(record);
    for(int i=0;i<answer.size();i++){
        cout << answer[i] << endl;
    }
    return 0;
}