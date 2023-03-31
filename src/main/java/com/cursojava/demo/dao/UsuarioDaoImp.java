package com.cursojava.demo.dao;

import com.cursojava.demo.models.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Usuario getUsuario(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario){
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (lista.isEmpty()){
            return null;
        }

        //traemos el dato del usuario encontrado y tomamos el dato de contraseña
        String passwordHashed = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        // usamos el metodo verify de argon2 para saber si la contraseña indicada es correcta
        Boolean isLoginOK = argon2.verify(passwordHashed, usuario.getPassword());
        if (isLoginOK){
            return lista.get(0);
        }
        return null;
    }
}
