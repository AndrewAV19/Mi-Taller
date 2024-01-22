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

public class AñadirMecanico extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    public AñadirMecanico() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
    }

    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    public java.awt.Image getIconImage() {
        java.awt.Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/LogoMiTaller.png"));
        return retValue;
    }

    private void LimpiarTextos() {
        //id.setText(null);
        nombre.setText(null);
        //apellidos.setText(null);
        direccion.setText(null);
        correo.setText(null);
        telefono.setText(null);
        //telefono2.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo_izq = new javax.swing.JLabel();
        Titulo_izq = new javax.swing.JLabel();
        Titulo_central = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BTN_Regresar = new javax.swing.JButton();
        nombre_txt = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        direccion_txt = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        correo_txt = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        telefono_txt = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        BTN_Agregar = new javax.swing.JButton();
        tituloabajo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        Titulo_central.setText("Añadir Mecanico");
        jPanel1.add(Titulo_central, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 220));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTN_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        BTN_Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_RegresarMouseClicked(evt);
            }
        });
        jPanel2.add(BTN_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, -1, -1));

        nombre_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nombre_txt.setForeground(new java.awt.Color(255, 255, 255));
        nombre_txt.setText("Nombre");
        jPanel2.add(nombre_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        nombre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 210, 30));

        direccion_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        direccion_txt.setForeground(new java.awt.Color(255, 255, 255));
        direccion_txt.setText("Direccion");
        jPanel2.add(direccion_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        direccion.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jPanel2.add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 210, 30));

        correo_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        correo_txt.setForeground(new java.awt.Color(255, 255, 255));
        correo_txt.setText("Email");
        jPanel2.add(correo_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        correo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        correo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                correoFocusLost(evt);
            }
        });
        correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correoKeyTyped(evt);
            }
        });
        jPanel2.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 210, 30));

        telefono_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        telefono_txt.setForeground(new java.awt.Color(255, 255, 255));
        telefono_txt.setText("Celular");
        jPanel2.add(telefono_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        telefono.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });
        jPanel2.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 210, 30));

        BTN_Agregar.setBackground(new java.awt.Color(0, 102, 204));
        BTN_Agregar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        BTN_Agregar.setText("Agregar");
        BTN_Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_AgregarMouseClicked(evt);
            }
        });
        jPanel2.add(BTN_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));

        tituloabajo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tituloabajo.setForeground(new java.awt.Color(255, 255, 255));
        tituloabajo.setText("Mi Taller");
        jPanel2.add(tituloabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 710, 510));

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
        new MenuMecanicos().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_RegresarMouseClicked

    private void BTN_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_AgregarMouseClicked
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert into mecanico values(?,?,?,?,?)");

            //String ID = id.getText().trim();
            String Nombre = nombre.getText().trim();
            //String Apellido = apellidos.getText().trim();  
            String Direccion = direccion.getText().trim();
            String Correo = correo.getText().trim();
            String Telefono = telefono.getText().trim();
            //String Telefono2 = telefono2.getText().trim();

            if (Nombre.equals("") || Direccion.equals("") || Correo.equals("")
                    || Telefono.equals("")) {
                JOptionPane.showMessageDialog(this, "Uno o mas campos estan vacios, favor de llenarlos.", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
            } else {
                pst.setString(1, "0");
                pst.setString(2, nombre.getText().trim());
                //pst.setString(3, apellidos.getText().trim());
                pst.setString(3, direccion.getText().trim());
                pst.setString(4, correo.getText().trim());
                pst.setString(5, telefono.getText().trim());
                //pst.setString(7, telefono2.getText().trim());
                pst.executeUpdate();
                LimpiarTextos();
                JOptionPane.showMessageDialog(null, "Mecanico Guardado", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_AgregarMouseClicked

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

    private void correoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoFocusLost
        if (isEmail(correo.getText())) {

        } else {
            JOptionPane.showMessageDialog(null, "Email escrito incorrectamente", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
            correo.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_correoFocusLost

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c != (char) KeyEvent.VK_BACKSPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Solo se permiten números.", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
        } else {

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoKeyTyped

    private void correoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isUpperCase(c)) {
            evt.setKeyChar(Character.toLowerCase(c));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_correoKeyTyped

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
            java.util.logging.Logger.getLogger(AñadirMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AñadirMecanico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Agregar;
    private javax.swing.JButton BTN_Regresar;
    private javax.swing.JLabel Titulo_central;
    private javax.swing.JLabel Titulo_izq;
    private javax.swing.JLabel cerrar;
    private javax.swing.JTextField correo;
    private javax.swing.JLabel correo_txt;
    private javax.swing.JTextField direccion;
    private javax.swing.JLabel direccion_txt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo_izq;
    private javax.swing.JLabel minimizar;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombre_txt;
    private javax.swing.JTextField telefono;
    private javax.swing.JLabel telefono_txt;
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
