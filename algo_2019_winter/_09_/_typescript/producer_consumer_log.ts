let data: number[][] = [
  [0, 3],
  [2, 6],
  [1, 9],
  [100, 5]
];
interface Job {
  call: number;
  exec: number;
}
const WorkerThread = class {
  backlog: Job[] = new Array<Job>();
  que: Job[] = new Array<Job>();
  total_jobs: number = 0;
  start_time: number = 0;
  current_time: number = 0;
  response_time: number = 0;
  total_response_time: number = 0;

  constructor(data: number[][], start_time: number) {
    data.forEach(e =>
      this.backlog.push({
        call: e[0],
        exec: e[1]
      })
    );
    this.total_jobs = data.length;
  }
  *fetch() {
    [...Array(3).keys()].forEach(x => console.log(""));
    while (true) {
      if (!this.que.length && !this.backlog.length) {
        yield this.total_response_time / this.total_jobs;
        return;
      }
      console.log("\n◻︎◻︎◻︎◻︎◻︎ worker on ◻︎◻︎◻︎◻︎◻︎");
      console.log("\n-- 미 완료 작업 목록 --");
      console.log(this.backlog);

      var remove: number[] = new Array<number>();
      for (let i = this.backlog.length - 1; i > -1; i--) {
        if (this.backlog[i].call <= this.current_time) {
          this.que.push(this.backlog[i]);
          this.backlog.splice(i, 1);
        }
      }

      console.log("\n-- 대기열 / 실행시간 기준으로 정렬 전--");
      console.log(this.que);

      if (this.que.length > 1) {
        this.que = this.que.sort((pre, ante) => pre.exec - ante.exec);
      }

      console.log("\n-- 대기열/ 실행시간 기준으로 정렬 후--");
      console.log(this.que);

      if (this.que.length == 0 && this.backlog.length != 0) {
        let job = this.backlog.pop();
        this.current_time = job.call;
        this.que.push(job);
      }

      if (this.que.length) {
        this.start_time = this.current_time;

        console.log("\n----------------");
        console.log("start-time: " + this.start_time);
        console.log("call-time: " + this.que[0].call);
        console.log("exec-time: " + this.que[0].exec);
        console.log(
          "finish-time: " +
            (this.current_time = this.start_time + this.que[0].exec)
        );
        console.log(
          "response-time: " +
            (this.response_time = this.current_time - this.que[0].call)
        );
        this.total_response_time += this.response_time;
        console.log("==================");
        console.log("total-response-time: " + this.total_response_time);
        this.que.shift();
        yield this.current_time / this.total_jobs;
      } else {
        this.start_time = this.current_time;
        console.log("\n----------------");
        console.log("start-time: " + this.start_time);
        console.log("call-time: " + this.que[0].call);
        console.log(
          "finish-time: " +
            (this.current_time = this.start_time + this.que[0].exec)
        );
        console.log(
          "response-time: " +
            (this.response_time = this.current_time - this.que[0].call)
        );
        this.total_response_time += this.response_time;
        console.log("==================");
        console.log("total-response-time: " + this.total_response_time);
        this.backlog.shift();
        yield this.current_time / this.total_jobs;
      }
    }
  }
  toString = () => {
    return `----------------\nresponse_time: ${this.total_response_time}\ncurrent time: ${this.current_time}\n`;
  };
};

function solution(data) {
  const worker = new WorkerThread(data, 0);
  let answer: number = 0;
  for (let s of worker.fetch()) {
    for (let i = 0; i < 3; i++) {
      console.log("");
    }
    answer = s;
  }
  return Math.floor(answer);
}

console.log(solution(data));
