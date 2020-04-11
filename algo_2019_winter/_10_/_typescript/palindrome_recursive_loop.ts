let data2: String[] = ["abcdcba", "abacba", "abacde"];

const solution2 = s => {
  const maxPalindrome = (str, len) => {
    while (len > 1) {
      let midpoint = Math.ceil(len / 2) - 1;
      // console.log("len: " + len, "midpoint: " + midpoint);
      for (let shift = 0; shift <= str.length - len; shift++) {
        // console.log("string: " + str.substring(0 + shift, len + shift));
        let isPalindrome = true;
        for (let cursor = 0; cursor <= midpoint; cursor++) {
          // console.log(
          //   str[cursor + shift],
          //   str[cursor + shift] == str[len - 1 - cursor + shift] ? "==" : "!=",
          //   str[len - 1 - cursor + shift] + "\n"
          // );
          if (str[cursor + shift] != str[len - 1 - cursor + shift]) {
            isPalindrome = false;
            break;
          }
        }
        if (isPalindrome) return len;
      }
      len--;
    }
    return 1;
  };
  return maxPalindrome(s, s.length);
};

console.log(solution2(data2[2]));
