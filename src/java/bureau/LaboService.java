/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mtaussac
 */
public class LaboService {
  
        EntityManagerFactory fact;

    public LaboService(EntityManagerFactory fact) {
        this.fact = fact;
    }
}
