var sArr: string[];
sArr = ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"];
const cArr = sArr.map(str => str.split(""));
const mArr = sArr.map(str => new Array<number>(sArr.length).fill(0));

//console.log(cArr);
//console.log(mArr);

function memo(i, j) {
  if (
    sArr[i][j] == sArr[i][j + 1] &&
    sArr[i][j] == sArr[i + 1][j] &&
    sArr[i][j] == sArr[i + 1][j + 1]
  ) {
    mArr[i][j] = mArr[i][j] + 1;
    mArr[i + 1][j]++;
    mArr[i][j + 1]++;
    mArr[i + 1][j + 1]++;
  }
}

//1-pass
for (let i = 0; i < cArr.length - 1; i++) {
  for (let j = 0; j < cArr[0].length - 1; j++) {
    memo(i, j);
  }
}

//console.log(mArr);

let c = 0;
mArr.map((x, i) =>
  x.map((y, j) => {
    if (mArr[i][j] != 0) {
      c++;
      mArr[i][j] = null;
      cArr[i][j] = "x";
    }
  })
);

//console.log(mArr);
//console.log(cArr);

//2-pass
const drop = () => {
  const iter = () => {
    let hasNext = false;
    for (let j = 0; j < mArr[0].length; j++) {
      for (let i = mArr.length - 1; i > 0; --i) {
        // 현재 위치가 빈 블록인지 확인
        if (mArr[i][j] == null) {
          let _i = i,
            hasZeroAbove = false;
          // 현재 위치 위로 비어있지 않은 블록이 있는지 확인
          while (_i--) {
            if (mArr[_i][j] != null) {
              hasZeroAbove = true;
              break;
            }
          }
          // 내 위로 비어 있다면 hasNext = false 인 채로 종료시키고, 아니면 플래그 변경
          if (!hasZeroAbove) {
            break;
          } else {
            hasNext = true;
          }
          // 블록 한칸씩 내리기
          while (i--) {
            mArr[i + 1][j] = mArr[i][j];
            cArr[i + 1][j] = cArr[i][j];
            mArr[i][j] = null;
            cArr[i][j] = "x";
          }
          break;
        }
      }
    }
    return hasNext;
  };
  while (iter()) {}
};

drop();
console.log(mArr);
console.log(cArr);
console.log(c);
