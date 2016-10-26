(function() {
angular.module("NarrowItDown", [])
.controller("NarrowItDownController", NarrowItDownController)
.service("MenuSearchService", MenuSearchService)
.directive("foundItems", foundItems)
.constant("baseUrl", "https://davids-restaurant.herokuapp.com/menu_items.json");

function foundItems() {
	var ddo = {
		restrict: "AE",
		templateUrl: "templates/items.html",
		scope: {
			items: "<items",
			onremove: "&onRemove",
			isEmpty: "<",
			length: "<",
		}
	};
	return ddo;
}

NarrowItDownController.$inject = ["MenuSearchService"];
function NarrowItDownController(MenuSearchService) {
	var ctrl = this;
	ctrl.found = "";
	ctrl.length = 0;
	ctrl.find = function(input) {
		MenuSearchService.getMatchedMenuItems(input)
		.then(function(response) {
			ctrl.found = response;
			ctrl.length = ctrl.found.length;
		})
		.catch(function(error) {
			ctrl.found="";
			ctrl.length=0;
			//console.log("error happens in controller");
		});
	};
	ctrl.onRemove = function(index) {
		ctrl.found.splice(index, 1);
		ctrl.length = ctrl.found.length;
	}
}

MenuSearchService.$inject = ["$http", "baseUrl", "$q"];
function MenuSearchService($http, baseUrl, $q) {
	var service = this;
	service.getMatchedMenuItems = function(searchTerm) {
		var foundItems = [];
		var deferred = $q.defer();
		if(searchTerm === undefined || searchTerm ==="") {
			// console.log(searchTerm);
			// console.log("error");
			deferred.reject(foundItems);
			return deferred.promise;
		}
		return $http({url: baseUrl, method: "GET"})
		.then(function(response) {
			var menulist = response.data.menu_items;
			var length = menulist.length;
			for(var i = 0; i < length; i++) {
				if (menulist[i].description.toLowerCase().indexOf(searchTerm) !== -1) {
					foundItems.push(menulist[i]);
				}
			}
			return foundItems;
		})
		.catch(function(error) {
			return "error";
		});
	};
}
})();