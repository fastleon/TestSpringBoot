package com.cursojava.demo.controllers;

import com.cursojava.demo.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorUsuario {

    //Llamado a un solo usuario
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

    //LLamado a todo el listado (se puede adecuar para recibir una cant fija ej:100)
    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        List usuarios = new ArrayList();

        Usuario usuario = new Usuario();
        usuario.setId(123L);
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("lucasmoy@email.com");
        usuario.setTelefono("1238378683");
        usuario.setPassword("");

        Usuario usuario2 = new Usuario();
        usuario.setId(1234L);
        usuario2.setNombre("Pepito");
        usuario2.setApellido("Perez");
        usuario2.setEmail("pepito@email.com");
        usuario2.setTelefono("123123553");
        usuario2.setPassword("");

        Usuario usuario3 = new Usuario();
        usuario.setId(1235L);
        usuario3.setNombre("Ainara");
        usuario3.setApellido("Leon");
        usuario3.setEmail("Ainara@email.com");
        usuario3.setTelefono("4565683");
        usuario3.setPassword("");

        Usuario usuario4 = new Usuario();
        usuario.setId(1236L);
        usuario4.setNombre("Ainhoa");
        usuario4.setApellido("Gonzalez");
        usuario4.setEmail("Ainhoa@email.com");
        usuario4.setTelefono("78455672349");
        usuario4.setPassword("");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);

        return usuarios;
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
