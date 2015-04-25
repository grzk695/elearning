var app = angular.module('elearning',[
      'ngRoute',
      'appControllers',
      'pascalprecht.translate'
])

app.config(['$routeProvider',function($routeProvider){
	$routeProvider.
		when('/login',{
			templateUrl: 'resources/partials/login.html',
			controller: 'LoginController'
		})	
}]);

app.run(function($rootScope){
	$rootScope.prefix="/elearning";
})