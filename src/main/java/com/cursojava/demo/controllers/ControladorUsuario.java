package com.cursojava.demo.controllers;

import com.cursojava.demo.dao.UsuarioDao;
import com.cursojava.demo.models.Usuario;
import com.cursojava.demo.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorUsuario {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    //Llamado a un solo usuario
    @RequestMapping(value = "api/usuario/{id}")
    public Usuario getUsuario(@RequestHeader(value="Authorization") String token,
                              @PathVariable Long id){
        String usuarioId = jwtUtil.getKey(token);
        if (usuarioId == null){
            return null;
        }
        return usuarioDao.getUsuario((id));
    }

    //LLamado a todo el listado (se puede adecuar para recibir una cant fija ej:100)
    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value="Authorization") String token){
        String usuarioId = jwtUtil.getKey(token);
        if (usuarioId == null){
             return new ArrayList<>();
        }
        return usuarioDao.getUsuarios();
    }

    //llamado para eliminar un Usuario
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable Long id){
        String usuarioId = jwtUtil.getKey(token);
        if (usuarioId == null){
            return;
        }
        usuarioDao.eliminar(id);
    }

    //llamado para agregar un Usuario, se usa el metodo POST
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
     public void registrarUsuario (Usuario usuario) {
        //Codificacion de la contraseña con Argon2 que crea un hash para guardar el hash y no la contraseña
        //se debe importar la libreria Argon2-jvm version 2.5, ver POM.XLM, el tipo de dato debe ser VARCHAT 255
        //para mas info ver la documentacion u otra libreria
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

}
