/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicandchill;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author paul.luna
 */
public class ReproductorMp3 extends javax.swing.JFrame {

    File file;
    Media media;
    MediaPlayer mp;
    ArrayList<Cancion> canciones = new ArrayList<Cancion>();
    DefaultListModel modelo = new DefaultListModel();
    DefaultListModel modelo_lista = new DefaultListModel();
    int index;
    boolean interasion = false;
    Socket socket;
    private ObjectOutputStream os;
    private ObjectInputStream is;
    private Vector<String> listaConectados;
    private Thread hilo_e;
    private Usuario myUser;
    private HashMap<String, FicheroBuffer> ficherosRecibiendos = new HashMap<>();
    

    public ReproductorMp3() {
        
        initComponents();
        myUser = new Usuario();
        listaContactos.setModel(modelo_lista);
        this.getContentPane().setBackground(Color.BLACK);
        this.jPanel1.setBackground(Color.BLACK);
        this.reproductor.getContentPane().setBackground(Color.BLACK);
        this.jPanel2.setBackground(Color.BLACK);
        listaMusica.setModel(modelo);

        com.sun.javafx.application.PlatformImpl.startup(() -> {});
        
        eventos();

    }
    
    public void eventos(){
        jSlider1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                interasion = true;
                int x = e.getX();
                jSlider1.setValue((int) (media.getDuration().toSeconds() * x / jSlider1.getWidth()));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        jSlider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = jSlider1.getValue();
                System.out.println("slider value =" + valor + " inter = " + interasion);

                if (mp != null) {
                    if (interasion) {
                        interasion = false;
                        mp.seek(Duration.seconds(valor));
                    }
                    montActual.setText(formatDuration(mp.getCurrentTime()));
                }

            }
        });
        
        jSlider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double volumenActual = (double) jSlider2.getValue() / 100.0;
                System.out.println("+ " + volumenActual);
                mp.setVolume(volumenActual);

            }
        });
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reproductor = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nombreCancion = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jPanel3 = new javax.swing.JPanel();
        anterior = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        duratTotal = new javax.swing.JLabel();
        montActual = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        jPanel6 = new javax.swing.JPanel();
        siguiente = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        play_pause = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMusica = new javax.swing.JList<>();
        reproducir = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        borrarCancion = new javax.swing.JButton();
        enviarMusica = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ListaUsuarioConectados = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaContactos = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        registro_user = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nombre_usuario1 = new javax.swing.JTextField();
        jPasswordField3 = new javax.swing.JPasswordField();
        inicioSesion1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPasswordField4 = new javax.swing.JPasswordField();
        jPasswordField5 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre_usuario = new javax.swing.JTextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        inicioSesion = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        reproductor.setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/portada.png"))); // NOI18N

        nombreCancion.setForeground(new java.awt.Color(0, 204, 204));
        nombreCancion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreCancion.setText("-");
        nombreCancion.setMaximumSize(new java.awt.Dimension(227, 14));
        nombreCancion.setMinimumSize(new java.awt.Dimension(227, 14));
        nombreCancion.setPreferredSize(new java.awt.Dimension(227, 14));

        jSlider1.setBackground(new java.awt.Color(0, 0, 0));
        jSlider1.setForeground(new java.awt.Color(255, 255, 255));
        jSlider1.setValue(0);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        anterior.setBackground(new java.awt.Color(0, 0, 0));
        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anterior.png"))); // NOI18N
        anterior.setBorder(null);
        anterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anteriorMouseClicked(evt);
            }
        });
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        duratTotal.setForeground(new java.awt.Color(0, 204, 204));
        duratTotal.setText("02:35");

        montActual.setForeground(new java.awt.Color(0, 204, 204));
        montActual.setText("00:00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(montActual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(duratTotal))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(duratTotal)
                .addComponent(montActual))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volume2.png"))); // NOI18N

        jSlider2.setBackground(new java.awt.Color(0, 0, 0));
        jSlider2.setForeground(new java.awt.Color(255, 255, 255));
        jSlider2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSlider2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        siguiente.setBackground(new java.awt.Color(0, 0, 0));
        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/siguiente.png"))); // NOI18N
        siguiente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        siguiente.setBorderPainted(false);
        siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siguienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(siguiente, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        play_pause.setBackground(new java.awt.Color(0, 0, 0));
        play_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reproducir.png"))); // NOI18N
        play_pause.setBorder(null);
        play_pause.setBorderPainted(false);
        play_pause.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        play_pause.setOpaque(false);
        play_pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                play_pauseMouseClicked(evt);
            }
        });
        play_pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                play_pauseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(play_pause, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(play_pause, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nombreCancion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo (2) (1).jpeg"))); // NOI18N

        listaMusica.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaMusica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMusicaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaMusica);

        reproducir.setText("Reproducir Canción");
        reproducir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reproducirMouseClicked(evt);
            }
        });

        agregar.setText("Agregar Musica");
        agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarMouseClicked(evt);
            }
        });
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        borrarCancion.setText("Borrar Musica");
        borrarCancion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarCancionMouseClicked(evt);
            }
        });

        enviarMusica.setText("Enviar Musica");

        jButton1.setText("Limpiar lista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Busqueda General");

        javax.swing.GroupLayout reproductorLayout = new javax.swing.GroupLayout(reproductor.getContentPane());
        reproductor.getContentPane().setLayout(reproductorLayout);
        reproductorLayout.setHorizontalGroup(
            reproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reproductorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(reproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reproductorLayout.createSequentialGroup()
                        .addGroup(reproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reproducir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enviarMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(reproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(borrarCancion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        reproductorLayout.setVerticalGroup(
            reproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reproductorLayout.createSequentialGroup()
                .addGroup(reproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(reproductorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(reproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregar)
                            .addComponent(reproducir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(reproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(borrarCancion)
                            .addComponent(jButton2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(reproductorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(enviarMusica))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listaContactos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaContactos);

        jLabel6.setText("Selecciona el destino:");

        jButton4.setText("Confirmar Envio");

        javax.swing.GroupLayout ListaUsuarioConectadosLayout = new javax.swing.GroupLayout(ListaUsuarioConectados.getContentPane());
        ListaUsuarioConectados.getContentPane().setLayout(ListaUsuarioConectadosLayout);
        ListaUsuarioConectadosLayout.setHorizontalGroup(
            ListaUsuarioConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListaUsuarioConectadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ListaUsuarioConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(ListaUsuarioConectadosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        ListaUsuarioConectadosLayout.setVerticalGroup(
            ListaUsuarioConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListaUsuarioConectadosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ListaUsuarioConectadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        registro_user.setBackground(new java.awt.Color(0, 0, 0));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo (2) (1).jpeg"))); // NOI18N

        jLabel9.setForeground(new java.awt.Color(0, 204, 255));
        jLabel9.setText("Usuario: ");

        jLabel10.setForeground(new java.awt.Color(0, 204, 255));
        jLabel10.setText("Contraseña: ");

        inicioSesion1.setText("Registrarse");
        inicioSesion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioSesion1MouseClicked(evt);
            }
        });
        inicioSesion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioSesion1ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancelar");

        jLabel11.setForeground(new java.awt.Color(0, 204, 255));
        jLabel11.setText("E-mail:");

        jLabel12.setForeground(new java.awt.Color(0, 204, 255));
        jLabel12.setText("Repite Contraseña:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombre_usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(25, 25, 25))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordField4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordField5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(inicioSesion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(nombre_usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jPasswordField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicioSesion1)
                    .addComponent(jButton5))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout registro_userLayout = new javax.swing.GroupLayout(registro_user.getContentPane());
        registro_user.getContentPane().setLayout(registro_userLayout);
        registro_userLayout.setHorizontalGroup(
            registro_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registro_userLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registro_userLayout.setVerticalGroup(
            registro_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo (2) (1).jpeg"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("Usuario: ");

        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("Contraseña: ");

        inicioSesion.setText("Iniciar Sesión");
        inicioSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioSesionMouseClicked(evt);
            }
        });
        inicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioSesionActionPerformed(evt);
            }
        });

        jButton3.setText("Registrarse");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(25, 25, 25)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inicioSesion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicioSesion)
                    .addComponent(jButton3))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicioSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioSesionMouseClicked
        
        conectarServidor();
        
        this.reproductor.setVisible(true);
        this.reproductor.setSize(600, 485);
        
//        int resp = JOptionPane.showConfirmDialog(null, "¿Deseas buscar todas las canciones del dispositivo?","",JOptionPane.YES_NO_OPTION);
//        System.out.println("-"+resp);
//        
//        if(resp==1){ //no
//            System.out.println("entro");
//            this.reproductor.setVisible(true);
//            this.reproductor.setSize(600, 485);
//        }else{ // 0 si
//            File file = new File("C:\\");
//            System.out.println(file.getAbsoluteFile());
//            
//        }
        
    }//GEN-LAST:event_inicioSesionMouseClicked

    private String formatDuration(Duration d) {
        long seconds = (long) d.toSeconds();
        long HH = seconds / 3600;
        long MM = (seconds % 3600) / 60;
        long SS = seconds % 60;
        if (HH > 0) {
            return String.format("%02d:%02d:%02d", HH, MM, SS);
        }
        return String.format("%02d:%02d", MM, SS);
    }


    private void reproducirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reproducirMouseClicked

        String cadena = listaMusica.getSelectedValue();

        if (mp != null) {
            mp.stop();
        }

        if (cadena != null) {
            for (int x = 0; x < canciones.size(); x++) {
                if (canciones.get(x).getFichero().getName().equals(cadena)) {
                    index = x;
                    file = canciones.get(x).getFichero();
                    cargarCancion(file);

                    nombreCancion.setText(file.getName().replace(".mp3", ""));
                    play_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pausa.png")));
                    mp.play();
                }
            }
        }


    }//GEN-LAST:event_reproducirMouseClicked

    private void agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseClicked

        File[] names;
        Cancion newUsuario = new Cancion();
        JFileChooser fc = new JFileChooser();

        fc.setMultiSelectionEnabled(true);

        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".MP3", "mp3");
        fc.setFileFilter(filtro);

        int selection = fc.showOpenDialog(this);

        if (selection == JFileChooser.APPROVE_OPTION) {

            if (fc.getSelectedFiles().length == 0) {
                modelo.addElement(fc.getSelectedFile().getName());
                System.out.println("si agrego");
            } else {

                names = fc.getSelectedFiles();
                System.out.println("si entro " + names.length);
                for (int i = 0; i < names.length; i++) {
                    modelo.addElement(names[i].getName());
                    System.out.println("hey: " + names[i].getName());
                    Cancion usu = new Cancion();
                    usu.setFichero(names[i]);
                    canciones.add(usu);
                }
            }

        }


    }//GEN-LAST:event_agregarMouseClicked

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed

    }//GEN-LAST:event_anteriorActionPerformed

    private void play_pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_play_pauseActionPerformed

    }//GEN-LAST:event_play_pauseActionPerformed

    private void play_pauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_play_pauseMouseClicked
        Status status = null;
        if (mp != null) {
            status = mp.getStatus();
        }

        if (status == Status.PLAYING) {
            mp.pause();
            play_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reproducir.png")));
        }
        if (status == Status.PAUSED) {
            mp.play();
            play_pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pausa.png")));
        }
    }//GEN-LAST:event_play_pauseMouseClicked

    private void anteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anteriorMouseClicked
        // TODO add your handling code here:
        if (mp != null) {
            mp.stop();
            index--;
            if (index < 0) {
                index = canciones.size() - 1;
            }
            file = canciones.get(index).getFichero();
            cargarCancion(file);

            mp.play();
        }

    }//GEN-LAST:event_anteriorMouseClicked

    private void siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguienteMouseClicked
        if (mp != null) {
            mp.stop();
            index++;
            if (index == canciones.size()) {
                index = 0;
            }
            file = canciones.get(index).getFichero();
            cargarCancion(file);

            mp.play();
        }

    }//GEN-LAST:event_siguienteMouseClicked

    private void cargarCancion(File file) {

        nombreCancion.setText(file.getName().replace(".mp3", ""));
        media = new Media(file.toURI().toString());
        mp = new MediaPlayer(media);

        mp.setOnReady(new Runnable() {
            @Override
            public void run() {
                jSlider1.setMaximum((int) media.getDuration().toSeconds());
                duratTotal.setText(formatDuration(media.getDuration()));
            }
        });

        mp.currentTimeProperty().addListener(new javafx.beans.value.ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue observable, Duration oldValue, Duration newValue) {
                jSlider1.setValue((int) newValue.toSeconds());

            }
        });
        
        double volumenActual = (double) jSlider2.getValue() / 100.0;
        mp.setVolume(volumenActual);

    }


    private void borrarCancionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarCancionMouseClicked
        // TODO add your handling code here:
        String borrar_cancion = listaMusica.getSelectedValue();

