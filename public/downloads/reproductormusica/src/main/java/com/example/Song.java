package com.example;

//Es el ID, la canción y el artista
//Devuelve la info de la canción
class Song {
    int id;
    String nombre;
    String artista;

    public Song(int id, String nombre, String artista) {
        this.id = id;
        this.nombre = nombre;
        this.artista = artista;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Canción: " + nombre + "\n" +
                "Artista: " + artista + "\n-----------------------";
    }
}