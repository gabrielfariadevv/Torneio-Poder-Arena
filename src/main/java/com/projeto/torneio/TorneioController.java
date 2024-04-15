package com.projeto.torneio;

import com.projeto.torneio.models.Arena;
import com.projeto.torneio.repositories.ArenaRepository;
import net.sf.jsqlparser.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TorneioController {

    @Autowired
    private ArenaRepository repository;

    @GetMapping("/")
    public ModelAndView home() {
        List<Arena> arenas = repository.findAll();
        ModelAndView view = new ModelAndView("index");
        view.addObject("arenas", arenas);
        return view;

    }

        @GetMapping("/register")
        public ModelAndView create () {
            ModelAndView view = new ModelAndView("create");
            view.addObject("arena", new Arena());
            return view;
        }

        @PostMapping("/register")
        public String createArena (Arena arena, Model model, BindingResult result){
            repository.save(arena);
            return "redirect:/";
        }

    }


