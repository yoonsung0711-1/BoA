const candidate_counter = (relation: string[][]) => {
  // relation은 2d array로
  // 예시의 경우 6(tuple의 수) x 4(attribute의 수)
  // nCr에서 n은 4이고 r은 1, 2, 3, 4
  let n = relation[0].length;
  let flags: boolean[] = Array<boolean>(n);
  let candidate_keys: Array<Array<string>> = new Array<Array<string>>();
  const recur = (s, r) => {
    // 출구: 호출 시마다 --r 처리 후  카운트가 끝나면 종료
    if (r == 0) {
      // step1: flas (attribute의 선택 여부) 만들기
      //console.log(flags);

      // step2: tuple에서 선택된 attribute만 뽑아내기
      //console.log(
      //// tuple = ["100", "ryan", "music", "2"], ...
      //// idx = 0, ...
      //relation.map((tuple, idx) => {
      //// attr = "100", ...
      //// i = 0, ...
      //return (
      //tuple
      //.map((attr, i) => {
      ////flags = [true,,,]
      //return flags[i] ? attr : null;
      //})
      ////[> null 걸러내기
      //.filter(x => x)
      //);
      ///[>/
      //})
      //);

      //step3: tuple 마다 attribute를 이어붙인 string 만들기
      //console.log(
      //relation.map((tuple, idx) => {
      //return tuple
      //.map((attr, i) => {
      //if (flags[i]) return attr;
      //else return null;
      //})
      //.filter(x => x)
      //.join("-");
      //})
      //);

      //step4: 유일성 판단을 위해 set으로 만들기
      let attr_strs: Set<string> = new Set(
        relation.map((tuple, idx) => {
          return tuple
            .map((attr, i) => {
              if (flags[i]) return attr;
              else return null;
            })
            .filter(x => x)
            .join("-");
        })
      );
      //console.log(attr_strs);

      let attr_subs: string[] = flags
        .map((flag, idx) => {
          if (flag) return idx.toString();
          else return null;
        })
        .filter(x => x);

      //console.log(attr_subs);
      //console.log(attr_subs.includes("0"));

      //console.log(attr_subsets.filter(x => x.includes("0")));
      //
      //step5-1: 유일성 판단 기준1 (set: 중복 merge)
      // relation의 size 6에 미달하면 merge된 데이터가 있다고 판단가능
      if (attr_strs.size == relation.length) {
        if (candidate_keys.length == 0) {
          candidate_keys.push(attr_subs);
        }
        //step6-2: 최소성 판단 기준2 (기존 후보키가 subset인지 확인)
        //let isSubset = candidate_keys.some(
        //c => c.filter(x => attr_subs.includes(x)).length == c.length
        //);

        candidate_keys.some(
          c => c.filter(x => attr_subs.includes(x)).length == c.length
        );

        //if (!isSubset) candidate_keys.push(attr_subs);
      }
      return;
    } else {
      // flag를 만드는 코드 - backtracking 이용
      for (let i = s; i < n; i++) {
        flags[i] = true;
        recur(i + 1, r - 1);
        flags[i] = false;
      }
    }
  };

  for (let r = 0; r < n; r++) {
    recur(0, r);
  }

  //recur(0, 1);
  //recur(0, 2);
  //recur(0, 3);
  //recur(0, 4);

  //console.log(candidate_keys);
  //console.log(candidate_keys.length);
  return candidate_keys.length;
};

//var student: string[][] = [
//["100", "ryan", "music", "2"],
//["200", "apeach", "math", "2"],
//["300", "tube", "computer", "3"],
//["400", "con", "computer", "4"],
//["500", "muzi", "music", "3"],
//["600", "apeach", "music", "2"]
//];

var student: string[][] = [
  //["1", "0", "o", "19"],
  //["1", "0", "p", "19"],
  //["2", "0", "p", "21"],
  //["2", "0", "o", "21"]
];

console.log(candidate_counter(student));
//candidate_counter(student);
