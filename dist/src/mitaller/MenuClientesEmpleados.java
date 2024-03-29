package mitaller;

import com.sun.glass.events.KeyEvent;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Andrew
 */
public class MenuClientesEmpleados extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    public MenuClientesEmpleados() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
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

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        titulologo = new javax.swing.JLabel();
        tiutulo_central = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BTN_AñadirCli = new javax.swing.JButton();
        BTN_MostrarCli = new javax.swing.JButton();
        BTN_EditarCli = new javax.swing.JButton();
        BTN_EliminarCli = new javax.swing.JButton();
        BTN_Regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BTN_RFC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoMiTaller2.png"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        titulologo.setFont(new java.awt.Font("Arial", 2, 22)); // NOI18N
        titulologo.setForeground(new java.awt.Color(255, 255, 255));
        titulologo.setText("Mi Taller");
        jPanel1.add(titulologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        tiutulo_central.setFont(new java.awt.Font("Arial", 1, 44)); // NOI18N
        tiutulo_central.setForeground(new java.awt.Color(255, 255, 255));
        tiutulo_central.setText("Menu Clientes");
        jPanel1.add(tiutulo_central, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BTN_X.png"))); // NOI18N
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        jPanel1.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, -10, -1, 50));

        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BTN_MINIMIZAR.png"))); // NOI18N
        minimizar.setToolTipText("");
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        jPanel1.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, -10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 169));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        BTN_AñadirCli.setBackground(new java.awt.Color(255, 255, 255));
        BTN_AñadirCli.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BTN_AñadirCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/añadirCliente.png"))); // NOI18N
        BTN_AñadirCli.setText("Añadir Cliente");
        BTN_AñadirCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_AñadirCliMouseClicked(evt);
            }
        });

        BTN_MostrarCli.setBackground(new java.awt.Color(255, 255, 255));
        BTN_MostrarCli.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BTN_MostrarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tabla (1).png"))); // NOI18N
        BTN_MostrarCli.setText("Tabla Clientes");
        BTN_MostrarCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_MostrarCliMouseClicked(evt);
            }
        });

        BTN_EditarCli.setBackground(new java.awt.Color(255, 255, 255));
        BTN_EditarCli.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BTN_EditarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editarCliente.png"))); // NOI18N
        BTN_EditarCli.setText("Editar Cliente");
        BTN_EditarCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_EditarCliMouseClicked(evt);
            }
        });

        BTN_EliminarCli.setBackground(new java.awt.Color(255, 255, 255));
        BTN_EliminarCli.setFont(new java.awt.Font("Arial", 1, 23)); // NOI18N
        BTN_EliminarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminarUsuario.png"))); // NOI18N
        BTN_EliminarCli.setText("Eliminar Cliente");
        BTN_EliminarCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_EliminarCliMouseClicked(evt);
            }
        });
        BTN_EliminarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EliminarCliActionPerformed(evt);
            }
        });

        BTN_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        BTN_Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_RegresarMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mi Taller");

        BTN_RFC.setBackground(new java.awt.Color(255, 255, 255));
        BTN_RFC.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BTN_RFC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar_usuario.png"))); // NOI18N
        BTN_RFC.setText("Buscar por ID");
        BTN_RFC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_RFCMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(BTN_Regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTN_AñadirCli, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(BTN_EditarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTN_EliminarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_RFC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_MostrarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_AñadirCli)
                    .addComponent(BTN_RFC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 308, Short.MAX_VALUE)
                        .addComponent(BTN_Regresar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTN_EditarCli)
                            .addComponent(BTN_EliminarCli))
                        .addGap(42, 42, 42)
                        .addComponent(BTN_MostrarCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8))))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 163, 854, 490));

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
        new MenuPrincipalEmpleado().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_RegresarMouseClicked

    private void BTN_AñadirCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_AñadirCliMouseClicked
        this.setVisible(false);
        new AñadirClienteEmpleado().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_AñadirCliMouseClicked

    private void BTN_MostrarCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_MostrarCliMouseClicked
        this.setVisible(false);
        new MostrarClientesEmpleados().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_MostrarCliMouseClicked

    private void BTN_EliminarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EliminarCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_EliminarCliActionPerformed

    private void BTN_RFCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_RFCMouseClicked
        this.setVisible(false);
        new BuscarPK_ClienteEmpleado().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_RFCMouseClicked

    private void BTN_EditarCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_EditarCliMouseClicked
       JOptionPane.showMessageDialog(this, "Solo los administradores tienen acceso", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_EditarCliMouseClicked

    private void BTN_EliminarCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_EliminarCliMouseClicked
        JOptionPane.showMessageDialog(this, "Solo los administradores tienen acceso", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_EliminarCliMouseClicked

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
            java.util.logging.Logger.getLogger(MenuClientesEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuClientesEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuClientesEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuClientesEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuClientesEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_AñadirCli;
    private javax.swing.JButton BTN_EditarCli;
    private javax.swing.JButton BTN_EliminarCli;
    private javax.swing.JButton BTN_MostrarCli;
    private javax.swing.JButton BTN_RFC;
    private javax.swing.JButton BTN_Regresar;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel titulologo;
    private javax.swing.JLabel tiutulo_central;
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
