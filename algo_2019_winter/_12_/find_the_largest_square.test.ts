import {
  solution,
  sampleStr,
  sampleProvider,
  getCandidateArr,
  checkBoard
} from "./find_the_largest_square";

describe("예제 1", () => {
  test("체크보드 1행", () => {
    expect(
      checkBoard({ row: 0, col: 1, length: 3 }, [
        [0, 1, 1, 1],
        [1, 1, 1, 1],
        [1, 1, 1, 1],
        [0, 0, 1, 0]
      ])
    ).toBe(3);
  });

  test("체크보드 2행", () => {
    expect(
      checkBoard({ row: 1, col: 0, length: 4 }, [
        [0, 1, 1, 1],
        [1, 1, 1, 1],
        [1, 1, 1, 1],
        [0, 0, 1, 0]
      ])
    ).toBe(2);
  });

  test("체크보드 3행", () => {
    expect(
      checkBoard({ row: 2, col: 1, length: 4 }, [
        [0, 1, 1, 1],
        [1, 1, 1, 1],
        [1, 1, 1, 1],
        [0, 0, 1, 0]
      ])
    ).toBe(1);
  });

  test("체크보드 4행", () => {
    expect(
      checkBoard({ row: 3, col: 2, length: 1 }, [
        [0, 1, 1, 1],
        [1, 1, 1, 1],
        [1, 1, 1, 1],
        [0, 0, 1, 0]
      ])
    ).toBe(1);
  });
});

describe("후보군 찾기", () => {
  test("예제1-1행", () => {
    expect(getCandidateArr([0, 1, 1, 1], 0)).toStrictEqual([{ row: 0, col: 1, length: 3}])
  });

  test("예제1-2행", () => {
    expect(getCandidateArr([1, 1, 1, 1], 1)).toStrictEqual([{ row: 1, col: 0, length: 4}])
  });

  test("예제1-3행", () => {
    expect(getCandidateArr([1, 1, 1, 1], 2)).toStrictEqual([{ row: 2, col: 0, length: 4}])
  });

  test("예제1-4행", () => {
    expect(getCandidateArr([0, 0, 1, 0], 3)).toStrictEqual([{ row: 3, col: 2, length: 1}])
  });
})

describe("예제 공급기", () => {
  test("sample_str#splitable_by_'/'", () => {
    expect(sampleStr.split("/")).toStrictEqual([
      "0111|1111|1111|0010",
      "0011|1111"
    ]);
  });

  test("sample_str#splitable_by_'|'_followed_by_'/'", () => {
    expect(sampleStr.split("/").map(sample => sample.split("|"))).toStrictEqual(
      [
        ["0111", "1111", "1111", "0010"],
        ["0011", "1111"]
      ]
    );
  });

  test("sample_str#splitable_by_''_followed_by_'|'_and_followed_by'/', consequently'", () => {
    expect(
      sampleStr
        .split("/")
        .map(sample => sample.split("|").map(digits => digits.split("")))
    ).toStrictEqual([
      [
        ["0", "1", "1", "1"],
        ["1", "1", "1", "1"],
        ["1", "1", "1", "1"],
        ["0", "0", "1", "0"]
      ],
      [
        ["0", "0", "1", "1"],
        ["1", "1", "1", "1"]
      ]
    ]);
  });

  test("sample_str#atomic_value_to_be_number", () => {
    expect(
      sampleStr
        .split("/")
        .map(sample =>
          sample
            .split("|")
            .map(digits => digits.split("").map(d => parseInt(d)))
        )
    ).toStrictEqual([
      [
        [0, 1, 1, 1],
        [1, 1, 1, 1],
        [1, 1, 1, 1],
        [0, 0, 1, 0]
      ],
      [
        [0, 0, 1, 1],
        [1, 1, 1, 1]
      ]
    ]);
  });

  test("sample_str#atomic_value_to_be_number", () => {
    expect(sampleProvider(sampleStr, 0)).toStrictEqual([
      [0, 1, 1, 1],
      [1, 1, 1, 1],
      [1, 1, 1, 1],
      [0, 0, 1, 0]
    ]);
  });
});
