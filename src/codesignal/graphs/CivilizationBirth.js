function solution(count, votes) {
    let laws = {}, result = [], satisfied = new Set(), considred = []
    //laws[i][0]: people who reject the law i, laws[i][1]: accept
    for(let i = 1;i <= count;i++) laws[i] = [[], []]

    function getRemainOption(abor, rejectID, status) {
        const sign = status > 0 ? 1 : -1,
            rejectPos = votes[abor].indexOf(sign * rejectID),
            remainID = votes[abor][+!rejectPos]
        return [Math.abs(remainID), +(remainID > 0)]
    }
    //database stores people who involve in the law i
    votes.map((_, i) => _.map(id => laws[Math.abs(id)][+(id > 0)].push(i)))

    //generate (ID: the id of the law, status: whether we should enact the law or not)
    function generate(ID, status) {
        //If we have already decided what we should do with the law ID
        //But now we have to a reverse action => Impossible
        if(result[ID] !== undefined && result[ID] ^ status) return false
        //Ignore if we have considred the law
        if(considred[ID]) return true
        //Store previous information if we the status we are considering is bad
        let OK = true,
            prevConsidred = [...considred],
            prevResult = [...result],
            preSatisfied = new Set([...satisfied])
        result[ID] = status
        considred[ID] = true
        //people who one of their suggestions are accepted
        laws[ID][status].map(_ => satisfied.add(_))
        //people who one of their suggestions are rejected
        //and *they are still NOT Satisfied*
        //=> We MUST satisfy the 1 left suggestion of them
        laws[ID][+!status].map(_ =>
            !satisfied.has(_) ?  OK &= generate(...getRemainOption(_, ID, +!status)) : 0)
        if(OK) return true
        //Reset to previous information if we failed
        result = prevResult, considred = prevConsidred, satisfied = preSatisfied
        // return false
    }
    for(let law = 1;law <=count;law++)
        //Only generate on unconsidered laws
        //First try to enact the law, if we fail then reject the law
        //if we sill fail -> Impossible
        if(!considred[law] && !(generate(law, 1) || generate(law, 0)))
            return Array.from({ length: count}, _ => -1)
    result.shift()
    return result
}