class PalindromeTailRecursion {
  public static void main(String[] args) {
    String[] data = new String[] {
      "abcdcba",
      "abacdba",
      "abacde"
    };

    System.out.println(solution(data[0]));

  }
  static int solution(String s) {
    return maxPalindrome(s, s.length());
  }
  static int maxPalindrome(String str, int len){
    int midpoint = len / 2; 
    boolean isPalindrome;
    System.out.println("len: " + len + " midpoint: " + midpoint);
    for (int shift = 0; shift <= str.length() - len; shift++) {
      System.out.println("string: " + str.substring(0+ shift, len + shift));
      isPalindrome = true;
      for (int cursor = 0; cursor <= midpoint; cursor++) {
        System.out.println(
          Character.toString(str.charAt(cursor + shift)) +
          ((str.charAt(cursor + shift) == str.charAt(len - 1 -cursor + shift)) ? "==" : "!=" )+
          str.charAt(len - 1 - cursor + shift) + "\n"
        );
        if (str.charAt(cursor + shift) != str.charAt(len - 1 - cursor + shift)) {
          isPalindrome = false;
          break;
        }
      }
    if (isPalindrome) return len;
    }
  return maxPalindrome(str, --len);
  }
}


