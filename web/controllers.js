/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        $location.path("/");
    };
}
])

.controller('ActeNewControlleur', ['ActeLabo','Admissions',
    function (ActeLabo, Admissions){        
        var self = this;        
        this.admissions = Admissions.query();        
        this.actel = new ActeLabo();
        this.update = function() {
            console.log("lklkl");
            self.actel.$save();
        };
    }
]);
//.controller('AdmissionGetAllControlleur', ['$routeParams', 'Admission', '$location',
//    function ($routeParams, Admission, $location){
//        this.adm = Admission.get({iep: $routeParams.iep});
//        this.update = function() {
//            // appel POST asynchrone au service web sur /crayons/{id} 
//            this.adm.$save();
//            $location.path("/");
//        };
//    }
//]);
