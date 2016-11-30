# project
###some projects help me understand some concepts about JS and AngularJS 

***

1. Angular fold contains a [BookStore](https://jinmingshi.github.io/project/angular%20demo/BookStore/#/index) using service, directives, ui-router library etc...
###Features:
   - Implemented Login Form and Signup Form
   - Implemented nested views using ui-router
   - Used ng-grid to implement dynamic grids
   - Implemented add button to input new book  
    RouteConfig.$inject = ["$stateProvider", "$urlRouterProvider"];
    function RouteConfig($stateProvider, $urlRouterProvider) {
      $urlRouterProvider.otherwise('/index');
    //configure the default route which is the state
    //configure nested views in same page and load the template respectively
   $stateProvider
    .state('index', {
        url: '/index',
        views: {
            '': {
                templateUrl: 'tpls/home.html'
            },
            'main@index': {
                templateUrl: 'tpls/loginForm.html'
            }
        }
    })
    .state('booklist', {
        url: '/{bookType:[0-9]{1,4}}',
        views: { 
            '': {
                templateUrl: 'tpls/bookList.html'
            },
            'booktype@booklist': {
                templateUrl: 'tpls/bookType.html'
            },
            'bookgrid@booklist': {
                templateUrl: 'tpls/bookGrid.html'
            }
        }
    })
    .state('addbook', {
        url: '/addbook',
        templateUrl: 'tpls/addBookForm.html'
    })
    .state('bookdetail', {
        //pass parameter in this page.
        url: '/bookdetail/:bookId',
        templateUrl: 'tpls/bookDetail.html'
    })
    .state('signUp', {
        url: '/signUp',
        templateUrl: 'tpls/signUp.html'
    })
}
2. Some module folds such as [module 3](https://jinmingshi.github.io/project/angular%20demo/modules/assignment3/index.html) uses $http, directives implementing singleton.    
   
3. [restaurant ](https://jinmingshi.github.io/project/restaurant/index.html) is a simple HTML5 and BootStrap3 application. Implemented drop-down menu, nav-bar, reservation and feedback form. 
