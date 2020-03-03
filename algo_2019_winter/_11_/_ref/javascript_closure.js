function createCounter(initValue) {
    var count = initValue;
    var map = new Map();
    map.set('val', () => console.log(count));
    map.set('inc', () => console.log(count++));
    return map;
}

v = createCounter(42);
v.get('val')();
v.get('inc')();
v.get('val')();
