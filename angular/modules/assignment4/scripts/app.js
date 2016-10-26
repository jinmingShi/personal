(function() {
angular.module("MenuApp")
.controller("categoriesController", categoriesController)
.controller("categoryController", categoryController);

categoriesController.$inject = ["menu"];
function categoriesController(menu) {
	// for(var t=0; t<menu.length; t++) {
	// 	console.log(menu[t]);
	// }
	var cateCtrl = this;
	cateCtrl.menu = menu;
	cateCtrl.show = function() {}
}

categoryController.$inject = ["items"];
function categoryController(items) {
	var childCtrl = this;
	childCtrl.items = items;
	console.log(childCtrl.items);
	// childCtrl.name = item.name;
	// childCtrl.id = item.id;
	// childCtrl.description = item.description;
}
})();