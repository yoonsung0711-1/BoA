let data1: String[] = ["abcdcba", "abacba", "abacde"];

const solution1 = s => {
  const maxPalindrome = (str, len) => {
    if (len == 1) return 1;
    let midpoint = Math.ceil(len / 2) - 1;
    process.stdout.write("len: " + len + ", midpoint: " + midpoint + "\n");
    let isPalindrome;
    for (let shift = 0; shift <= str.length - len; shift++) {
      process.stdout.write("word: " + str.substring(0 + shift, len + shift) + "\n");
      isPalindrome = true;
      for (let cursor = 0; cursor <= midpoint; cursor++) {
        process.stdout.write(
          str[cursor + shift] +
            (str[cursor + shift] == str[len - 1 - cursor + shift] ? "==" : "!=" )+
          str[len - 1 - cursor + shift]
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

console.log(solution1(data1[0]));
