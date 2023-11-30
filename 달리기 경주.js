


function solution(players, callings) {
    var person = {}
    for (let i = 0; i <= players.length - 1; i++) {
        let letter = players[i]
        person[letter] = i;

    }
    for (let j = 0; j <= callings.length - 1; j++) {
        var idx = person[callings[j]]
        person[players[idx - 1]]++
        person[players[idx]]--

        temp = players[idx - 1];
        players[idx - 1] = players[idx];
        players[idx] = temp;


    }
    return players;
}


