package com.docencia.service.impl;

import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.repository.impl.UserRepositoryImpl;
import com.docencia.service.IUserService;

public class UserServiceImpl implements IUserService{
    private final IUserRepository userRepository;

    public UserServiceImpl(){
        userRepository = new UserRepositoryImpl();
    }
    @Override
    public Usuario crearUsuario(int id, String nombre, String email, String password) {
        
        throw new UnsupportedOperationException("Unimplemented method 'crearUsuario'");
    }

    @Override
    public Set<Usuario> listarUsuarios() {
        
        throw new UnsupportedOperationException("Unimplemented method 'listarUsuarios'");
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorEmail'");
    }

    @Override
    public boolean eliminarPorEmail(String email) {
        
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPorEmail'");
    }

    @Override
    public Usuario cambiarNombre(String email, String nuevoNombre) {
        
        throw new UnsupportedOperationException("Unimplemented method 'cambiarNombre'");
    }

    @Override
    public Usuario cambiarPassword(String email, String nuevaPassword) {
        
        throw new UnsupportedOperationException("Unimplemented method 'cambiarPassword'");
    }

}
