const foo = (x:string, y:string) => { 
  console.log(x,y);
 }

const foo2 = (...x: string[]) => { 
  console.log(x[0]);
  console.log(x[1]);
 }
 let args:string[] = "a/b".split('/');
 
 foo2(...args);
 (<any> foo)(...args);