// 조합을 사용하려면 https://bcp0109.tistory.com/15 참고
function solution(relation) {
  var answers = [];
  var rows = relation.length;
  var cols = relation[0].length;

  for (var i = 1; i <= (1 << cols) - 1; i++) {
    var cache = {};

    for (var j = 0; j < rows; j++) {
      var strs = [];

      for (var k = 0; k < cols; k++) {
        //console.log(i, 1 << k, i & (1 << k))
        // 0만 아니면 if문을 통과함
        if (i & (1 << k)) {
          //console.log(i, j, k, relation[j][k])
          strs.push(relation[j][k]);
        }
      }

      // console.log(strs, strs.length)
      cache[strs.join("")] = true;
    }

    // console.log(i, Object.keys(cache).length)

    // 캐시에는 로우수만큼 있는지 확인하고, 최소성 검증을 해야 함.
    // 중간에 중복되는 값이 cache에 들어가면 개수가 rows 개수랑 같지 않음.
    if (Object.keys(cache).length == rows && check(answers, i)) {
      answers.push(i);
    }
  }

  function check(answers, now) {
    for (var i = 0; i < answers.length; i++) {
      console.log(answers, now);
      if ((answers[i] & now) == answers[i]) {
        return false;
      }
    }

    return true;
  }

  return answers.length;
}
