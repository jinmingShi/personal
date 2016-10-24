(function() {
angular.module("data")
.component("items", {
	templateUrl: "templates/items.html",
	bindings: {
		menuitems: "<"
	}
});
})();