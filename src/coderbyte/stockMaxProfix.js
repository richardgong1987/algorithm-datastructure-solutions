// https://coderbyte.com/algorithm/stock-maximum-profit

function ArrayChallenge(arr) {

    var maxProfit = -1;
    var buyPrice = 0;
    var change = true;

    for (var i = 0; i < arr.length - 1; i++) {
        let sellPrice = arr[i + 1];
        if (change) {
            buyPrice = arr[i];
        }
        change = sellPrice < buyPrice;
        if (change === false) {
            maxProfit = Math.max(sellPrice - buyPrice, maxProfit);
        }
    }

    return maxProfit;

}

console.log(ArrayChallenge([10, 12, 4, 5, 9]))
