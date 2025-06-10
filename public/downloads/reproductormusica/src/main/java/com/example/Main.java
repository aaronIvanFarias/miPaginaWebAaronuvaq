package com.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Song> canciones = new ArrayList<>();
        managerPlayList playlistManager = new managerPlayList();
        reproductor reproductor = new reproductor();

        while (true) {
            System.out.println("----------------------------------");
            System.out.println("REPRODUCTOR DE MÚSICA:");
            System.out.println("Menú:");
            System.out.println("1. Agregar Canciones");
            System.out.println("2. Administrar Playlists");
            System.out.println("3. Reproductor");
            System.out.println("4. Salir");
            System.out.println("----------------------------------");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                //Agregar canciones
                case 1:
                    System.out.print("Ingresar el ID, Nombre y su Artista: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    String nombre = scanner.nextLine();
                    String artista = scanner.nextLine();
                    canciones.add(new Song(id, nombre, artista));
                    System.out.println("La canción fue agregada correctamente:");
                    for (Song s : canciones) {
                        System.out.println(s);
                    }
                    break;
                    //Administrar playlists
                case 2:
                    System.out.println("1. Agregar Playlist");
                    System.out.println("2. Agregar Canción a Playlist");
                    System.out.print("Elige una opción: ");
                    int subOpcion = scanner.nextInt();
                    scanner.nextLine();
                    if (subOpcion == 1) {
                        System.out.print("Ingresa el nombre de la nueva playlist: ");
                        String nombrePlaylist = scanner.nextLine();
                        playlistManager.agregarPlaylist(nombrePlaylist);
                    } else if (subOpcion == 2) {
                        System.out.print("Ingresa el nombre de la playlist: ");
                        String nombrePlaylist = scanner.nextLine();
                        System.out.print("Ingresa el ID de la canción: ");
                        int songId = scanner.nextInt();
                        scanner.nextLine();
                        Song cancion = canciones.stream().filter(s -> s.id == songId).findFirst().orElse(null);
                        if (cancion != null) {
                            playlistManager.agregarCancionAPlaylist(nombrePlaylist, cancion);
                        } else {
                            System.out.println("La canción no fue encontrada.");
                        }
                    }
                    break;
                    //Reproductor
                case 3:
                    System.out.print("Ingresa el nombre de la playlist a reproducir: ");
                    String playlistAReproducir = scanner.nextLine();
                    nodePlayList playlist = playlistManager.buscarPlaylist(playlistAReproducir);
                    reproductor.iniciarReproduccion(playlist);
                    break;
                    //Salir
                case 4:
                    System.out.println("Saliendo del reproductor de música, GRACIAS");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
