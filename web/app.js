/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//déclaration du module
 // var bureauServices = angular.module('bureau', ['ngRoute','ngResource']);



angular.module('monApp', ['ngRoute','ngResource']);

angular.module('monApp').config(['$routeProvider', function routeConfig($routeProvider) {
    $routeProvider
     .when('/', {
        controller: "ActeNewControlleur as ctrl",
        templateUrl: 'demandeActe.html'    
    })
     .when('/listeDemande', {
        controller: "ListeDemandeControlleur as ctrl",
        templateUrl: 'listeDemande.html'    
    })
    .when('/editResultat/:id', {
    controller: "ResultatNewControlleur as ctrl",
    templateUrl: 'editResultat.html'    
    })
     .when('/crayon/edit/:id', {
        controller: "CrayonEditController as ctrl",
        templateUrl: 'editCrayon.html'    
    })
     .when('/crayon/new', {
        controller: "CrayonNewController as ctrl",
        templateUrl: 'newCrayon.html'    
    })
    //.otherwise({ redirectTo: '/'});
}]);
