package com.mycompany.parserpy.fe;

import com.mycompany.parserpy.be.Archivo;
import com.mycompany.parserpy.be.Lexer;
import com.mycompany.parserpy.be.Parser;
import com.mycompany.parserpy.be.Parserdef;
import com.mycompany.parserpy.be.Token;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UI extends javax.swing.JFrame {

    private Archivo archivo;
    private ArrayList<Token> reporteTokens = new ArrayList();
    private ArrayList<Token> reporteErroresLexicos = new ArrayList();
    private ArrayList<String> reporteErroresSintacticos = new ArrayList();
    private Token elToken;

    /**
     * Creates new form NewJFrame
     */
    public UI() {
        initComponents();
        archivo = new Archivo();
        txtAreaCodigo.setEnabled(true);
        elToken = new Token();

        btnPlay.setVisible(false);
        lblReporte.setVisible(false);
        lblErrorLex.setVisible(false);
        lblErrorSint.setVisible(false);
        btnLimpiar1.setVisible(false);
        jScrollPane1.setVisible(false);
        jScrollPane4.setVisible(false);
        jScrollPane2.setVisible(false);

        comboBoxIdentificadores.setVisible(false);
        comboBoxAritmeticos.setVisible(false);
        comboBoxComparacion.setVisible(false);
        comboBoxLogicos.setVisible(false);
        comboBoxAsignacion.setVisible(false);
        comboBoxKW.setVisible(false);
        btnTablaSimbolos.setVisible(false);

        lblLexico.setVisible(false);
        lblSintactico.setVisible(false);
        divisor.setVisible(false);
        jScrollPane3.setVisible(false);
        //txtAreaReporteSint.setVisible(false);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

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
        lblErrorLex = new javax.swing.JLabel();
        btnLimpiar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaErrorLex = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAreaReporteLex = new javax.swing.JTextPane();
        comboBoxIdentificadores = new javax.swing.JComboBox<>();
        comboBoxAritmeticos = new javax.swing.JComboBox<>();
        comboBoxComparacion = new javax.swing.JComboBox<>();
        comboBoxLogicos = new javax.swing.JComboBox<>();
        comboBoxAsignacion = new javax.swing.JComboBox<>();
        comboBoxKW = new javax.swing.JComboBox<>();
        lblTitulo = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaCodigo = new javax.swing.JTextPane();
        btnTablaSimbolos = new javax.swing.JButton();
        divisor = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaErrorSint = new javax.swing.JTextPane();
        lblLexico = new javax.swing.JLabel();
        lblSintactico = new javax.swing.JLabel();
        lblErrorSint = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnMenuAnalizar = new javax.swing.JMenu();
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
        btnPlay.setText("Iniciar Analisis Lexico y Sintáctico");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        pnlUI.add(btnPlay);
        btnPlay.setBounds(750, 50, 290, 40);

        lblReporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReporte.setText("Reporte");
        pnlUI.add(lblReporte);
        lblReporte.setBounds(20, 440, 90, 20);

        lblErrorLex.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblErrorLex.setText("Error");
        pnlUI.add(lblErrorLex);
        lblErrorLex.setBounds(20, 690, 40, 17);

        btnLimpiar1.setBackground(new java.awt.Color(255, 255, 0));
        btnLimpiar1.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });
        pnlUI.add(btnLimpiar1);
        btnLimpiar1.setBounds(1040, 390, 90, 30);

        jScrollPane1.setViewportView(txtAreaErrorLex);

        pnlUI.add(jScrollPane1);
        jScrollPane1.setBounds(20, 710, 640, 100);

        jScrollPane4.setViewportView(txtAreaReporteLex);

        pnlUI.add(jScrollPane4);
        jScrollPane4.setBounds(20, 460, 640, 230);

        comboBoxIdentificadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Identificadores" }));
        comboBoxIdentificadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxIdentificadoresActionPerformed(evt);
            }
        });
        pnlUI.add(comboBoxIdentificadores);
        comboBoxIdentificadores.setBounds(20, 150, 120, 24);

        comboBoxAritmeticos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aritmeticos" }));
        comboBoxAritmeticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxAritmeticosActionPerformed(evt);
            }
        });
        pnlUI.add(comboBoxAritmeticos);
        comboBoxAritmeticos.setBounds(20, 170, 120, 24);

        comboBoxComparacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comparacion" }));
        comboBoxComparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxComparacionActionPerformed(evt);
            }
        });
        pnlUI.add(comboBoxComparacion);
        comboBoxComparacion.setBounds(20, 190, 120, 24);

        comboBoxLogicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Logicos" }));
        comboBoxLogicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxLogicosActionPerformed(evt);
            }
        });
        pnlUI.add(comboBoxLogicos);
        comboBoxLogicos.setBounds(20, 210, 120, 24);

        comboBoxAsignacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Asignacion" }));
        comboBoxAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxAsignacionActionPerformed(evt);
            }
        });
        pnlUI.add(comboBoxAsignacion);
        comboBoxAsignacion.setBounds(20, 230, 120, 24);

        comboBoxKW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Palabras Clave" }));
        comboBoxKW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxKWActionPerformed(evt);
            }
        });
        pnlUI.add(comboBoxKW);
        comboBoxKW.setBounds(20, 250, 120, 24);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 255, 51));
        lblTitulo.setText("PARSER-PY");
        pnlUI.add(lblTitulo);
        lblTitulo.setBounds(570, 20, 180, 40);
        pnlUI.add(lblImagen);
        lblImagen.setBounds(360, 130, 760, 470);

        jScrollPane2.setViewportView(txtAreaCodigo);

        pnlUI.add(jScrollPane2);
        jScrollPane2.setBounds(350, 90, 690, 330);

        btnTablaSimbolos.setBackground(new java.awt.Color(0, 153, 153));
        btnTablaSimbolos.setText("Ver Tabla Tokens");
        btnTablaSimbolos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaSimbolosActionPerformed(evt);
            }
        });
        pnlUI.add(btnTablaSimbolos);
        btnTablaSimbolos.setBounds(20, 90, 200, 40);

        divisor.setBackground(new java.awt.Color(0, 255, 255));
        divisor.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnlUI.add(divisor);
        divisor.setBounds(690, 430, 10, 390);

        jScrollPane3.setViewportView(txtAreaErrorSint);

        pnlUI.add(jScrollPane3);
        jScrollPane3.setBounds(710, 470, 630, 260);

        lblLexico.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        lblLexico.setText("Analísis Léxico");
        pnlUI.add(lblLexico);
        lblLexico.setBounds(250, 420, 120, 22);

        lblSintactico.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        lblSintactico.setText("Analísis Sintáctico");
        pnlUI.add(lblSintactico);
        lblSintactico.setBounds(910, 430, 160, 22);

        lblErrorSint.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        lblErrorSint.setText("Error");
        pnlUI.add(lblErrorSint);
        lblErrorSint.setBounds(720, 450, 37, 18);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        btnMenuAnalizar.setText("Analizar");
        btnMenuAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuAnalizarActionPerformed(evt);
            }
        });

        btnMenuSeleccionarArchivo.setText("Seleccionar Archivo (Codigo Fuente)");
        btnMenuSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuSeleccionarArchivoActionPerformed(evt);
            }
        });
        btnMenuAnalizar.add(btnMenuSeleccionarArchivo);

        btnMenuEscribirCodigo.setText("Escribir Codigo Fuente");
        btnMenuEscribirCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuEscribirCodigoActionPerformed(evt);
            }
        });
        btnMenuAnalizar.add(btnMenuEscribirCodigo);

        jMenuBar1.add(btnMenuAnalizar);

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlUI, javax.swing.GroupLayout.PREFERRED_SIZE, 1401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlUI, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuAnalizarActionPerformed
        btnPlay.setVisible(true);
        txtAreaCodigo.setVisible(true);
        txtAreaErrorLex.setVisible(true);
        txtAreaErrorSint.setVisible(true);
        lblErrorLex.setVisible(true);
        lblErrorSint.setVisible(true);
    }//GEN-LAST:event_btnMenuAnalizarActionPerformed

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
        txtAreaReporteLex.setText("");
        txtAreaErrorLex.setText("");
        txtAreaErrorSint.setText("");
        reporteTokens.clear();
        reporteErroresLexicos.clear();
        reporteErroresSintacticos.clear();

        new Lexer(reporteTokens, reporteErroresLexicos).analizar(txtAreaCodigo.getText());

        for (int i = 0; i < reporteTokens.size(); i++) {
            txtAreaReporteLex.setText(txtAreaReporteLex.getText() + reporteTokens.get(i).toString());
        }
        for (int i = 0; i < reporteErroresLexicos.size(); i++) {
            txtAreaErrorLex.setText(txtAreaErrorLex.getText() + reporteErroresLexicos.get(i).toString());
        }
        btnLimpiar1.setEnabled(true);
        elToken.llenarComboBox(reporteTokens, comboBoxIdentificadores, comboBoxAritmeticos, comboBoxComparacion,
                comboBoxLogicos, comboBoxAsignacion, comboBoxKW);
        elToken.colorearTokens(txtAreaReporteLex, reporteTokens);
        btnTablaSimbolos.setVisible(true);

        new Parserdef(reporteTokens, reporteErroresSintacticos).analizar();

        for (int i = 0; i < reporteErroresSintacticos.size(); i++) {
            txtAreaErrorSint.setText(txtAreaErrorSint.getText() + reporteErroresSintacticos.get(i).toString());
        }
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnMenuSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuSeleccionarArchivoActionPerformed
        // TODO add your handling code here:
        btnPlay.setVisible(true);
        lblReporte.setVisible(true);
        lblErrorLex.setVisible(true);
        lblErrorSint.setVisible(true);
        btnLimpiar1.setVisible(true);
        jScrollPane1.setVisible(true);
        jScrollPane4.setVisible(true);
        jScrollPane3.setVisible(true);
        jScrollPane2.setVisible(true);
        String codigoFuenteLeido;
        codigoFuenteLeido = archivo.abrirArchivo();
        txtAreaCodigo.setText(codigoFuenteLeido);
        txtAreaCodigo.setEnabled(false);
        txtAreaCodigo.setBackground(Color.red);
        btnPlay.setEnabled(true);
        lblSintactico.setVisible(true);
        lblLexico.setVisible(true);
        divisor.setVisible(true);

        comboBoxIdentificadores.setVisible(false);
        comboBoxAritmeticos.setVisible(false);
        comboBoxComparacion.setVisible(false);
        comboBoxLogicos.setVisible(false);
        comboBoxAsignacion.setVisible(false);
        comboBoxKW.setVisible(false);
        lblImagen.setVisible(false);
    }//GEN-LAST:event_btnMenuSeleccionarArchivoActionPerformed

    private void btnMenuEscribirCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuEscribirCodigoActionPerformed
        // TODO add your handling code here:
        btnPlay.setVisible(true);
        lblReporte.setVisible(true);
        lblErrorLex.setVisible(true);
        lblErrorSint.setVisible(true);
        btnLimpiar1.setVisible(true);
        jScrollPane1.setVisible(true);
        jScrollPane4.setVisible(true);
        jScrollPane3.setVisible(true);
        jScrollPane2.setVisible(true);
        txtAreaCodigo.setEnabled(true);
        txtAreaCodigo.setBackground(Color.white);
        btnPlay.setEnabled(true);

        comboBoxIdentificadores.setVisible(false);
        comboBoxAritmeticos.setVisible(false);
        comboBoxComparacion.setVisible(false);
        comboBoxLogicos.setVisible(false);
        comboBoxAsignacion.setVisible(false);
        comboBoxKW.setVisible(false);
        lblImagen.setVisible(false);
    }//GEN-LAST:event_btnMenuEscribirCodigoActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        // TODO add your handling code here:
        txtAreaCodigo.setText("");
        txtAreaCodigo.setEnabled(true);
        txtAreaCodigo.setBackground(Color.white);
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnMenuGenerarGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuGenerarGraficoActionPerformed
        // TODO add your handling code here:
        btnPlay.setVisible(false);
        lblReporte.setVisible(false);
        lblErrorLex.setVisible(false);
        btnLimpiar1.setVisible(false);
        jScrollPane1.setVisible(false);
        jScrollPane4.setVisible(false);
        jScrollPane2.setVisible(false);

        comboBoxIdentificadores.setVisible(true);
        comboBoxAritmeticos.setVisible(true);
        comboBoxComparacion.setVisible(true);
        comboBoxLogicos.setVisible(true);
        comboBoxAsignacion.setVisible(true);
        comboBoxKW.setVisible(true);
        lblImagen.setVisible(true);
    }//GEN-LAST:event_btnMenuGenerarGraficoActionPerformed

    private void comboBoxIdentificadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxIdentificadoresActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) comboBoxIdentificadores.getSelectedItem();
        System.out.println("Selected Item: " + selectedItem);
        elToken.generarGrafica(selectedItem);
        archivo.mostrarImagen(lblImagen);
    }//GEN-LAST:event_comboBoxIdentificadoresActionPerformed

    private void comboBoxAritmeticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAritmeticosActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) comboBoxAritmeticos.getSelectedItem();
        System.out.println("Selected Item: " + selectedItem);
        elToken.generarGrafica(selectedItem);
        archivo.mostrarImagen(lblImagen);
    }//GEN-LAST:event_comboBoxAritmeticosActionPerformed

    private void comboBoxComparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxComparacionActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) comboBoxComparacion.getSelectedItem();
        System.out.println("Selected Item: " + selectedItem);
        elToken.generarGrafica(selectedItem);
        archivo.mostrarImagen(lblImagen);
    }//GEN-LAST:event_comboBoxComparacionActionPerformed

    private void comboBoxLogicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxLogicosActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) comboBoxLogicos.getSelectedItem();
        System.out.println("Selected Item: " + selectedItem);
        elToken.generarGrafica(selectedItem);
        archivo.mostrarImagen(lblImagen);
    }//GEN-LAST:event_comboBoxLogicosActionPerformed

    private void comboBoxAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAsignacionActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) comboBoxAsignacion.getSelectedItem();
        System.out.println("Selected Item: " + selectedItem);
        elToken.generarGrafica(selectedItem);
        archivo.mostrarImagen(lblImagen);
    }//GEN-LAST:event_comboBoxAsignacionActionPerformed

    private void comboBoxKWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxKWActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) comboBoxKW.getSelectedItem();
        System.out.println("Selected Item: " + selectedItem);
        elToken.generarGrafica(selectedItem);
        archivo.mostrarImagen(lblImagen);
    }//GEN-LAST:event_comboBoxKWActionPerformed

    private void btnTablaSimbolosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaSimbolosActionPerformed
        DefaultTableModel columna = new DefaultTableModel();

        columna.addColumn("Tipo");
        columna.addColumn("Patron");
        columna.addColumn("Lexema ");
        columna.addColumn("Linea");
        columna.addColumn("Columna");

        for (Token token : reporteTokens) {
            columna.addRow(new Object[]{token.getTipo1() + " / " + token.getTipo2(),
                token.getPatron(),
                token.getLexema(),
                token.getLinea(),
                token.getColumna()});
        }
        JTable tabla = new JTable(columna);
        JScrollPane scrollPane = new JScrollPane(tabla);
        JFrame frame = new JFrame("Tabla de Simbolos");
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_btnTablaSimbolosActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JMenu btnMenuAcercaDe;
    private javax.swing.JMenu btnMenuAnalizar;
    private javax.swing.JMenu btnMenuAyuda;
    private javax.swing.JMenuItem btnMenuEscribirCodigo;
    private javax.swing.JMenuItem btnMenuGenerarGrafico;
    private javax.swing.JMenu btnMenuGrafico;
    private javax.swing.JMenuItem btnMenuSeleccionarArchivo;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnTablaSimbolos;
    private javax.swing.JComboBox<String> comboBoxAritmeticos;
    private javax.swing.JComboBox<String> comboBoxAsignacion;
    private javax.swing.JComboBox<String> comboBoxComparacion;
    private javax.swing.JComboBox<String> comboBoxIdentificadores;
    private javax.swing.JComboBox<String> comboBoxKW;
    private javax.swing.JComboBox<String> comboBoxLogicos;
    private javax.swing.JSeparator divisor;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblErrorLex;
    private javax.swing.JLabel lblErrorSint;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblLexico;
    private javax.swing.JLabel lblReporte;
    private javax.swing.JLabel lblSintactico;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlUI;
    private javax.swing.JTextPane txtAreaCodigo;
    private javax.swing.JTextPane txtAreaErrorLex;
    private javax.swing.JTextPane txtAreaErrorSint;
    private javax.swing.JTextPane txtAreaReporteLex;
    // End of variables declaration//GEN-END:variables
}
