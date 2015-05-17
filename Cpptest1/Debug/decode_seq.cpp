/*
 * decode_seq.cpp
 *
 *  Created on: Nov 30, 2014
 *      Author: maria_000
 */
#include <iostream>
#include <cstdio>
#include <string>
#include <vector>
#include <set>
#include <map>
#include <queue>
#include <cmath>
#include <algorithm>
#include <sstream>
#include <stack>
#include <cstring>
#include <iomanip>
#include <ctime>
using namespace std;
#define pb push_back
#define INF 1000000000
#define FOR(i,n) for(int (i)=0;(i)<(n);++(i))
#define FORI(i,n) for(int (i)=1;(i)<=(n);++(i))
#define mp make_pair
#define pii pair<int,int>
#define ll long long
#define vi vector<int>
#define SZ(x) ((int)(x.size()))
#define fi first
#define se second
#define wez(n) int (n); scanf("%d",&(n));
#define wez2(n,m) int (n),(m); scanf("%d %d",&(n),&(m));
#define wez3(n,m,k) int (n),(m),(k); scanf("%d %d %d",&(n),&(m),&(k));
inline void pisz(int n) { printf("%d\n",n); }
template<typename T,typename TT> ostream& operator<<(ostream &s,pair<T,TT> t) {return s<<"("<<t.first<<","<<t.second<<")";}
template<typename T> ostream& operator<<(ostream &s,vector<T> t){FOR(i,SZ(t))s<<t[i]<<" ";return s; }
#define IN(x,y) ((y).find((x))!=(y).end())
#define DBG(vari) cerr<<#vari<<" = "<<(vari)<<endl;
#define ALL(t) t.begin(),t.end()
#define FOREACH(i,t) for (typeof(t.begin()) i=t.begin(); i!=t.end(); i++)
#define TESTS wez(testow)while(testow--)
#define REP(i,a,b) for(int (i)=(a);(i)<=(b);++i)
#define REPD(i,a,b) for(int (i)=(a); (i)>=(b);--i)
#define REMAX(a,b) (a)=max((a),(b));
#define REMIN(a,b) (a)=min((a),(b));

#define MAXLENGTH 1000000
typedef struct
{
   int d;
   int num;
} Vertex;
struct cmp {
  bool operator() (const Vertex& v1, const Vertex& v2) const
  {
     if(v1.d < v2.d) return true;
     if(v1.d == v2.d && v1.num < v2.num) return true;
     return false;
  }
};
typedef set<Vertex, cmp> Q;

typedef vector<vector<int> > G;
typedef vector<int> B;
int main()
{
	cout<<"John";
   ios_base::sync_with_stdio( false );
   int n, k, n1, n2;
   cin >> n;
   vi init;
   Q q;
   Q::iterator q_it;
   G g(MAXLENGTH, init);
   B deg(MAXLENGTH, -1);
   FOR(i, n)
   {
      cin >> k;
      cin >> n1;
      n1--;
      if(deg[n1] == -1)
      {
         deg[n1]++;
      }
      FOR(i, k - 1)
      {
         cin >> n2;
         n2--;
         g[n1].pb(n2);
         if(deg[n2] == -1) deg[n2] = 1;
         else deg[n2]++;
         n1 = n2;
      }
      if(deg[n2] == -1) deg[n2] = 0;
   }
   Vertex v;
   FOR(i, MAXLENGTH)
   {
      if(deg[i] != -1)
      {
         v.d = deg[i];
         v.num = i;
         q.insert(v);
      }
   }
   /*
   cout << "Q: " << q.size() << endl;
   FOREACH(q_it, q)
   {
      cout << "deg: " << q_it->d << " label: " << q_it->num + 1 << endl;
   }
   */
   int res_len = q.size();
   vi res(res_len, 0);
   FOR(i, res_len)
   {
//      cout << "Q: " << q.size() << endl;
      q_it = q.begin();
      n1 = q_it->num;
      res[i] = n1 + 1;
      q.erase(q.begin());
      FOR(j, g[n1].size())
      {
         n2 = g[n1][j];
         v.d = deg[n2];
         v.num = n2;
         q.erase(v);
         deg[n2]--;
         v.d--;
         q.insert(v);
      }
   }
//   cout << "########################" << endl;
   FOR(i, res.size())
   {
      cout << res[i] << " ";
   }
   return 0;
}




