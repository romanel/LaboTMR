/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//déclaration du module
// var bureauServices = angular.module('bureau', ['ngRoute','ngResource']);



angular.module('monApp', ['ngRoute', 'ngResource']);

angular.module('monApp').config(['$routeProvider', function routeConfig($routeProvider) {
        $routeProvider
                .when('/', {
                    controller: "ConnexionControlleur as ctrl",
                    templateUrl: 'connexion.html'
                })
                .when('/demandeActe', {
                    controller: "ActeNewControlleur as ctrl",
                    templateUrl: 'demandeActe.html'
                })
                .when('/accueil', {
                    templateUrl: 'accueil.html'
                })
                .when('/accueilService', {
                    templateUrl: 'accueilService.html'
                })
                .when('/actelabo/uf/:unite_fonctionnel', {
                    controller: "ListeActeLaboServiceControlleur as ctrl",
                    templateUrl: 'listeActeLaboService.html'
                })
                .when('/listeActeLabo', {
                    controller: "ListActeLaboControlleur as ctrl",
                    templateUrl: 'listeActeLabo.html'
                })
                .when('/listeDemande', {
                    controller: "ListeDemandeControlleur as ctrl",
                    templateUrl: 'listeDemande.html'
                })
                .when('/editResultat/:id', {
                    controller: "ResultatNewControlleur as ctrl",
                    templateUrl: 'editResultat.html'
                })
                .when('/afficherActe/:id', {
                    controller: "AfficherActeControlleur as ctrl",
                    templateUrl: 'afficherActe.html'
                })
                .when('/editActe/:id', {
                    controller: "EditActeControlleur as ctrl",
                    templateUrl: 'editActe.html'
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
