package com.docencia.service.impl;

import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.service.IUserService;
import com.docencia.util.Validaciones;

/**
 * Clase UserServiceImpl
 * @author hectorpoleo
 * @version 1.0.0
 */
public class UserServiceImpl implements IUserService{
    private final IUserRepository userRepository;

    /**
     * Inicilizador de IUserRepository
     * @param userRepository
     */
    public UserServiceImpl(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Metodo para crear un usuario y añadirlo a userRepository
     * @param id
     * @param nombre
     * @param email
     * @param password
     * @return Usuario
     */
    @Override
    public Usuario crearUsuario(int id, String nombre, String email, String password) {
        if(id <= 0 || !Validaciones.validarNombre(nombre) || !Validaciones.validarEmail(email) || !Validaciones.validarPassword(password)){
            return null;
        }
        userRepository.save(new Usuario(id, nombre, email, password));
        Usuario usuario = userRepository.findByEmail(email);
        if(usuario == null){
            return null;
        }
        return usuario;
    }

    /**
     * Metodo para leer la lista de usuarios de userRepository
     * @return Set<Usuario>
     */
    @Override
    public Set<Usuario> listarUsuarios() {
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    /**
     * Metodo para buscar un usuario por email
     * @param email
     * @return Usuario
     */
    @Override
    public Usuario buscarPorEmail(String email) {
        if(!Validaciones.validarEmail(email)){
            return null;
        }
        email = Validaciones.normalizarEmail(email);
        return userRepository.findByEmail(email);
    }

    /**
     * Metodo para eliminar un usuario de la lista de userRepository
     * @param email
     * @return boolean
     */
    @Override
    public boolean eliminarPorEmail(String email) {
        if(!Validaciones.validarEmail(email)){
            return false;
        }
        email = Validaciones.normalizarEmail(email);
        return userRepository.deleteByEmail(email);
    }

    /**
     * Metodo para cambiar el nombre de un usuario
     * @param email
     * @param nuevoNombre
     * @return Usuario
     */
    @Override
    public Usuario cambiarNombre(String email, String nuevoNombre) {
        if(!Validaciones.validarEmail(email) || !Validaciones.validarNombre(nuevoNombre)){
            return null;
        }
        Usuario usuarioAcambiar = userRepository.findByEmail(email);
        usuarioAcambiar.setNombre(nuevoNombre);
        userRepository.save(usuarioAcambiar);
        return usuarioAcambiar;
    }

    /**
     * Metodo para cambiar la contraseña de un usuario
     * @param email
     * @param nuevaPassword
     * @return Usuario
     */
    @Override
    public Usuario cambiarPassword(String email, String nuevaPassword) {
        if(!Validaciones.validarEmail(email) || !Validaciones.validarPassword(nuevaPassword)){
            return null;
        }
        Usuario usuarioAcambiar = userRepository.findByEmail(email);
        usuarioAcambiar.setPassword(nuevaPassword);
        userRepository.save(usuarioAcambiar);
        return usuarioAcambiar;
    }
}
