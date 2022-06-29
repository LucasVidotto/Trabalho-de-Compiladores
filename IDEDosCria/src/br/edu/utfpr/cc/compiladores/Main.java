/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.cc.compiladores;

import br.edu.utfpr.cc.compiladores.view.main.MainFrame;
import br.edu.utfpr.cc.compiladores.view.splash.SplashFrame;


public class Main {

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        var splash = new SplashFrame();
        splash.setVisible(true);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        splash.dispose();
        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                var main = new MainFrame();
                main.setVisible(true);
            }
        });
    }
}
