function SearchingChallenge(strArr) {
    let ret = [];
    let indexs = [];
    let subStr = [];
    for (const element of strArr) {
        subStr = element.split("");
        let index = [];
        for (let y = 0; y < subStr.length; y++) {
            if (subStr[y] == 0) {
                index.push(y);
            }
            if (y == subStr.length - 1) {
                indexs.push(index);
            }
        }
    }
    for (let i = 0; i < indexs.length; i++) {
        for (let j = 0; j < indexs[i].length; j++) {
            if (indexs[i + 1] && (indexs[i][j] === indexs[i + 1][j] || indexs[i + 1].indexOf(indexs[i][j]))) {
                if (ret.indexOf(strArr[i]) === -1) {
                    ret.push(strArr[i]);
                }
            }

            if (Math.abs(indexs[i][j] - indexs[i][j + 1]) === 1) {
                if (ret.indexOf(strArr[i]) === -1) {
                    ret.push(strArr[i])
                }
            }
        }
    }

    return ret.length;
}

// keep this function call here
console.log(SearchingChallenge(["1011", "0010"]));
