function solution(n, roads, route) {
    let shortest = Array.from({length: n}, _ => []), result = 0
    //Dijstra for every node
    roads.map((_, startVertex) => {
        let min = shortest[startVertex],
            queue = [[startVertex, 0]]
        min[startVertex] = 0
        while (queue.length) {
            const [u, path] = queue.shift()
            for (let [v, w] of roads[u]) {
                const nextPath = path + w
                if (min[v] <= nextPath) continue
                min[v] = nextPath
                queue.push([v, nextPath])
            }
        }
    })
    for (let i = 1; i < route.length; i++) result += shortest[route[i - 1]][route[i]]
    return result
}
