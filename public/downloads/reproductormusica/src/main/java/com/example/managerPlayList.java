package com.example;

import java.util.ArrayList;

//Administrar las playlist
class managerPlayList {
    private nodePlayList cabeza;

    //Hacer una nueva playlist
    public void agregarPlaylist(String nombre) {
        nodePlayList nueva = new nodePlayList(nombre);
        if (cabeza == null) {
            cabeza = nueva;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            nodePlayList cola = cabeza.anterior;
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
        }
    }

    //Agregar una nueva canción a la playlist
    public void agregarCancionAPlaylist(String nombrePlaylist, Song cancion) {
        nodePlayList playlist = buscarPlaylist(nombrePlaylist);
        if (playlist != null) {
            playlist.canciones.add(cancion);
            System.out.println("La canción fue agregada a la playlist " + nombrePlaylist);
        } else {
            System.out.println("La playlist no fue encontrada.");
        }
    }

    //Buscar en la playlist
    public nodePlayList buscarPlaylist(String nombre) {
        if (cabeza == null) return null;
        nodePlayList actual = cabeza;
        do {
            if (actual.nombre.equals(nombre)) return actual;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return null;
    }

    public String[] obtenerNombresPlaylists() {
        if (cabeza == null) return new String[0];
        ArrayList<String> nombres = new ArrayList<>();
        nodePlayList actual = cabeza;
        do {
            nombres.add(actual.nombre);
            actual = actual.siguiente;
        } while (actual != cabeza);
        return nombres.toArray(new String[0]);
    }
}


