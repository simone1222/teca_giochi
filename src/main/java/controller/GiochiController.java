package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.GiochiEntity;
import repository.GiocoRepository;

@Controller
public class GiochiController {

    @Autowired
    private GiocoRepository giocoRepository;

    @GetMapping("/giochi")
    public ModelAndView giochi(@RequestParam String genere) {
        List<GiochiEntity> giochi = (List<GiochiEntity>) giocoRepository.findAll();
        ModelAndView viewModel = new ModelAndView("giochi");
        viewModel.addObject("giochi", giochi);
        return viewModel;
    }
}