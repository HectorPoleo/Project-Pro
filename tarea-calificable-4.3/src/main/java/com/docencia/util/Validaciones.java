package com.docencia.util;

import com.docencia.model.Usuario;

public class Validaciones extends Usuario {

    public Validaciones(int id) {
        super(id);
    }

    public String validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (email.matches(regex)) {
            return "Email válido";
        } else {
            return "Email inválido";
        }
    }
}
