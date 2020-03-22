import { solution } from "./longest_string_chain";

describe("(# 01 ) longestStrChain을 얻기 위한 solution 객체", () => {
  let sol: any;

  beforeEach(() => {
    sol = solution(["a", "ab", "bc", "abc"]);
  });

  it("solution에는 node객체가 존재하고, node는 linked list형태로 이어져 있음", () => {
    let node = sol.node;
    expect(node.val).toEqual("a");
    expect(node.next.val).toEqual("ab");
    expect(node.next.next.val).toEqual("bc");
  });

  it("solution에는 memo객체가 존재하고, memo는 key값으로 문자열을, value값으로 String Chain의 길이를 반환함 ", () => {
    let memo: Map<string, number> = sol.memo;
    expect(memo.get("a")).toEqual(1);
    expect(memo.get("ab")).toEqual(2);
    expect(memo.get("bc")).toEqual(1);
    expect(memo.get("abc")).toEqual(3);
  });

  it("solution에는 maxlen객체가 존재하고, 입력된 문자열들이 만들 수 있는 가장 긴 String Chain의 길이를 반환함", () => {
    let maxlen: number = sol.maxLen;
    expect(maxlen).toEqual(3);
  });
});

