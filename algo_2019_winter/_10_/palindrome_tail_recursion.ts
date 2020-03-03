let data: String[] = ["abcdcba", "abacba", "abacde"];

const solution = s => {
  const maxPalindrome = (str, len) => {
    if (len == 1) return 1;
    let midpoint = Math.ceil(len / 2) - 1;
    console.log("len: " + len, "midpoint: " + midpoint);
    let isPalindrome;
    for (let shift = 0; shift <= str.length - len; shift++) {
      console.log("string: " + str.substring(0 + shift, len + shift));
      isPalindrome = true;
      for (let cursor = 0; cursor <= midpoint; cursor++) {
        console.log(
          str[cursor + shift],
          str[cursor + shift] == str[len - 1 - cursor + shift] ? "==" : "!=",
          str[len - 1 - cursor + shift] + "\n"
        );
        if (str[cursor + shift] != str[len - 1 - cursor + shift]) {
          isPalindrome = false;
          break;
        }
      }
      if (isPalindrome) return len;
    }
    return maxPalindrome(str, --len);
  };

  return maxPalindrome(s, s.length);
};

console.log(solution("abacde"));
