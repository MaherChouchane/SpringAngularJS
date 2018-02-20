'use strict'
app.factory('homeService', function($http, CONSTANTS) {
	var service = {};

	service.getAllUsers = function() {
		return $http.get(CONSTANTS.getAllUsers);
	}
	return service;
});