angular.module('pdv').service('userService', userService);
userService.$inject = ['$http', 'BACKEND_CFG'];

function userService ($http, BACKEND_CFG) {
	var service = this;
	
	/**
	 *  Insert user into database
	 */
	service.signUp = function (user, callback) {		 
		$http.post(BACKEND_CFG.url + 'api/user/signUp', user)      		
        .success(function (response) {
        	callback(response);
        }).error (function (error) {
      		console.log('Error: ' + error.details.message);
        });
	};
      
	
	/**
	 *  Validate user login
	 */
	service.signIn = function (user, callback) {
		$http.post(BACKEND_CFG.url + 'api/user/signIn', user)
		.success(function (response) {
			callback(response);
      	}).error (function (error) {
      		console.log('Error: ' + error.details.message);
      	});
    };        
 
    return service;      
};