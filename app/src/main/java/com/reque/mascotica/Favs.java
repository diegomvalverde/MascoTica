package com.reque.mascotica;

public class Favs {
    private int idFav;
    private int idPublicacion;

    public Favs(int idFav, int idPublicacion) {
        this.idFav = idFav;
        this.idPublicacion = idPublicacion;
    }

    public int getIdFav() {
        return idFav;
    }

    public void setIdFav(int idFav) {
        this.idFav = idFav;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }
}
