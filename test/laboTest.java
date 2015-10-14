
import bureau.ActeLabo;
import bureau.Admission;
import bureau.DatabaseUtils;
import bureau.LaboService;
import bureau.Resultat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mtaussac
 */
public class laboTest {
    
    static EntityManagerFactory fact;
    
    public laboTest() {
       
    }
    
    static  void clean() {
        LaboService serv = new LaboService(DatabaseUtils.fact());
        serv.deleteAllAdmission();
        serv.deleteAllActeLabo();
        serv.deleteAllResultat();
        //List<ActeLabo> actelabo = serv.getAllActeLabo();
        //assert(actelabo.isEmpty());
    }
    
    @BeforeClass
    public static void setUpClass() {
        clean();

    }
    
    @AfterClass
    public static void tearDownClass() {

    }
    
    @Before
    public void setUp() {
       
    }
    
    @After
    public void tearDown() {
        
    }
    /*
    @Test
    public void admission() {
        clean();
        LaboService serv = new LaboService(DatabaseUtils.fact());
        Admission adm = serv.newAdmission(1,"Taussac", "Meggan");
        assertNotNull(adm); 
        adm = serv.newAdmission(2,"Almansa","Tiphanie");
        assertNotNull(adm);
        adm = serv.newAdmission(3,"Leguede","Romane");
        assertNotNull(adm);
     //   List<Crayon> res = serv.getCrayonsByCouleurId("vert");
     //   assert(!res.isEmpty());
     //   assert(res.size() == 2);
      
        List<Admission> res = serv.getAllAdmission();
        assert(!res.isEmpty());
        assert(res.size() == 3);
        
    }
    
    @Test
    public void actelabo() {
        clean();
        LaboService serv = new LaboService(DatabaseUtils.fact());
        ActeLabo acte = serv.newActeLabo("2015/09/21","2015/09/22",0040,"Obstetrique");
        assertNotNull(acte); 
     /*   adm = serv.newAdmission(2,"Almansa","Tiphanie");
        assertNotNull(adm);
        adm = serv.newAdmission(3,"Leguede","Romane");
        assertNotNull(adm);
     //   List<Crayon> res = serv.getCrayonsByCouleurId("vert");
     //   assert(!res.isEmpty());
     //   assert(res.size() == 2);
      
        List<ActeLabo> res = serv.getAllActeLabo();
        assert(!res.isEmpty());
        assert(res.size() == 1);
        
    }
    
    @Test
    public void resultat() {
        clean();
        LaboService serv = new LaboService(DatabaseUtils.fact());
        Resultat resu = serv.newResultat("2015/09/22", "Test positif");
        assertNotNull(resu); 
     /*   adm = serv.newAdmission(2,"Almansa","Tiphanie");
        assertNotNull(adm);
        adm = serv.newAdmission(3,"Leguede","Romane");
        assertNotNull(adm);
     //   List<Crayon> res = serv.getCrayonsByCouleurId("vert");
     //   assert(!res.isEmpty());
     //   assert(res.size() == 2);
     
        List<Resultat> res = serv.getAllResultat();
        assert(!res.isEmpty());
        assert(res.size() == 1);
        
    }
    */
    
    @Test
    public void testTout(){
        clean();
        LaboService serv = new LaboService(DatabaseUtils.fact());
        
        Admission adm = serv.newAdmission(1,"Taussac", "Meggan");
        long iep = adm.getIep();
        
        ActeLabo acte1 = serv.newActeLabo("2015/09/21","2015/09/22",0040,"Obstetrique", null, adm);
        ActeLabo acte2 = serv.newActeLabo("2015/09/29","2015/09/30",0162,"Medecine", null, adm);
                
        Resultat res1 = serv.newResultat("2015/10/01", "test positif");
        Resultat res2 = serv.newResultat("2015/10/14", "test negatif");
              
        acte1.setResultat(res1);
        acte2.setResultat(res2);
        
        serv.updateActe(acte1);
        serv.updateActe(acte2);
        
        List<Admission> admi = serv.getAllAdmission();
        assert(!admi.isEmpty());
        assert(admi.size() == 1);        
        assert(admi.get(0).getIep() ==iep);
        
        List<ActeLabo> act = serv.getAllActeLabo();
        assert(!act.isEmpty());
        assert(act.size() == 2);
        
        
        List<Resultat> resu = serv.getAllResultat();
        assert(!resu.isEmpty());
        assert(resu.size() == 2);
        
    }
    
}
