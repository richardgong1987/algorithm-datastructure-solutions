function solution(firstCube, secondCube) {
    let mod = x => (x % 4 + 4) % 4,
        same = (rubik1, rubik2) =>
            rubik1.every((row, i) => row.every((val, j) => rubik2[i][j] == val))
    function rotateFace(face, dir) {
        let config = dir == 1 ? [2, 0, 3, 1] : [1, 3, 0, 2], mimic = [...face]
        config.map((pos, i) => face[i] = mimic[pos])
    }
    function rotate(rubik, faceIDs, changePos, dir, affectID, rotateType) {
        let result = rubik.map(_ => [..._]),
            rotated = faceIDs.map((id, i) => changePos[i].map(pos => rubik[id][pos]))
        rotated.map((data, i) => {
            let face = result[faceIDs[i]]
            changePos[i].map((pos, k) => face[pos] = rotated[mod(i + dir)][k])
        })
        rotateFace(result[affectID], rotateType)
        return result
    }
    function generate(rubik) {
        let all = [], configuration = [
            [[4, 2, 5, 3],
                [new Array(4).fill([0, 1]), new Array(4).fill([2, 3])],
                [0, 1], [1, -1]], //[faceID, multiplier]
            [[4, 0, 5, 1], [
                [[2, 0], [2, 0], [1, 3], [1, 3]], [[3, 1], [3, 1], [0, 2], [0, 2]]],
                [3, 2], [1, -1]],
            [[0, 2, 1, 3],[
                [[2, 3], [0, 2], [2, 3], [3, 1]], [[0, 1], [1, 3],[0, 1], [2, 0]] ],
                [4, 5], [-1, 1]]
        ], directions = [1, -1]
        directions.map(dir => {
            configuration.map(([faceIDs, changes, affectFaces, multi]) => {
                changes.map((changePos, i) =>
                    all.push(
                        rotate(rubik, faceIDs, changePos, dir, affectFaces[i], dir*multi[i])))
            })
        })
        return all
    }
    function move(data) {
        for(let i = 1;i < 3;i++) {
            data[i] = []
            data[i - 1].map(rubik => data[i] = data[i].concat(generate(rubik)))
        }
    }
    let firstMoves = [[firstCube]],
        secondMoves = [[secondCube]]
    move(firstMoves)
    move(secondMoves)
    let result = 3
    for(let i = 0;i < 3;i++) {
        for(let j = 0;j < 3;j++)
            for(let m of firstMoves[i]) {
                for(let n of secondMoves[j]) {
                    if(same(m, n)) result = Math.min(result, Math.max(i, j))
                }
            }
    }
    return result == 3 ? -1 : result
}
