package com.example;
import java.util.LinkedList;

//Nodo de las playlist, con punto anterior y siguiente
class nodePlayList {
    String nombre;
    LinkedList<Song> canciones;
    nodePlayList anterior, siguiente;

    public nodePlayList(String nombre) {
        this.nombre = nombre;
        this.canciones = new LinkedList<>();
    }
}