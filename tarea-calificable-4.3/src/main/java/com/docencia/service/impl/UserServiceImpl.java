package com.docencia.service.impl;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.repository.impl.UserRepositoryImpl;
import com.docencia.service.IUserService;
import com.docencia.util.Validaciones;

/**
 * Clase UserServiceImpl
 * @author hectorpoleo
 * @version 1.0.0
 */
public class UserServiceImpl implements IUserService{
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository){
        this.userRepository = new UserRepositoryImpl();
    }
    @Override
    public Usuario crearUsuario(int id, String nombre, String email, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Usuario> listarUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        if(Validaciones.validarEmail(email)){
            return null;
        }
        email = Validaciones.normalizarEmail(email);
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean eliminarPorEmail(String email) {
        if(Validaciones.validarEmail(email)){
            return false;
        }
        email = Validaciones.normalizarEmail(email);
        return userRepository.deleteByEmail(email);
    }

    @Override
    public Usuario cambiarNombre(String email, String nuevoNombre) {
        
        throw new UnsupportedOperationException("Unimplemented method 'cambiarNombre'");
    }

    @Override
    public Usuario cambiarPassword(String email, String nuevaPassword) {
        throw new UnsupportedAddressTypeException();
    }

}
