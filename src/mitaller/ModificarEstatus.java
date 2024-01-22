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

public class ModificarEstatus extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    public void ConsultarAutomovil(JComboBox<String> Clientes, String nombreCliente) {
        try {

            String[] datos = new String[2];
            String texto;
            String texto1;
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst1 = cn1.prepareStatement("select entrada.id,entrada.placas from entrada, estatus WHERE entrada.placas LIKE ? and entrada.id = estatus.placas and estatus.estado = 'Revision' ORDER BY entrada.id DESC");
            pst1.setString(1, "%" + nombreCliente + "%");

            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {
                datos[0] = rs1.getString(1);
                datos[1] = rs1.getString(2);
                texto = datos[0] + " - " + datos[1];
                Clientes.addItem(texto);

            }

        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public ModificarEstatus() {
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
                ConsultarAutomovil(Id, nombreCliente);
            }
        });

        // Cargar todos los clientes al JComboBox al inicio
        ConsultarAutomovil(Id, "");

        estado.setVisible(false);

        estado_txt.setVisible(false);

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
        BTN_Regresar = new javax.swing.JButton();
        placas_txt = new javax.swing.JLabel();
        estado_txt = new javax.swing.JLabel();
        BTN_Agregar = new javax.swing.JButton();
        tituloabajo = new javax.swing.JLabel();
        BTN = new javax.swing.JButton();
        estado = new javax.swing.JComboBox<>();
        Id = new javax.swing.JComboBox<>();
        buscar_entradatxt = new javax.swing.JLabel();
        buscarPlacas = new javax.swing.JTextField();
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

        BTN_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        BTN_Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_RegresarMouseClicked(evt);
            }
        });
        jPanel2.add(BTN_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, -1));

        placas_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        placas_txt.setForeground(new java.awt.Color(255, 255, 255));
        placas_txt.setText("ID de entrada");
        jPanel2.add(placas_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        estado_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        estado_txt.setForeground(new java.awt.Color(255, 255, 255));
        estado_txt.setText("Nombre");
        jPanel2.add(estado_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        BTN_Agregar.setBackground(new java.awt.Color(0, 102, 204));
        BTN_Agregar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        BTN_Agregar.setText("Buscar");
        BTN_Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_AgregarMouseClicked(evt);
            }
        });
        BTN_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AgregarActionPerformed(evt);
            }
        });
        jPanel2.add(BTN_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        tituloabajo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tituloabajo.setForeground(new java.awt.Color(255, 255, 255));
        tituloabajo.setText("Mi Taller");
        jPanel2.add(tituloabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, -1, -1));

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
        jPanel2.add(BTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En curso", "Concluido" }));
        jPanel2.add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 126, 210, 30));

        jPanel2.add(Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 210, 30));

        buscar_entradatxt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        buscar_entradatxt.setForeground(new java.awt.Color(255, 255, 255));
        buscar_entradatxt.setText("Buscar Placas");
        jPanel2.add(buscar_entradatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));
        jPanel2.add(buscarPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 170, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 710, 290));

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
        Titulo_central.setText("Modificar Estatus");
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

    private void BTN_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_RegresarMouseClicked
        this.setVisible(false);
        new MenuEstatus().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_RegresarMouseClicked

    private void BTN_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_AgregarMouseClicked
        try {
            buscar_entradatxt.setVisible(false);
            buscarPlacas.setVisible(false);
            Id.setEnabled(false);

            estado.setVisible(true);
            estado_txt.setVisible(true);
            BTN_Agregar.setVisible(false);
            BTN.setVisible(true);

            String entradaSeleccionada = (String) Id.getSelectedItem();
            String[] datosCliente = entradaSeleccionada.split(" - ");
            String ID = datosCliente[0];

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from estatus where placas = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                
                estado.setSelectedItem(0);

            } else {
                JOptionPane.showMessageDialog(null, "Estatus no encontrado");
                this.setVisible(false);
                new ModificarEstatus().setVisible(true);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_AgregarMouseClicked

    private void BTN_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AgregarActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_AgregarActionPerformed

    private void BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTNMouseClicked
        try {
            String entradaSeleccionada = (String) Id.getSelectedItem();
            String[] datosCliente = entradaSeleccionada.split(" - ");
            String ID = datosCliente[0];
            int est = 0;
            String ESTADO = "";

            est = estado.getSelectedIndex() + 1;
            if (est == 1) {
                ESTADO = "Revision";
            }
            if (est == 2) {
                ESTADO = "Concluido";
            }

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("update estatus set placas = '" + ID + "',estado = '" + ESTADO + "' where placas = '" + ID + "'");

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            this.setVisible(false);
            new ModificarEstatus().setVisible(true);

        } catch (Exception e) {
            System.err.print(e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNMouseClicked

    private void BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarEstatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarEstatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN;
    private javax.swing.JButton BTN_Agregar;
    private javax.swing.JButton BTN_Regresar;
    private javax.swing.JComboBox<String> Id;
    private javax.swing.JLabel Titulo_central;
    private javax.swing.JLabel Titulo_izq;
    private javax.swing.JTextField buscarPlacas;
    private javax.swing.JLabel buscar_entradatxt;
    private javax.swing.JLabel cerrar;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JLabel estado_txt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo_izq;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel placas_txt;
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