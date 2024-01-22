package mitaller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.*;
import javax.swing.JComboBox;

public class EliminarVehiculo extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    public void ConsultarAutomovil(JComboBox<String> Clientes, String nombreCliente) {
        try {

            String[] datos = new String[2];
            String texto;
            String texto1;
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst1 = cn1.prepareStatement("select placas,vehiculo from automovil WHERE placas LIKE ?");
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

    public EliminarVehiculo() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
        // Asociar el KeyListener al campo de búsqueda
        buscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                // Obtener el texto ingresado en el campo de búsqueda
                String nombreCliente = buscarCliente.getText().trim();
                // Limpiar el JComboBox antes de realizar una nueva búsqueda
                Placas.removeAllItems();
                // Realizar la consulta en la base de datos y actualizar el JComboBox
                ConsultarAutomovil(Placas, nombreCliente);
            }
        });

        // Cargar todos los clientes al JComboBox al inicio
        ConsultarAutomovil(Placas, "");

        vehiculo.setVisible(false);
        modelo.setVisible(false);
        color.setVisible(false);
        motor.setVisible(false);
        kilometraje.setVisible(false);
        rfc_cliente.setVisible(false);

        vehiculo_txt.setVisible(false);
        modelo_txt.setVisible(false);
        color_txt.setVisible(false);
        motor_txt.setVisible(false);
        kilometraje_txt.setVisible(false);
        rfc_cliente_txt.setVisible(false);
        color_txt.setVisible(false);
        nombre_cliente.setVisible(false);
        nombre_cliente_txt.setVisible(false);

        BTN_Agregar.setVisible(true);
        BTN.setVisible(false);
    }

     public java.awt.Image getIconImage() {
        java.awt.Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/LogoMiTaller.png"));
        return retValue;
    }

    private void LimpiarTextos() {
        //placas.setText(null);
        vehiculo.setText(null);
        modelo.setText(null);
        color.setText(null);
        motor.setText(null);
        kilometraje.setText(null);
        rfc_cliente.setText(null);
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
        tituloabajo = new javax.swing.JLabel();
        rfc_txt = new javax.swing.JLabel();
        vehiculo_txt = new javax.swing.JLabel();
        vehiculo = new javax.swing.JTextField();
        modelo_txt = new javax.swing.JLabel();
        modelo = new javax.swing.JTextField();
        color_txt = new javax.swing.JLabel();
        color = new javax.swing.JTextField();
        motor_txt = new javax.swing.JLabel();
        motor = new javax.swing.JTextField();
        kilometraje_txt = new javax.swing.JLabel();
        kilometraje = new javax.swing.JTextField();
        rfc_cliente_txt = new javax.swing.JLabel();
        rfc_cliente = new javax.swing.JTextField();
        BTN_Agregar = new javax.swing.JButton();
        BTN = new javax.swing.JButton();
        nombre_cliente_txt = new javax.swing.JLabel();
        nombre_cliente = new javax.swing.JTextField();
        Placas = new javax.swing.JComboBox<>();
        buscar_placastxt = new javax.swing.JLabel();
        buscarCliente = new javax.swing.JTextField();
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
        jPanel2.add(BTN_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, -1));

        tituloabajo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tituloabajo.setForeground(new java.awt.Color(255, 255, 255));
        tituloabajo.setText("Mi Taller");
        jPanel2.add(tituloabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, -1, -1));

        rfc_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        rfc_txt.setForeground(new java.awt.Color(255, 255, 255));
        rfc_txt.setText("Placas");
        jPanel2.add(rfc_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        vehiculo_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        vehiculo_txt.setForeground(new java.awt.Color(255, 255, 255));
        vehiculo_txt.setText("Vehiculo");
        jPanel2.add(vehiculo_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        vehiculo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jPanel2.add(vehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 210, 30));

        modelo_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        modelo_txt.setForeground(new java.awt.Color(255, 255, 255));
        modelo_txt.setText("Modelo");
        jPanel2.add(modelo_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        modelo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        modelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                modeloFocusLost(evt);
            }
        });
        modelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                modeloKeyTyped(evt);
            }
        });
        jPanel2.add(modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 210, 30));

        color_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        color_txt.setForeground(new java.awt.Color(255, 255, 255));
        color_txt.setText("Color");
        jPanel2.add(color_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        color.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        color.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                colorKeyTyped(evt);
            }
        });
        jPanel2.add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 210, 30));

        motor_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        motor_txt.setForeground(new java.awt.Color(255, 255, 255));
        motor_txt.setText("Motor");
        jPanel2.add(motor_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        motor.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        motor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                motorKeyTyped(evt);
            }
        });
        jPanel2.add(motor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 210, 30));

        kilometraje_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        kilometraje_txt.setForeground(new java.awt.Color(255, 255, 255));
        kilometraje_txt.setText("Kilometraje");
        jPanel2.add(kilometraje_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        kilometraje.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        kilometraje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kilometrajeKeyTyped(evt);
            }
        });
        jPanel2.add(kilometraje, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 210, 30));

        rfc_cliente_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        rfc_cliente_txt.setForeground(new java.awt.Color(255, 255, 255));
        rfc_cliente_txt.setText("ID Cliente");
        jPanel2.add(rfc_cliente_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        rfc_cliente.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        rfc_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rfc_clienteKeyTyped(evt);
            }
        });
        jPanel2.add(rfc_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 220, 30));

        BTN_Agregar.setBackground(new java.awt.Color(0, 102, 204));
        BTN_Agregar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        BTN_Agregar.setText("Buscar");
        BTN_Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_AgregarMouseClicked(evt);
            }
        });
        jPanel2.add(BTN_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        BTN.setBackground(new java.awt.Color(0, 102, 204));
        BTN.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        BTN.setText("Eliminar");
        BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTNMouseClicked(evt);
            }
        });
        jPanel2.add(BTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, -1, -1));

        nombre_cliente_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nombre_cliente_txt.setForeground(new java.awt.Color(255, 255, 255));
        nombre_cliente_txt.setText("Nombre Cliente");
        jPanel2.add(nombre_cliente_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, -1, -1));

        nombre_cliente.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        nombre_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_clienteKeyTyped(evt);
            }
        });
        jPanel2.add(nombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 210, 30));

        jPanel2.add(Placas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 210, 30));

        buscar_placastxt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        buscar_placastxt.setForeground(new java.awt.Color(255, 255, 255));
        buscar_placastxt.setText("Buscar Placas");
        jPanel2.add(buscar_placastxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));
        jPanel2.add(buscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 170, 30));

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
        Titulo_central.setText("Eliminar Vehiculo");
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
        new MenuVehiculos().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_RegresarMouseClicked

    private void BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTNMouseClicked
        try {
            String vehiculoSeleccionado = (String) Placas.getSelectedItem();
            String[] datosCliente = vehiculoSeleccionado.split(" - ");
            String Placas = datosCliente[0];

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("delete from automovil where placas = ?");

            pst.setString(1, Placas);
            pst.executeUpdate();

            LimpiarTextos();

            JOptionPane.showMessageDialog(null, "Automovil eliminado", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            new EliminarVehiculo().setVisible(true);
        } catch (Exception e) {
            System.err.print(e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BTNMouseClicked

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

    private void modeloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_modeloFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_modeloFocusLost

    private void modeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modeloKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_modeloKeyTyped

    private void colorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_colorKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_colorKeyTyped

    private void motorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_motorKeyTyped

    private void kilometrajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kilometrajeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_kilometrajeKeyTyped

    private void rfc_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rfc_clienteKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_rfc_clienteKeyTyped

    private void BTN_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_AgregarMouseClicked
        try {
            String vehiculoSeleccionado = (String) Placas.getSelectedItem();
            String[] datosCliente = vehiculoSeleccionado.split(" - ");
            String placas = datosCliente[0];

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from automovil where placas = ?");
            pst.setString(1, placas);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Mostrar información del automóvil
                Placas.setEnabled(false);
                buscar_placastxt.setVisible(false);
                buscarCliente.setVisible(false);
                vehiculo.setVisible(true);
                vehiculo.setEditable(false);
                modelo.setVisible(true);
                modelo.setEditable(false);
                color.setVisible(true);
                color.setEditable(false);
                motor.setVisible(true);
                motor.setEditable(false);
                kilometraje.setVisible(true);
                kilometraje.setEditable(false);
                rfc_cliente.setVisible(true);
                rfc_cliente.setEditable(false);
                vehiculo_txt.setVisible(true);
                modelo_txt.setVisible(true);
                color_txt.setVisible(true);

                motor_txt.setVisible(true);
                kilometraje_txt.setVisible(true);
                rfc_cliente_txt.setVisible(true);
                BTN_Agregar.setVisible(false);
                BTN.setVisible(true);
                vehiculo.setText(rs.getString("vehiculo"));
                modelo.setText(rs.getString("modelo"));
                color.setText(rs.getString("color"));
                motor.setText(rs.getString("motor"));
                kilometraje.setText(rs.getString("kilometraje"));
                rfc_cliente.setText(rs.getString("rfc_cliente"));

                // Obtener nombre del cliente
                String rfcCliente = rs.getString("rfc_cliente");
                PreparedStatement pst2 = cn.prepareStatement("select nombre from clientes where rfc = ?");
                pst2.setString(1, rfcCliente);
                ResultSet rs2 = pst2.executeQuery();
                if (rs2.next()) {
                    nombre_cliente.setVisible(true);
                    nombre_cliente.setEditable(false);
                    nombre_cliente_txt.setVisible(true);
                    nombre_cliente.setText(rs2.getString("nombre"));

                }
            } else {
                LimpiarTextos();
                JOptionPane.showMessageDialog(null, "Automovil no encontrado", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                new BuscarPK_Vehiculo().setVisible(true);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_AgregarMouseClicked

    private void nombre_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_clienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_clienteKeyTyped

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
            java.util.logging.Logger.getLogger(EliminarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN;
    private javax.swing.JButton BTN_Agregar;
    private javax.swing.JButton BTN_Regresar;
    private javax.swing.JComboBox<String> Placas;
    private javax.swing.JLabel Titulo_central;
    private javax.swing.JLabel Titulo_izq;
    private javax.swing.JTextField buscarCliente;
    private javax.swing.JLabel buscar_placastxt;
    private javax.swing.JLabel cerrar;
    private javax.swing.JTextField color;
    private javax.swing.JLabel color_txt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField kilometraje;
    private javax.swing.JLabel kilometraje_txt;
    private javax.swing.JLabel logo_izq;
    private javax.swing.JLabel minimizar;
    private javax.swing.JTextField modelo;
    private javax.swing.JLabel modelo_txt;
    private javax.swing.JTextField motor;
    private javax.swing.JLabel motor_txt;
    private javax.swing.JTextField nombre_cliente;
    private javax.swing.JLabel nombre_cliente_txt;
    private javax.swing.JTextField rfc_cliente;
    private javax.swing.JLabel rfc_cliente_txt;
    private javax.swing.JLabel rfc_txt;
    private javax.swing.JLabel tituloabajo;
    private javax.swing.JTextField vehiculo;
    private javax.swing.JLabel vehiculo_txt;
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
