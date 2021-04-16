#include <iostream>
#include <string>
using namespace std;
int main() {
	string input;
	string finder;
	int num = 0;
	cin >> input >> finder;
	while(input.find(finder)!=string::npos){
		input = input.erase(input.find(finder),finder.length());
		num++;
	}
	cout << num << endl;
	return 0;
}