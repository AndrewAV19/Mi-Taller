package mitaller;

import com.sun.glass.events.KeyEvent;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ModificarEntrada extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    public void ConsultarEntrada(JComboBox<String> Entrada, String nombreCliente) {
        try {

            String[] datos = new String[2];
            String texto;
            String texto1;
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst1 = cn1.prepareStatement("select id,placas from entrada WHERE placas LIKE ? ORDER BY id DESC");
            pst1.setString(1, "%" + nombreCliente + "%");

            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {
                datos[0] = rs1.getString(1);
                datos[1] = rs1.getString(2);
                texto = datos[0] + " - " + datos[1];
                Entrada.addItem(texto);

            }

        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public void ConsultarVehiculo(JComboBox<String> VEHI, String nombreCliente) {
        try {

            String[] datos = new String[2];
            String texto;
            String texto1;
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst1 = cn1.prepareStatement("select placas,vehiculo from automovil WHERE placas LIKE ? ORDER BY placas");
            pst1.setString(1, "%" + nombreCliente + "%");

            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {
                datos[0] = rs1.getString(1);
                datos[1] = rs1.getString(2);
                texto = datos[0] + " - " + datos[1];
                VEHI.addItem(texto);

            }

        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public void ConsultarMecanico(JComboBox<String> MEC, String nombreCliente) {
        try {

            String[] datos = new String[2];
            String texto;
            String texto1;
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst1 = cn1.prepareStatement("select id_mecanico,nombre from mecanico WHERE nombre LIKE ? ORDER BY nombre");
            pst1.setString(1, "%" + nombreCliente + "%");

            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {
                datos[0] = rs1.getString(1);
                datos[1] = rs1.getString(2);
                texto = datos[0] + " - " + datos[1];
                MEC.addItem(texto);

            }

        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public ModificarEntrada() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
        // Asociar el KeyListener al campo de búsqueda
        buscarPlacas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                // Obtener el texto ingresado en el campo de búsqueda
                String nombreCliente = buscarPlacas.getText().trim();
                // Limpiar el JComboBox antes de realizar una nueva búsqueda
                Id.removeAllItems();
                // Realizar la consulta en la base de datos y actualizar el JComboBox
                ConsultarEntrada(Id, nombreCliente);
            }
        });

        // Cargar todos los clientes al JComboBox al inicio
        ConsultarEntrada(Id, "");
        // Asociar el KeyListener al campo de búsqueda
        buscarAuto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                // Obtener el texto ingresado en el campo de búsqueda
                String nombreCliente = buscarAuto.getText().trim();
                // Limpiar el JComboBox antes de realizar una nueva búsqueda
                PLACAS.removeAllItems();
                // Realizar la consulta en la base de datos y actualizar el JComboBox
                ConsultarVehiculo(PLACAS, nombreCliente);
            }
        });

        // Cargar todos los clientes al JComboBox al inicio
        ConsultarVehiculo(PLACAS, "");
        // Asociar el KeyListener al campo de búsqueda
        buscarMecanico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                // Obtener el texto ingresado en el campo de búsqueda
                String nombreCliente = buscarMecanico.getText().trim();
                // Limpiar el JComboBox antes de realizar una nueva búsqueda
                ID_MECANICO.removeAllItems();
                // Realizar la consulta en la base de datos y actualizar el JComboBox
                ConsultarMecanico(ID_MECANICO, nombreCliente);
            }
        });

        // Cargar todos los clientes al JComboBox al inicio
        ConsultarMecanico(ID_MECANICO, "");

        buscarAuto.setVisible(false);
        buscar_placastxt.setVisible(false);
        buscarMecanico.setVisible(false);
        buscar_mecanicotxt.setVisible(false);
        PLACAS.setVisible(false);
        FECHA_ENTRADA.setVisible(false);
        HORA_ENTRADA.setVisible(false);
        REPORTE.setVisible(false);
        ID_MECANICO.setVisible(false);

        placas_txt.setVisible(false);
        fecha_entrada_txt.setVisible(false);
        hora_entrada_txt.setVisible(false);
        reporte_txt.setVisible(false);
        id_mecanico_txt.setVisible(false);

        BTN_Agregar.setVisible(true);
        BTN.setVisible(false);
    }

     public java.awt.Image getIconImage() {
        java.awt.Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/LogoMiTaller.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        tituloabajo = new javax.swing.JLabel();
        BTN_Regresar = new javax.swing.JButton();
        id_txt = new javax.swing.JLabel();
        placas_txt = new javax.swing.JLabel();
        fecha_entrada_txt = new javax.swing.JLabel();
        hora_entrada_txt = new javax.swing.JLabel();
        reporte_txt = new javax.swing.JLabel();
        id_mecanico_txt = new javax.swing.JLabel();
        HORA_ENTRADA = new com.toedter.calendar.JDateChooser();
        FECHA_ENTRADA = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        REPORTE = new javax.swing.JTextArea();
        BTN_Agregar = new javax.swing.JButton();
        BTN = new javax.swing.JButton();
        Id = new javax.swing.JComboBox<>();
        PLACAS = new javax.swing.JComboBox<>();
        ID_MECANICO = new javax.swing.JComboBox<>();
        buscar_entradatxt = new javax.swing.JLabel();
        buscarPlacas = new javax.swing.JTextField();
        buscar_mecanicotxt = new javax.swing.JLabel();
        buscarMecanico = new javax.swing.JTextField();
        buscar_placastxt = new javax.swing.JLabel();
        buscarAuto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        logo_izq = new javax.swing.JLabel();
        Titulo_izq = new javax.swing.JLabel();
        Titulo_central = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloabajo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tituloabajo.setForeground(new java.awt.Color(255, 255, 255));
        tituloabajo.setText("Mi Taller");
        jPanel2.add(tituloabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, -1, -1));

        BTN_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        BTN_Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_RegresarMouseClicked(evt);
            }
        });
        jPanel2.add(BTN_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, -1));

        id_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        id_txt.setForeground(new java.awt.Color(255, 255, 255));
        id_txt.setText("ID de entrada");
        jPanel2.add(id_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        placas_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        placas_txt.setForeground(new java.awt.Color(255, 255, 255));
        placas_txt.setText("Placas");
        jPanel2.add(placas_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        fecha_entrada_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        fecha_entrada_txt.setForeground(new java.awt.Color(255, 255, 255));
        fecha_entrada_txt.setText("Fecha entrada");
        jPanel2.add(fecha_entrada_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        hora_entrada_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        hora_entrada_txt.setForeground(new java.awt.Color(255, 255, 255));
        hora_entrada_txt.setText("Hora entrada");
        jPanel2.add(hora_entrada_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        reporte_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        reporte_txt.setForeground(new java.awt.Color(255, 255, 255));
        reporte_txt.setText("Reporte");
        jPanel2.add(reporte_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        id_mecanico_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        id_mecanico_txt.setForeground(new java.awt.Color(255, 255, 255));
        id_mecanico_txt.setText("ID del mecanico");
        jPanel2.add(id_mecanico_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        HORA_ENTRADA.setDateFormatString("HH:mm:ss");
        jPanel2.add(HORA_ENTRADA, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 210, 30));

        FECHA_ENTRADA.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(FECHA_ENTRADA, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 210, 30));

        REPORTE.setColumns(20);
        REPORTE.setRows(5);
        jScrollPane1.setViewportView(REPORTE);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 210, -1));

        BTN_Agregar.setBackground(new java.awt.Color(0, 102, 204));
        BTN_Agregar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        BTN_Agregar.setText("Buscar");
        BTN_Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_AgregarMouseClicked(evt);
            }
        });
        jPanel2.add(BTN_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        BTN.setBackground(new java.awt.Color(0, 102, 204));
        BTN.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        BTN.setText("Actualizar");
        BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTNMouseClicked(evt);
            }
        });
        BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNActionPerformed(evt);
            }
        });
        jPanel2.add(BTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, -1, -1));

        jPanel2.add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 210, 30));

        jPanel2.add(PLACAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 210, 30));

        jPanel2.add(ID_MECANICO, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 210, -1));

        buscar_entradatxt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        buscar_entradatxt.setForeground(new java.awt.Color(255, 255, 255));
        buscar_entradatxt.setText("Buscar Placas");
        jPanel2.add(buscar_entradatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));
        jPanel2.add(buscarPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 170, 30));

        buscar_mecanicotxt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        buscar_mecanicotxt.setForeground(new java.awt.Color(255, 255, 255));
        buscar_mecanicotxt.setText("Buscar Mecanico");
        jPanel2.add(buscar_mecanicotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, -1));
        jPanel2.add(buscarMecanico, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 170, 30));

        buscar_placastxt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        buscar_placastxt.setForeground(new java.awt.Color(255, 255, 255));
        buscar_placastxt.setText("Buscar Placas");
        jPanel2.add(buscar_placastxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));
        jPanel2.add(buscarAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 170, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 710, 510));

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo_izq.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        logo_izq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoMiTaller2.png"))); // NOI18N
        jPanel1.add(logo_izq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Titulo_izq.setFont(new java.awt.Font("Arial", 2, 22)); // NOI18N
        Titulo_izq.setForeground(new java.awt.Color(255, 255, 255));
        Titulo_izq.setText("Mi Taller");
        jPanel1.add(Titulo_izq, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        Titulo_central.setFont(new java.awt.Font("Arial", 1, 44)); // NOI18N
        Titulo_central.setForeground(new java.awt.Color(255, 255, 255));
        Titulo_central.setText("Modificar Entrada");
        jPanel1.add(Titulo_central, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BTN_X.png"))); // NOI18N
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        jPanel1.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, -10, -1, 50));

        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BTN_MINIMIZAR.png"))); // NOI18N
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        jPanel1.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, -10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 164));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        int a = JOptionPane.YES_NO_OPTION;
        int resultado = JOptionPane.showConfirmDialog(this, "¿DESEA SALIR?", "SALIR", a);
        if (resultado == 0) {
            System.exit(0);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarMouseClicked

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setState(Login.ICONIFIED);
        // TODO add your handling code here:
    }//GEN-LAST:event_minimizarMouseClicked

    private void BTN_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_RegresarMouseClicked
        this.setVisible(false);
        new MenuVehiculos().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_RegresarMouseClicked

    private void BTN_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_AgregarMouseClicked
        try {

            String entradaSeleccionada = (String) Id.getSelectedItem();
            String[] datosCliente = entradaSeleccionada.split(" - ");
            String ID = datosCliente[0];

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from entrada where id = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                buscarAuto.setVisible(true);
                buscar_placastxt.setVisible(true);
                buscarMecanico.setVisible(true);
                buscar_mecanicotxt.setVisible(true);
                Id.setEnabled(false);
                buscarPlacas.setVisible(false);
                buscar_entradatxt.setVisible(false);

                //ID.setEditable(false);
                PLACAS.setVisible(true);
                //PLACAS.setEditable(false);
                FECHA_ENTRADA.setVisible(true);
                //((JTextField)FECHA_ENTRADA.getDateEditor().getUiComponent()).setEditable(false);
                HORA_ENTRADA.setVisible(true);
                //((JTextField)HORA_ENTRADA.getDateEditor().getUiComponent()).setEditable(false);
                REPORTE.setVisible(true);
                //REPORTE.setEditable(false);
                ID_MECANICO.setVisible(true);
                //ID_MECANICO.setEditable(false);

                placas_txt.setVisible(true);
                fecha_entrada_txt.setVisible(true);
                hora_entrada_txt.setVisible(true);
                reporte_txt.setVisible(true);
                id_mecanico_txt.setVisible(true);
                BTN_Agregar.setVisible(false);
                BTN.setVisible(true);

                ((JTextField) FECHA_ENTRADA.getDateEditor().getUiComponent()).setText(rs.getString("fecha_entrada"));
                ((JTextField) HORA_ENTRADA.getDateEditor().getUiComponent()).setText(rs.getString("hora_entrada"));
                REPORTE.setText(rs.getString("reporte"));
                //ID_MECANICO.setText(rs.getString("id_mecanico"));
                //PLACAS.setText(rs.getString("placas"));
                //ConsultarPlacasPorID(ID, PLACAS); 
                //ConsultarMecanicoPorID(ID, ID_MECANICO); 

                String Placa = rs.getString("entrada.placas");

                PreparedStatement pstVEH = cn.prepareStatement("SELECT vehiculo FROM automovil WHERE placas = ?");
                pstVEH.setString(1, Placa);
                ResultSet rsVEH = pstVEH.executeQuery();

                if (rsVEH.next()) {
                    String nombreCliente = rsVEH.getString("vehiculo");
                    PLACAS.setSelectedItem(Placa + " - " + nombreCliente);
                }

                String MECA = rs.getString("entrada.id_mecanico");

                PreparedStatement pstMEC = cn.prepareStatement("SELECT nombre FROM mecanico WHERE id_mecanico = ?");
                pstMEC.setString(1, MECA);
                ResultSet rsMEC = pstMEC.executeQuery();

                if (rsMEC.next()) {
                    String nombreCliente = rsMEC.getString("nombre");
                    ID_MECANICO.setSelectedItem(MECA + " - " + nombreCliente);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Entrada de vehiculo no encontrada", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                new ModificarEntrada().setVisible(true);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_AgregarMouseClicked

    private void BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTNMouseClicked
        try {
            String entradaSeleccionada = (String) Id.getSelectedItem();
            String[] datosCliente = entradaSeleccionada.split(" - ");
            String ID = datosCliente[0];

            String placaSeleccionada = (String) PLACAS.getSelectedItem();
            String[] datosPlaca = placaSeleccionada.split(" - ");
            String PLAC = datosPlaca[0];

            String MECSeleccionadO = (String) ID_MECANICO.getSelectedItem();
            String[] datosMEC = MECSeleccionadO.split(" - ");
            String MEC = datosMEC[0];

            String Fecha_entrada = ((JTextField) FECHA_ENTRADA.getDateEditor().getUiComponent()).getText();
            String Hora_entrada = ((JTextField) HORA_ENTRADA.getDateEditor().getUiComponent()).getText();
            String Reporte = REPORTE.getText().trim();

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("update entrada set id = ?, placas = ?, fecha_entrada = ?, hora_entrada = ?, reporte = ?, id_mecanico = ? where id = ?");
            pst.setString(1, ID);
            pst.setString(2, PLAC);
            pst.setString(3, Fecha_entrada);
            pst.setString(4, Hora_entrada);
            pst.setString(5, Reporte);
            pst.setString(6, MEC);
            pst.setString(7, ID);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            this.setVisible(false);
            new ModificarEntrada().setVisible(true);

        } catch (Exception e) {
            System.err.print(e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNMouseClicked

    private void BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ModificarEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarEntrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN;
    private javax.swing.JButton BTN_Agregar;
    private javax.swing.JButton BTN_Regresar;
    private com.toedter.calendar.JDateChooser FECHA_ENTRADA;
    private com.toedter.calendar.JDateChooser HORA_ENTRADA;
    private javax.swing.JComboBox<String> ID_MECANICO;
    private javax.swing.JComboBox<String> Id;
    private javax.swing.JComboBox<String> PLACAS;
    private javax.swing.JTextArea REPORTE;
    private javax.swing.JLabel Titulo_central;
    private javax.swing.JLabel Titulo_izq;
    private javax.swing.JTextField buscarAuto;
    private javax.swing.JTextField buscarMecanico;
    private javax.swing.JTextField buscarPlacas;
    private javax.swing.JLabel buscar_entradatxt;
    private javax.swing.JLabel buscar_mecanicotxt;
    private javax.swing.JLabel buscar_placastxt;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel fecha_entrada_txt;
    private javax.swing.JLabel hora_entrada_txt;
    private javax.swing.JLabel id_mecanico_txt;
    private javax.swing.JLabel id_txt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo_izq;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel placas_txt;
    private javax.swing.JLabel reporte_txt;
    private javax.swing.JLabel tituloabajo;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel {

        private Image imagen;

        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/fondo_principal.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

}
