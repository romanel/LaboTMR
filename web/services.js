/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//global à l'application
// ancien code
bureauServices.factory('Crayons', ['$resource', function($resource) {
    return $resource('/bureau/webresources/generic/crayons/:id', 
    { id : '@id'}, { charge: {method: 'POST', params: {charge:true}, isArray:false}});
    
}]);

// nouveau code NS :
angular.module('monApp').factory('Crayons', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/crayons/:id', { id : '@id'} );
    
}]);
