/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author mtaussac
 * @author rleguede
 */
@Entity
public class Admission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iep;
    
    @Column

    private int ipp;
    private String nom;
    private String prenom;
    
    public int getIpp() {
        return ipp;
    }

    public void setIpp(int ipp) {
        this.ipp = ipp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public Long getIep() {
        return iep;
    }

    public void setIep(Long iep) {
        this.iep = iep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iep != null ? iep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admission)) {
            return false;
        }
        Admission other = (Admission) object;
        if ((this.iep == null && other.iep != null) || (this.iep != null && !this.iep.equals(other.iep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bureau.Admission[ id=" + iep + " ]";
    }
    
}
