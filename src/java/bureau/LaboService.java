/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author mtaussac
 * @author rleguede
 * @author talmansa
 */
public class LaboService {
  
    EntityManagerFactory fact;
    EntityManager em;

    public LaboService(EntityManagerFactory fact) {
        this.fact = fact;
        this.em = fact.createEntityManager();
    }
    
    public Admission newAdmission (int ipp, String nom, String prenom){
        Admission adm = new Admission();
        adm.setIpp(ipp);
        adm.setNom(nom);
        adm.setPrenom(prenom);
	em.getTransaction( ).begin( );
        em.persist(adm);
        em.getTransaction().commit();
        return adm;
    }
    
    public ActeLabo newActeLabo (String date_dde, String date_real, int nabm, String uf, Resultat res, Admission adm){
        ActeLabo acte = new ActeLabo();
        acte.setDate_demande_labo(date_dde);
        acte.setDate_realisation_acte(date_real);
        acte.setNABM(nabm);
        acte.setUnite_fonctionnel(uf);
        acte.setAdm(adm);
        acte.setResultat(res);
	em.getTransaction( ).begin( );
        em.persist(acte);
        em.getTransaction().commit();
        return acte;
    }
    
      public void newResultat2 (Resultat res){
      
	em.getTransaction( ).begin( );
        em.persist(res);
        em.getTransaction().commit();
    }  
        
    public Resultat newResultat (String date, String resu){
        Resultat result = new Resultat();
        result.setDate(date);
        result.setResu(resu);
	em.getTransaction( ).begin( );
        em.persist(result);
        em.getTransaction().commit();
        return result;
    }  
    
    public ActeLabo updateActe(ActeLabo acte){
	em.getTransaction( ).begin( );
        em.merge(acte);
        em.getTransaction().commit();
        return acte;
    }
    
    public Admission getAdmissionById(Long iep) {
	Admission adm = em.find( Admission.class, iep );
        return adm;
    }
    
    public ActeLabo getActeLaboById(Long id) {
	ActeLabo acte = em.find( ActeLabo.class, id );
        return acte;
    }
    
    public Resultat getResultatById(Long id) {
	Resultat result = em.find( Resultat.class, id );
        return result;
    }
    
    public List<ActeLabo> getActelaboSansResultat(){
        List<ActeLabo> listeActe = new ArrayList();
        
        // Récupère dans une liste res tous les actes labo existants
        TypedQuery<ActeLabo> query = em.createQuery("SELECT acte FROM ActeLabo acte", ActeLabo.class);
        List<ActeLabo> res = query.getResultList();
        
        // Récupère dans une liste listeActe les actes qui n'ont pas de résultat
        for (ActeLabo acte : res){
            if (acte.getResultat() == null){
                listeActe.add(acte);
            }
        }
        return listeActe;
    }
    
    public List<ActeLabo> getActelaboAvecResultat(){
        List<ActeLabo> listeActe = new ArrayList();
        
        // Récupère dans une liste res tous les actes labo existants
        TypedQuery<ActeLabo> query = em.createQuery("SELECT acte FROM ActeLabo acte", ActeLabo.class);
        List<ActeLabo> res = query.getResultList();
        
        // Récupère dans une liste listeActe les actes qui ont un résultat
        for (ActeLabo acte : res){
            if (acte.getResultat() != null){
                listeActe.add(acte);
            }
        }
        return listeActe;
    }
    
    public List<ActeLabo> getActelaboParService(String UF){
        List<ActeLabo> listeActe = new ArrayList();
        
        // Récupère dans une liste res tous les actes labo existants
        TypedQuery<ActeLabo> query = em.createQuery("SELECT acte FROM ActeLabo acte", ActeLabo.class);
        List<ActeLabo> res = query.getResultList();
        
        // Récupère dans une liste listeActe les actes qui ont l'UF passé en argument
        for (ActeLabo acte : res){
            if(acte.getUnite_fonctionnel()==UF){
                listeActe.add(acte);
            }
        }
        
        return listeActe;
    }
    
    public List<Admission> getAllAdmission() {
	TypedQuery<Admission> query = em.createQuery("SELECT adm FROM Admission adm", Admission.class);
        List<Admission> res = query.getResultList();
        return res;
    }
    
    /*public  List<String> getAlluf() {        
        String[] res = { "sflkjdflk", "slkdklsfjkl", "lmdflmskg" };
        ArrayList <String> unitf =(ArrayList <String>) em.createQuery("SELECT nom_uf FROM unite_fonctionnelle", String.class);
        return unitf;
    }*/
    
    
    public List<ActeLabo> getAllActeLabo() {
	TypedQuery<ActeLabo> query = em.createQuery("SELECT acte FROM ActeLabo acte", ActeLabo.class);
        List<ActeLabo> res = query.getResultList();
        return res;
    }
    
    public List<Resultat> getAllResultat() {
	TypedQuery<Resultat> query = em.createQuery("SELECT result FROM Resultat result", Resultat.class);
        List<Resultat> res = query.getResultList();
        return res;
    }
    
    public void deleteAllAdmission() {
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Admission").executeUpdate();
        em.getTransaction().commit();
    }
    
    public void deleteAllActeLabo() {
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM ActeLabo").executeUpdate();
        em.getTransaction().commit();
    }
    
    public void deleteAllResultat() {
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Resultat").executeUpdate();
        em.getTransaction().commit();
    }
    
    public void deleteAdmissionById(Long id) {
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Admission WHERE iep ="+id).executeUpdate();
        em.getTransaction().commit();
    }
    
    public void deleteActelaboById(Long id) {
        em.getTransaction( ).begin( );
        em.createQuery("DELETE acte FROM Actelabo WHERE id ="+id).executeUpdate();
        em.getTransaction().commit();
    }
    
    public void deleteResultatById(Long id) {
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Resultat WHERE id ="+id).executeUpdate();
        em.getTransaction().commit();
    }
}
