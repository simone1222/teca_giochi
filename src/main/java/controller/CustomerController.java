package controller;


import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import model.UtenteEntity;
import service.UtenteService;

//Questa è una tipica Spring MVC controller class, annotata con l'annotazione @Controller. Notare che in questa
//classe abbiamo iniettato un'istanza di UtenteService, usando l'annotazione @Autowired.

@Controller
public class CustomerController {
	
	@Autowired
	private UtenteService utenteService;
	
	//L'oggetto ModelAndView consente al controller di restituire in unica soluzione sia il model 
	//che la vista da renderizzare.
	// Siccome la home page della web app deve visualizzare tutti gli utenti,
	// dobbiamo aggiungere alla classe
	// CustomerController il seguente metodo handler:
	
private boolean isLogged(HttpSession session) {
		
		return session.getAttribute("usernameLogged") != null;
	}

	@RequestMapping("/")
    public ModelAndView home2(HttpSession session,UtenteEntity utente) {
        List<UtenteEntity> utenti = utenteService.listAll();
        ModelAndView viewModel = new ModelAndView("home");
        viewModel.addObject("utenti", utenti);
         return viewModel;

    }
	@RequestMapping("/home/index")
	public ModelAndView index(@ModelAttribute("utente")UtenteEntity utente,HttpSession session) {

		if(utenteService.isLogged(utente)) {
			session.setAttribute("usernameLogged", utente.getUsername());
			return new ModelAndView( "redirect:/index?id=" + utente.getId());
			
		}else
		 
			return new ModelAndView( "redirect:/");
		
	}
	
	
	@RequestMapping("/index")
	public ModelAndView home(HttpSession session) {

		List<UtenteEntity> utenti = utenteService.listAll();
		ModelAndView viewModel = new ModelAndView("index");
		viewModel.addObject("utenti", utenti);
		return viewModel;
	}

	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
		UtenteEntity utente = new UtenteEntity();
		model.put("utente", utente);
		return "new";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUtente(@ModelAttribute("utente") UtenteEntity utente) {
		utenteService.save(utente);
		return "redirect:/index";
	}

	@RequestMapping("/edit")
	public ModelAndView editUtente(@RequestParam long id,HttpSession session) {
		if(isLogged(session)) {
			ModelAndView viewModel = new ModelAndView("/edit");
			UtenteEntity utente = utenteService.get(id);
			viewModel.addObject("utente", utente);
			
			return viewModel;
		}else {
			// la vista è login, il modello è l'utente vuoto
			ModelAndView viewModel = new ModelAndView("/index");
			UtenteEntity u = new UtenteEntity();
			u.setId(id);
			viewModel.addObject("utente",u );
			return viewModel;
		}
	}

//	 Facendo click sul link Delete nella riga di un customer nella home page, il customer verrà eliminato e l’elenco viene 
//	 aggiornato.

	@RequestMapping("/delete")
	public String deleteUtente(@RequestParam long id,HttpSession session) {
		if(isLogged(session)) {
			utenteService.delete(id);

			return "redirect:/";
			
		}else {
			return "redirect:/index";
		}
	}
	@RequestMapping("/home/edit")
	public ModelAndView loginEdit(@ModelAttribute("utente")UtenteEntity utente,HttpSession session) {
//		ModelAndView viewModel = new ModelAndView("/login");
		
		if(utenteService.isLogged(utente)) {
			session.setAttribute("usernameLogged", utente.getUsername());
		
			return new ModelAndView( "redirect:/edit?id=" + utente.getId());
			
		}else
			//return new ModelAndView(new RedirectView("/CustomerManager/edit?id="+utente.getId()));
		return null;
			
	}
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<UtenteEntity> result = utenteService.search(keyword);//Da fare anche con giochi e generi
		ModelAndView viewModel = new ModelAndView("/search");
		viewModel.addObject("result", result);
		return viewModel;
	}

	

	@RequestMapping("/viewsGame")
	public ModelAndView Game(@RequestParam long id,HttpSession session) {
		if(isLogged(session)) {
			ModelAndView viewModel = new ModelAndView("/viewsGame");
			UtenteEntity utente = utenteService.get(id);
			viewModel.addObject("utente", utente);
			
			return viewModel;
		}else {
			// la vista è login, il modello è l'utente vuoto
			ModelAndView viewModel = new ModelAndView("/index");
			UtenteEntity u = new UtenteEntity();
			u.setId(id);
			viewModel.addObject("utente",u );
			return viewModel;
		}
	}

}