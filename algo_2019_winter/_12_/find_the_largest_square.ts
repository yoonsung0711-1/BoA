const sampleStr = "0111|1111|1111|0010/0011|1111";
const sampleStr2 = "011101111|001110011|1101100111|1101100100";

const sampleProvider = (sample_str: string, no: number) => {
  let board: number[][][] = sample_str
    .split("/")
    .map(sample =>
      sample.split("|").map(digits => digits.split("").map(d => parseInt(d)))
    );
  return board[no];
};

interface Candidate {
  row: number;
  col: number;
  length: number;
}

const checkBoard = ( { row, col, length }: Candidate, board: number[][]): number => {
  let max: number = -1;
  for (let len = length; len > 1; len--) {
    let flag = true;
        for (let r = row; r < row + len; r++) {
      for (let c = col + (length - len); c < col + len; c++) {
        if ((r >= board.length) || (c >= board[0].length) ) {
          flag = false;
          continue;
        } 
        if (board[r][c] == 0) {
          flag = false;
        }
      }
    }
    if (flag && len > max) max = len;
  }
  return max > 1 ? max : board[row].includes(1) ? 1 : 0;
};

const solution = (_board: number[][]) => {
  const [w, h] = [_board[0].length, _board.length];
  const board = _board.reduce((acc: Array<number[]>, curr: number[]) => {
    acc.push(curr);
    return acc;
  }, new Array<number[]>());
  console.log(board);
  let candidArr = board.map((x, i) => getCandidateArr(x, i));
  return candidArr.map(candidates => candidates.map(c => checkBoard(c, board)).reduce((acc, curr) => Math.max(acc, curr), -1)).reduce((acc, curr) => Math.max(acc,curr), -1);
};

const getCandidateArr = (row: number[], rowNum: number): Array<Candidate> => {
  let open: boolean = false;
  let cnt = 0;
  let candidate = new Array<Candidate>();
  for (let i = 0; i < row.length; i++) {
    if (row[i] == 1) {
      cnt++;
      if (cnt == 1) {
        open = !open;
        let pair: Candidate = { row: rowNum, col: i, length: -1 };
        candidate.push(pair);
      }
    } else if (row[i] == 0) {
      if (open) {
        candidate[candidate.length - 1].length = cnt;
        cnt = 0;
        open = !open;
      }
    }
    if (i == row.length - 1 && open) {
      candidate[candidate.length - 1].length = cnt;
      cnt = 0;
      open = !open;
    }
  }
  return candidate;
};

//solution(sample_provider(sample_str, 0));

solution(sampleProvider(sampleStr, 0));

export { solution, sampleStr, sampleProvider, getCandidateArr, checkBoard };
