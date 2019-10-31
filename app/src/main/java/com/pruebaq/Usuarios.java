package com.pruebaq;

import android.content.Context;
import android.database.Cursor;

public class Usuarios
{
    private Context context;

    private Long id;
    private String nombre;
    private int telefono;
    private String email;

    public Usuarios (Context context)
    {
        this.context = context;
    }


    public Usuarios (Context context, Long id, String nombre, int telefono, String email)
    {
        this.context = context;
        this.id =id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
