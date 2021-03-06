/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prebeeditor;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.event.TextEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rho
 */
public class Editor extends javax.swing.JFrame {
    
    final String tituloMarco = "PrebeEditor";
    String nombreArchivo = "";
    String fn="";
    String dir="";
    String holdText="";
    boolean cambios=false;
    
    BufferedReader br = null;
    FileReader fr = null;
    String sCurrentLine = "";

    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
        java.awt.EventQueue.invokeLater(() -> {
            setVisible(true);
            setLocationRelativeTo(null);
            setTitle(nombreArchivo + tituloMarco);
        });
    }
    
    private void guardarComo() throws FileNotFoundException, IOException {
        FileDialog fd=new FileDialog(Editor.this,"Guardar",FileDialog.SAVE);
        fd.show();
        if (fd.getFile()!=null) {
            fn=fd.getFile();
            dir=fd.getDirectory();
            nombreArchivo=dir+fn+".txt";
            setTitle(nombreArchivo);
            
            try{
                DataOutputStream d = new DataOutputStream(new FileOutputStream(nombreArchivo));
                holdText = areaTexto.getText();
                BufferedReader bra =  new BufferedReader(new StringReader(holdText));
                while((holdText=bra.readLine())!=null){
                    d.writeBytes(holdText+"\r\n");
                    d.close();
                }
                
            }catch(FileNotFoundException e){
            }
            
        }
    }

    private void guardar(String nombreArchivo) {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            setTitle(nombreArchivo);
            FileWriter salida;
            salida = new FileWriter(fn);
            salida.write(areaTexto.getText());
            salida.close();
        } catch (IOException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
        cambios = false;
        guardarBtn.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorTop = new javax.swing.JPanel();
        abrirBtn = new javax.swing.JButton();
        guardarBtn = new javax.swing.JButton();
        iconL = new javax.swing.JLabel();
        contenedorCentral = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        archivoM = new javax.swing.JMenu();
        nuevoI = new javax.swing.JMenuItem();
        abrirI = new javax.swing.JMenuItem();
        guardarI = new javax.swing.JMenuItem();
        exitI = new javax.swing.JMenuItem();
        editarM = new javax.swing.JMenu();
        copiarI = new javax.swing.JMenuItem();
        cortarI = new javax.swing.JMenuItem();
        pegarI = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        abrirBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prebeeditor/Open.png"))); // NOI18N
        abrirBtn.setText("abrir");
        abrirBtn.setBorderPainted(false);
        abrirBtn.setContentAreaFilled(false);
        abrirBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrirBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        guardarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prebeeditor/save.png"))); // NOI18N
        guardarBtn.setText("guardar");
        guardarBtn.setBorderPainted(false);
        guardarBtn.setContentAreaFilled(false);
        guardarBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardarBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        iconL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prebeeditor/prebelogo.jpeg"))); // NOI18N
        iconL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout contenedorTopLayout = new javax.swing.GroupLayout(contenedorTop);
        contenedorTop.setLayout(contenedorTopLayout);
        contenedorTopLayout.setHorizontalGroup(
            contenedorTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorTopLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(abrirBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconL)
                .addGap(39, 39, 39))
        );
        contenedorTopLayout.setVerticalGroup(
            contenedorTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contenedorTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenedorTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(abrirBtn)
                        .addComponent(guardarBtn))
                    .addComponent(iconL)))
        );

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        areaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areaTextoKeyTyped(evt);
            }
        });
        scrollPane.setViewportView(areaTexto);

        javax.swing.GroupLayout contenedorCentralLayout = new javax.swing.GroupLayout(contenedorCentral);
        contenedorCentral.setLayout(contenedorCentralLayout);
        contenedorCentralLayout.setHorizontalGroup(
            contenedorCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorCentralLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        contenedorCentralLayout.setVerticalGroup(
            contenedorCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        archivoM.setText("archivo");

        nuevoI.setText("nuevo");
        nuevoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoIActionPerformed(evt);
            }
        });
        archivoM.add(nuevoI);

        abrirI.setText("abrir");
        abrirI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirIActionPerformed(evt);
            }
        });
        archivoM.add(abrirI);

        guardarI.setText("guardar");
        guardarI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarIActionPerformed(evt);
            }
        });
        archivoM.add(guardarI);

        exitI.setText("exit");
        exitI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitIActionPerformed(evt);
            }
        });
        archivoM.add(exitI);

        menuBar.add(archivoM);

        editarM.setText("editar");

        copiarI.setText("copiar");
        copiarI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarIActionPerformed(evt);
            }
        });
        editarM.add(copiarI);

        cortarI.setText("cortar");
        cortarI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cortarIActionPerformed(evt);
            }
        });
        editarM.add(cortarI);

        pegarI.setText("pegar");
        pegarI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarIActionPerformed(evt);
            }
        });
        editarM.add(pegarI);

        menuBar.add(editarM);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenedorCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contenedorTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedorCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitIActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_exitIActionPerformed

    private void iconLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconLMouseClicked
        try {
            // TODO add your handling code here:
            Desktop.getDesktop().browse(new URL("http://proteco.mx").toURI());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_iconLMouseClicked

    private void copiarIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiarIActionPerformed
        // TODO add your handling code here:
        areaTexto.copy();
    }//GEN-LAST:event_copiarIActionPerformed

    private void cortarIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cortarIActionPerformed
        // TODO add your handling code here:
        areaTexto.cut();
    }//GEN-LAST:event_cortarIActionPerformed

    private void pegarIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegarIActionPerformed
        // TODO add your handling code here:
        areaTexto.paste();
    }//GEN-LAST:event_pegarIActionPerformed

    private void nuevoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoIActionPerformed
        // TODO add your handling code here:
        if (areaTexto.getText().length() > 1) {
            if ("".equals(nombreArchivo)) {
                //desea guardar
                int confirmar;
                confirmar = JOptionPane.showConfirmDialog(this, "Desea guardar?");
                if (confirmar == JOptionPane.YES_OPTION) {
                    try {
                        guardarComo();
                    } catch (IOException ex) {
                        Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }else {
                if (cambios) {
                    //llamar a guardar()
                    guardar(nombreArchivo);
                }
            }
        }
        areaTexto.setText("");
        cambios = false;
        nombreArchivo = "";
        setTitle(tituloMarco);
        
    }//GEN-LAST:event_nuevoIActionPerformed

    private void areaTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTextoKeyTyped
        // TODO add your handling code here:
                // TODO add your handling code here:
        if (TextEvent.TEXT_VALUE_CHANGED!=0) {
            if (!cambios) {
                setTitle("*"+getTitle());
                cambios = true;
                guardarBtn.setEnabled(true);
            }
        }
    }//GEN-LAST:event_areaTextoKeyTyped

    private void guardarIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarIActionPerformed
        // TODO add your handling code here:
        //no olvide hacer guardarBtn.setEnabled(true);
        if (nombreArchivo.equals("")) {
            try {
                //Debemos abrir un filechoser
                guardarComo();
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            guardar(nombreArchivo);
        }
    }//GEN-LAST:event_guardarIActionPerformed

    private void abrirIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirIActionPerformed
        // TODO add your handling code here:
        if (areaTexto.getText().length() > 1) {
            if ("".equals(nombreArchivo)) {
                //desea guardar
                int confirmar;
                confirmar = JOptionPane.showConfirmDialog(this, "Desea guardar?");
                if (confirmar == JOptionPane.YES_OPTION) {
                    try {
                        guardarComo();
                    } catch (IOException ex) {
                        Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                if (cambios) {
                    //llamar a guardar()
                    guardar(nombreArchivo);
                }
            }
        }
        cambios = false;
        //abrirArchivo
        FileDialog fd = new FileDialog(this, "Escoger un archivo");
        fd.show();
        if (fd.getFile()!=null) {
            nombreArchivo = fd.getDirectory()+fd.getFile();
            setTitle(nombreArchivo);
            try {
                fr = new FileReader(nombreArchivo);
                br = new BufferedReader(fr);
                while ((sCurrentLine = br.readLine()) != null) {
                    //checar esta linea
                    areaTexto.setText(sCurrentLine);
		}
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        
    }//GEN-LAST:event_abrirIActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirBtn;
    private javax.swing.JMenuItem abrirI;
    private javax.swing.JMenu archivoM;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JPanel contenedorCentral;
    private javax.swing.JPanel contenedorTop;
    private javax.swing.JMenuItem copiarI;
    private javax.swing.JMenuItem cortarI;
    private javax.swing.JMenu editarM;
    private javax.swing.JMenuItem exitI;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JMenuItem guardarI;
    private javax.swing.JLabel iconL;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem nuevoI;
    private javax.swing.JMenuItem pegarI;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
