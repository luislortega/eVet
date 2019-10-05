/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import servicios.ConectarServicio;
import servicios.Conexion;

/**
 *
 * @author Luis
 */
public class InternalPanelBusqueda extends javax.swing.JInternalFrame {

    /**
     * Creates new form InternalPanelBusqueda
     */
    public InternalPanelBusqueda() {
        initComponents();
        txtID.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
           int key = e.getKeyCode();
            if (key == KeyEvent.VK_ENTER) {
                limpiarCampos();
                busqueda();
            }
        }
    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNomProp = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblNumTel = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        boxTipo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNomMasc = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        setIconifiable(true);
        setTitle("Buscar propietario");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Informacion"));

        jLabel1.setText("Nombre:");

        jLabel4.setText("Correo electronico:");

        jLabel5.setText("Numero de telefono:");

        jLabel6.setText("- Direccion del propietario -");

        lblNomProp.setForeground(new java.awt.Color(204, 0, 0));
        lblNomProp.setText("...");

        lblEmail.setForeground(new java.awt.Color(204, 0, 0));
        lblEmail.setText("...");

        lblNumTel.setForeground(new java.awt.Color(204, 0, 0));
        lblNumTel.setText("...");

        lblDireccion.setForeground(new java.awt.Color(204, 0, 0));
        lblDireccion.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumTel)
                            .addComponent(lblEmail)
                            .addComponent(lblNomProp)))
                    .addComponent(lblDireccion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNomProp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblNumTel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDireccion))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Tipo de mascota:");

        boxTipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        boxTipo.setForeground(new java.awt.Color(255, 0, 0));
        boxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perro", "Gato" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Nombre de la mascota:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("ID de la mascota:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utilitarios/iconBusq.png"))); // NOI18N
        jLabel2.setText("  Buscar propietario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );

        lblNomMasc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNomMasc.setForeground(new java.awt.Color(0, 0, 255));
        lblNomMasc.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(lblNomMasc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBuscar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(lblNomMasc)
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(108, 108, 108)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        limpiarCampos();
        busqueda();
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void busqueda(){
        String opcion = boxTipo.getSelectedItem().toString();
        String codigo = txtID.getText();
        if (!codigo.isEmpty()) {
            switch(opcion){
                case "Perro":
                    buscarPropPerro(codigo);
                    break;
                case "Gato":
                    buscarPropGato(codigo);
                    break;
            }
        }else{
            JOptionPane.showMessageDialog(null, "No has ingresado un ID");
            limpiarCampos();
        }
    }
    
    public void buscarPropPerro(String codigo){
        try {
            Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
            cdb.un_sql = "SELECT * FROM perros WHERE codigoQR='"+codigo+"';";
            cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
            
            while (cdb.resultado.next()) {                
                lblNomMasc.setText(cdb.resultado.getString(2));
                lblNomProp.setText(cdb.resultado.getString(4));
                lblEmail.setText(cdb.resultado.getString(5));
                lblNumTel.setText(cdb.resultado.getString(6));
                lblDireccion.setText(cdb.resultado.getString(7));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }
    
    public void buscarPropGato(String codigo){
        try {
            Conexion cdb = ConectarServicio.getInstancia().getConexionDb();
            cdb.un_sql = "SELECT * FROM gatos WHERE codigoQR='"+codigo+"';";
            cdb.resultado = cdb.us_st.executeQuery(cdb.un_sql);
            
            while (cdb.resultado.next()) {                
                lblNomMasc.setText(cdb.resultado.getString(2));
                lblNomProp.setText(cdb.resultado.getString(4));
                lblEmail.setText(cdb.resultado.getString(5));
                lblNumTel.setText(cdb.resultado.getString(6));
                lblDireccion.setText(cdb.resultado.getString(7));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    }
    
    public void limpiarCampos(){
        lblNomMasc.setText("...");
        lblNomProp.setText("...");
        lblEmail.setText("...");
        lblNumTel.setText("..."); 
        lblDireccion.setText("...");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNomMasc;
    private javax.swing.JLabel lblNomProp;
    private javax.swing.JLabel lblNumTel;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
