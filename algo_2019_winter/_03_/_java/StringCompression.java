package algo_2019_winter._03_;

class StringCompression {
    public static void main(final String[] args) {
        String[] sArr = {"aabbaccc",
            "ababcdcdababcdcd",
            "abcabcdede",
            "abcabcabcabcdededededede",
            "xababcdcdababcdcd"};
        int[] res = {7, 9, 8, 14, 17};
        for (int i = 0; i < 5; i++) {
            if (comp(sArr[i]) == res[i]){
                System.out.println("test " + (i + 1) + " passed");
            } else {
                System.out.println("test " + (i + 1) + " failed");
            };
        }
    }

    public static int comp(final String s){
        int minLen = s.length();
        StringBuilder whole_str = new StringBuilder();
        String remn = "";
        String curr = "";
        for (int unit = s.length()/2; unit > 0; unit--){
            int q = s.length() / unit;
            String prev = s.substring(0, unit);
            int cnt = 0;
            remn = s.substring(unit * q);
            for (int i = 1; i < q + 1; i++) {
                if (i < q) {
                    curr = s.substring(unit * i, unit * (i + 1));
                } else {
                    curr = "";
                }
                if (curr.equals(prev)) {
                    cnt = cnt + 1;
                } else if (!curr.equals(prev)) {
                    if (cnt > 0) {
                        whole_str.append((cnt + 1) + prev);
                    } else {
                        whole_str.append(prev);
                    }
                    prev = curr;
                    cnt = 0;
                }
            }
            whole_str.append(remn);
            if ("".equals(remn)){
            } 
            int curLen = whole_str.length();
            if (curLen < minLen) {
                minLen = curLen;
            }
            whole_str.setLength(0);
        }
        return minLen;
    }
}