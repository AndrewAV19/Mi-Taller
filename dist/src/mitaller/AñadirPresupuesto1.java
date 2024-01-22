package mitaller;

import com.sun.glass.events.KeyEvent;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import javax.swing.DefaultCellEditor;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;

public class AñadirPresupuesto1 extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    DefaultTableModel table = new DefaultTableModel();
    private double IVA = 0.0;
    private double TOTAL_IVA = 0.0;
    private double totalActual = 0.0;
    private double totalAmount = 0.0;
    private HashMap<String, Integer> productosAgregados = new HashMap<>();

    public void ConsultarRefaccion(JComboBox Clientes) {
        try {

            String[] datos = new String[2];
            String texto;
            String texto1;
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst1 = cn1.prepareStatement("select id_refaccion,nombre from hoja_refacciones ORDER BY id_refaccion");

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

    public void ConsultarCliente(JComboBox Clientes) {
        try {

            String[] datos = new String[2];
            String texto;
            String texto1;
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst1 = cn1.prepareStatement("select rfc,nombre from clientes ORDER BY nombre");

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

    public void ConsultarAutomovil(JComboBox Clientes) {
        try {

            String[] datos = new String[2];
            String texto;
            String texto1;
            Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst1 = cn1.prepareStatement("select id,placas from entrada ORDER BY id DESC");

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

    public AñadirPresupuesto1() {
        this.setContentPane(fondo);
        initComponents();
        ConsultarCliente(rfc);
        ConsultarAutomovil(ID);
        ConsultarRefaccion(id);
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
        //total.setEditable(false);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        table.addColumn("ID Refacción");
        table.addColumn("Nombre");
        table.addColumn("Cantidad");
        table.addColumn("Precio");
        table.addColumn("Total");

        Tabla.setModel(table);

        int rowHeight = 30; // Define la altura deseada para las filas
        Tabla.setRowHeight(rowHeight);

        Tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) { // Botón derecho
                    int row = Tabla.rowAtPoint(e.getPoint());

                    if (row >= 0) {
                        int choice = JOptionPane.showConfirmDialog(AñadirPresupuesto1.this,
                                "¿Desea eliminar esta fila?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                        if (choice == JOptionPane.YES_OPTION) {
                            table.removeRow(row);
                            actualizarTotal();
                        }
                    }
                }
            }
        });

    }

     public java.awt.Image getIconImage() {
        java.awt.Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/LogoMiTaller.png"));
        return retValue;
    }

    private void actualizarTablaYTotal() {
        // Limpia la tabla
        while (table.getRowCount() > 0) {
            table.removeRow(0);
        }

        double totalAmount = 0.0;

        for (String producto : productosAgregados.keySet()) {
            int cantidad = productosAgregados.get(producto);

            // Obtener la información del producto y agregarla a la tabla
            try {
                Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
                PreparedStatement pst1 = cn1.prepareStatement("SELECT id_refaccion, nombre, precio FROM hoja_refacciones WHERE CONCAT(id_refaccion, ' - ', nombre) = ?");
                pst1.setString(1, producto);

                ResultSet rs1 = pst1.executeQuery();

                // Después de obtener la información del producto y el precio:
                if (rs1.next()) {
                    String idRefaccion = rs1.getString(1);
                    String nombreRefaccion = rs1.getString(2);
                    int precioRefaccion = rs1.getInt(3);
                    double totaal = 0.0;
                    totaal += (precioRefaccion * cantidad);

                    // Agregar el IVA al total
                    double iva = 0.16; // Porcentaje de IVA (16% en este ejemplo)
                    double totalConIva = totaal * (1 + iva);

                    // Agregar la información a la tabla "table"
                    Object[] rowData = {idRefaccion, nombreRefaccion, cantidad, precioRefaccion, totaal, totalConIva};
                    table.addRow(rowData);

                    // Actualiza el total
                    String totalString = this.total.getText();

                    // Remove currency symbols from the totalString
                    totalString = totalString.replace("$", "").replace(",", "");

                    double total = 0.0;
                    if (!totalString.isEmpty()) {
                        total = Double.parseDouble(totalString);
                    }
                    totalAmount += totalConIva;
                }
            } catch (SQLException e) {
                System.err.print(e);
            }
        }

        // Formatea el total con el formato de pesos mexicanos
        Locale locale = new Locale("es", "MX");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        String formattedTotal = currencyFormat.format(totalAmount);

        this.total.setText(formattedTotal);

        Tabla.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new JTextField()));

        // Agregar un listener para detectar cambios en el precio
        Tabla.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                if (column == 3) {  // Columna del precio
                    DefaultTableModel model = (DefaultTableModel) Tabla.getModel();
                    String precioString = (String) model.getValueAt(row, 3);
                    double nuevoPrecio = Double.parseDouble(precioString);

                    // Actualizar el total con el nuevo precio
                    double iva = 0.16;
                    int cantidad = (int) model.getValueAt(row, 2);
                    double totalConIva = nuevoPrecio * cantidad;
                    model.setValueAt(totalConIva, row, 4);
                    actualizarTotal();

                }

            }
        });
    }

    private void actualizarTotal() {
        double totalAmount = 0.0;

        for (int i = 0; i < table.getRowCount(); i++) {
            double totalConIva = (double) table.getValueAt(i, 4);
            totalAmount += totalConIva * 1.16;
        }

        Locale locale = new Locale("es", "MX");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        String formattedTotal = currencyFormat.format(totalAmount);

        this.total.setText(formattedTotal);
    }

    private void LimpiarTextos() {
        //id.setText(null);
        ((JTextField) fecha.getDateEditor().getUiComponent()).setText(null);
        //id_cliente.setText(null);
        forma_pago.setText(null);
        //placas.setText(null);
        total.setText(null);
        observaciones.setText(null);
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
        rfc_txt = new javax.swing.JLabel();
        nombre_txt = new javax.swing.JLabel();
        direccion_txt = new javax.swing.JLabel();
        correo_txt = new javax.swing.JLabel();
        forma_pago = new javax.swing.JTextField();
        telefono_txt = new javax.swing.JLabel();
        telefono2_txt = new javax.swing.JLabel();
        BTN_Agregar = new javax.swing.JButton();
        tituloabajo = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        observaciones = new javax.swing.JTextArea();
        rfc = new javax.swing.JComboBox<>();
        ID = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        id = new javax.swing.JComboBox<>();
        nombre_txt1 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        telefono2_txt1 = new javax.swing.JLabel();

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
        Titulo_central.setText("Añadir Presupuesto");
        jPanel1.add(Titulo_central, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BTN_X.png"))); // NOI18N
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        jPanel1.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, -10, -1, 50));

        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BTN_MINIMIZAR.png"))); // NOI18N
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        jPanel1.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, -10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 164));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTN_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        BTN_Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_RegresarMouseClicked(evt);
            }
        });
        jPanel2.add(BTN_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, -1, -1));

        rfc_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        rfc_txt.setForeground(new java.awt.Color(255, 255, 255));
        rfc_txt.setText("Observaciones");
        jPanel2.add(rfc_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        nombre_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nombre_txt.setForeground(new java.awt.Color(255, 255, 255));
        nombre_txt.setText("Refacciones & Mano de obra");
        jPanel2.add(nombre_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, -1, -1));

        direccion_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        direccion_txt.setForeground(new java.awt.Color(255, 255, 255));
        direccion_txt.setText("ID Cliente");
        jPanel2.add(direccion_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        correo_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        correo_txt.setForeground(new java.awt.Color(255, 255, 255));
        correo_txt.setText("Forma de Pago");
        jPanel2.add(correo_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        forma_pago.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        forma_pago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                forma_pagoFocusLost(evt);
            }
        });
        forma_pago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                forma_pagoKeyTyped(evt);
            }
        });
        jPanel2.add(forma_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 210, 30));

        telefono_txt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        telefono_txt.setForeground(new java.awt.Color(255, 255, 255));
        telefono_txt.setText("ID de entrada");
        jPanel2.add(telefono_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        telefono2_txt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        telefono2_txt.setForeground(new java.awt.Color(255, 255, 255));
        telefono2_txt.setText("Incluye IVA");
        jPanel2.add(telefono2_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 450, -1, -1));

        BTN_Agregar.setBackground(new java.awt.Color(0, 102, 204));
        BTN_Agregar.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        BTN_Agregar.setText("Agregar");
        BTN_Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_AgregarMouseClicked(evt);
            }
        });
        jPanel2.add(BTN_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, -1, -1));

        tituloabajo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tituloabajo.setForeground(new java.awt.Color(255, 255, 255));
        tituloabajo.setText("Mi Taller");
        jPanel2.add(tituloabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 480, -1, -1));

        fecha.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 210, 30));

        observaciones.setColumns(20);
        observaciones.setRows(5);
        jScrollPane1.setViewportView(observaciones);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 280, 180));

        jPanel2.add(rfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 210, 30));

        jPanel2.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 210, 30));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad", "Precio", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setHeaderValue("Codigo");
            Tabla.getColumnModel().getColumn(1).setHeaderValue("Descripcion");
            Tabla.getColumnModel().getColumn(2).setHeaderValue("Cantidad");
            Tabla.getColumnModel().getColumn(3).setHeaderValue("Precio");
            Tabla.getColumnModel().getColumn(4).setHeaderValue("Total");
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 540, 250));

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 180, 30));

        nombre_txt1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nombre_txt1.setForeground(new java.awt.Color(255, 255, 255));
        nombre_txt1.setText("Fecha");
        jPanel2.add(nombre_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        total.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        total.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 420, -1, -1));

        telefono2_txt1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        telefono2_txt1.setForeground(new java.awt.Color(255, 255, 255));
        telefono2_txt1.setText("Total:");
        jPanel2.add(telefono2_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 420, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1050, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        int a = JOptionPane.YES_NO_OPTION;
        int resultado = JOptionPane.showConfirmDialog(this, "¿DESEA SALIR?", "SALIR", a);
        if (resultado == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_cerrarMouseClicked

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked

    private void BTN_RegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_RegresarMouseClicked
        this.setVisible(false);
        new MenuPresupuesto().setVisible(true);
    }//GEN-LAST:event_BTN_RegresarMouseClicked

    private void forma_pagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_forma_pagoFocusLost

    }//GEN-LAST:event_forma_pagoFocusLost

    private void forma_pagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_forma_pagoKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')
                && (c != (char) KeyEvent.VK_BACKSPACE) && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Solo se permiten letras.", "Mi Taller", JOptionPane.INFORMATION_MESSAGE);
        } else {

        }
    }//GEN-LAST:event_forma_pagoKeyTyped

    private void BTN_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_AgregarMouseClicked
        try {
            actualizarTotal();

            String clienteSeleccionado = (String) rfc.getSelectedItem();
            String[] datosCliente = clienteSeleccionado.split(" - ");
            String RFC = datosCliente[0];

            String entradaSeleccionada = (String) ID.getSelectedItem();
            String[] datosEntrada = entradaSeleccionada.split(" - ");
            String ID = datosEntrada[0];

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert into presupuesto1 values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            String FECHA = ((JTextField) fecha.getDateEditor().getUiComponent()).getText();
            String FORMA_PAGO = forma_pago.getText().trim();
            String TOTAL = total.getText().trim();
            String totalLimpio = TOTAL.replaceAll("[^\\d.]", "");
            int totalEntero = (int) Double.parseDouble(totalLimpio);
            String OBSERVACIONES = observaciones.getText().trim();
            if (FORMA_PAGO.equals("") || OBSERVACIONES.equals("")) {
                JOptionPane.showMessageDialog(this, "Uno o más campos están vacíos, favor de llenarlos.", "Mi Taller",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                pst.setString(1, "0");
                pst.setString(2, ((JTextField) fecha.getDateEditor().getUiComponent()).getText());
                pst.setString(3, RFC);
                pst.setString(4, forma_pago.getText().trim());
                pst.setString(5, observaciones.getText().trim());
                pst.setString(6, ID);
                pst.setString(7, totalLimpio);

                pst.executeUpdate();

                // Obtener el id_presupuesto recién insertado
                ResultSet generatedKeys = pst.getGeneratedKeys();
                int id_presupuestoo = -1;
                if (generatedKeys.next()) {
                    id_presupuestoo = generatedKeys.getInt(1);
                }

                // Insertar en la tabla presupuesto
                for (int i = 0; i < Tabla.getRowCount(); i++) {
                    Connection cn1 = DriverManager.getConnection("jdbc:mysql://localhost/tecnoauto", "root", "");
                    PreparedStatement pst1 = cn1.prepareStatement("insert into presupuesto values(?,?,?,?)");

                    String RefaccionSeleccionada = (String) id.getSelectedItem();
                    String[] datosREF = RefaccionSeleccionada.split(" - ");
                    String ID1 = datosREF[0];

                    // Obtener los datos de la fila de la tabla
                    String codigo = Tabla.getValueAt(i, 0).toString();
                    String cantidad = Tabla.getValueAt(i, 2).toString();
                    String precio = Tabla.getValueAt(i, 3).toString();

                    pst1.setString(1, "0");
                    pst1.setString(2, String.valueOf(id_presupuestoo));
                    pst1.setString(3, codigo);
                    pst1.setString(4, cantidad);

                    pst1.executeUpdate();
                }
                JOptionPane.showMessageDialog(this, "Presupuesto creado correctamente.", "Mi Taller",
                        JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                new MenuPresupuesto().setVisible(true);

            }
        } catch (Exception e) {
            System.err.print(e);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_AgregarMouseClicked

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        String selectedItem = id.getSelectedItem().toString();

        if (selectedItem.isEmpty()) {
            return;
        }

        // Verifica si el producto ya está en el HashMap
        if (productosAgregados.containsKey(selectedItem)) {
            String cantidadString = JOptionPane.showInputDialog(this, "Cambiar cantidad a:", "Modificar cantidad", JOptionPane.INFORMATION_MESSAGE);

            // Verificar si el usuario ingresó una cantidad válida (número entero positivo)
            int cantidad;
            try {
                if (cantidadString == null || cantidadString.isEmpty()) {
                    return;
                }
                cantidad = Integer.parseInt(cantidadString);
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida (número entero positivo).", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida (número entero positivo).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Actualiza la cantidad en el HashMap
            productosAgregados.put(selectedItem, cantidad);

            // Actualiza la tabla y el total
            actualizarTablaYTotal();
        } else {
            // Si el producto no está en el HashMap, agrega uno nuevo
            String cantidadString = JOptionPane.showInputDialog(this, "Ingrese la cantidad deseada de " + selectedItem + ": ", "Cantidad", JOptionPane.INFORMATION_MESSAGE);

            int cantidad;
            try {
                if (cantidadString == null || cantidadString.isEmpty()) {
                    return;
                }
                cantidad = Integer.parseInt(cantidadString);
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida (número entero positivo).", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida (número entero positivo).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            productosAgregados.put(selectedItem, cantidad);
            actualizarTablaYTotal();
        }
    }//GEN-LAST:event_idActionPerformed

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
            java.util.logging.Logger.getLogger(AñadirPresupuesto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirPresupuesto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirPresupuesto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirPresupuesto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AñadirPresupuesto1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Agregar;
    private javax.swing.JButton BTN_Regresar;
    private javax.swing.JComboBox<String> ID;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel Titulo_central;
    private javax.swing.JLabel Titulo_izq;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel correo_txt;
    private javax.swing.JLabel direccion_txt;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JTextField forma_pago;
    private javax.swing.JComboBox<String> id;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logo_izq;
    private javax.swing.JLabel minimizar;
    private javax.swing.JLabel nombre_txt;
    private javax.swing.JLabel nombre_txt1;
    private javax.swing.JTextArea observaciones;
    private javax.swing.JComboBox<String> rfc;
    private javax.swing.JLabel rfc_txt;
    private javax.swing.JLabel telefono2_txt;
    private javax.swing.JLabel telefono2_txt1;
    private javax.swing.JLabel telefono_txt;
    private javax.swing.JLabel tituloabajo;
    private javax.swing.JLabel total;
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
