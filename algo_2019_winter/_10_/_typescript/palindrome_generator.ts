let data3: String[] = ["abcdcba", "abacba", "abacde"];

const solution3 = s => {
  function* maxPalindrome(str, len) {
    while (len > 1) {
      let midpoint = Math.ceil(len / 2) - 1;
      for (let shift = 0; shift <= str.length - len; shift++) {
        let isPalindrome = true;
        for (let cursor = 0; cursor <= midpoint; cursor++) {
          if (str[cursor + shift] != str[len - 1 - cursor + shift]) {
            isPalindrome = false;
            break;
          }
        }
        if (isPalindrome) {
          yield len
          return len;
        };
      }
      len--;
    }
    yield 1;
    return 1;
  }
  let answer;
  for (let r of maxPalindrome(s, s.length)) {
    answer = r;
  }
  return answer;
};;

//[...new Array(14).keys()].forEach(x => console.log(answer.next().value));

console.log(solution3(data3[1]));
