angular.module('pdv').service('pdvService', pdvService);
pdvService.$inject = ['$http', 'BACKEND_CFG'];

function pdvService ($http, BACKEND_CFG) {
	var service = this;
	
	/**
	 *  List all pdvs from database
	 */
	service.list = function (callback) {
	   	$http.get(BACKEND_CFG.url + 'api/pdv/list')
	   	.success(function (response) {
	   		callback(response);
	   	}).error (function (error) {
      		console.log('Error: ' + error.details.message);
	    });
	};
	
	/**
	 *  Insert pdv into database
	 */
	service.save = function (pdv, callback) {		 
		$http.post(BACKEND_CFG.url + 'api/pdv/save', pdv)      		
        .success(function (response) {
        	callback(response);
        }).error (function (error) {
      		console.log('Error: ' + error.details.message);
        });
	};
	
	/**
	 *  Delete pdv from database from a custom Id
	 */
	service.del = function (cdPdv, callback) {		 
		$http.delete(BACKEND_CFG.url + 'api/pdv/delete/' + cdPdv)      		
        .success(function (response) {
        	callback(response);
        }).error (function (error) {
      		console.log('Error: ' + error.details.message);
        });
	};
	
    return service;     
};