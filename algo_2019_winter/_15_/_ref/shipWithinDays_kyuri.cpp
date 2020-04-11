class Solution {
  public:
    int counterDay(vector < int > & ws, int mount) {
      int cap = 0;
      int day = 1;
      for (auto w: ws) {
        cap += w;
        if (cap > mount) {
          day++;
          cap = w;
        }
      }
      return day;
    }
	
  int shipWithinDays(vector < int > & ws, int D) {
    auto r = accumulate(ws.begin(), ws.end(), 0);
    auto l = max( * max_element(ws.begin(), ws.end()), r / D);
    while (l < r) {
      auto m = l + (r - l) / 2;
      if (counterDay(ws, m) > D) {
        l = m + 1;
      } else {
        r = m;
      }
    }
    return l;
  }
};