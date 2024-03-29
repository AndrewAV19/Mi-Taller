package mitaller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.*;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuBackup extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    public MenuBackup() {
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
        BTN_RealizarBackup = new javax.swing.JButton();
        BTN_IngresarBackup = new javax.swing.JButton();
        BTN_Regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        tiutulo_central.setText("Menu Backup");
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 169));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        BTN_RealizarBackup.setBackground(new java.awt.Color(255, 255, 255));
        BTN_RealizarBackup.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BTN_RealizarBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/backup2.png"))); // NOI18N
        BTN_RealizarBackup.setText("Realizar Backup");
        BTN_RealizarBackup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_RealizarBackupMouseClicked(evt);
            }
        });

        BTN_IngresarBackup.setBackground(new java.awt.Color(255, 255, 255));
        BTN_IngresarBackup.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        BTN_IngresarBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/backup2.png"))); // NOI18N
        BTN_IngresarBackup.setText("Ingresa Backup");
        BTN_IngresarBackup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_IngresarBackupMouseClicked(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(BTN_Regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTN_RealizarBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_IngresarBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(BTN_RealizarBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(BTN_IngresarBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BTN_Regresar))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 163, 860, 500));

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

    private void BTN_RealizarBackupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_RealizarBackupMouseClicked
        String dbHost = "localhost";
        String dbName = "tecnoauto";
        String dbUser = "root";
        String dbPass = "";

        String desktopPath = System.getProperty("user.home") + "/Desktop";

        String backupFileName = "mitaller.sql";
        String backupFilePath = desktopPath + "/" + backupFileName;

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "C:/xampp/mysql/bin/mysqldump.exe",
                    "--host=" + dbHost,
                    "--user=" + dbUser,
                    "--password=" + dbPass,
                    "--databases",
                    dbName
            );

            processBuilder.redirectOutput(ProcessBuilder.Redirect.to(new File(backupFilePath)));
            Process process = processBuilder.start();

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                JOptionPane.showMessageDialog(null, "Backup creado exitosamente en el escritorio.", "Backup Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al crear el backup.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear el backup.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_BTN_RealizarBackupMouseClicked

    private void BTN_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_RegresarMouseClicked
        this.setVisible(false);
        new MenuPrincipal().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_RegresarMouseClicked

    private void BTN_IngresarBackupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_IngresarBackupMouseClicked
        JOptionPane.showMessageDialog(null, "Para ingresar un Backup comuniquese con el Administrador.", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BTN_IngresarBackupMouseClicked

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
            java.util.logging.Logger.getLogger(MenuBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuBackup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_IngresarBackup;
    private javax.swing.JButton BTN_RealizarBackup;
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
