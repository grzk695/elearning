var app = angular.module('elearning',[
      'ngRoute',
      'appControllers',
      'pascalprecht.translate'
])

app.config(['$routeProvider',function($routeProvider){
	$routeProvider.
		when('/',{
			templateUrl: 'resources/partials/index.html',
			controller: 'MainController'
		})
		.when('/login',{
			templateUrl: 'resources/partials/login.html',
			controller: 'LoginController'
		})
		.when('/register',{
			templateUrl: 'resources/partials/register.html',
			controller: 'RegistrationsController'
		})
}]);