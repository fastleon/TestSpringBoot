package com.cursojava.demo.dao;

import com.cursojava.demo.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    //llamado de todos los usuarios
    List<Usuario> getUsuarios();

    //llamado de un ususario con id
    Usuario getUsuario(Long id);

}
