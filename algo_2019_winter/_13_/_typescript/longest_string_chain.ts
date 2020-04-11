interface Node {
  val: string;
  next: Node;
}

const solution = (words: string[]) => {
  let node: Node;
  let memo: Map<string, number>;
  let maxLen: number;

  node = (() => {
    let asc_words = words.sort((a, b) => a.length - b.length);
    let prev: Node, next: Node;
    node = prev = { val: asc_words[0], next: next };

    for (let i = 1; i < asc_words.length; i++) {
      let curr = { val: asc_words[i], next: next };
      prev.next = curr;
      prev = curr;
    }
    return node;
  })();

  memo = (() => {
    memo = new Map<string, number>();
    let cursor = node,
      max;
    memo.set(cursor.val, 1);

    cursor = cursor.next;
    while (true) {
      if (cursor == null) break;
      max = -1;
      for (let i = 0; i < cursor.val.length; i++) {
        let wordMinusOneChr = cursor.val
          .split("")
          .map((s, idx) => (idx == i ? "" : s))
          .join("");
        let ret = memo.get(wordMinusOneChr) ? memo.get(wordMinusOneChr) + 1 : 1;
        if (ret > max) max = ret;
      }
      memo.set(cursor.val, max);
      cursor = cursor.next;
    }
    return memo;
  })();

  maxLen = (() => {
    let max = -1;
    memo.forEach((v, k) => {
      if (v > max) {
        max = v;
      }
    });
    return max;
  })();
  return { node, memo, maxLen };
};

//(() => {
//let _node = solution(["b", "ab", "bc", "abc"]).node;
//while (_node != null) {
//console.log(_node.val);
//_node = _node.next;
//}
//})();

//console.log(memo);
//console.log(node.next.next);
//console.log(node.next.next.next);
//console.log(solution(["b", "ab", "bc", "abc"]).node);

export { solution };


var longestStrChain = (words: string[]) => {
  return solution(words).maxLen;
};