//        if(mp.getStatus()){
//            
//        }
        for (int h = 0; h < canciones.size(); h++) {
            if (canciones.get(h).getFichero().getName().equals(borrar_cancion)) {
                canciones.remove(h);
                modelo.remove(h);
                index--;
                if (index < 0) {
                    index = canciones.size();
                }
            }
        }


    }//GEN-LAST:event_borrarCancionMouseClicked

    private void listaMusicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMusicaMouseClicked


    }//GEN-LAST:event_listaMusicaMouseClicked

    private void jSlider2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider2MouseClicked

        int x = evt.getX();
        jSlider2.setValue((int) (100 * x / jSlider2.getWidth()));

    }//GEN-LAST:event_jSlider2MouseClicked

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void inicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioSesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicioSesionActionPerformed

    private void inicioSesion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioSesion1MouseClicked
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_inicioSesion1MouseClicked

    private void inicioSesion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioSesion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicioSesion1ActionPerformed

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<File> buscarMusica(File root){
        ArrayList<File> musicas = new ArrayList<File>();
        File [] archivos=root.listFiles();

        if (archivos != null){
            for (File lista : archivos) {
                if (lista.isDirectory() && !lista.isHidden()) {
                    musicas.addAll(buscarMusica(lista));
                } else {
                    if (lista.getName().endsWith(".mp3")) {
                        musicas.add(lista);
                    }
                }
            }
        }
        return musicas;
    }
    
    
    public boolean conectarServidor(){
        
        myUser.setName(nombre_usuario.getText());
        FicheroParticionado ficheroVacio = new FicheroParticionado();
        ficheroVacio.setOrigen(myUser);
        
        try {
            socket = new Socket("localhost",8989);
            os = new ObjectOutputStream(socket.getOutputStream());
            is = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        if(socket != null){
            try {
                os.writeObject(ficheroVacio);
                return true;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        return false;
    }
    
    private void hilo_Receptor(){
        
        hilo_e = new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        FicheroParticionado fichero = (FicheroParticionado) is.readObject();
                        String protocolo = fichero.getProtocolo();
                        if(protocolo != null){
                            if(protocolo.startsWith("/fichero")){
                                String [] cadena = protocolo.split("\"");
                                String nombreFichero = cadena[1];
                                int tamaniofichero = Integer.parseInt(cadena[2]);
                                ficherosRecibiendos.put(nombreFichero, new FicheroBuffer(tamaniofichero));
                                //almacenarDatosFichero(nombreFichero,fichero.getDatos_music());
                            }
                            if(protocolo.startsWith("parte/")){
                                String [] cadena = protocolo.split("\"");
                                String nombreFichero = cadena[1];
                                int num_parte = Integer.parseInt(cadena[2]);
                                //almacenarDatosFichero(nombreFichero,new FicheroBuffer(tamaniofichero));
                                
                                
                            }
                            //TO DO: falta notificar que se recibio una cancion
                        }
                        
                        
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    } catch (ClassNotFoundException ex) {
                        System.out.println(ex.getMessage());
                    }
                    
                }
            }            
        };
        hilo_e.start();
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReproductorMp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReproductorMp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReproductorMp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReproductorMp3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReproductorMp3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame ListaUsuarioConectados;
    private javax.swing.JButton agregar;
    private javax.swing.JButton anterior;
    private javax.swing.JButton borrarCancion;
    private javax.swing.JLabel duratTotal;
    private javax.swing.JButton enviarMusica;
    private javax.swing.JButton inicioSesion;
    private javax.swing.JButton inicioSesion1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JPasswordField jPasswordField5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JList<String> listaContactos;
    private javax.swing.JList<String> listaMusica;
    private javax.swing.JLabel montActual;
    private javax.swing.JLabel nombreCancion;
    private javax.swing.JTextField nombre_usuario;
    private javax.swing.JTextField nombre_usuario1;
    private javax.swing.JButton play_pause;
    private javax.swing.JFrame registro_user;
    private javax.swing.JButton reproducir;
    private javax.swing.JFrame reproductor;
    private javax.swing.JButton siguiente;
    // End of variables declaration//GEN-END:variables
}
