package br.edu.ifsp.dsw3.mar1000tas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.ModelMap;
import br.edu.ifsp.dsw3.mar1000tas.model.dao.UsuarioDao;
import br.edu.ifsp.dsw3.mar1000tas.model.domain.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioDao dao;
    
    @GetMapping("/cadastrar")
    public String cadastrar(Usuario usuario){
        return "/usuario/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap map){
        map.addAttribute("usuarios", dao.findAll());
        return "/usuario/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Usuario usuario){
        dao.save(usuario);
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id){
        //QUANDO O USUÁRIO ESTIVER EM UMA RESERVA
        //O PROGRAMA VAI DAR ERRO E NÃO VAI DEIXAR EXCLUIR
        dao.deleteById(id);
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap map){
        map.addAttribute("usuario", dao.findById(id).get());
        return "/usuario/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Usuario usuario){
        dao.save(usuario);
        return "redirect:/usuarios/listar";
    }
}
