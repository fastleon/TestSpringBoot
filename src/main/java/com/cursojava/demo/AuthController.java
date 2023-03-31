package com.cursojava.demo;

import com.cursojava.demo.dao.UsuarioDao;
import com.cursojava.demo.models.Usuario;
import com.cursojava.demo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        //Creacion del token JWT con el ID del usuario como key y el email como el value del token
        //luego los podemos recuperar con los metodos .getKey() .getValue()
        if (usuarioLogueado != null){
            String tokenJWT = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return tokenJWT;
        }
        return "Fail";
    }
}
