//import { solution } from "./largest_rectangle";

require("es6-symbol/implement");

describe("문제 풀이에 필요한 기능 테스트하기", () => {
  let example: Array<number>;
  beforeEach(() => {
    example = [2, 1, 5, 6, 2, 3];
  });

  it("최소 높이 찾기", () => {
    let min = Math.min(...example);
    expect(min).toEqual(1);
  });

  it("부분열 만들기", () => {
    expect(example.slice(0, example.length - 1)).toEqual([2, 1, 5, 6, 2]);
  });

  it("부분열 generator", () => {
    let subsetGenerator = (function* (numArr: Array<number>, num: number) {
      let subset = numArr.splice(0, numArr.length - num);
      while (true) {
        subset.pop();
        yield subset;
        if (subset.length == 1) return;
      }
    })(example, 0);
    expect(subsetGenerator.next().value).toEqual([2, 1, 5, 6, 2]);
    expect(subsetGenerator.next().value).toEqual([2, 1, 5, 6]);
    expect(subsetGenerator.next().value).toEqual([2, 1, 5]);
    expect(subsetGenerator.next().value).toEqual([2, 1]);
    expect(subsetGenerator.next().value).toEqual([2]);
    expect(subsetGenerator.next().value).toEqual();
  });

  it("부분열 generator를 partial 적용하기", () => {
    let subsetPartialGenerator = (numArr: Array<number>) => {
      return function* (num: number) {
        let subset = Object.assign([], numArr);
        if (subset.length == 0) return;
        subset.splice(0, num);
        while (true) {
          subset.pop();
          if (subset.length == 0) return;
          yield subset;
        }
      };
    };
    let generator = subsetPartialGenerator(example);
    let iter = generator(0);
    expect(iter.next().value).toEqual([2, 1, 5, 6, 2]);
    expect(iter.next().value).toEqual([2, 1, 5, 6]);
    expect(iter.next().value).toEqual([2, 1, 5]);
    expect(iter.next().value).toEqual([2, 1]);
    expect(iter.next().value).toEqual([2]);
    expect(iter.next().value).toEqual();

    iter = generator(1);
    expect(iter.next().value).toEqual([1, 5, 6, 2]);
    expect(iter.next().value).toEqual([1, 5, 6]);
    expect(iter.next().value).toEqual([1, 5]);
    expect(iter.next().value).toEqual([1]);

    iter = generator(2);
    expect(iter.next().value).toEqual([5, 6, 2]);
    expect(iter.next().value).toEqual([5, 6]);
    expect(iter.next().value).toEqual([5]);
  });
});

//
describe("파이프라인 체이닝을 위한 클래스 객체 만들기", () => {
  describe("1. 클래스 생성", () => {
    class Solution {
      generator: Function;
      sol: Solution;
      constructor(heights: Array<number>) {
        this.generator = this.subsetPartialGenerator(heights);
      }
      subsetPartialGenerator(numArr: Array<number>) {
        return function* (num: number) {
          let subset = Object.assign([], numArr);
          if (subset.length == 0) return;
          subset.splice(0, num);
          while (true) {
            if (subset.length == 0) return;
            yield subset;
            subset.pop();
          }
        };
      }
    }
    let sol = new Solution([2, 1, 5, 6, 2]);
    it("solution객체로부터 subsetPartialGenerator 얻어서 사용", () => {
      let iter = sol.generator(3);
      expect(iter.next().value).toEqual([6, 2]);
      expect(iter.next().value).toEqual([6]);
    });
  }); // 1.class

  describe("2. decorator 패턴 + getMaxArea 메서드 작성", () => {
    class Solution {
      generator: Function;
      subset: Array<number>;
      constructor(heights: Array<number>) {
        this.generator = this.subsetPartialGenerator(heights);
      }
      subsetPartialGenerator(numArr: Array<number>) {
        return function* (num: number) {
          this.subset = Object.assign([], numArr);
          if (this.subset.length == 0) return;
          this.subset.splice(0, num);
          while (true) {
            if (this.subset.length == 0) return;
            yield this;
            this.subset.pop();
          }
        };
      }
      getMaxArea() {
        return Math.min(...this.subset) * this.subset.length;
      }
    }
    let sol = new Solution([2, 1, 5, 6, 2]);
    it("subsetPartialGenerator는 호출될 때마다 새 iterator 반환", () => {
      let iter = sol.generator(3);
      console.log(iter.next().value.getMaxArea());
    }); // 2. decorator

    describe("3. Iterable", () => {
      class Solution {
        generator: Function;
        subset: Array<number>;
        constructor(heights: Array<number>) {
          this.generator = this.subsetPartialGenerator(heights);
        }
        subsetPartialGenerator(numArr: Array<number>) {
          return function* (num: number) {
            this.subset = Object.assign([], numArr);
            if (this.subset.length == 0) return;
            this.subset.splice(0, num);
            while (true) {
              if (this.subset.length == 0) return;
              yield this;
              this.subset.pop();
            }
          };
        }
        getMaxArea() {
          return Math.min(...this.subset) * this.subset.length;
        }
        [Symbol.iterator](num: number) {
          let iter = this.generator(num);
          return {
            next: () => {
              return {
                value: iter.next().value,
                done: false,
              };
            },
          };
        }
      }
      let sol = new Solution([2, 1, 5, 6, 2]);
      it("subsetPartialGenerator는 호출될 때마다 새 iterator 반환", () => {
        let iter = sol.generator(2);
        let max = -1;
        let curr;
        for (let i of iter) {
          if ((curr = i.getMaxArea()) > max) {
            max = curr;
          }
        }
        console.log(max);
      });
    });
  }); //3. Iterable
});
