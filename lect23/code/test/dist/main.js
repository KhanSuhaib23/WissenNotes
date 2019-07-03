/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, { enumerable: true, get: getter });
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 			Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 		}
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// create a fake namespace object
/******/ 	// mode & 1: value is a module id, require it
/******/ 	// mode & 2: merge all properties of value into the ns
/******/ 	// mode & 4: return value when already ns object
/******/ 	// mode & 8|1: behave like require
/******/ 	__webpack_require__.t = function(value, mode) {
/******/ 		if(mode & 1) value = __webpack_require__(value);
/******/ 		if(mode & 8) return value;
/******/ 		if((mode & 4) && typeof value === 'object' && value && value.__esModule) return value;
/******/ 		var ns = Object.create(null);
/******/ 		__webpack_require__.r(ns);
/******/ 		Object.defineProperty(ns, 'default', { enumerable: true, value: value });
/******/ 		if(mode & 2 && typeof value != 'string') for(var key in value) __webpack_require__.d(ns, key, function(key) { return value[key]; }.bind(null, key));
/******/ 		return ns;
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = "./src/index.js");
/******/ })
/************************************************************************/
/******/ ({

/***/ "./src/commonJS/index.js":
/*!*******************************!*\
  !*** ./src/commonJS/index.js ***!
  \*******************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

eval("\r\nlet util = __webpack_require__(/*! ./util */ \"./src/commonJS/util.js\");\r\n\r\nmodule.exports.commonCalc = function(n1, n2, c) {\r\n    if (c === 0) {\r\n        return util.commonAdd(n1,n2);\r\n    }\r\n    if (c === 1) {\r\n        return util.commonSub(n1,n2);\r\n    }\r\n    if (c === 2) {\r\n        return util.commonMul(n1,n2);\r\n    }\r\n    if (c === 3) {\r\n        return util.commonDiv(n1,n2);\r\n    }\r\n}\n\n//# sourceURL=webpack:///./src/commonJS/index.js?");

/***/ }),

/***/ "./src/commonJS/util.js":
/*!******************************!*\
  !*** ./src/commonJS/util.js ***!
  \******************************/
/*! no static exports found */
/***/ (function(module, exports) {

eval("commonAdd = function(n1, n2) {\r\n    return n1 + n2;\r\n}\r\n\r\ncommonSub = function(n1, n2) {\r\n    return n1 - n2;\r\n}\r\n\r\ncommonMul = function(n1, n2) {\r\n    return n1 * n2;\r\n}\r\n\r\ncommonDiv = function(n1, n2) {\r\n    return n1 / n2;\r\n}\r\n\r\nmodule.exports = {commonAdd, commonSub, commonMul, commonDiv};\n\n//# sourceURL=webpack:///./src/commonJS/util.js?");

/***/ }),

/***/ "./src/es6JS/index.js":
/*!****************************!*\
  !*** ./src/es6JS/index.js ***!
  \****************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _util__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./util */ \"./src/es6JS/util.js\");\n\r\n\r\ncommonCalc = function(n1, n2, c) {\r\n    if (c === 0) {\r\n        return _util__WEBPACK_IMPORTED_MODULE_0__[\"commonAdd\"](n1,n2);\r\n    }\r\n    if (c === 1) {\r\n        return _util__WEBPACK_IMPORTED_MODULE_0__[\"commonSub\"](n1,n2);\r\n    }\r\n    if (c === 2) {\r\n        return _util__WEBPACK_IMPORTED_MODULE_0__[\"commonMul\"](n1,n2);\r\n    }\r\n    if (c === 3) {\r\n        return _util__WEBPACK_IMPORTED_MODULE_0__[\"commonDiv\"](n1,n2);\r\n    }\r\n}\r\n\r\n/* harmony default export */ __webpack_exports__[\"default\"] = (commonCalc);\n\n//# sourceURL=webpack:///./src/es6JS/index.js?");

/***/ }),

/***/ "./src/es6JS/util.js":
/*!***************************!*\
  !*** ./src/es6JS/util.js ***!
  \***************************/
/*! exports provided: commonAdd, commonSub, commonMul, commonDiv */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"commonAdd\", function() { return commonAdd; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"commonSub\", function() { return commonSub; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"commonMul\", function() { return commonMul; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"commonDiv\", function() { return commonDiv; });\nlet commonAdd = function (n1, n2) {\r\n    return n1 + n2;\r\n}\r\n\r\nlet commonSub = function (n1, n2) {\r\n    return n1 - n2;\r\n}\r\n\r\nlet commonMul = function (n1, n2) {\r\n    return n1 * n2;\r\n}\r\n\r\nlet commonDiv = function (n1, n2) {\r\n    return n1 / n2;\r\n}\r\n\r\n\r\n\n\n//# sourceURL=webpack:///./src/es6JS/util.js?");

/***/ }),

/***/ "./src/index.js":
/*!**********************!*\
  !*** ./src/index.js ***!
  \**********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _es6JS__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./es6JS */ \"./src/es6JS/index.js\");\n\r\n\r\nlet common = __webpack_require__(/*! ./commonJS */ \"./src/commonJS/index.js\")\r\n\r\nlet res1 = common.commonCalc(5, 2, 3);\r\n\r\nconsole.log(`common.commonCalc(5, 2, 3) = ${res1}`);\r\n\r\n\r\n\r\nlet res2 = _es6JS__WEBPACK_IMPORTED_MODULE_0__[\"default\"].commonCalc(6, 3, 1);\r\n\r\nconsole.log(`es6.commonCalc(6, 3, 1) = ${res2}`);\r\n\r\n// let lodash = require('lodas')\n\n//# sourceURL=webpack:///./src/index.js?");

/***/ })

/******/ });