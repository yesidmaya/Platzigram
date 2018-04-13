package com.platzi.platzigram.modelo;

/**
 * Created by yesidmaya on 10/04/18.
 */

public class Picture {
    private String picture; // se la trabaja como string para que reciba una url de cualquier lugar y mostrarla
    private String userName;
    private String time;
    private String like_number = "0";

    // luego generamos nuestro constructor asi: en mac control + enter, escogemos constructor y en la siguiente pantalla escogemos todos los atributos

    public Picture(String picture, String userName, String time, String like_number) {
        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.like_number = like_number;
    }

    // creamos nuestros geters and seters: en mac control + enter y escogemos getters and setters y despues escogemos las dos primeras opciones


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLike_number() {
        return like_number;
    }

    public void setLike_number(String like_number) {
        this.like_number = like_number;
    }
}
