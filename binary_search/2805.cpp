#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
    long long n, m; // 나무의 수 n 과 사근이가 집으로 가져가려는 나무길이 m
    vector<long long> trees;
    cin >> n >> m;
    long long start = 0, end = 0, mid;
    long long result = 0, cnt = 0;
    for(int i=0;i<n;i++) {
        int num;
        cin >> num;
        trees.push_back(num);
    }

    end = *max_element(trees.begin(), trees.end());

    while(start <= end) {
        cnt = 0;
        mid = (start + end) / 2;

        // 나무 자르기
        for(int i=0;i<n;i++) {
            // mid보다 높은 나무를 찾아 자른다
            if(trees[i] > mid) {
                cnt = cnt + (trees[i] - mid);
            }
        }
        // 다 잘랐으면 길이 확인
        // 전체 길이가 m 보다 작으면 더 크게 잘라본다
        if(cnt < m) {
            end = mid - 1;
        }
        // m보다 더 크게 가져가면 더 작게 잘라본다
        else{
            start = mid + 1;
            result = mid;
        }
    }
    cout << result << "\n";
    return 0;
}