let data: number[][] = [
  //test 1
  //[0, 3],
  //[2, 6],
  //[1, 9],
  //[100, 5]

  //test 2
  //[24, 10],
  //[18, 39],
  //[34, 20],
  //[37, 5],
  //[47, 22],
  //[20, 47],
  //[15, 2],
  //[15, 34],
  //[35, 43],
  //[26, 1]

  //test 3
  //[0, 3],
  //[1, 9],
  //[500, 6]

  //test 4
  //[0, 5],
  //[1, 2],
  //[5, 5]

  //test5
  //[0, 9],
  //[0, 4],
  //[0, 5],
  //[0, 7],
  //[0, 3]

  //test 6
  //[1, 9],
  //[1, 4],
  //[1, 5],
  //[1, 7],
  //[1, 3]

  //test 7
  //[0, 3],
  //[1, 9],
  //[2, 6],
  //[4, 3]

  //test 8
  //[0, 0],
  //[1, 0],
  //[2, 0],
  //[3, 0]

  //test 9
  [0, 10],
  [0, 5],
  [2, 3],
  [2, 7],
  [8, 10],
  [8, 1]
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
    while (true) {
      if (!this.que.length && !this.backlog.length) {
        yield this.total_response_time / this.total_jobs;
        return;
      }

      for (let i = this.backlog.length - 1; i > -1; i--) {
        if (this.backlog[i].call <= this.current_time) {
          this.que.push(this.backlog[i]);
          this.backlog.splice(i, 1);
        }
      }

      if (this.que.length > 1) {
        this.que = this.que.sort((pre, ante) => pre.exec - ante.exec);
      }

      if (this.que.length == 0 && this.backlog.length != 0) {
        let job = this.backlog.pop();
        this.current_time = job.call;
        this.que.push(job);
      }

      if (this.que.length) {
        this.start_time = this.current_time;
        this.current_time = this.start_time + this.que[0].exec;
        this.response_time = this.current_time - this.que[0].call;
        this.total_response_time += this.response_time;
        this.total_response_time;
        this.que.shift();
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
    for (let i = 0; i < 3; i++) {}
    answer = s;
  }
  return Math.floor(answer);
}

console.log(solution(data));
