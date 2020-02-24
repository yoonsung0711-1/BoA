class PalindromeRecursiveLoop {
  public static void main(String[] args) {
    String[] data = new String[] {
      "abcdcba",
      "abacba", 
      "abacde"
    };
    System.out.println(solution(data[2]));
  }

  static int solution(String s) {
    return maxPalindrome(s, s.length());
  }
  static int maxPalindrome(String str, int len) {
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
}

