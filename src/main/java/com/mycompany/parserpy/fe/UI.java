/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.parserpy.fe;

import com.mycompany.parserpy.be.Archivo;
import com.mycompany.parserpy.be.Parser;
import com.mycompany.parserpy.be.Token;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.text.StyledDocument;

/**
 *
 * @author romar
 */
public class UI extends javax.swing.JFrame {

    private Archivo archivo;
    ArrayList<Token> reporteTokens = new ArrayList();
    ArrayList<Token> reporteErrores = new ArrayList();
    StyledDocument doc1;
    StyledDocument doc2;

    /**
     * Creates new form NewJFrame
     */
    public UI() {
        initComponents();
        archivo = new Archivo();
        txtAreaCodigo.setEnabled(true);
        doc1 = txtAreaReporte.getStyledDocument();
        doc2 = txtAreaError.getStyledDocument();

        btnPlay.setVisible(false);
        lblReporte.setVisible(false);
        lblError.setVisible(false);
        btnLimpiar1.setVisible(false);
        btnLimpiar2.setVisible(false);
        btnLimpiar3.setVisible(false);
        jScrollPane1.setVisible(false);
        jScrollPane4.setVisible(false);
        jScrollPane3.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUI = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        lblReporte = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaCodigo = new javax.swing.JTextArea();
        btnLimpiar1 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        btnLimpiar3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaError = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaReporte = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        listTokens = new javax.swing.JList<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnMenuArchivo = new javax.swing.JMenu();
        btnMenuSeleccionarArchivo = new javax.swing.JMenuItem();
        btnMenuEscribirCodigo = new javax.swing.JMenuItem();
        btnMenuGrafico = new javax.swing.JMenu();
        btnMenuGenerarGrafico = new javax.swing.JMenuItem();
        btnMenuAyuda = new javax.swing.JMenu();
        btnMenuAcercaDe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlUI.setBackground(new java.awt.Color(153, 0, 51));
        pnlUI.setLayout(null);

        btnPlay.setBackground(new java.awt.Color(0, 0, 153));
        btnPlay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(255, 255, 255));
        btnPlay.setText("Iniciar Analisis Lexico\n");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        pnlUI.add(btnPlay);
        btnPlay.setBounds(660, 10, 180, 40);

        lblReporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReporte.setText("Reporte");
        pnlUI.add(lblReporte);
        lblReporte.setBounds(150, 250, 60, 30);

        lblError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblError.setText("Error");
        pnlUI.add(lblError);
        lblError.setBounds(150, 520, 34, 20);

        txtAreaCodigo.setColumns(20);
        txtAreaCodigo.setRows(5);
        jScrollPane3.setViewportView(txtAreaCodigo);

        pnlUI.add(jScrollPane3);
        jScrollPane3.setBounds(150, 50, 690, 200);

