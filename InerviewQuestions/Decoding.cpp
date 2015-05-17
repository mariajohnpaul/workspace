/*
 * Decoding.cpp
 *
 *  Created on: Oct 7, 2014
 *      Author: maria_000
 */
#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>
using namespace std;
class Decode {
public:
	vector<string> decode(string message) {
		vector<int> input, output;
		int prev = 1;
		int current = 0, next;
		for (unsigned int i = 0; i < message.size(); i++) {
			input.push_back(int(message[i])-48);
		}
		vector<int>::iterator itr = input.begin();
       // int sz=input.size();
		for (int i = 0; i < 3; i++) {
			switch (i) {
			case 0:
				//assume result starts with 01
				prev = 0;
				current = 1;
				output.push_back(0);
				output.push_back(1);
				itr = itr++;
				break;
			case 1:
				//assume result starts with 10
				prev = 1;
				current = 0;
				output.clear();
				output.push_back(1);
				output.push_back(0);
				itr = input.begin();
				itr = itr++;
				break;
			case 2:
				//assume result starts with 10
				prev = 1;
				current = 1;
				output.clear();
				output.push_back(1);
				output.push_back(1);
				itr = input.begin();
				itr = itr++;
				break;
			default:
				cout << "error";

			}
			int j=1;
			while (itr != input.end()) {

				next = input[j] - prev - current;
				if (next > 1)break;
				prev= current;
				current=next;
				output.push_back(next);
				itr++;
				j++;
			}
			if(j>input.size())break;
		}

		for(int k=0;k<output.size();k++)
			cout<<output[k];

		vector<string>vec;

		//vec.push_back(string(output));
		return vec;
	}

};


int fact(int inp)
{
int ans;
if(inp<2)
return inp;

ans = inp + fact(inp-1);
return ans;
}
int main() {

/*
	Decode *jp=new Decode();
	//jp->decode("123210122");//0111000110-1
	//cout<<"\n ";
	jp->decode("1222212121211");//1011010101010
	cout<<"\n ";
	//jp->decode("2332212121211");//1111010101010
*/
int i;
cin>>i;
	cout<<fact(i);

}

