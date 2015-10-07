/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author mtaussac
 */
public class LaboService {
  
        EntityManagerFactory fact;

    public LaboService(EntityManagerFactory fact) {
        this.fact = fact;
    }
    
    public Admission newAdmission (int ipp, String nom, String prenom){
        Admission adm = new Admission();
        adm.setIpp(ipp);
        adm.setNom(nom);
        adm.setPrenom(prenom);
        EntityManager em = fact.createEntityManager();
	em.getTransaction( ).begin( );
        em.persist(adm);
        em.getTransaction().commit();
        em.close();
        return adm;
    }
    
    public ActeLabo newActeLabo (String date_dde, String date_real, int nabm, String uf){
        ActeLabo acte = new ActeLabo();
        acte.setDate_demande_labo(date_dde);
        acte.setDate_realisation_acte(date_real);
        acte.setNABM(nabm);
        acte.setUnite_fonctionnel(uf);
        EntityManager em = fact.createEntityManager();
	em.getTransaction( ).begin( );
        em.persist(acte);
        em.getTransaction().commit();
        em.close();
        return acte;
    }
        
    public Resultat newResultat (String date, String resu){
        Resultat result = new Resultat();
        result.setDate(date);
        result.setResu(resu);
        EntityManager em = fact.createEntityManager();
	em.getTransaction( ).begin( );
        em.persist(result);
        em.getTransaction().commit();
        em.close();
        return result;
    }  
    
    public Admission getAdmissionById(int iep) {
        EntityManager em = fact.createEntityManager();
	Admission adm = em.find( Admission.class, iep );
        em.close();
        return adm;
    }
    
    public ActeLabo getActeLaboById(int id) {
        EntityManager em = fact.createEntityManager();
	ActeLabo acte = em.find( ActeLabo.class, id );
        em.close();
        return acte;
    }
    
    public Resultat getCrayonsById(int id) {
        EntityManager em = fact.createEntityManager();
	Resultat result = em.find( Resultat.class, id );
        em.close();
        return result;
    }
    
    public List<Admission> getAllAdmission() {
        EntityManager em = fact.createEntityManager();
	TypedQuery<Admission> query = em.createQuery("SELECT adm FROM Admission adm", Admission.class);
        List<Admission> res = query.getResultList();
        em.close();
        return res;
    }
    
    public List<ActeLabo> getAllActeLabo() {
        EntityManager em = fact.createEntityManager();
	TypedQuery<ActeLabo> query = em.createQuery("SELECT acte FROM ActeLabo acte", ActeLabo.class);
        List<ActeLabo> res = query.getResultList();
        em.close();
        return res;
    }
    
    public List<Resultat> getAllResultat() {
        EntityManager em = fact.createEntityManager();
	TypedQuery<Resultat> query = em.createQuery("SELECT result FROM Resultat result", Resultat.class);
        List<Resultat> res = query.getResultList();
        em.close();
        return res;
    }
    
    public void deleteAllAdmission() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Admission").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
    public void deleteAllActeLabo() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM ActeLabo").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
    public void deleteAllResultat() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Resultat").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
