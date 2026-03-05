package com.docencia.repository.impl;

import java.util.HashSet;
import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;

public class UserRepositoryImpl implements IUserRepository{
    final Set<Usuario> usuarios;
    public UserRepositoryImpl(){
        usuarios = new HashSet<>();
    }

    @Override
    public Usuario findByEmail(String email){
        if(!existsByEmail(email)){
            return null;
        }
        Usuario usuarioBuscar = new Usuario(email);
        for (Usuario usuario : usuarios) {
            if(usuario.equals(usuarioBuscar)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public boolean existsByEmail(String email){
        Usuario usuarioBuscar = new Usuario(email);
        
    }
    @Override
    public void save(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }


    @Override
    public boolean existsByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsByEmail'");
    }

    @Override
    public Set<Usuario> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public boolean deleteByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByEmail'");
    }

}
