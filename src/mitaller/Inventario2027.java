package mitaller;

import com.sun.glass.events.KeyEvent;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Inventario2027 extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    public Inventario2027() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT SUM(presupuesto1.total) FROM presupuesto1 WHERE presupuesto1.fecha BETWEEN '2027-01-01' AND '2027-01-31'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double resultado = rs.getDouble(1);
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String resultadoFormateado = formatoMoneda.format(resultado);
                enero.setText(resultadoFormateado);
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT SUM(presupuesto1.total) FROM presupuesto1 WHERE presupuesto1.fecha BETWEEN '2027-02-01' AND '2027-02-28'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double resultado = rs.getDouble(1);
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String resultadoFormateado = formatoMoneda.format(resultado);
                febrero.setText(resultadoFormateado);
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT SUM(presupuesto1.total) FROM presupuesto1 WHERE presupuesto1.fecha BETWEEN '2027-03-01' AND '2027-03-31'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double resultado = rs.getDouble(1);
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String resultadoFormateado = formatoMoneda.format(resultado);
                marzo.setText(resultadoFormateado);
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT SUM(presupuesto1.total) FROM presupuesto1 WHERE presupuesto1.fecha BETWEEN '2027-04-01' AND '2027-04-30'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double resultado = rs.getDouble(1);
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String resultadoFormateado = formatoMoneda.format(resultado);
                abril.setText(resultadoFormateado);
            }

        } catch (Exception e) {
            System.err.print(e);
        }

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT SUM(presupuesto1.total) FROM presupuesto1 WHERE presupuesto1.fecha BETWEEN '2027-05-01' AND '2027-05-31'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double resultado = rs.getDouble(1);
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String resultadoFormateado = formatoMoneda.format(resultado);
                mayo.setText(resultadoFormateado);
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT SUM(presupuesto1.total) FROM presupuesto1 WHERE presupuesto1.fecha BETWEEN '2027-06-01' AND '2027-06-30'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double resultado = rs.getDouble(1);
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String resultadoFormateado = formatoMoneda.format(resultado);
                junio.setText(resultadoFormateado);
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT SUM(presupuesto1.total) FROM presupuesto1 WHERE presupuesto1.fecha BETWEEN '2027-07-01' AND '2027-07-31'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double resultado = rs.getDouble(1);
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String resultadoFormateado = formatoMoneda.format(resultado);
                julio.setText(resultadoFormateado);
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT SUM(presupuesto1.total) FROM presupuesto1 WHERE presupuesto1.fecha BETWEEN '2027-08-01' AND '2027-08-31'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double resultado = rs.getDouble(1);
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String resultadoFormateado = formatoMoneda.format(resultado);
                agosto.setText(resultadoFormateado);
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT SUM(presupuesto1.total) FROM presupuesto1 WHERE presupuesto1.fecha BETWEEN '2027-09-01' AND '2027-09-30'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double resultado = rs.getDouble(1);
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String resultadoFormateado = formatoMoneda.format(resultado);
                septiembre.setText(resultadoFormateado);
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT SUM(presupuesto1.total) FROM presupuesto1 WHERE presupuesto1.fecha BETWEEN '2027-10-01' AND '2027-10-31'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double resultado = rs.getDouble(1);
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String resultadoFormateado = formatoMoneda.format(resultado);
                octubre.setText(resultadoFormateado);
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT SUM(presupuesto1.total) FROM presupuesto1 WHERE presupuesto1.fecha BETWEEN '2027-11-01' AND '2027-11-30'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double resultado = rs.getDouble(1);
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String resultadoFormateado = formatoMoneda.format(resultado);
                noviembre.setText(resultadoFormateado);
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("SELECT SUM(presupuesto1.total) FROM presupuesto1 WHERE presupuesto1.fecha BETWEEN '2027-12-01' AND '2027-12-31'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                double resultado = rs.getDouble(1);
                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                String resultadoFormateado = formatoMoneda.format(resultado);
                diciembre.setText(resultadoFormateado);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2023 = new javax.swing.JButton();
        jButton2024 = new javax.swing.JButton();
        jButton2025 = new javax.swing.JButton();
        jButton2026 = new javax.swing.JButton();
        jButton2028 = new javax.swing.JButton();
        jButton2029 = new javax.swing.JButton();
        jButton2030 = new javax.swing.JButton();
        enero = new javax.swing.JLabel();
        febrero = new javax.swing.JLabel();
        marzo = new javax.swing.JLabel();
        mayo = new javax.swing.JLabel();
        abril = new javax.swing.JLabel();
        julio = new javax.swing.JLabel();
        junio = new javax.swing.JLabel();
        septiembre = new javax.swing.JLabel();
        agosto = new javax.swing.JLabel();
        octubre = new javax.swing.JLabel();
        noviembre = new javax.swing.JLabel();
        diciembre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        titulologo = new javax.swing.JLabel();
        tiutulo_central = new javax.swing.JLabel();
        cerrar = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        BTN_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        BTN_Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_RegresarMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mi Taller");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Noviembre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Marzo");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Febrero");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Abril");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mayo");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Junio");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Julio");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Agosto");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Septiembre");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Octubre");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Diciembre");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Enero");

        jButton2023.setBackground(new java.awt.Color(0, 102, 153));
        jButton2023.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2023.setText("2023");
        jButton2023.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2023MouseClicked(evt);
            }
        });

        jButton2024.setBackground(new java.awt.Color(0, 102, 153));
        jButton2024.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2024.setText("2024");
        jButton2024.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2024MouseClicked(evt);
            }
        });

        jButton2025.setBackground(new java.awt.Color(0, 102, 153));
        jButton2025.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2025.setText("2025");
        jButton2025.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2025MouseClicked(evt);
            }
        });

        jButton2026.setBackground(new java.awt.Color(0, 102, 153));
        jButton2026.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2026.setText("2026");
        jButton2026.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2026MouseClicked(evt);
            }
        });

        jButton2028.setBackground(new java.awt.Color(0, 102, 153));
        jButton2028.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2028.setText("2028");
        jButton2028.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2028MouseClicked(evt);
            }
        });
        jButton2028.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton2028KeyTyped(evt);
            }
        });

        jButton2029.setBackground(new java.awt.Color(0, 102, 153));
        jButton2029.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2029.setText("2029");
        jButton2029.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2029MouseClicked(evt);
            }
        });

        jButton2030.setBackground(new java.awt.Color(0, 102, 153));
        jButton2030.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2030.setText("2030");
        jButton2030.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2030MouseClicked(evt);
            }
        });

        enero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enero.setForeground(new java.awt.Color(255, 255, 255));
        enero.setText("$0.0");

        febrero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        febrero.setForeground(new java.awt.Color(255, 255, 255));
        febrero.setText("$0.0");

        marzo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        marzo.setForeground(new java.awt.Color(255, 255, 255));
        marzo.setText("$0.0");

        mayo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mayo.setForeground(new java.awt.Color(255, 255, 255));
        mayo.setText("$0.0");

        abril.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        abril.setForeground(new java.awt.Color(255, 255, 255));
        abril.setText("$0.0");

        julio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        julio.setForeground(new java.awt.Color(255, 255, 255));
        julio.setText("$0.0");

        junio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        junio.setForeground(new java.awt.Color(255, 255, 255));
        junio.setText("$0.0");

        septiembre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        septiembre.setForeground(new java.awt.Color(255, 255, 255));
        septiembre.setText("$0.0");

        agosto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        agosto.setForeground(new java.awt.Color(255, 255, 255));
        agosto.setText("$0.0");

        octubre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        octubre.setForeground(new java.awt.Color(255, 255, 255));
        octubre.setText("$0.0");

        noviembre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        noviembre.setForeground(new java.awt.Color(255, 255, 255));
        noviembre.setText("$0.0");

        diciembre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        diciembre.setForeground(new java.awt.Color(255, 255, 255));
        diciembre.setText("$0.0");

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
                .addGap(132, 132, 132)
                .addComponent(jButton2023)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2024)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2025)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2026)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2028)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2029)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2030)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enero)
                    .addComponent(julio))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(febrero)
                    .addComponent(agosto))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(marzo)
                    .addComponent(septiembre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(abril)
                    .addComponent(octubre))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(mayo)
                    .addComponent(noviembre))
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(diciembre)
                    .addComponent(junio)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enero)
                    .addComponent(febrero)
                    .addComponent(marzo)
                    .addComponent(abril)
                    .addComponent(mayo)
                    .addComponent(junio))
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(julio)
                    .addComponent(agosto)
                    .addComponent(septiembre)
                    .addComponent(octubre)
                    .addComponent(noviembre)
                    .addComponent(diciembre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2023)
                    .addComponent(jButton2024)
                    .addComponent(jButton2025)
                    .addComponent(jButton2026)
                    .addComponent(jButton2028)
                    .addComponent(jButton2029)
                    .addComponent(jButton2030))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addComponent(BTN_Regresar, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

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
        tiutulo_central.setText("Inventario 2027");
        jPanel1.add(tiutulo_central, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 854, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_RegresarMouseClicked
        this.setVisible(false);
        new MenuPrincipal().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_RegresarMouseClicked

    private void jButton2023MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2023MouseClicked
        this.setVisible(false);
        new Inventario().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2023MouseClicked

    private void jButton2024MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2024MouseClicked
        this.setVisible(false);
        new Inventario2024().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2024MouseClicked

    private void jButton2025MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2025MouseClicked
        this.setVisible(false);
        new Inventario2025().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2025MouseClicked

    private void jButton2026MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2026MouseClicked
        this.setVisible(false);
        new Inventario2026().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2026MouseClicked

    private void jButton2028MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2028MouseClicked
        this.setVisible(false);
        new Inventario2028().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2028MouseClicked

    private void jButton2028KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2028KeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2028KeyTyped

    private void jButton2029MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2029MouseClicked
        this.setVisible(false);
        new Inventario2029().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2029MouseClicked

    private void jButton2030MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2030MouseClicked
        this.setVisible(false);
        new Inventario2030().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2030MouseClicked

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
            java.util.logging.Logger.getLogger(Inventario2027.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario2027.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario2027.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario2027.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario2027().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Regresar;
    private javax.swing.JLabel abril;
    private javax.swing.JLabel agosto;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel diciembre;
    private javax.swing.JLabel enero;
    private javax.swing.JLabel febrero;
    private javax.swing.JButton jButton2023;
    private javax.swing.JButton jButton2024;
    private javax.swing.JButton jButton2025;
    private javax.swing.JButton jButton2026;
    private javax.swing.JButton jButton2028;
    private javax.swing.JButton jButton2029;
    private javax.swing.JButton jButton2030;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel julio;
    private javax.swing.JLabel junio;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel marzo;
    private javax.swing.JLabel mayo;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel noviembre;
    private javax.swing.JLabel octubre;
    private javax.swing.JLabel septiembre;
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
