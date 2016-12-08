angular.module('pdv').controller('UserController', UserController);
UserController.$inject = ['$scope', '$location', 'userService'];

function UserController($scope, $location, userService) {
    $scope.message = ''; 
    $scope.user = {}; 

    $scope.signUp = function () {
    	userService.signUp($scope.user, function (response) {
    		$scope.message = response.result;
    	});
    };
    
    $scope.signIn = function () {
    	userService.signIn($scope.user, function (response) {    		
    		if (response.code == 2001) {
    			$scope.message = response.result;
    			return;
    		}
			$scope.message = response.result;
    		$location.path('/list'); 
    	});
    }; 
};