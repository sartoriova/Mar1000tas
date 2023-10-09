package br.edu.ifsp.dsw3.mar1000tas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.dsw3.mar1000tas.model.dao.MarmitaDao;
import br.edu.ifsp.dsw3.mar1000tas.model.domain.Marmita;

@Controller
@RequestMapping("/marmitas")
public class MarmitaController {
    @Autowired
    MarmitaDao dao;

    @GetMapping("/cadastrar")
    public String cadastrar(Marmita marmita) {
        return "/marmita/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap map) {
        map.addAttribute("marmitas", dao.findAll());
        return "/marmita/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Marmita marmitas) {
        dao.save(marmitas);
        return "redirect:/marmitas/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        //QUANDO A MARMITA ESTIVER EM UMA RESERVA
        //O PROGRAMA VAI DAR ERRO E NÃO VAI DEIXAR EXCLUIR
        dao.deleteById(id);
        return "redirect:/marmitas/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap map) {
        map.addAttribute("marmita", dao.findById(id).get());
        return "/marmita/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Marmita marmita) {
        dao.save(marmita);
        return "redirect:/marmitas/listar";
    }
}
