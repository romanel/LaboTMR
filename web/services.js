/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//global à l'application

// nouveau code NS :
angular.module('monApp').factory('ActeLabo', ['$resource', function ($resource) {

        //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
        return $resource('/LaboTMR/webresources/generic/actelabo/:id', {id: '@id'});

    }]);

angular.module('monApp').factory('ActeLaboSansRes', ['$http', function ($http) {

        return {get: function () {
                return $http.get("/LaboTMR/webresources/generic/actelabo/sansresultat");
            }};

    }]);

angular.module('monApp').factory('ActeLaboAvecRes', ['$http', function ($http) {

        return {get: function () {
                return $http.get("/LaboTMR/webresources/generic/actelabo/avecresultat");
            }};

    }]);


angular.module('monApp').factory('Admissions', ['$resource', function ($resource) {

        //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
        return $resource('/LaboTMR/webresources/generic/admission/:id', {id: '@iep'});

    }]);

angular.module('monApp').factory('Resultat', ['$resource', function ($resource) {

        //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
        return $resource('/LaboTMR/webresources/generic/resultat/:id', {id: '@id'});

    }]);