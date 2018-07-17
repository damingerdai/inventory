(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["gift-gift-module"],{

/***/ "./src/app/modal/response.ts":
/*!***********************************!*\
  !*** ./src/app/modal/response.ts ***!
  \***********************************/
/*! exports provided: CommonResponse, ErrorResponse, DataResponse, ListResponse, PageResponse */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CommonResponse", function() { return CommonResponse; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ErrorResponse", function() { return ErrorResponse; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DataResponse", function() { return DataResponse; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ListResponse", function() { return ListResponse; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PageResponse", function() { return PageResponse; });
var __extends = (undefined && undefined.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var CommonResponse = /** @class */ (function () {
    function CommonResponse() {
    }
    return CommonResponse;
}());

var ErrorResponse = /** @class */ (function (_super) {
    __extends(ErrorResponse, _super);
    function ErrorResponse() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return ErrorResponse;
}(CommonResponse));

var DataResponse = /** @class */ (function (_super) {
    __extends(DataResponse, _super);
    function DataResponse() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return DataResponse;
}(CommonResponse));

var ListResponse = /** @class */ (function (_super) {
    __extends(ListResponse, _super);
    function ListResponse() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return ListResponse;
}(CommonResponse));

var PageResponse = /** @class */ (function (_super) {
    __extends(PageResponse, _super);
    function PageResponse() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return PageResponse;
}(ListResponse));



/***/ }),

/***/ "./src/app/routes/gift/gift.module.ts":
/*!********************************************!*\
  !*** ./src/app/routes/gift/gift.module.ts ***!
  \********************************************/
/*! exports provided: GiftModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GiftModule", function() { return GiftModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _list_gift_list_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./list/gift.list.component */ "./src/app/routes/gift/list/gift.list.component.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/fesm5/common.js");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};




var routes = [
    { path: '', component: _list_gift_list_component__WEBPACK_IMPORTED_MODULE_2__["GiftListComponent"] },
];
var GiftModule = /** @class */ (function () {
    function GiftModule() {
    }
    GiftModule = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"])({
            imports: [
                _angular_common__WEBPACK_IMPORTED_MODULE_3__["CommonModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forChild(routes)
            ],
            declarations: [
                _list_gift_list_component__WEBPACK_IMPORTED_MODULE_2__["GiftListComponent"]
            ],
            exports: [
                _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]
            ]
        })
    ], GiftModule);
    return GiftModule;
}());



/***/ }),

/***/ "./src/app/routes/gift/list/gift.list.component.css":
/*!**********************************************************!*\
  !*** ./src/app/routes/gift/list/gift.list.component.css ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/routes/gift/list/gift.list.component.html":
/*!***********************************************************!*\
  !*** ./src/app/routes/gift/list/gift.list.component.html ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\r\n    <div class=\"clearfix\"></div>\r\n    <div class=\"col-12\">\r\n        <div class=\"card\">\r\n            <div class=\"card-header\">\r\n                礼品列表\r\n            </div>\r\n            <div class=\"card-body\">\r\n                <div class=\"card\">\r\n                    <div class=\"card-body\">\r\n                        <div class=\"table-responsive\">\r\n                            <table class=\"table table-striped table-bordered table-hover\">\r\n                                <thead>\r\n                                    <tr>\r\n                                        <th scope=\"col\">#</th>\r\n                                        <th scope=\"col\">礼品编码</th>\r\n                                        <th scope=\"col\">礼品名字</th>\r\n                                        <th scope=\"col\">礼品数量</th>\r\n                                        <th scope=\"col\">操作</th>\r\n                                    </tr>\r\n                                </thead>\r\n                                <tbody>\r\n                                    <tr *ngFor=\"let gift of gifts; let num = index\">\r\n                                        <th scope=\"col\">{{ num + 1}}</th>\r\n                                        <th scope=\"col\">{{ gift.code }}</th>\r\n                                        <th scope=\"col\">{{ gift.name }}</th>\r\n                                        <th scope=\"col\">{{ gift.num }}</th>\r\n                                        <th scope=\"col\">操作</th>\r\n                                    </tr>\r\n                                </tbody>\r\n                            </table>\r\n                        </div>\r\n\r\n                    </div>\r\n                </div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n</div>"

/***/ }),

/***/ "./src/app/routes/gift/list/gift.list.component.ts":
/*!*********************************************************!*\
  !*** ./src/app/routes/gift/list/gift.list.component.ts ***!
  \*********************************************************/
/*! exports provided: GiftListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GiftListComponent", function() { return GiftListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _modal_response__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../modal/response */ "./src/app/modal/response.ts");
var __decorate = (undefined && undefined.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (undefined && undefined.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var GiftListComponent = /** @class */ (function () {
    function GiftListComponent(http) {
        this.http = http;
        this.page = {
            pageNo: 1,
            pageSize: 5,
        };
    }
    GiftListComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.http.get('/api/v1/gift', { params: {
                name: this.name || '',
                pageNo: this.page.pageNo + '' || '1',
                pageSize: this.page.pageSize + '' || '5',
            } }).subscribe(function (res) {
            if (res instanceof _modal_response__WEBPACK_IMPORTED_MODULE_2__["ErrorResponse"]) {
                alert(res.error.message);
            }
            else {
                _this.gifts = res.data;
                _this.pageInfo = res.pageInfo;
            }
        });
    };
    GiftListComponent = __decorate([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"])({
            selector: 'app-gift-list',
            template: __webpack_require__(/*! ./gift.list.component.html */ "./src/app/routes/gift/list/gift.list.component.html"),
            styles: [__webpack_require__(/*! ./gift.list.component.css */ "./src/app/routes/gift/list/gift.list.component.css")]
        }),
        __metadata("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]])
    ], GiftListComponent);
    return GiftListComponent;
}());



/***/ })

}]);
//# sourceMappingURL=gift-gift-module.js.map