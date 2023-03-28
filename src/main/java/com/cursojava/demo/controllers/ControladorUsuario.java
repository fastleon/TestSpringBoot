package com.cursojava.demo.controllers;

import com.cursojava.demo.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorUsuario {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@email.com");
        usuario.setTelefono("1238378683");
        usuario.setPassword("");
        return usuario;
    }

    @RequestMapping(value = "prueba")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@email.com");
        usuario.setTelefono("1238378683");
        usuario.setPassword("");
        return usuario;
    }

    @RequestMapping(value = "prueba2")
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@email.com");
        usuario.setTelefono("1238378683");
        usuario.setPassword("");
        return usuario;
    }

    @RequestMapping(value = "prueba3")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@email.com");
        usuario.setTelefono("1238378683");
        usuario.setPassword("");
        return usuario;
    }

}
