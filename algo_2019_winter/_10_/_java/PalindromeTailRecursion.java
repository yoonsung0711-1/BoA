class PalindromeTailRecursion {
  //컨텍스트
  //static String str = "abcdcba";
  public static void main(String[] args) {
    String[] data = new String[] {
      "abcdcba",
      "abacdba",
      "abacde"
    };

    //인자로 공유
    System.out.println(solution(data[0]));

    //컨텍스트
    //System.out.println(solution());

  }
  static int solution(String s) {
  //static int solution() {
    return maxPalindrome(s, s.length());
    //return maxPalindrome(str.length());
  }

  static int maxPalindrome(String str, int len){
  //static int maxPalindrome(int len){
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
  //return maxPalindrome(--len);
  }
}


