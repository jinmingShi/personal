(function() {
angular.module("data")
.service("MenuDataService", MenuDataService);

MenuDataService.$inject = ["$http"];
function MenuDataService($http) {
	var service = this;
	service.getAllCategories = function() {
		return $http({
				url: "https://davids-restaurant.herokuapp.com/categories.json",
				method: "GET"
	   	   })
		   .then(function(response) {
		   	return response.data;
		   }, function(error) {
		   	console.log("this is an error " + error);
		   });
	}
	service.getItemsForCategory = function(categoryShortName) {
		return $http({
				url: ("https://davids-restaurant.herokuapp.com/menu_items.json?"),
				method: "GET",
				params: {
					category: categoryShortName
				}
	   	   })
		   .then(function(response) {
		   	return response.data.menu_items;
		   }, function(error) {
		   	console.log("this is an error " + error);
		   });
	}
}
})();