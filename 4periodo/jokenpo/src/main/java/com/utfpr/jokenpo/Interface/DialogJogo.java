package com.utfpr.jokenpo.Interface;

import com.utfpr.jokenpo.JogadorTCP;
import com.utfpr.jokenpo.classes.Jogador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DialogJogo extends javax.swing.JDialog {
    public Jogador jogador = new Jogador();
    
    public DialogJogo(java.awt.Frame parent, boolean modal, Jogador jogador) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.jogador = jogador;
        lblSala.setText("Sala: " + String.valueOf(jogador.getSala()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnExecutarJogada = new javax.swing.JButton();
        rbPedra = new javax.swing.JRadioButton();
        rbPapel = new javax.swing.JRadioButton();
        rbTesoura = new javax.swing.JRadioButton();
        lblJogador = new javax.swing.JLabel();
        lblPontuacao = new javax.swing.JLabel();
        lblSala = new javax.swing.JLabel();
        lblMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        btnExecutarJogada.setText("Executar Jogada");
        btnExecutarJogada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecutarJogadaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbPedra);
        rbPedra.setSelected(true);
        rbPedra.setText("Rocha");

        buttonGroup1.add(rbPapel);
        rbPapel.setText("Papel");

        buttonGroup1.add(rbTesoura);
        rbTesoura.setText("Tesoura");

        lblJogador.setText("Jogador:");

        lblPontuacao.setText("Pontuação:");

        lblSala.setText("Sala:");

        lblMsg.setText("Mensagem:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJogador)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(rbPedra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbPapel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbTesoura))
                    .addComponent(btnExecutarJogada, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPontuacao)
                    .addComponent(lblSala)
                    .addComponent(lblMsg))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbPedra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPapel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTesoura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPontuacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(btnExecutarJogada)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        lblJogador.setText("Jogador: " + jogador.getNome());
        lblPontuacao.setText("Pontuação: " + jogador.getPontuacao());
    }//GEN-LAST:event_formWindowActivated

    private void btnExecutarJogadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecutarJogadaActionPerformed
        JogadorTCP jogadorTcp = new JogadorTCP();
        if(rbPedra.isSelected()){
            jogador.setJogada('R');
        }
        if(rbPapel.isSelected()){
            jogador.setJogada('P');
        }
        if(rbTesoura.isSelected()){
            jogador.setJogada('T');
        }
        rbPapel.setEnabled(false);
        rbPedra.setEnabled(false);
        rbTesoura.setEnabled(false);        
        btnExecutarJogada.setEnabled(false);
        try {
           jogador = jogadorTcp.enviarComRetorno(jogador);
           lblPontuacao.setText("Pontuação: " + jogador.getPontuacao());
           lblMsg.setText("Mensagem: " + jogador.getMsg());
        } catch (IOException ex) {
            Logger.getLogger(DialogJogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DialogJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        rbPapel.setEnabled(true);
        rbPedra.setEnabled(true);
        rbTesoura.setEnabled(true);        
        btnExecutarJogada.setEnabled(true);
    }//GEN-LAST:event_btnExecutarJogadaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecutarJogada;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblJogador;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblPontuacao;
    private javax.swing.JLabel lblSala;
    private javax.swing.JRadioButton rbPapel;
    private javax.swing.JRadioButton rbPedra;
    private javax.swing.JRadioButton rbTesoura;
    // End of variables declaration//GEN-END:variables
}
