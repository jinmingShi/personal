(function() {
	angular.module("LunchCheckApp", [])
	.controller("LunchCheckCtrl", LunchCheckCtrl);

	LunchCheckCtrl.$inject = ['$scope'];

	function LunchCheckCtrl($scope) {
		$scope.message = "";

		$scope.lunchcheck = function() {
			$scope.message2 = "";
			$scope.message1 = "";
			if($scope.lunchlist === undefined || $scope.lunchlist.length == 0 ) {
				// $scope.message1 = "";
				$scope.message2 = "Please enter data first";
			} else {
				var arraylist = $scope.lunchlist.split(/\s*,\s*/).sort();
				while(arraylist[0].length == 0) {
					arraylist.shift();
				}
				var num = arraylist.length;
				console.log(arraylist);
				if(num < 3) {
					$scope.message1 = "Enjoy!";
				} else {
					$scope.message1 = "Too much!";
				}
			}
		};
	}
})();
	