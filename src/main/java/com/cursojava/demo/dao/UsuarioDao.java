package com.cursojava.demo.dao;

import com.cursojava.demo.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    //llamado de todos los usuarios
    List<Usuario> getUsuarios();

    //llamado de un ususario con id
    Usuario getUsuario(Long id);

    //llamado a eliminacion de un usuario
    void eliminar(Long id);

    //llamado a la adicion de un usuario
    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
