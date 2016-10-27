/**
 * router configuration.
 * ui-router is injected and replace the original ngRoute
 * because the original ngRoute doesn't support the nested views
 * @param  {[type]} $stateProvider
 * @param  {[type]} $urlRouterProvider
 * @return {[type]}
 */
(function() {
angular.module("routerApp")
.config(RouteConfig)
.run(function($rootScope, $state, $stateParams) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
});

/**
 * As $state and $stateParams will be used in the app, so get its reference in the $rootScope,
 * which will be convenient to be referenced in the whole app.
 * initiate the run once it starts.
 * @param  {[type]} $rootScope
 * @param  {[type]} $state
 * @param  {[type]} $stateParams
 * @return {[type]}
 **/

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

})()
