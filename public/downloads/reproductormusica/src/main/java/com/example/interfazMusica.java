package com.example;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class interfazMusica {
    static ArrayList<Song> canciones = new ArrayList<>();
    static managerPlayList playlistManager = new managerPlayList();
    static reproductor player = new reproductor();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reproductor de Música");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //TAMAÑO
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        // COLOR BACKGROUND
        panel.setBackground(new Color(0, 128, 128));

        JLabel titulo = new JLabel("REPRODUCTOR DE MÚSICA", SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);

        JButton btnCanciones = new JButton("Agregar Canciones");
        JButton btnPlaylists = new JButton("Agregar Playlists");
        JButton btnAsignar = new JButton("Asignar Canciones a una Playlist");
        JButton btnReproductor = new JButton("Reproduce tu Música");

        estilizarBoton(btnCanciones);
        estilizarBoton(btnPlaylists);
        estilizarBoton(btnAsignar);
        estilizarBoton(btnReproductor);

        panel.add(titulo);
        panel.add(btnCanciones);
        panel.add(btnPlaylists);
        panel.add(btnAsignar);
        panel.add(btnReproductor);

        frame.add(panel);
        frame.setVisible(true);

        btnCanciones.addActionListener(e -> mostrarVentanaAgregarCancion());
        btnPlaylists.addActionListener(e -> mostrarVentanaAgregarPlaylist());
        btnAsignar.addActionListener(e -> mostrarVentanaAsignarCanciones());
        btnReproductor.addActionListener(e -> mostrarVentanaReproducir());
    }

    
    public static void estilizarBoton(JButton boton) {
        boton.setForeground(Color.WHITE);
        boton.setBackground(new Color(0, 102, 102)); // COLOR BOTONES
    }

    // Esta ventana usa para agregar una nueva CANCIÓN
    static void mostrarVentanaAgregarCancion() {
        JTextField idField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField artistaField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Artista:"));
        panel.add(artistaField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Agregar canción",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int id = Integer.parseInt(idField.getText());
                String nombre = nombreField.getText();
                String artista = artistaField.getText();
                Song nueva = new Song(id, nombre, artista);
                canciones.add(nueva);
                JOptionPane.showMessageDialog(null, "Canción agregada: " + nueva);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID debe ser un número válido.");
            }
        }
    }

    // Esta ventana se usa para agregar una nueva PLAYLIST
    static void mostrarVentanaAgregarPlaylist() {
        JTextField nombreField = new JTextField();
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nombre de la Playlist:"));
        panel.add(nombreField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Agregar Playlist",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String nombre = nombreField.getText();
            playlistManager.agregarPlaylist(nombre);
            JOptionPane.showMessageDialog(null, "Playlist agregada: " + nombre);
        }
    }

    // Ventana para REPRODUCIR una canción
    static void mostrarVentanaReproducir() {
        String[] nombresPlaylists = playlistManager.obtenerNombresPlaylists();
        if (nombresPlaylists.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay playlists para reproducir.");
            return;
        }

        String seleccion = (String) JOptionPane.showInputDialog(null, "Selecciona una playlist:",
                "Reproducir", JOptionPane.PLAIN_MESSAGE, null, nombresPlaylists, nombresPlaylists[0]);

        if (seleccion != null) {
            nodePlayList seleccionada = playlistManager.buscarPlaylist(seleccion);
            String mensaje = player.reproducirSiguiente(seleccionada);
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    // Esta ventana se usa para asignar CANCIONES existentes a una PLAYLIST
    static void mostrarVentanaAsignarCanciones() {
        String[] nombresPlaylists = playlistManager.obtenerNombresPlaylists();
        if (nombresPlaylists.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay playlists disponibles.");
            return;
        }

        if (canciones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay canciones para asignar.");
            return;
        }

        String seleccionPlaylist = (String) JOptionPane.showInputDialog(null, "Selecciona una playlist:",
                "Asignar Canciones", JOptionPane.PLAIN_MESSAGE, null, nombresPlaylists, nombresPlaylists[0]);

        if (seleccionPlaylist == null) return;

        nodePlayList playlist = playlistManager.buscarPlaylist(seleccionPlaylist);
        if (playlist == null) {
            JOptionPane.showMessageDialog(null, "Playlist no encontrada.");
            return;
        }

        String[] nombresCanciones = new String[canciones.size()];
        for (int i = 0; i < canciones.size(); i++) {
            Song s = canciones.get(i);
            nombresCanciones[i] = s.id + " - " + s.nombre + " (" + s.artista + ")";
        }

        JList<String> listaCanciones = new JList<>(nombresCanciones);
        listaCanciones.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaCanciones);

        int result = JOptionPane.showConfirmDialog(null, scrollPane, "Selecciona canciones para agregar",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            int[] indicesSeleccionados = listaCanciones.getSelectedIndices();
            for (int i : indicesSeleccionados) {
                Song cancion = canciones.get(i);
                if (!playlist.canciones.contains(cancion)) {
                    playlist.canciones.add(cancion);
                }
            }
            JOptionPane.showMessageDialog(null, "Canciones agregadas a la playlist: " + seleccionPlaylist);
        }
    }
}
