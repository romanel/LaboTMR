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


// Code Nicolas Singer 

angular.module('monApp').controller('CrayonsController', [ 'Crayons',
    function (Crayons) {
        this.crayons = Crayons.query();
        this.delete = function (cr) {
            // appel DELETE asynchrone au service web sur /crayons/{id}
            //cr.$delete();
            Crayons.delete(cr);
            // remet à jour le tableau des crayons en suprimant l'élément effacé
            this.crayons.splice(this.crayons.indexOf(cr), 1);
        };
    }
])

.controller('CrayonNewController', [ 'Crayons',
   function(Crayons) {
    this.cr = new Crayons();
    this.update = function() { 
        // appel POST asynchrone au service web sur /crayons
       this.cr.$save();
   };
}])


.controller('CrayonEditController', [ '$routeParams', 'Crayons', '$location',
function($routeParams, Crayons, $location) {
    this.cr = Crayons.get({id: $routeParams.id}); 
    this.update = function() {
        // appel POST asynchrone au service web sur /crayons/{id} 
        this.cr.$save();
        $location.path("/")
    };
}
]);
