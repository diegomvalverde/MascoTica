package com.reque.mascotica;

public class PropertyProfile {
    String imagenl;
    String descripcion;
    String numTelefono;
    int like;

    public PropertyProfile(String imagenl, String descripcion, String numTelefono, int like) {
        this.imagenl = imagenl;
        this.descripcion = descripcion;
        this.numTelefono = numTelefono;
        this.like = like;
    }

    public String getImagenl() {
        return imagenl;
    }

    public void setImagenl(String imagenl) {
        this.imagenl = imagenl;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}