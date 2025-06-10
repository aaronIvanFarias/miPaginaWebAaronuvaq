package com.example;

import java.util.ListIterator;

//Administra la reproducción de canciones
class reproductor {
    private nodePlayList playlistActual;
    private ListIterator<Song> iterador;
    private boolean iniciado = false;

    public String reproducirSiguiente(nodePlayList playlist) {
        if (playlist == null || playlist.canciones.isEmpty()) {
            return "No hay canciones en la playlist.";
        }
        if (playlistActual != playlist || !iniciado) {
            playlistActual = playlist;
            iterador = playlist.canciones.listIterator();
            iniciado = true;
        }
        if (iterador.hasNext()) {
            return "Reproduciendo: \n" + iterador.next();
        } else {
            iterador = playlist.canciones.listIterator();
            return "Reiniciando playlist...\nReproduciendo: \n" + iterador.next();
        }
    }

    public void iniciarReproduccion(nodePlayList playlist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iniciarReproduccion'");
    }
}


