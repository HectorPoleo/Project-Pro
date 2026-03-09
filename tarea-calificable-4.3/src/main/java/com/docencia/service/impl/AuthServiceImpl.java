package com.docencia.service.impl;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.service.IAuthService;
import com.docencia.util.Validaciones;

/**
 * Clase AuthServiceImpl
 * @author hectorpoleo
 * @version 1.0.0
 */
public class AuthServiceImpl implements IAuthService{

    final IUserRepository userRepository;

    /**
     * Metodo para inizializar userRepository
     * @param userRepository
     */
    public AuthServiceImpl(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Metodo para registrar un Usuario
     * @param id
     * @param nombre
     * @param email
     * @param password
     * @return Usuario
     */
    @Override
    public Usuario register(int id, String nombre, String email, String password) {
        if(id < 1 || !Validaciones.validarEmail(email) || !Validaciones.validarPassword(password)){
            return null;
        }
        email = Validaciones.normalizarEmail(email);
        Usuario usuario = new Usuario(id, nombre, email, password);
        userRepository.save(usuario);
        System.out.println(usuario);
        return usuario;
    }

    /**
     * Metodo para logearte
     * @param email
     * @param password
     * @return boolean
     */
    @Override
    public boolean login(String email, String password) {
        if(isBloqueado(email)){
            System.out.println("Este email esta bloqueado");
            return false;
        }
        if(!Validaciones.validarEmail(email) || !Validaciones.validarPassword(password)){
            return false;
        }
        Usuario usuario = userRepository.findByEmail(email);
        if(usuario == null){
            return false;
        }
        if(!usuario.getPassword().equals(password)){
            usuario.setIntentosFallidos(usuario.getIntentosFallidos()+1);
            if(usuario.getIntentosFallidos() >= 3){
                usuario.setBloqueado(true);
            }
            return false;
        }
        return true;
    }

    /**
     * Metodo para bloquear un Usuario si falla la password 3 veces
     * @param email
     * @return boolean
     */
    @Override
    public boolean isBloqueado(String email) {
        if(!Validaciones.validarEmail(email)){
            return false;
        }
        Usuario usuario = userRepository.findByEmail(email);
        if(usuario == null){
            return false;
        }
        if(usuario.getIntentosFallidos() >= 3){
            usuario.setBloqueado(true);
            return true;
        }
        return false;
    }

    /**
     * Metodo para desbloquear un usuario bloqueado
     * @param email
     * @return boolean
     */
    @Override
    public void desbloquear(String email) {
        if(!Validaciones.validarEmail(email)){
            return;
        }
        Usuario usuario = userRepository.findByEmail(email);
        if(usuario.isBloqueado()){

        }
    }

}
