var app = angular.module('app', [ 'ngRoute', 'ngResource' ]);

app.config(function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'resources/static/views/home.html',
		controller : 'homeController'
	}).otherwise({
		redirectTo : '/'
	});
});
app.constant("CONSTANTS", {
    getAllUsers: "/users"
})