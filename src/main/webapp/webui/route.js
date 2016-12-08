var pdv = angular.module('pdv');

pdv.config(['$routeProvider', function ($routeProvider){
	  
	$routeProvider.when('/login', {
	        templateUrl: 'webui/view/user/login.html',
	        controller: 'UserController',
		});
	    
	    $routeProvider.when('/user', {
	        templateUrl: 'webui/view/user/user.html',
	        controller: 'UserController',
		});
	    
	    $routeProvider.when('/list', {
            templateUrl: 'webui/view/pdv/pdv-list.html',
            controller: 'PDVController'
    	});
	    
	    $routeProvider.when('/edit/:pdv', {
            templateUrl: 'webui/view/pdv/pdv.html',
            controller: 'PDVController'
    	})
    	
    	 $routeProvider.when('/new', {
            templateUrl: 'webui/view/pdv/pdv.html',
            controller: 'PDVController'
    	})

        .otherwise({ redirectTo: '/login' });
    }
]);
