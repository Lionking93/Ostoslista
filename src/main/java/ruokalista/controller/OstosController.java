package ruokalista.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ruokalista.model.OstoslistaModel;
import ruokalista.wrappers.Ostos;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OstosController {

    private OstoslistaModel ostoslista;

    public OstosController(OstoslistaModel pOstoslistaModel) {
        this.ostoslista = pOstoslistaModel;
    }

    @RequestMapping(value="/lisaaOstos", method = RequestMethod.POST)
    public List<Ostos> lisaaOstos(@RequestBody Ostos pOstos) {
        this.ostoslista.tallennaOstos(pOstos);
        System.out.println("Lisätty ostos " + pOstos.getNimi() + " " + pOstos.getMaara() + " " + pOstos.getYksikko());
        return this.ostoslista.haeOstokset();
    }

    @RequestMapping(value="/poistaOstokset", method = RequestMethod.POST)
    public void poistaOstokset(@RequestBody List<Ostos> pOstokset) {
        this.ostoslista.poistaOstoksia(pOstokset);
        for (Ostos ostos : pOstokset) {
            System.out.println(ostos.getNimi() + " " + ostos.getMaara() + " " + ostos.getYksikko());
        }
    }

    @RequestMapping(value="/haeTehdytOstokset", method = RequestMethod.GET)
    public List<Ostos> haeTehdytOstokset() {
        List<Ostos> ostokset = this.ostoslista.haeOstokset();
                /*new ArrayList();
        for (int i = 0; i < 3; i++) {
            Ostos ostos = new Ostos();
            ostos.setNimi("Maito"+i);
            ostos.setMaara("1");
            ostos.setYksikko("prk");
            System.out.println(ostos.getNimi() + " " + ostos.getMaara() + " " + ostos.getYksikko());
            ostokset.add(ostos);
        }*/
        return ostokset;
    }
}
