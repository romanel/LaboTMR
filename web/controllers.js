/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Code Nicolas Singer 

angular.module('monApp')
//        .controller('CrayonsController', ['Crayons',
//            function (Crayons) {
//                this.crayons = Crayons.query();
//                this.delete = function (cr) {
//                    // appel DELETE asynchrone au service web sur /crayons/{id}
//                    //cr.$delete();
//                    Crayons.delete(cr);
//                    // remet à jour le tableau des crayons en suprimant l'élément effacé
//                    this.crayons.splice(this.crayons.indexOf(cr), 1);
//                };
//            }
//        ])

//        .controller('CrayonNewController', ['Crayons',
//            function (Crayons) {
//                this.cr = new Crayons();
//                this.update = function () {
//                    // appel POST asynchrone au service web sur /crayons
//                    this.cr.$save();
//                };
//            }])


//        .controller('CrayonEditController', ['$routeParams', 'Crayons', '$location',
//            function ($routeParams, Crayons, $location) {
//                this.cr = Crayons.get({id: $routeParams.id});
//                this.update = function () {
//                    // appel POST asynchrone au service web sur /crayons/{id} 
//                    this.cr.$save();
//                    $location.path("/");
//                };
//            }
//        ])

        .controller('ActeNewControlleur', ['ActeLabo', 'Admissions',
            function (ActeLabo, Admissions) {
                var self = this;
                this.admissions = Admissions.query();
                this.actel = new ActeLabo();
                this.update = function () {
                    //console.log("lklkl");
                    self.actel.$save();
                };
//                self.accueil = function () {
//                    $location.path("/accueil");
//                }
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

        .controller('ListActeLaboControlleur', ['ActeLabo', 'ActeLaboAvecRes',
            function (ActeLabo, ActeLaboAvecRes) {
                //console.log("coucou1");
                var self = this;
                ActeLaboAvecRes.get().then(function (res) {
                    //console.log("coucou");
                    self.actel = res.data;
                });
                //console.log("coucou2");
                //console.log("coucou3");
                self.afficher = function () {
                    $location.path("/afficherActe");
                }
                self.modifier = function () {
                    $location.path("/editActe");
                }                
                this.delete = function (actel) {
                    // appel DELETE asynchrone au service web sur /crayons/{id}
                    //actel.$delete();
                    ActeLabo.delete(actel);
                    // remet à jour le tableau des crayons en suprimant l'élément effacé
                    self.actel.splice(self.actel.indexOf(actel), 1);
                };
            }
        ])
        
        .controller('EditActeControlleur', ['$routeParams','ActeLabo', '$location', 'Resultat',
            function ($routeParams, ActeLabo, $location, Resultat) {
                var self = this;
                this.actel = ActeLabo.get({id: $routeParams.id});
                this.update = function () {
                    self.actel.$save(function (u, putResponseHeaders) {
                        console.dir(u);
                        console.log(angular.toJson(self.actel));
                        self.actel.date_realisation_acte = self.actel.resultat.date;
                        self.actel.$save();
                        $location.path("/");
                        //console.log("coucou6");
                    });
                }
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

