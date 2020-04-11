class PalindromeJavaClosure {
  public static void main(String[] args) {
    String[] data = new String[] { "abcdcba", "abacba", "abacde" };
    System.out.println(solution(data[2]));
  }

  public interface MaxPalindrome {
    int get(String str, int len);
  }

  static int solution(String s) {
    MaxPalindrome maxPalindrome = new MaxPalindrome() {
		@Override
		public int get(String str, int len) {
            while (len > 1) {
            int midpoint = len / 2 - 1;
            for (int shift = 0; shift <= str.length() - len; shift++) {
                boolean isPalindrome = true;
                for (int cursor = 0; cursor <= midpoint; cursor++) {
                    if (str.charAt(cursor + shift) != str.charAt(len - 1 - cursor + shift)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) return len;
            }
            len--;
            }
            return 1;
		}
    };
    return maxPalindrome.get(s, s.length());
  }
//   static int maxPalindrome(String str, int len) {
    // while (len > 1) {
    //   int midpoint = len / 2 - 1;
    //   for (int shift = 0; shift <= str.length() - len; shift++) {
    //     boolean isPalindrome = true;
    //     for (int cursor = 0; cursor <= midpoint; cursor++) {
    //       if (str.charAt(cursor + shift) != str.charAt(len - 1 - cursor + shift)) {
    //         isPalindrome = false;
    //         break;
    //       }
    //     }
    //     if (isPalindrome) return len;
    //   }
    //   len--;
    // }
    // return 1;
//   }
}

