package com.cursojava.demo.controllers;

import com.cursojava.demo.dao.UsuarioDao;
import com.cursojava.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorUsuario {

    @Autowired
    private UsuarioDao usuarioDao;

    //Llamado a un solo usuario
    @RequestMapping(value = "api/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        return usuarioDao.getUsuario((id));
    }

    //LLamado a todo el listado (se puede adecuar para recibir una cant fija ej:100)
    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    //llamado para eliminar un Usuario
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);
    }

    //llamado para agregar un Usuario, se usa el metodo POST
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
     public void registrarUsuario (Usuario usuario) {
        usuarioDao.registrar(usuario);
    }

}
