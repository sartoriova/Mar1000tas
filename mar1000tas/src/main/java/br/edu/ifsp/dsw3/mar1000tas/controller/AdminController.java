package br.edu.ifsp.dsw3.mar1000tas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.dsw3.mar1000tas.model.dao.AdminDao;
import br.edu.ifsp.dsw3.mar1000tas.model.domain.Admin;

@Controller
@RequestMapping("/administradores")
public class AdminController {
    @Autowired
    AdminDao dao;
    
    @GetMapping("/cadastrar")
    public String cadastrar(Admin admin){
        return "/administrador/cadastro";
    }
    
    @GetMapping("/listar")
    public String listar(ModelMap map){
        map.addAttribute("administradores", dao.findAll());
        return "/administrador/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Admin admin){
        dao.save(admin);
        return "redirect:/administradores/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id){
        dao.deleteById(id);
        return "redirect:/administradores/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap map){
        map.addAttribute("admin", dao.findById(id).get());
        return "/administrador/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Admin admin){
        dao.save(admin);
        return "redirect:/administradores/listar";
    }
}
