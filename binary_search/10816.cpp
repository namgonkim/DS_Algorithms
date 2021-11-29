#include <iostream>
#include <vector>
#include <algorithm>
/*
lower_bound: 찾고자 하는 값중 가장 처음에 있는 인덱스와 그 요소를 찾는다.
index = lower_bound(vector 시작, vector 끝, 찾으려는 값) - vector.begin()
value = *lower_bound(vector 시작, vector 끝, 찾으려는 값)
찾으려 하는 key값이 "없으면" key값보다 큰 가장 작은 정수 값을 찾는다

upper_bound: 찾고자 하는 값중 가장 마지막에 있는 인덱스와 그 요소를 찾는다.
index = upper_bound(vector 시작, vector 끝, 찾으려는 값) - vector.begin()
value = *upper_bound(vector 시작, vector 끝, 찾으려는 값)

*/
using namespace std;

int main(void) {
    int n, m;
    scanf("%d", &n);
    vector<int> v(n, 0);

    for(int i=0;i<n;i++) {
        scanf("%d", &v[i]);
    }
    
    sort(v.begin(), v.end());

    scanf("%d", &m);

    for(int i=0;i<m;i++) {
        int num;
        scanf("%d", &num);
        auto start = lower_bound(v.begin(), v.end(), num) - v.begin();
        auto end = upper_bound(v.begin(), v.end(), num) - v.begin();
        printf("%d ", end-start);
    }

    return 0;
}