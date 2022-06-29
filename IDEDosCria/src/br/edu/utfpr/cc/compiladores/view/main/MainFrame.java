/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.utfpr.cc.compiladores.view.main;

import br.edu.utfpr.cc.compiladores.controller.MainController;
import br.edu.utfpr.cc.compiladores.view.codeEditor.CodeEditorFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;


public class MainFrame extends javax.swing.JFrame {

    private class JTreeLabel {

        String name;
        File file;

        public JTreeLabel(String name, File file) {
            this.file = file;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Creates new form MainJFrame
     */
    private List<CodeEditorFrame> editors;
    private MainController controller;
    private DefaultMutableTreeNode root;

    public List<CodeEditorFrame> getEditors() {
        return editors;
    }

    public JToolBar getButtonBar() {
        return buttonBar;
    }

    public JButton getExecuteButton() {
        return executeButton;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JMenu getMenuExecutar() {
        return menuExecutar;
    }

    public JButton getNewFileButton() {
        return newFileButton;
    }

    public JButton getOpenFileButton() {
        return openFileButton;
    }

    public JButton getOpenFolderButtonButton() {
        return openFolderButtonButton;
    }

    public JPanel getPanelOutput() {
        return panelOutput;
    }

    public JPanel getPanelSintaxTree() {
        return panelSintaxTree;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JScrollPane getScrollPaneSintaxTree() {
        return scrollPaneSintaxTree;
    }

    public JScrollPane getScrollPaneTree() {
        return scrollPaneTree;
    }

    public JScrollPane getScrollPanelOutput() {
        return scrollPanelOutput;
    }

    public JTabbedPane getTabbedCodeEditor() {
        return tabbedCodeEditor;
    }

    public JTabbedPane getTabbedOthers() {
        return tabbedOthers;
    }

    public JEditorPane getTextAreaOutputProgram() {
        return textAreaOutputProgram;
    }

    public JTextArea getTextAreaSintaxTree() {
        return textAreaSintaxTree;
    }

    public JTree getTreeFolderWorkpace() {
        return treeFolderWorkpace;
    }

    public void setEditors(List<CodeEditorFrame> editors) {
        this.editors = editors;
    }

    public void setButtonBar(JToolBar buttonBar) {
        this.buttonBar = buttonBar;
    }

    public void setExecuteButton(JButton executeButton) {
        this.executeButton = executeButton;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public void setMenuExecutar(JMenu menuExecutar) {
        this.menuExecutar = menuExecutar;
    }

    public void setNewFileButton(JButton newFileButton) {
        this.newFileButton = newFileButton;
    }

    public void setOpenFileButton(JButton openFileButton) {
        this.openFileButton = openFileButton;
    }

    public void setOpenFolderButtonButton(JButton openFolderButtonButton) {
        this.openFolderButtonButton = openFolderButtonButton;
    }

    public void setPanelOutput(JPanel panelOutput) {
        this.panelOutput = panelOutput;
    }

    public void setPanelSintaxTree(JPanel panelSintaxTree) {
        this.panelSintaxTree = panelSintaxTree;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public void setScrollPaneSintaxTree(JScrollPane scrollPaneSintaxTree) {
        this.scrollPaneSintaxTree = scrollPaneSintaxTree;
    }

    public void setScrollPaneTree(JScrollPane scrollPaneTree) {
        this.scrollPaneTree = scrollPaneTree;
    }

    public void setScrollPanelOutput(JScrollPane scrollPanelOutput) {
        this.scrollPanelOutput = scrollPanelOutput;
    }

    public void setTabbedCodeEditor(JTabbedPane tabbedCodeEditor) {
        this.tabbedCodeEditor = tabbedCodeEditor;
    }

    public void setTabbedOthers(JTabbedPane tabbedOthers) {
        this.tabbedOthers = tabbedOthers;
    }

    public void setTextAreaOutputProgram(JEditorPane textAreaOutputProgram) {
        this.textAreaOutputProgram = textAreaOutputProgram;
    }

    public void setTextAreaSintaxTree(JTextArea textAreaSintaxTree) {
        this.textAreaSintaxTree = textAreaSintaxTree;
    }

    public void setTreeFolderWorkpace(JTree treeFolderWorkpace) {
        this.treeFolderWorkpace = treeFolderWorkpace;
    }

    public void addTabbedCodeEditor(String titulo, CodeEditorFrame editor) {
        if (editors.isEmpty()) {
            this.tabbedCodeEditor.add(titulo, editor);
            this.tabbedCodeEditor.setSelectedIndex(this.tabbedCodeEditor.getTabCount() - 1);
            this.editors.add(editor);
        } else {
            if (editors.stream().filter(value -> value.getFileName().equals(titulo)).toArray().length == 0) {
                this.tabbedCodeEditor.add(titulo, editor);
                this.tabbedCodeEditor.setSelectedIndex(this.tabbedCodeEditor.getTabCount() - 1);
                this.editors.add(editor);
            }
        }
    }

    public void setTreeFolder(File file) {
        root = new DefaultMutableTreeNode("root", true);
        getList(root, file);
        treeFolderWorkpace.setModel(new DefaultTreeModel(root.getNextNode()));

    }

    public void getList(DefaultMutableTreeNode node, File f) {
        if (!f.isDirectory()) {
            if (f.getName().endsWith("noia")) {
                //System.out.println("FILE  -  " + f.getName());
                DefaultMutableTreeNode child = new DefaultMutableTreeNode(new JTreeLabel(f.getName(), f));
                node.add(child);
            }
        } else {
            //System.out.println("DIRECTORY  -  " + f.getName());
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(new JTreeLabel(f.getName(), f));
            node.add(child);
            File fList[] = f.listFiles();
            for (int i = 0; i < fList.length; i++) {
                getList(child, fList[i]);
            }

        }
    }

    public MainFrame() {

        initComponents();
        controller = new MainController(this);
        editors = new ArrayList<>();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        treeFolderWorkpace.setModel(new DefaultTreeModel(root));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        scrollPaneTree = new javax.swing.JScrollPane();
        treeFolderWorkpace = new javax.swing.JTree();
        buttonBar = new javax.swing.JToolBar();
        newFileButton = new javax.swing.JButton();
        openFileButton = new javax.swing.JButton();
        openFolderButtonButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        executeButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tabbedCodeEditor = new javax.swing.JTabbedPane();
        tabbedOthers = new javax.swing.JTabbedPane();
        panelSintaxTree = new javax.swing.JPanel();
        scrollPaneSintaxTree = new javax.swing.JScrollPane();
        textAreaSintaxTree = new javax.swing.JTextArea();
        panelOutput = new javax.swing.JPanel();
        scrollPanelOutput = new javax.swing.JScrollPane();
        textAreaOutputProgram = new javax.swing.JEditorPane();
        menuBar = new javax.swing.JMenuBar();
        menuExecutar = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("InteliCria");

        treeFolderWorkpace.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeFolderWorkpaceValueChanged(evt);
            }
        });
        scrollPaneTree.setViewportView(treeFolderWorkpace);

        buttonBar.setRollover(true);

        newFileButton.setText("Novo Arquivo");
        newFileButton.setFocusable(false);
        newFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileButtonActionPerformed(evt);
            }
        });
        buttonBar.add(newFileButton);

