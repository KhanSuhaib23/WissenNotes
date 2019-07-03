

let common = require('./commonJS')
import es6Calc from './es6JS'

let _ = require('lodash')

import 'bootstrap/dist/css/bootstrap.css'

let res1 = common.commonCalc(5, 2, 3);

console.log(`common.commonCalc(5, 2, 3) = ${res1}`);


let res2 = es6Calc(6, 3, 1);

console.log(`es6Calc(6, 3, 1) = ${res2}`);

let diff = _.difference([1, 2, 3, 4, 5], [2, 3, 6, 4])

console.log(diff)