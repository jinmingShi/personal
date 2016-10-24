(function() {
angular.module("data")
.component("categories", {
	templateUrl: "templates/categories_component.html",
	bindings: {
		menu: "<"
	}
});
})();