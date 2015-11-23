/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Code Nicolas Singer 

angular.module('monApp').controller('CrayonsController', ['Crayons',
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

        .controller('CrayonNewController', ['Crayons',
            function (Crayons) {
                this.cr = new Crayons();
                this.update = function () {
                    // appel POST asynchrone au service web sur /crayons
                    this.cr.$save();
                };
            }])


        .controller('CrayonEditController', ['$routeParams', 'Crayons', '$location',
            function ($routeParams, Crayons, $location) {
                this.cr = Crayons.get({id: $routeParams.id});
                this.update = function () {
                    // appel POST asynchrone au service web sur /crayons/{id} 
                    this.cr.$save();
                    $location.path("/");
                };
            }
        ])

        .controller('ActeNewControlleur', ['ActeLabo', 'Admissions',
            function (ActeLabo, Admissions) {
                var self = this;
                this.admissions = Admissions.query();
                this.actel = new ActeLabo();
                this.update = function () {
                    //console.log("lklkl");
                    self.actel.$save();
                };
            }
        ])

        .controller('ListeDemandeControlleur', ['ActeLabo', 'ActeLaboSansRes',
            function (ActeLabo, ActeLaboSansRes) {
                var self = this;
                // this.actel = ActeLabo.query(); 
                ActeLaboSansRes.get().then(function (res) {
                    //console.log("coucou");
                    self.actel = res.data;
                });
                self.submit = function () {
                    $location.path("/editResultat");
                }
            }
        ])

        .controller('AfficherActeControlleur', ['$routeParams', 'ActeLabo', 'Resultat',
            function ($routeParams, ActeLabo, Resultat) {
                var self = this;
                this.actel = ActeLabo.get({id: $routeParams.id});
                //this.adm = Admission.query();
                //this.res = Resultat.query();
            }
        ])

        .controller('ListActeLaboControlleur', ['ActeLabo',
            function (ActeLabo) {
                //console.log("coucou1");
                var self = this;
                //console.log("coucou2");
                this.actel = ActeLabo.query();
                //console.log("coucou3");
                self.afficher = function () {
                    $location.path("/afficherActe");
                }
                self.modifier = function () {
                    $location.path("/editActe");
                }
                //MARCHE PAS POUR L'INSTANT
                this.delete = function (actel) {
                    // appel DELETE asynchrone au service web sur /crayons/{id}
                    //cr.$delete();
                    ActeLabo.delete(actel);
                    // remet à jour le tableau des crayons en suprimant l'élément effacé
                    self.actel.splice(self.actel.indexOf(actel), 1);
                };
            }
        ])

        .controller('ResultatNewControlleur', ['$routeParams', 'Resultat', 'ActeLabo', '$location',
            function ($routeParams, Resultat, ActeLabo, $location) {
                var self = this;
                this.actel = ActeLabo.get({id: $routeParams.id});
                this.res = new Resultat();
                this.update = function () {
                    //console.log("coucou4");
                    self.res.$save(function (u, putResponseHeaders) {
                        console.dir(u);
                        self.actel.resultat = u;
                        console.log(angular.toJson(self.actel));
                        self.actel.$save();
                        $location.path("/");
                        //console.log("coucou6");

                    });




                };
                self.submit = function () {
                    $location.path("/listeDemande");
                }
            }
        ]);

