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

public class ModificarUsuario extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    public void ConsultarCliente(JComboBox Clientes) {
        try {

            String[] datos = new String[2];
            String texto;
            String texto1;
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst1 = cn1.prepareStatement("select id,nombre from usuarios");

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

    public ModificarUsuario() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
        ConsultarCliente(id);

        nombre.setVisible(false);
        apellidos.setVisible(false);
        username.setVisible(false);
        pass.setVisible(false);
        cargo.setVisible(false);

        nombre_txt.setVisible(false);
        apellido_txt.setVisible(false);
        username_txt.setVisible(false);
        pass_txt.setVisible(false);
        pass_txt1.setVisible(false);

        BTN_Agregar.setVisible(true);
        BTN.setVisible(false);
    }

     public java.awt.Image getIconImage() {
        java.awt.Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/LogoMiTaller.png"));
        return retValue;
    }

    private void LimpiarTextos() {
        //ID.setText(null);
        nombre.setText(null);
        apellidos.setText(null);
        username.setText(null);
        pass.setText(null);
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
        id_txt = new javax.swing.JLabel();
        nombre_txt = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellido_txt = new javax.swing.JLabel();
        apellidos = new javax.swing.JTextField();
        username_txt = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        pass_txt = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        BTN_Agregar = new javax.swing.JButton();
        tituloabajo = new javax.swing.JLabel();
        BTN = new javax.swing.JButton();
        id = new javax.swing.JComboBox<>();
        pass_txt1 = new javax.swing.JLabel();
        cargo = new javax.swing.JComboBox<>();
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
        jPanel2.add(BTN_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, -1));

        id_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        id_txt.setForeground(new java.awt.Color(255, 255, 255));
        id_txt.setText("ID");
        jPanel2.add(id_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 16, -1, -1));

        nombre_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nombre_txt.setForeground(new java.awt.Color(255, 255, 255));
        nombre_txt.setText("Nombre");
        jPanel2.add(nombre_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        nombre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 210, 30));

        apellido_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        apellido_txt.setForeground(new java.awt.Color(255, 255, 255));
        apellido_txt.setText("Apellidos");
        jPanel2.add(apellido_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        apellidos.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidosKeyTyped(evt);
            }
        });
        jPanel2.add(apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 210, 30));

        username_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        username_txt.setForeground(new java.awt.Color(255, 255, 255));
        username_txt.setText("Username");
        jPanel2.add(username_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        username.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 210, 30));

        pass_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        pass_txt.setForeground(new java.awt.Color(255, 255, 255));
        pass_txt.setText("Cargo");
        jPanel2.add(pass_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        pass.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passFocusLost(evt);
            }
        });
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passKeyTyped(evt);
            }
        });
        jPanel2.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 210, 30));

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
        jPanel2.add(tituloabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, -1, -1));

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
        jPanel2.add(BTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        jPanel2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 210, 30));

        pass_txt1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        pass_txt1.setForeground(new java.awt.Color(255, 255, 255));
        pass_txt1.setText("Contraseña");
        jPanel2.add(pass_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Empleado" }));
        jPanel2.add(cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 210, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 710, 500));

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
        Titulo_central.setText("Modificar Usuario");
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
        new MenuUsuarios().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_RegresarMouseClicked

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')
                && (c != (char) KeyEvent.VK_BACKSPACE) && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Solo se permiten letras.", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
        } else {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreKeyTyped

    private void apellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidosKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')
                && (c != (char) KeyEvent.VK_BACKSPACE) && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Solo se permiten letras.", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
        } else {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidosKeyTyped

    private void passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_passFocusLost

    private void passKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_passKeyTyped

    private void BTN_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_AgregarMouseClicked
        try {

            nombre.setVisible(true);
            apellidos.setVisible(true);
            username.setVisible(true);
            pass.setVisible(true);
            cargo.setVisible(true);

            nombre_txt.setVisible(true);
            apellido_txt.setVisible(true);
            username_txt.setVisible(true);
            pass_txt.setVisible(true);
            pass_txt1.setVisible(true);

            BTN_Agregar.setVisible(false);
            BTN.setVisible(true);

            String clienteSeleccionado = (String) id.getSelectedItem();
            String[] datosCliente = clienteSeleccionado.split(" - ");
            String ID = datosCliente[0];

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from usuarios where id = ?");
            pst.setString(1, ID);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nombre.setText(rs.getString("nombre"));
                apellidos.setText(rs.getString("apellidos"));
                username.setText(rs.getString("username"));
                pass.setText(rs.getString("pass"));

                // Obtener el valor del cargo
                String cargoValue = rs.getString("cargo");

                // Configurar el valor del JComboBox "cargo"
                if ("administrador".equals(cargoValue)) {
                    cargo.setSelectedIndex(0); // Administrador es el primer elemento en el JComboBox
                } else if ("empleado".equals(cargoValue)) {
                    cargo.setSelectedIndex(1); // Empleado es el segundo elemento en el JComboBox
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                this.setVisible(false);
                new ModificarUsuario().setVisible(true);
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
            //String IDD = ID.getText().trim();
            String Nombre = nombre.getText().trim();
            String Apellido = apellidos.getText().trim();
            String USERNAME = username.getText().trim();
            String PASS = pass.getText().trim();

            String clienteSeleccionado = (String) id.getSelectedItem();
            String[] datosCliente = clienteSeleccionado.split(" - ");
            String ID = datosCliente[0];

            int car = 0;
            String CARGO = "";
            car = cargo.getSelectedIndex() + 1;
            if (car == 1) {
                CARGO = "administrador";
            }
            if (car == 2) {
                CARGO = "empleado";
            }

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("update usuarios set id = ?, nombre = ?, apellidos = ?, username = ?, pass = ?, cargo = ? where id = ?");

            pst.setString(1, ID);
            pst.setString(2, Nombre);
            pst.setString(3, Apellido);
            pst.setString(4, USERNAME);
            pst.setString(5, PASS);
            pst.setString(6, CARGO);
            pst.setString(7, ID);

            pst.executeUpdate();
            LimpiarTextos();
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            this.setVisible(false);
            new ModificarUsuario().setVisible(true);

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
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN;
    private javax.swing.JButton BTN_Agregar;
    private javax.swing.JButton BTN_Regresar;
    private javax.swing.JLabel Titulo_central;
    private javax.swing.JLabel Titulo_izq;
    private javax.swing.JLabel apellido_txt;
    private javax.swing.JTextField apellidos;
    private javax.swing.JComboBox<String> cargo;
    private javax.swing.JLabel cerrar;
    private javax.swing.JComboBox<String> id;
    private javax.swing.JLabel id_txt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo_izq;
    private javax.swing.JLabel minimizar;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombre_txt;
    private javax.swing.JTextField pass;
    private javax.swing.JLabel pass_txt;
    private javax.swing.JLabel pass_txt1;
    private javax.swing.JLabel tituloabajo;
    private javax.swing.JTextField username;
    private javax.swing.JLabel username_txt;
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
