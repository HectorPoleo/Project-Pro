package com.docencia.repository.impl;

import java.util.HashSet;
import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;

/**
 * Clase UserRepositoryImpl
 * @author hectorpoleo
 * @version 1.0.0
 */
public class UserRepositoryImpl implements IUserRepository{
    final Set<Usuario> usuarios;
    public UserRepositoryImpl(){
        usuarios = new HashSet<>();
    }

    /**
     * Metodo para buscar por email
     * @param String email
     * @return usuario
     */
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

    /**
     * Metodo para añadir un usuario si no existe
     * @param Usuario usuario
     */
    @Override
    public void save(Usuario usuario) {
        if(usuario == null){
            throw new IllegalArgumentException();
        }
        if(existsByEmail(usuario.getEmail())){
            usuarios.add(usuario);
        }
    }


    /**
     * Metodo para saber si un usuario existe utilizando el email
     * @param String email
     * @return boolean true/false
     */
    @Override
    public boolean existsByEmail(String email) {
        if(email == null){
            return false;
        }
        if(usuarios.contains(new Usuario(email))){
            return true;
        }
        return false;
    }

    /**
     * Metodo para leer toda la lista de usuarios
     * @return usuarios
     */
    @Override
    public Set<Usuario> findAll() {
        return usuarios;
    }

    /**
     * Metodo para borrar un usuario por su email
     * @param String email
     * @return boolean true/false
     */
    @Override
    public boolean deleteByEmail(String email) {
        if(!existsByEmail(email)){
            return false;
        }
        Usuario usuarioBuscar = new Usuario(email);
        for (Usuario usuario : usuarios) {
            if(usuario.equals(usuarioBuscar)){
                usuarios.remove(usuario);
                return true;
            }
        }
        return false;
    }

}
