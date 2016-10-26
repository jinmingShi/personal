(function() {
angular.module("MenuApp")
.config(RoutesConfig);

RoutesConfig.$inject = ['$stateProvider', '$urlRouterProvider'];
function RoutesConfig($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise("/");
	$stateProvider
	.state("home", {
		url: "/",
		templateUrl: "templates/home.html"
	})
	.state("categories", {
		url: "/categories",
		templateUrl: "templates/categories.html",
		controller: "categoriesController as cs",
		resolve: {
			menu: ["MenuDataService", function(MenuDataService) {
				return MenuDataService.getAllCategories();
			}]
		}
	})
	.state("categories.items", {
		url: "/category/{categoryShortName}",
		templateUrl: "templates/category.html",
		controller: "categoryController as childCtrl",
		resolve: {
			items: ["MenuDataService", "$stateParams",
			       function(MenuDataService, $stateParams) {
				return MenuDataService.getItemsForCategory($stateParams.categoryShortName);
			}]
		}
	});
}
})();