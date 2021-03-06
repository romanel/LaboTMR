/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author mtaussac
 * @author rleguede
 * @author talmansa
 */
@Entity
public class ActeLabo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String date_demande_labo;
    private String date_realisation_acte; 
    private int NABM;
    private String unite_fonctionnel;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Resultat resultat;
        
    @OneToOne
    private Admission adm; 

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_demande_labo() {
        return date_demande_labo;
    }

    public void setDate_demande_labo(String date_demande_labo) {
        this.date_demande_labo = date_demande_labo;
    }

    public String getDate_realisation_acte() {
        return date_realisation_acte;
    }

    public void setDate_realisation_acte(String date_realisation_acte) {
        this.date_realisation_acte = date_realisation_acte;
    }
    

    public int getNABM() {
        return NABM;
    }

    public void setNABM(int NABM) {
        this.NABM = NABM;
    }

    public String getUnite_fonctionnel() {
        return unite_fonctionnel;
    }

    public void setUnite_fonctionnel(String unite_fonctionnel) {
        this.unite_fonctionnel = unite_fonctionnel;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

    public Admission getAdm() {
        return adm;
    }

    public void setAdm(Admission adm) {
        this.adm = adm;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActeLabo)) {
            return false;
        }
        ActeLabo other = (ActeLabo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bureau.ActeLabo[ id=" + id + " ]";
    }
    
}
