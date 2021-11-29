#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
    
    int n, m;
    scanf("%d", &n);
    vector<int>v(n,0);

    for(int i=0;i<n;i++) {
        scanf("%d", &v[i]);
    }
    sort(v.begin(), v.end());

    scanf("%d", &m);

    for(int i=0;i<m;i++) {
        int num;
        scanf("%d", &num);
        bool result = binary_search(v.begin(), v.end(), num);
        if(result == true) {
            printf("1\n");
        }
        else {
            printf("0\n");
        }
    }
    return 0;
}