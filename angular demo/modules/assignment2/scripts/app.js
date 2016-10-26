(function() {
	"use strict";
	angular.module("app", [])
	.controller("ToBuyController", ToBuyController)
	.controller("AlreadyBoughtController", AlreadyBoughtController)
	.service("ShoppingListCheckOffService", ShoppingListCheckOffService);

	ToBuyController.$inject = ["ShoppingListCheckOffService"];
	AlreadyBoughtController.$inject = ["ShoppingListCheckOffService"];
	
	function AlreadyBoughtController(ShoppingListCheckOffService) {
		var boughtCtrl = this;

		boughtCtrl.items = ShoppingListCheckOffService.getboughtitems();

	}

	function ToBuyController(ShoppingListCheckOffService) {
		var tobuyCtrl = this;

		tobuyCtrl.items = ShoppingListCheckOffService.tobuyitem();

		tobuyCtrl.bought = function(name, quantity, index) {
			ShoppingListCheckOffService.bought(name, quantity, index);
		};
	}

	function ShoppingListCheckOffService() {
		var service = this;

		var tobuyarray = [{name: "cookie", quantity: "1 bags"}, 
						  {name: "cookie", quantity: "2 bags"}, 
						  {name: "cookie", quantity: "3 bags"}, 
						  {name: "cookie", quantity: "4 bags"},
						  {name: "cookie", quantity: "5 bags"}];

		var alreadyboughtarray = [];

		service.tobuyitem = function() {
			return tobuyarray;
		};

		service.bought = function(_name, _quantity, _index) {
			var item = {
				name: _name,
				quantity: _quantity
			}
			alreadyboughtarray.push(item);
			tobuyarray.splice(_index, 1);
		};

		service.getboughtitems = function() {
			return alreadyboughtarray;
		};
	}
})();