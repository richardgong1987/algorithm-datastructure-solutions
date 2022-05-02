function exactOneDiff(a, b) {
    let diff = 0;
    for (let i = 0; i < a.length; i++) {
        if (a.charAt(i) !== b.charAt(i)) {
            diff++;
        }
    }
    return diff === 1;
}

function solution(strArr) {
    let matches = [strArr.shift()];

    while (strArr.length) {
        let first = matches[0];
        let last = matches[matches.length - 1];

        let lenOfTries = strArr.length;
        for (let t = 0; t < lenOfTries; t++) {
            let actual = strArr.shift();
            if (exactOneDiff(first, actual)) {
                matches.unshift(actual);
                break;
            } else if (exactOneDiff(last, actual)) {
                matches.push(actual);
                break;
            } else {
                strArr.push(actual);
            }
        }

        if (lenOfTries === strArr.length) {
            return false;
        }
    }

    return true;
}

let strArr = [];
let matches = ["bef", "bec", "bcc", "bdc", "bbc", "abc"];
console.log(solution(rest));