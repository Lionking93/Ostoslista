package ruokalista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ruokalista.database.OstosDAO;
import ruokalista.wrappers.Ostos;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OstosController {

    private OstosDAO ostoslista;

    @Autowired
    public OstosController(OstosDAO pOstoslista) {
        this.ostoslista = pOstoslista;
    }

    @RequestMapping(value="/lisaaOstos", method = RequestMethod.POST)
    public List<Ostos> lisaaOstos(@RequestBody Ostos pOstos) {
        this.ostoslista.tallennaOstos(pOstos);
        System.out.println("OstosController: Lisätty ostos " + pOstos);
        return this.ostoslista.haeOstokset();
    }

    @RequestMapping(value="/merkitseOstetuiksi", method = RequestMethod.POST)
    public List<Ostos> poistaOstokset(@RequestBody List<Ostos> pOstokset) {
        System.out.println();
        System.out.println("Controller: Poistettavat: ");
        for (Ostos o : pOstokset) {
            System.out.println(o);
        }
        this.ostoslista.merkitseOstoksiaOstetuiksi(pOstokset);
        return this.ostoslista.haeOstokset();
    }

    @RequestMapping(value="/haeOstokset", method = RequestMethod.GET)
    public List<Ostos> haeTehdytOstokset() {
        System.out.println("Controller: haetaan tietokannasta ostoksia.");
        return this.ostoslista.haeOstokset();
    }
}
