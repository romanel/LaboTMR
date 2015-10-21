/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;


import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Kurasawa
 */
@Path("generic")
public class RestServices {

    @Context
    private UriInfo context;
    LaboService serv;
   
    /**
     * Creates a new instance of GenericResource
     */
    public RestServices() {
        serv = new LaboService(DatabaseUtils.fact());
    }

    /**
     * Retrieves representation of an instance of bureau.RestServices
     * @return an instance of java.lang.String
     */
/*    
    @GET
    @Path("crayons/{id}")
    @Produces("application/json")
    public Crayon getCrayons(@PathParam("id") int id) {
        return serv.getCrayonsById(id);
    }
    
    @GET
    @Path("crayons")
    @Produces("application/json")
    public List<Crayon> getAllCrayons() {
        return serv.getAllCrayons();
    }

    @GET
    @Path("boites")
    @Produces("application/json")
    public List<Boite> getBoites() {
        return serv.getAllBoites();
    }
    */
    @GET
    @Path("admission")
    @Produces("application/json")
    public List<Admission> getAdmissions() {
        return serv.getAllAdmission();
    }
    
    @GET
    @Path("actelabo")
    @Produces("application/json")
    public List<ActeLabo> getActeLabos() {
        return serv.getAllActeLabo();
    }
    
    @GET
    @Path("resultat")
    @Produces("application/json")
    public List<Resultat> getResultats() {
        return serv.getAllResultat();
    }
    
    @GET
    @Path("admission/{id}")
    @Produces("application/json")
    public Admission getAdmission(@PathParam("id") long id) {
        return serv.getAdmissionById(id);
    }
    
    @GET
    @Path("actelabo/{id}")
    @Produces("application/json")
    public ActeLabo getActeLabo(@PathParam("id") int id) {
        return serv.getActeLaboById(id);
    }
    
    @GET
    @Path("resultat/{id}")
    @Produces("application/json")
    public Resultat getResultat(@PathParam("id") int id) {
        return serv.getResultatById(id);
    }
    
    @GET
    @Path("actelabo/sansresultat")
    @Produces("application/json")
    public List<ActeLabo> getActeLabosSansResultat() {
        return serv.getActelaboSansResultat();
    }
    
    @GET
    @Path("actelabo/avecresultat")
    @Produces("application/json")
    public List<ActeLabo> getActeLabosAvecResultat() {
        return serv.getActelaboAvecResultat();
    }
    
    @GET
    @Path("actelabo/parservice")
    @Produces("application/json")
    public List<ActeLabo> getActeLabosParService(String service) {
        return serv.getActelaboParService(service);
    }
    
   /* 
    @POST
    @Path("crayons")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Crayon newCrayon(Crayon cr) {
        serv.newCrayon(cr);
        System.out.println("id:"+cr.getId());
        return cr;
    }
    
    @POST
    @Path("crayons/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editCrayon(Crayon cr) {
        serv.editCrayon(cr);
        return Response.status(200).entity(cr).build();
    }*/
    
    @POST
    @Path("admission")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Admission newAdmission(Admission adm) {
        serv.newAdmission(adm.getIpp(),adm.getNom(),adm.getPrenom());
        System.out.println("id:"+adm.getIep());
        return adm;
    }
    
    @POST
    @Path("actelabo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public ActeLabo newActeLabo(ActeLabo acte) {
        serv.newActeLabo(acte.getDate_demande_labo(),acte.getDate_realisation_acte(),acte.getNABM(),acte.getUnite_fonctionnel(),
                acte.getResultat(), acte.getAdm());
        System.out.println("id:"+acte.getId());
        return acte;
    }
    
    @POST
    @Path("resultat")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Resultat newResultat(Resultat resu) {
        serv.newResultat(resu.getDate(),resu.getResu());
        System.out.println("id:"+resu.getId());
        return resu;
    }
    
    @POST
    @Path("actelabo/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editActelabo(ActeLabo acte) {
        serv.updateActe(acte);
        return Response.status(200).entity(acte).build();
    }
  
    /*
    @DELETE
    @Path("crayons/{id}")
    public Response removeCrayon(@PathParam("id") int id) {
        serv.removeCrayon(id);
        return Response.status(200).build();
    }
*/
    
    @DELETE
    @Path("admission")
    public Response removeAdmission() {
        serv.deleteAllAdmission();
        return Response.status(200).build();
    }
    
    @DELETE
    @Path("actelabo")
    public Response removeActelabo() {
        serv.deleteAllActeLabo();
        return Response.status(200).build();
    }
    
    @DELETE
    @Path("resultat")
    public Response removeResultat() {
        serv.deleteAllResultat();
        return Response.status(200).build();
    }
    
    @DELETE
    @Path("admission/{id}")
    public Response removeAdmissionByID(@PathParam("id") long id) {
        serv.deleteAdmissionById(id);
        return Response.status(200).build();
    }
    
    @DELETE
    @Path("actelabo/{id}")
    public Response removeActelaboByID(@PathParam("id") int id) {
        serv.deleteActelaboById(id);
        return Response.status(200).build();
    }
    
    @DELETE
    @Path("resultat/{id}")
    public Response removeResultatByID(@PathParam("id") int id) {
        serv.deleteResultatById(id);
        return Response.status(200).build();
    }
    
}
