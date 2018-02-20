'use strict'
app.controller('homeController', function($scope, homeService) {
	$scope.headingTitle = "List of users";
	$scope.users = null;

	$scope.getUsers = function() {

		homeService.getAllUsers().then(function(response) {
			$scope.users = response.data;
		});
	}
	$scope.getUsers();
});