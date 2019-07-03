
let util = require('./util');

let commonCalc = function (n1, n2, c) {
    if (c === 0) {
        return util.commonAdd(n1, n2);
    }
    if (c === 1) {
        return util.commonSub(n1, n2);
    }
    if (c === 2) {
        return util.commonMul(n1, n2);
    }
    if (c === 3) {
        return util.commonDiv(n1, n2);
    }
}

module.exports = { commonCalc };