        openFileButton.setText("Abrir Arquivo");
        openFileButton.setFocusable(false);
        openFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileButtonActionPerformed(evt);
            }
        });
        buttonBar.add(openFileButton);

        openFolderButtonButton.setText("Abrir Pasta");
        openFolderButtonButton.setFocusable(false);
        openFolderButtonButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openFolderButtonButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openFolderButtonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFolderButtonButtonActionPerformed(evt);
            }
        });
        buttonBar.add(openFolderButtonButton);

        saveButton.setText("Salvar");
        saveButton.setFocusable(false);
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        buttonBar.add(saveButton);

        executeButton.setText("Executar");
        executeButton.setFocusable(false);
        executeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        executeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        executeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeButtonActionPerformed(evt);
            }
        });
        buttonBar.add(executeButton);

        jButton1.setText("Fechar Aba Atual");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        buttonBar.add(jButton1);

        textAreaSintaxTree.setColumns(20);
        textAreaSintaxTree.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        textAreaSintaxTree.setRows(5);
        scrollPaneSintaxTree.setViewportView(textAreaSintaxTree);

        javax.swing.GroupLayout panelSintaxTreeLayout = new javax.swing.GroupLayout(panelSintaxTree);
        panelSintaxTree.setLayout(panelSintaxTreeLayout);
        panelSintaxTreeLayout.setHorizontalGroup(
            panelSintaxTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneSintaxTree, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );
        panelSintaxTreeLayout.setVerticalGroup(
            panelSintaxTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneSintaxTree, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );

        tabbedOthers.addTab("Árvore Sintática", panelSintaxTree);

        textAreaOutputProgram.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        scrollPanelOutput.setViewportView(textAreaOutputProgram);

        javax.swing.GroupLayout panelOutputLayout = new javax.swing.GroupLayout(panelOutput);
        panelOutput.setLayout(panelOutputLayout);
        panelOutputLayout.setHorizontalGroup(
            panelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );
        panelOutputLayout.setVerticalGroup(
            panelOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );

        tabbedOthers.addTab("Saída", panelOutput);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneTree, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedCodeEditor)
                    .addComponent(tabbedOthers)
                    .addComponent(buttonBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneTree)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(buttonBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabbedCodeEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabbedOthers, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        menuExecutar.setText("Arquivo");
        menuExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExecutarActionPerformed(evt);
            }
        });

        jMenu1.setText("Novo Arquivo");
        menuExecutar.add(jMenu1);

        jMenu2.setText("Abrir Arquivo");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        menuExecutar.add(jMenu2);

        jMenu3.setText("Abrir Pasta");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        menuExecutar.add(jMenu3);

        jMenu4.setText("Salvar");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        menuExecutar.add(jMenu4);

        jMenu5.setText("Executar");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        menuExecutar.add(jMenu5);

        menuBar.add(menuExecutar);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileButtonActionPerformed
        controller.openNewFile();
    }//GEN-LAST:event_newFileButtonActionPerformed

    private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileButtonActionPerformed
        try {
            controller.openFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao tentar abrir o arquivo, tente novamente.");
        }
    }//GEN-LAST:event_openFileButtonActionPerformed

    private void openFolderButtonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFolderButtonButtonActionPerformed
        controller.openFolder();
    }//GEN-LAST:event_openFolderButtonButtonActionPerformed

    private void treeFolderWorkpaceValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeFolderWorkpaceValueChanged
        try {
            DefaultMutableTreeNode mutableTreeNode = (DefaultMutableTreeNode) treeFolderWorkpace.getLastSelectedPathComponent();
            JTreeLabel treeLabel = (JTreeLabel) mutableTreeNode.getUserObject();
            controller.opeFile(treeLabel.file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao tentar abrir o arquivo, tente novamente.");
        }
    }//GEN-LAST:event_treeFolderWorkpaceValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.tabbedCodeEditor.getTabCount() > 0) {
            editors.remove(this.tabbedCodeEditor.getSelectedIndex());
            this.tabbedCodeEditor.remove(this.tabbedCodeEditor.getSelectedIndex());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            controller
                    .saveFile(editors.get(tabbedCodeEditor.getSelectedIndex()), tabbedCodeEditor.getSelectedIndex());
        } catch (Exception e) {
            JOptionPane
                    .showMessageDialog(
                            rootPane,
                            "Ops! Ocorreu um erro ao salvar seu arquivo."
                    );
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void executeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeButtonActionPerformed
        controller
                .executeFile(editors.get(tabbedCodeEditor.getSelectedIndex()), tabbedCodeEditor.getSelectedIndex());
    }//GEN-LAST:event_executeButtonActionPerformed

    private void menuExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExecutarActionPerformed
        controller.openNewFile();
    }//GEN-LAST:event_menuExecutarActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        try {
            controller.openFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao tentar abrir o arquivo, tente novamente.");
        }
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        controller.openFolder();
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        try {
            controller
                    .saveFile(editors.get(tabbedCodeEditor.getSelectedIndex()), tabbedCodeEditor.getSelectedIndex());
        } catch (Exception e) {
            JOptionPane
                    .showMessageDialog(
                            rootPane,
                            "Ops! Ocorreu um erro ao salvar seu arquivo."
                    );
        }
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        controller
                .executeFile(editors.get(tabbedCodeEditor.getSelectedIndex()), tabbedCodeEditor.getSelectedIndex());
    }//GEN-LAST:event_jMenu5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar buttonBar;
    private javax.swing.JButton executeButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuExecutar;
    private javax.swing.JButton newFileButton;
    private javax.swing.JButton openFileButton;
    private javax.swing.JButton openFolderButtonButton;
    private javax.swing.JPanel panelOutput;
    private javax.swing.JPanel panelSintaxTree;
    private javax.swing.JButton saveButton;
    private javax.swing.JScrollPane scrollPaneSintaxTree;
    private javax.swing.JScrollPane scrollPaneTree;
    private javax.swing.JScrollPane scrollPanelOutput;
    private javax.swing.JTabbedPane tabbedCodeEditor;
    private javax.swing.JTabbedPane tabbedOthers;
    private javax.swing.JEditorPane textAreaOutputProgram;
    private javax.swing.JTextArea textAreaSintaxTree;
    private javax.swing.JTree treeFolderWorkpace;
    // End of variables declaration//GEN-END:variables
}
