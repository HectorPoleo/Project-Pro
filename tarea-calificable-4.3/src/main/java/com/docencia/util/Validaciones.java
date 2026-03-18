package com.docencia.util;

import java.util.regex.Pattern;

/**
 * Clase Validaciones
 * @author hectorpoleo
 * @version 1.0.0
 */
public class Validaciones{

    /**
     * Metodo para normalizar el email
     * @param email
     * @return String
     */
    public static String normalizarEmail(String email){
        if(email == null || email.isBlank()){
            return null;
        }
        return email.trim().toLowerCase();
    }

    /**
     * Metodo para inicializar cualquier valor que se vea afectado por mayus
     * @param valor
     * @return String
     */
    public static String normalizarValor(String valor) {
        if(valor == null || valor.isBlank()){
            return null;
        }
        return valor.trim();
    }

    /**
     * Metodo para validar email
     * @param email
     * @return boolean
     */
    public static boolean  validarEmail(String email) {
        email = normalizarEmail(email);
        System.out.println(email);
        if(email == null){
            return false;
        }
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex, email);
    }

    /**
     * Metodo para validar contraseñas
     * @param password
     * @return boolean
     */
    public static boolean validarPassword(String password){
        password = normalizarValor(password);
        if(password == null){
            return false;
        }
        String regex = "^.{6,}$";
        return Pattern.matches(regex, password);
    }

    /**
     * Metodo para validar nombre
     * @param nombre
     * @return boolean
     */
    public static boolean validarNombre(String nombre){
        nombre = normalizarValor(nombre);
        if(nombre == null){
            return false;
        }
        String regex = "^[A-Za-zÁÉÍÓÚáéíóúÑñ]{5,}$";
        return Pattern.matches(regex, nombre);
    }
}
