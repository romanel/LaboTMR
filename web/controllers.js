/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function bureauRouteConfig($routeProvider) {
    $routeProvider
     .when('/', {
        controller: demandeActeController,
        templateUrl: 'demandeActe.html'    
    })
    .otherwise({ redirectTo: '/'});
}

angular.module('bureau').config(bureauRouteConfig);



function CrayonsController($scope, Crayons) {
   $scope.crayons = Crayons.query();
   // -> ligne pour obtenir le crayon d'identifiant 19 :  console.dir(Crayons.get({id:19}));
}

function demandeActeController($scope, ActeLabo) {
   $scope.actelabo = ActeLabo.query();
   // -> ligne pour obtenir le crayon d'identifiant 19 :  console.dir(Crayons.get({id:19}));
}