        btnLimpiar1.setBackground(new java.awt.Color(255, 255, 0));
        btnLimpiar1.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });
        pnlUI.add(btnLimpiar1);
        btnLimpiar1.setBounds(840, 220, 80, 30);

        btnLimpiar2.setBackground(new java.awt.Color(255, 255, 0));
        btnLimpiar2.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar2.setText("Limpiar");
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });
        pnlUI.add(btnLimpiar2);
        btnLimpiar2.setBounds(840, 460, 80, 30);

        btnLimpiar3.setBackground(new java.awt.Color(255, 255, 0));
        btnLimpiar3.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar3.setText("Limpiar");
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });
        pnlUI.add(btnLimpiar3);
        btnLimpiar3.setBounds(840, 620, 80, 30);

        jScrollPane1.setViewportView(txtAreaError);

        pnlUI.add(jScrollPane1);
        jScrollPane1.setBounds(150, 550, 690, 100);

        jScrollPane4.setViewportView(txtAreaReporte);

        pnlUI.add(jScrollPane4);
        jScrollPane4.setBounds(150, 280, 690, 230);

        listTokens.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Identificadores", "Aritmeticos", "Comparacion", "Logicos", "Asignacion", "Palabras Clave" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listTokens);

        pnlUI.add(jScrollPane2);
        jScrollPane2.setBounds(0, 40, 100, 120);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Identificadores", "Aritmeticos", "Comparacion", "Logicos", "Asignacion", "Palabras Clave" }));
        pnlUI.add(jComboBox1);
        jComboBox1.setBounds(0, 170, 120, 22);

        jButton1.setText("pintarReporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlUI.add(jButton1);
        jButton1.setBounds(190, 20, 170, 23);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        btnMenuArchivo.setText("Archivo");
        btnMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuArchivoActionPerformed(evt);
            }
        });

        btnMenuSeleccionarArchivo.setText("Seleccionar Archivo (Codigo Fuente)");
        btnMenuSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuSeleccionarArchivoActionPerformed(evt);
            }
        });
        btnMenuArchivo.add(btnMenuSeleccionarArchivo);

        btnMenuEscribirCodigo.setText("Escribir Codigo Fuente");
        btnMenuEscribirCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuEscribirCodigoActionPerformed(evt);
            }
        });
        btnMenuArchivo.add(btnMenuEscribirCodigo);

        jMenuBar1.add(btnMenuArchivo);

        btnMenuGrafico.setText("Grafico");
        btnMenuGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuGraficoActionPerformed(evt);
            }
        });

        btnMenuGenerarGrafico.setText("Generar Grafico");
        btnMenuGenerarGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuGenerarGraficoActionPerformed(evt);
            }
        });
        btnMenuGrafico.add(btnMenuGenerarGrafico);

        jMenuBar1.add(btnMenuGrafico);

        btnMenuAyuda.setText("Ayuda");
        btnMenuAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuAyudaActionPerformed(evt);
            }
        });
        jMenuBar1.add(btnMenuAyuda);

        btnMenuAcercaDe.setText("Acerca de ");
        btnMenuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuAcercaDeActionPerformed(evt);
            }
        });
        jMenuBar1.add(btnMenuAcercaDe);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUI, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUI, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuArchivoActionPerformed
        btnPlay.setVisible(true);
        txtAreaCodigo.setVisible(true);
        txtAreaError.setVisible(true);
        lblError.setVisible(true);
    }//GEN-LAST:event_btnMenuArchivoActionPerformed

    private void btnMenuGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuGraficoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuGraficoActionPerformed

    private void btnMenuAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuAyudaActionPerformed

    private void btnMenuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuAcercaDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuAcercaDeActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
        txtAreaReporte.setText("");
        txtAreaError.setText("");
        reporteTokens.clear();
        reporteErrores.clear();

        new Parser(reporteTokens, reporteErrores).analizar(txtAreaCodigo.getText());

        for (int i = 0; i < reporteTokens.size(); i++) {
            txtAreaReporte.setText(txtAreaReporte.getText() + reporteTokens.get(i).toString());
            //txtAreaReporte.setForeground(Color);

        }
        for (int i = 0; i < reporteErrores.size(); i++) {
            txtAreaError.setText(txtAreaError.getText() + reporteErrores.get(i).toString());
        }
        // txtAreaReporte.setBackground(Color.darkGray);
        //    txtAreaError.setBackground(Color.darkGray);
        btnLimpiar1.setEnabled(true);
        btnLimpiar2.setEnabled(true);
        btnLimpiar3.setEnabled(true);

    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnMenuSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuSeleccionarArchivoActionPerformed
        // TODO add your handling code here:
        btnPlay.setVisible(true);
        lblReporte.setVisible(true);
        lblError.setVisible(true);
        btnLimpiar1.setVisible(true);
        btnLimpiar2.setVisible(true);
        btnLimpiar3.setVisible(true);
        jScrollPane1.setVisible(true);
        jScrollPane4.setVisible(true);
        jScrollPane3.setVisible(true);
        String codigoFuenteLeido;
        codigoFuenteLeido = archivo.abrirArchivo();
        txtAreaCodigo.setText(codigoFuenteLeido);
        txtAreaCodigo.setEnabled(false);
        txtAreaCodigo.setBackground(Color.red);
        btnPlay.setEnabled(true);
    }//GEN-LAST:event_btnMenuSeleccionarArchivoActionPerformed

    private void btnMenuEscribirCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuEscribirCodigoActionPerformed
        // TODO add your handling code here:
        btnPlay.setVisible(true);
        lblReporte.setVisible(true);
        lblError.setVisible(true);
        btnLimpiar1.setVisible(true);
        btnLimpiar2.setVisible(true);
        btnLimpiar3.setVisible(true);
        jScrollPane1.setVisible(true);
        jScrollPane4.setVisible(true);
        jScrollPane3.setVisible(true);
        txtAreaCodigo.setEnabled(true);
        txtAreaCodigo.setBackground(Color.white);
        btnPlay.setEnabled(true);
    }//GEN-LAST:event_btnMenuEscribirCodigoActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        // TODO add your handling code here:
        txtAreaCodigo.setText("");
        txtAreaCodigo.setEnabled(true);
        txtAreaCodigo.setBackground(Color.white);
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        // TODO add your handling code here:
        txtAreaReporte.setText("");
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed
        // TODO add your handling code here:
        txtAreaError.setText("");
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    private void btnMenuGenerarGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuGenerarGraficoActionPerformed
        // TODO add your handling code here:
        btnPlay.setVisible(false);
        lblReporte.setVisible(false);
        lblError.setVisible(false);
        btnLimpiar1.setVisible(false);
        btnLimpiar2.setVisible(false);
        btnLimpiar3.setVisible(false);
        jScrollPane1.setVisible(false);
        jScrollPane4.setVisible(false);
        jScrollPane3.setVisible(false);
    }//GEN-LAST:event_btnMenuGenerarGraficoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println(reporteTokens.toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JMenu btnMenuAcercaDe;
    private javax.swing.JMenu btnMenuArchivo;
    private javax.swing.JMenu btnMenuAyuda;
    private javax.swing.JMenuItem btnMenuEscribirCodigo;
    private javax.swing.JMenuItem btnMenuGenerarGrafico;
    private javax.swing.JMenu btnMenuGrafico;
    private javax.swing.JMenuItem btnMenuSeleccionarArchivo;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblReporte;
    private javax.swing.JList<String> listTokens;
    private javax.swing.JPanel pnlUI;
    private javax.swing.JTextArea txtAreaCodigo;
    private javax.swing.JTextPane txtAreaError;
    private javax.swing.JTextPane txtAreaReporte;
    // End of variables declaration//GEN-END:variables
}
