/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package vista;

import controlador.DAO.peticiones.PeticionDao;
import controlador.DAO.SucursalDao;
import controlador.DAO.historiales.HistorialDao;
import controlador.SucursalControl;
import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;
import controlador.util.Utilidades;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Peticiones;
import modelo.Sucursal;
import vista.modeloTabla.ModeloTablaHistorial;
import vista.modeloTabla.ModeloTablaPetisiones;
import vista.modeloTabla.ModeloTablaSucursal;

/**
 *
 * @author andy
 */
public class JFromSucursal extends java.awt.Dialog {

    private SucursalControl control = new SucursalControl();
    private SucursalDao controDao = new SucursalDao();
    private ModeloTablaSucursal modelo = new ModeloTablaSucursal();
    private ModeloTablaPetisiones modeloP = new ModeloTablaPetisiones();
    private PeticionDao pd = new PeticionDao();
//    private ModeloTablaHistorial modeloH = new ModeloTablaHistorial();
//    private HistorialDao hist = new HistorialDao();

    /**
     * Creates new form JFromVentas
     */
    public JFromSucursal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarTabla();
    }

    private void cargarTabla() {
        modelo.setDatos(controDao.listar());
        tblTabla.setModel(modelo);
        tblTabla.updateUI();

        modeloP.setPeticion(pd.listar());
        tblPeticion.setModel(modeloP);
        tblPeticion.updateUI();

//        modeloH.setHistorial(hist.listar());
//        tblTablaH.setModel(modeloH);
//        tblTablaH.updateUI();

    }

    private void limpiar() {

        this.controDao.setSucursal(null);
        txtNombre.setText("");
        txtPeticion.setText("");
        cargarTabla();

    }

    private void guardarSucursal() {
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {

            try {
                controDao.getSucursal().setNombre(txtNombre.getText());
                controDao.guardar();
//                hist.guardarHistorial("Sucursal guardada" + LocalTime.now());
                limpiar();
            } catch (IOException ex) {
                Logger.getLogger(JFromSucursal.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Se a guardado", "OK", JOptionPane.INFORMATION_MESSAGE);
            limpiar();

        }
    }

    private void ventas() {

        try {

            int fila = tblTabla.getSelectedRow();

            if (fila >= 0) {
                Sucursal sucursal = modelo.getDatos().get(fila);
                if (sucursal != null) {
                    this.controDao.setSucursal(modelo.getDatos().get(fila));
                    this.control.setSucursal(controDao.getSucursal());
                    new JFromVentas(null, true, this.control).setVisible(true);
                    cargarTabla();
                    tblTabla.clearSelection();
                    this.controDao.modificar(this.controDao.getSucursal(), fila);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre de la sucursal", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una sucursal", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {

        }
    }

    private void mostrarMayorVenta() throws VacioException, PosicionException {
        JOptionPane.showMessageDialog(null, Utilidades.sucursalVentaMayor(controDao.listar()));
    }

    private void mostrarMenorVenta() throws VacioException, PosicionException {
        JOptionPane.showMessageDialog(null, Utilidades.sucursalVentaMenor(controDao.listar()));
    }

    private void peticion() {

        if (txtPeticion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene la peticion", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                pd.guardarPeticion(new Peticiones(txtPeticion.getText()));
                pd.listar();
                JOptionPane.showMessageDialog(null, "Se a guardado", "OK", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            limpiar();
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnGuardar1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        btnVenta = new javax.swing.JButton();
        btnMenorV = new javax.swing.JButton();
        btnMayorV = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtPeticion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPeticion = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Sucursal");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LLenar Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Nombre:");

        btnGuardar1.setText("Guardar");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnGuardar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sucursales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 0, 15), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(0, 102, 102));

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblTabla);

        btnVenta.setText("Venta");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        btnMenorV.setText("Menor Venta");
        btnMenorV.setToolTipText("");
        btnMenorV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenorVActionPerformed(evt);
            }
        });

        btnMayorV.setText("Mayor Venta");
        btnMayorV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMayorVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMenorV)
                        .addGap(25, 25, 25)
                        .addComponent(btnMayorV)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVenta)
                    .addComponent(btnMenorV)
                    .addComponent(btnMayorV))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Peticiones")));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblPeticion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblPeticion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPeticion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel3)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed

        guardarSucursal();
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        ventas();

    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnMayorVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMayorVActionPerformed
        try {
            // TODO add your handling code here:
            mostrarMayorVenta();
        } catch (VacioException ex) {
            Logger.getLogger(JFromSucursal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionException ex) {
            Logger.getLogger(JFromSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMayorVActionPerformed

    private void btnMenorVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenorVActionPerformed
        try {
            // TODO add your handling code here:
            mostrarMenorVenta();
        } catch (VacioException ex) {
            Logger.getLogger(JFromSucursal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionException ex) {
            Logger.getLogger(JFromSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMenorVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        peticion();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFromSucursal dialog = new JFromSucursal(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnMayorV;
    private javax.swing.JButton btnMenorV;
    private javax.swing.JButton btnVenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblPeticion;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeticion;
    // End of variables declaration//GEN-END:variables
}
