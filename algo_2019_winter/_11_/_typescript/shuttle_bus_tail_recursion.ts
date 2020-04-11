const parser = str => {
  let arr: string[] = str.split("/").map(s => s.split("|"));
  let [n, m, t] = arr[0];
  let timetable = arr[1];
  return [n, m, t, timetable];
};

//console.log((<any>parser)("1|1|5/08:00|08:01|08:02|08:03"));

let sample = [
  "1|1|5/08:00|08:01|08:02|08:03",
  "1|1|5/08:00|08:01|08:02|08:03|08:04",
  "2|10|2/09:10|09:09|08:00",
  "2|1|2/09:00|09:00|09:00|09:00",
  "1|1|5/00:01|00:01|00:01|00:01|00:01",
  "1|1|1/23:59",
  "10|60|45/23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59"
];

const clock = n =>
  parseInt(n) >= 10 ? n : parseInt(n) >= 0 ? "0" + n : n + 24;
const range = n => Array.from(Array(n).keys());
const getChangedTime = (basetime, num) => {
  const HHMM = [Math.floor(num / 60), num % 60];
  return new Date(basetime.getTime() + num * 60 * 1000);
  //return basetime;
};

const basetime = new Date(0);

const solution = (n: number, t: number, m: number, _timetable: string[]) => {
  let current_time = getChangedTime(new Date(0), 60 * 9);
  let timetable: Date[] = _timetable
    .map(e => {
      const HHMM = e.split(":");
      const depart_time = getChangedTime(
        new Date(0),
        parseInt(HHMM[0], 10) * 60 + parseInt(HHMM[1], 10)
      );
      return depart_time;
    })
    .sort((d1, d2) => d2.getTime() - d1.getTime());

  console.log("---------------------------");
  console.log("n: " + n, ", m: " + m, ", t: " + t);
  console.log(
    "timetable: \n\t[" +
      timetable.map(x =>
        [clock(x.getHours() - basetime.getHours()), clock(x.getMinutes())].join(
          ":"
        )
      ) +
      "]"
  );
  console.log("---------------------------\n");

  const recur = n => {
    console.log(
      "# n: " +
        n +
        ", current_time: " +
        clock(current_time.getHours() - basetime.getHours()) +
        ":" +
        clock(current_time.getMinutes())
    );
    // 정류장에 도착한 인원
    let arrived_crew = timetable.filter(
      x => x.getTime() <= current_time.getTime()
    );
    console.log("  crew " + arrived_crew.length + " arrived ");
    console.log(
      "\t[" +
        arrived_crew.map(x =>
          [
            clock(x.getHours() - basetime.getHours()),
            clock(x.getMinutes())
          ].join(":")
        ) +
        "]"
    );

    // n == 0이면 m(탑승인원) - 1번째 크루의 도착시간
    if (n == 0) {
      if (arrived_crew.length <= m - 1) {
        return current_time;
      } else {
        return getChangedTime(
          arrived_crew[arrived_crew.length - 1 - (m - 1)],
          -1
        );
      }
    }

    // n > 0이면 m(탑승인원)만큼 크루에서 제거하고 recur(--n);
    if (n > 0) {
      for (let i = 0; i < Math.min(arrived_crew.length, m); i++) {
        timetable.pop();
      }
      current_time = getChangedTime(current_time, t);
      return recur(--n);
    }
  }; // recur

  let ret = recur(--n);
  return (
    clock(ret.getHours() - basetime.getHours()) + ":" + clock(ret.getMinutes())
  );
}; // solution

let answer = (<any>solution)(...parser(sample[5]));
console.log(answer);
//let sample2 = [
//{
//n: 1,
//t: 1,
//m: 5,
//timetable: ["08:00", "08:01", "08:02", "08:03"]
//},
//{
//n: 2,
//t: 10,
//m: 2,
//timetable: ["09:10", "09:09", "08:00"]
//},
//{
//n: 2,
//t: 1,
//m: 2,
//timetable: ["09:00", "09:00", "09:00", "09:00"]
//},
//{
//n: 1,
//t: 1,
//m: 5,
//timetable: ["00:01", "00:01", "00:01", "00:01", "00:01"]
//},
//{
//n: 1,
//t: 1,
//m: 1,
//timetable: ["23:59"]
//},
//{
//n: 10,
//t: 60,
//m: 45,
//timetable: [
//"23:59",
//"23:59",
//"23:59",
//"23:59",
//"23:59",
//"23:59",
//"23:59",
//"23:59",
//"23:59",
//"23:59",
//"23:59",
//"23:59",
//"23:59",
//"23:59",
//"23:59",
//"23:59"
//]
//}
//];
