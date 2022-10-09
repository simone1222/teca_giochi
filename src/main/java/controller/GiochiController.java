package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.GenereEntity;
import model.GiochiEntity;
import model.UtenteEntity;
import repository.GiocoRepository;
import repository.UserRepository;

@Controller
public class GiochiController {

    @Autowired
    private GiocoRepository giocoRepository;
    @Autowired
    private UserRepository utenteRepository;
    @GetMapping("/giochi")
    public ModelAndView giochi(@RequestParam String genere) {
        GenereEntity genereEntity = new GenereEntity();
        genereEntity.setId(Integer.parseInt(genere));
        List<GiochiEntity> giochi = giocoRepository.findByGenere(genereEntity);
        ModelAndView viewModel = new ModelAndView("giochi");
        viewModel.addObject("giochi", giochi);
        viewModel.addObject("genere", genere);

        return viewModel;
    }

    @GetMapping("/listaGiochiUtente")
    public ModelAndView listaGiochiUtente(@RequestParam String id) {
        UtenteEntity user = utenteRepository.findById(Long.parseLong(id)).get();
        ModelAndView viewModel = new ModelAndView("listaGiochiUtente");
        viewModel.addObject("giochi", user.getGiochi());
        return viewModel;
    }
    @GetMapping("/giochi/acquista")
    public ModelAndView acquistaGioco(@RequestParam String idGioco, @RequestParam String genere, HttpSession session) {
        ModelAndView result = new ModelAndView("giochi");
        GiochiEntity daAcquistare = new GiochiEntity();
        daAcquistare.setId(Long.parseLong(idGioco));
        Long id = (Long) session.getAttribute("idUsernameLogged");
        UtenteEntity user = utenteRepository.findById(id).get();
        boolean error = false;
        for (GiochiEntity gioco : user.getGiochi()) {
            if (gioco.getId() == Long.parseLong(idGioco)) {
                error = true;
                result.addObject("error", "gioco già acquistato dall'utente");
            }
        }
        
        if(!error) {
            user.getGiochi().add(daAcquistare);
            utenteRepository.save(user);
            result.addObject("success", "gioco acquistato con successo");
        }
        GenereEntity genereEntity = new GenereEntity();
        genereEntity.setId(Integer.parseInt(genere));
        List<GiochiEntity> giochi = giocoRepository.findByGenere(genereEntity);
        result.addObject("giochi", giochi);
        result.addObject("genere", genere);
        return result;
    }
}