/**
 * book list implementation
 * @type {[type]}
 */
var bookListModule = angular.module("BookListModule", []);

bookListModule.controller('BookListCtrl', function($scope, $http, $state, $stateParams) {
    $scope.filterOptions = {
        filterText: "",
        useExternalFilter: true
    };
    $scope.totalServerItems = 0;
    $scope.pagingOptions = {
        pageSizes: [5, 10, 20],
        pageSize: 5,
        currentPage: 1
    };
    $scope.setPagingData = function(data, page, pageSize) {
        var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
        $scope.books = pagedData;
        $scope.totalServerItems = data.length;
        if (!$scope.$$phase) {
            $scope.$apply();
        }
    };

    //loading different datas according to different bookType
    console.log($stateParams);
    $scope.getPagedDataAsync = function(pageSize, page, searchText) {
        setTimeout(function() {
            var data;
            if (searchText) {
                var ft = searchText.toLowerCase();
                $http.get('data/books' + $stateParams.bookType + '.json')
                    .success(function(largeLoad) {
                        data = largeLoad.filter(function(item) {
                            return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
                        });
                        $scope.setPagingData(data, page, pageSize);
                    });
            } else {
                $http.get('data/books' + $stateParams.bookType + '.json')
                    .success(function(largeLoad) {
                        $scope.setPagingData(largeLoad, page, pageSize);
                    });
            }
        }, 100);
    };

    $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);

    $scope.$watch('pagingOptions', function(newVal, oldVal) {
        if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        }
    }, true);
    $scope.$watch('filterOptions', function(newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        }
    }, true);

    $scope.gridOptions = {
        data: 'books',
        rowTemplate: '<div style="height: 100%"><div ng-style="{ \'cursor\': row.cursor }" ng-repeat="col in renderedColumns" ng-class="col.colIndex()" class="ngCell ">' +
            '<div class="ngVerticalBar" ng-style="{height: rowHeight}" ng-class="{ ngVerticalBarVisible: !$last }"> </div>' +
            '<div ng-cell></div>' +
            '</div></div>',
        multiSelect: false,
        enableCellSelection: true,
        enableRowSelection: false,
        enableCellEdit: true,
        enablePinning: true,
        columnDefs: [{
            field: 'index',
            displayName: 'index',
            width: 60,
            pinnable: false,
            sortable: false
        }, {
            field: 'name',
            displayName: 'title',
            enableCellEdit: true
        }, {
            field: 'author',
            displayName: 'author',
            enableCellEdit: true,
            width: 220
        }, {
            field: 'pubTime',
            displayName: 'pubTime',
            enableCellEdit: true,
            width: 120
        }, {
            field: 'price',
            displayName: 'price',
            enableCellEdit: true,
            width: 120,
            cellFilter: 'currency:"$"'
        }, {
            field: 'bookId',
            displayName: 'operation',
            enableCellEdit: false,
            sortable: false,
            pinnable: false,
            cellTemplate: '<div><a ui-sref="bookdetail({bookId:row.getProperty(col.field)})" id="{{row.getProperty(col.field)}}">details</a></div>'
        }],
        enablePaging: true,
        showFooter: true,
        totalServerItems: 'totalServerItems',
        pagingOptions: $scope.pagingOptions,
        filterOptions: $scope.filterOptions
    };
});


/**
 * 
 * book details
 * @type {[type]}
 */

var bookDetailModule = angular.module("BookDetailModule", []);
bookDetailModule.controller('BookDetailCtrl', function($scope, $http, $state, $stateParams) {
    console.log($stateParams);

    //to be continue: use $http to get data from the end, implement the examples totally.
});

var signUpModule = angular.module("signUpModule", ["ui.router", 'ngGrid']);

signUpModule.controller("signUpCtrl", ["$scope", "$rootScope", "$state", function($scope, $rootScope, $state) {
    $scope.user = {};
    $rootScope.users=[];
    $scope.signUp=function() {
        if($scope.user != null) {
            $rootScope.users.push($scope.user);
            $state.go("index");
        }
    };
}]);

signUpModule.controller("loginCtrl", ["$scope","$state","$rootScope", function($scope, $state, $rootScope) {
    $scope.login=function(bookTypeid) {
        var user=$scope.user;
        if (user) {
            for(var i=0; i<$rootScope.users.length; i++) {
                if (user.name == $rootScope.users[i].name && 
                    user.password == $rootScope.users[i].password) {
                    $state.go("booklist", ({bookType: bookTypeid}));
                }
            }
        } else {
            alert("Please SignUp");
        }
    };
}]);


signUpModule.directive("compare", function() {
    return {
        strict: 'AE',
        scope: {
            orgText: '=compare'
        },
        require: 'ngModel',
        link: function(scope, element, attr, ctrl) {
            ctrl.$validators.compare = function(v) {
                return v == scope.orgText;
            };
            scope.$watch('orgText', function() {
                ctrl.$validate();
            });
        }
    };
});
