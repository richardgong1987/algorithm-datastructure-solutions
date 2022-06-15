/**
 * Have the function SearchingChallenge(strArr) take the array of strings stored in strArr,
 * which will be a 2D matrix of 0 and 1's, and determine how many holes, or contiguous regions of 0's,
 * exist in the matrix. A contiguous region is one where there is a connected group of 0's going in one or more of four directions:
 * up, down, left, or right. For example: if strArr is ["10111", "10101", "11101", "11111"], then this looks like the following matrix:
 */
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
