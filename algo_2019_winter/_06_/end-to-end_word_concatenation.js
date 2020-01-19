const wordsets = [["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"],
         ["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"],
         ["hello", "one", "even", "never", "now", "world", "draw"]];

const nums = [3, 5, 2];

const solution = function(n, words) {
    const go = function(n, words){
        var l = Array.from(Array(n), () => new Array());
        var prev = "";
        for (const [idx, word] of words.entries()) {
            var i = idx % n;
            l[i].push(word);
            if (idx == 0) {
                prev = word;
                continue;
            }
            if (true == (words.slice(0, idx).includes(word))) {
                return [i + 1, l[i].length];
            }
            if (word[0] != prev[prev.length - 1]) {
                return [i + 1, l[i].length];
            }
            prev = word;
        }
    }
    const answer = go(n, words);
    return answer ? answer : [0, 0];
}

console.log(solution(nums[2], wordsets[2]));


// console.log(wordsets[0].slice(0, wordsets[0].length - 1).includes('tank'));