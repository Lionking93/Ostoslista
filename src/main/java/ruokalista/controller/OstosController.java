package ruokalista.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ruokalista.wrappers.Ostos;

@RestController
public class OstosController {

    @RequestMapping(value="/lisaaOstos", method = RequestMethod.POST)
    public void lisaaOstos(@RequestBody Ostos pOstos) {
        System.out.println("Lisätty ostos " + pOstos.getNimi() + " " + pOstos.getMaara());
    }
}
