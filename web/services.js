/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//global à l'application

// nouveau code NS :
angular.module('monApp').factory('ActeLabo', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/LaboTMR/webresources/generic/actelabo/:id', { id : '@id'} );
    
}]);
