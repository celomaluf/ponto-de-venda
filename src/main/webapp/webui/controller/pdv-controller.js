angular.module('pdv').controller('PDVController', PDVController);
PDVController.$inject = ['$scope', 'pdvService', '$location', '$routeParams'];

function PDVController($scope, pdvService, $location, $routeParams) {
	var pdv = this;
	$scope.message = '';
	$scope.pdv = {};
	$scope.pdvList = [];
	$scope.filter = '';
	
	pdv.list = function () {
		pdvService.list(function (response) {
			$scope.pdvList = response.result;
		});
    };
    
	$scope.save = function () {
		pdvService.save($scope.pdv, function (response) {
			$scope.message = response.result
		});
    };
    
	$scope.del = function (cdPdv) {
		pdvService.del(cdPdv, function (response) {
			$scope.pdv = {};
			$scope.message = response.result
		});
    };

    if ($routeParams.pdv) {
		$scope.pdv = angular.fromJson($routeParams.pdv); 
	}
    
	if ($location.path() !== '/new' && $location.path() !== '/edit' ){ 
		pdv.list();
	}
};