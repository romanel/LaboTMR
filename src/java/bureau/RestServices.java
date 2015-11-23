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
    public List<Admission> getAllAdmissions() {
        return serv.getAllAdmission();
    }
    
    
    @GET
    @Path("actelabo")
    @Produces("application/json")
    public List<ActeLabo> getAllActeLabos() {
        return serv.getAllActeLabo();
    }
    
    @GET
    @Path("resultat")
    @Produces("application/json")
    public List<Resultat> getAllResultats() {
        return serv.getAllResultat();
    }
    
       
    /*@GET
    @Path("uf")
    @Produces("application/json")
    public List<String> getAlluf() {
        return serv.getAlluf();
    }*/
    
    @GET
    @Path("admission/{id}")
    @Produces("application/json")
    public Admission getAdmissionById(@PathParam("id") Long id) {
        return serv.getAdmissionById(id);
    }
    
    @GET
    @Path("actelabo/{id}")
    @Produces("application/json")
    public ActeLabo getActeLaboById(@PathParam("id") Long id) {
        return serv.getActeLaboById(id);
    }
    
    @GET
    @Path("resultat/{id}")
    @Produces("application/json")
    public Resultat getResultatById(@PathParam("id") Long id) {
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
        return acte;
    }
    
    @POST
    @Path("resultat")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Resultat newResultat(Resultat resu) {
        serv.newResultat2(resu);
        System.out.println("idres:"+resu.getId());
        return resu;
    }
    
    @POST
    @Path("actelabo/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editActelabo(ActeLabo acte) {
        System.out.println("idacte:"+acte.getId());
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
    public Response removeAllAdmission() {
        serv.deleteAllAdmission();
        return Response.status(200).build();
    }
    
    @DELETE
    @Path("actelabo")
    public Response removeAllActelabo() {
        serv.deleteAllActeLabo();
        return Response.status(200).build();
    }
    
    @DELETE
    @Path("resultat")
    public Response removeAllResultat() {
        serv.deleteAllResultat();
        return Response.status(200).build();
    }
    
    @DELETE
    @Path("admission/{id}")
    public Response removeAdmissionByID(@PathParam("id") Long id) {
        serv.deleteAdmissionById(id);
        return Response.status(200).build();
    }
    
    @DELETE
    @Path("actelabo/{id}")
    public Response removeActelaboByID(@PathParam("id") Long id) {
        serv.deleteActelaboById(id);
        return Response.status(200).build();
    }
    
    @DELETE
    @Path("resultat/{id}")
    public Response removeResultatByID(@PathParam("id") Long id) {
        serv.deleteResultatById(id);
        return Response.status(200).build();
    }
    
}
