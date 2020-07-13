#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int tbw = 0; // �ٸ��� �ִ� ��ü Ʈ�� ����
    int i = 0; // Ʈ�� idx
    queue<int> times; // Ʈ���� �ٸ��� �����ϴ� �ð�
    queue<int> q; // Ʈ���� �ٸ��� ������ �� 

    while ((!q.empty()) || (i != truck_weights.size())) {
        answer += 1;

        if (!times.empty()) {
            // ���� �ð��� �ٸ��� �����ϴ� �� �� Ʈ�� �ð��� ������ ������.
            if (answer == times.front()) {
                tbw -= q.front();
                q.pop();
                times.pop();
            }
        }

        if ((i < truck_weights.size()) && (weight - tbw) >= truck_weights[i]) {
            // �ٸ��� Ʈ���� �־���
            q.push(truck_weights[i]);
            tbw += truck_weights[i];
            // Ʈ���� �ٸ��� �����ϴ� �ð�
            times.push(answer + bridge_length);
            i += 1;
        }
    }
    return answer;
}

int main() {

    int a, b;
    vector<int> c;
    a = 2;
    b = 10;
    c.push_back(7);
    c.push_back(4);
    c.push_back(5);
    c.push_back(6);
    int res = solution(a, b, c);
    cout << res << endl;

    return 0;
}