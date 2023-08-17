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
        txtAreaCodigo.setEnabled(false);
        btnPlay.setEnabled(false);
        btnLimpiarAreaCodigo.setEnabled(false);
        btnLimpiarAreaReporte.setEnabled(false);
        btnLimpiarAreaError.setEnabled(false);
        doc1 = txtAreaReporte.getStyledDocument();
        doc2 = txtAreaError.getStyledDocument();
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
        btnLimpiarAreaCodigo = new javax.swing.JButton();
        btnLimpiarAreaReporte = new javax.swing.JButton();
        btnLimpiarAreaError = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaReporte = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaError = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnMenuArchivo = new javax.swing.JMenu();
        btnMenuSeleccionarArchivo = new javax.swing.JMenuItem();
        btnMenuEscribirCodigo = new javax.swing.JMenuItem();
        btnMenuGenerarGrafico = new javax.swing.JMenu();
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
        btnPlay.setBounds(610, 20, 180, 40);

        lblReporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReporte.setText("Reporte");
        pnlUI.add(lblReporte);
        lblReporte.setBounds(100, 260, 60, 30);

        lblError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblError.setText("Error");
        pnlUI.add(lblError);
        lblError.setBounds(100, 510, 34, 20);

        txtAreaCodigo.setColumns(20);
        txtAreaCodigo.setRows(5);
        jScrollPane3.setViewportView(txtAreaCodigo);

        pnlUI.add(jScrollPane3);
        jScrollPane3.setBounds(100, 60, 690, 200);

        btnLimpiarAreaCodigo.setBackground(new java.awt.Color(255, 255, 0));
        btnLimpiarAreaCodigo.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarAreaCodigo.setText("Limpiar");
        btnLimpiarAreaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAreaCodigoActionPerformed(evt);
            }
        });
        pnlUI.add(btnLimpiarAreaCodigo);
        btnLimpiarAreaCodigo.setBounds(790, 230, 80, 30);

        btnLimpiarAreaReporte.setBackground(new java.awt.Color(255, 255, 0));
        btnLimpiarAreaReporte.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarAreaReporte.setText("Limpiar");
        btnLimpiarAreaReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAreaReporteActionPerformed(evt);
            }
        });
        pnlUI.add(btnLimpiarAreaReporte);
        btnLimpiarAreaReporte.setBounds(790, 470, 80, 30);

        btnLimpiarAreaError.setBackground(new java.awt.Color(255, 255, 0));
        btnLimpiarAreaError.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarAreaError.setText("Limpiar");
        btnLimpiarAreaError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAreaErrorActionPerformed(evt);
            }
        });
        pnlUI.add(btnLimpiarAreaError);
        btnLimpiarAreaError.setBounds(790, 630, 80, 30);

        jScrollPane4.setViewportView(txtAreaReporte);

        pnlUI.add(jScrollPane4);
        jScrollPane4.setBounds(100, 290, 690, 210);

        jScrollPane1.setViewportView(txtAreaError);

        pnlUI.add(jScrollPane1);
        jScrollPane1.setBounds(100, 540, 690, 120);

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

        btnMenuGenerarGrafico.setText("Generar Grafico");
        btnMenuGenerarGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuGenerarGraficoActionPerformed(evt);
            }
        });
        jMenuBar1.add(btnMenuGenerarGrafico);

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
            .addComponent(pnlUI, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
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

    private void btnMenuGenerarGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuGenerarGraficoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuGenerarGraficoActionPerformed

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
        btnLimpiarAreaCodigo.setEnabled(true);
        btnLimpiarAreaReporte.setEnabled(true);
        btnLimpiarAreaError.setEnabled(true);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnMenuSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuSeleccionarArchivoActionPerformed
        // TODO add your handling code here:
        String codigoFuenteLeido;
        codigoFuenteLeido = archivo.abrirArchivo();
        txtAreaCodigo.setText(codigoFuenteLeido);
        txtAreaCodigo.setEnabled(false);
        txtAreaCodigo.setBackground(Color.red);
        btnPlay.setEnabled(true);
    }//GEN-LAST:event_btnMenuSeleccionarArchivoActionPerformed

    private void btnMenuEscribirCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuEscribirCodigoActionPerformed
        // TODO add your handling code here:
        txtAreaCodigo.setEnabled(true);
        txtAreaCodigo.setBackground(Color.white);
        btnPlay.setEnabled(true);
    }//GEN-LAST:event_btnMenuEscribirCodigoActionPerformed

    private void btnLimpiarAreaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAreaCodigoActionPerformed
        // TODO add your handling code here:
        txtAreaCodigo.setText("");
        txtAreaCodigo.setEnabled(true);
        txtAreaCodigo.setBackground(Color.white);
    }//GEN-LAST:event_btnLimpiarAreaCodigoActionPerformed

    private void btnLimpiarAreaReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAreaReporteActionPerformed
        // TODO add your handling code here:
        txtAreaReporte.setText("");
    }//GEN-LAST:event_btnLimpiarAreaReporteActionPerformed

    private void btnLimpiarAreaErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAreaErrorActionPerformed
        // TODO add your handling code here:
        txtAreaError.setText("");
    }//GEN-LAST:event_btnLimpiarAreaErrorActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiarAreaCodigo;
    private javax.swing.JButton btnLimpiarAreaError;
    private javax.swing.JButton btnLimpiarAreaReporte;
    private javax.swing.JMenu btnMenuAcercaDe;
    private javax.swing.JMenu btnMenuArchivo;
    private javax.swing.JMenu btnMenuAyuda;
    private javax.swing.JMenuItem btnMenuEscribirCodigo;
    private javax.swing.JMenu btnMenuGenerarGrafico;
    private javax.swing.JMenuItem btnMenuSeleccionarArchivo;
    private javax.swing.JButton btnPlay;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblReporte;
    private javax.swing.JPanel pnlUI;
    private javax.swing.JTextArea txtAreaCodigo;
    private javax.swing.JTextPane txtAreaError;
    private javax.swing.JTextPane txtAreaReporte;
    // End of variables declaration//GEN-END:variables
}
