#include string
#include vector
#include map

using namespace std;

vectorint solution(string msg) {
    mapstring, int dict;
    mapstring, intiterator it;
    vectorint answer;
    stdstring dic = ;
    for(int i=1;i=26;i++){
        dic = 'A' + (i-1);
        dict.insert(make_pair(dic, i));
        dic = ;
    }
    for(int i=0;imsg.length();i++){
        dic = ;
        dic = dic + msg[i];
        
        it = dict.find(dic);
        answer.push_back(it-second);
    }
    
    return answer;
}
