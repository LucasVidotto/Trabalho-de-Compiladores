/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.cc.compiladores.controller;

import br.edu.utfpr.cc.compiladores.utils.FileManager;
import br.edu.utfpr.cc.compiladores.view.codeEditor.CodeEditorFrame;
import br.edu.utfpr.cc.compiladores.view.main.MainFrame;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import parser.CompiladorAula;
import parser.ResultCriaCompiler;


public class MainController {

    private FileManager fileManager;
    private MainFrame frame;
    private File folder;

    public MainController(MainFrame frame) {
        this.fileManager = new FileManager();
        this.frame = frame;
    }

    public void openNewFile() {
        frame.addTabbedCodeEditor("Sem Titulo.noia", new CodeEditorFrame());
    }

    public void openFolder() {
        JFileChooser jc = new JFileChooser();
        jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int isSelected = jc.showSaveDialog(null);
        if (isSelected != 1) {
            folder = jc.getSelectedFile();
            frame.setTreeFolder(folder);
        }
    }

    public void openFile() throws IOException {
        JFileChooser jc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo da linguagem dos cria", "noia");
        jc.addChoosableFileFilter(filter);
        jc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jc.setAcceptAllFileFilterUsed(false);
        int isSelected = jc.showSaveDialog(null);
        if (isSelected != 1) {
            var file = jc.getSelectedFile();
            setNewTabbed(file);
            folder = file.getParentFile();
            frame.setTreeFolder(folder);
        }
    }

    public void opeFile(File file) throws IOException {
        if (!file.isDirectory()) {
            setNewTabbed(file);
        }
    }

    private void setNewTabbed(File file) throws IOException {
        var reader = fileManager.getFileReaderByFile(file);
        var content = fileManager.readContent(reader);
        frame.addTabbedCodeEditor(file.getName(), new CodeEditorFrame(content, file));
    }
    
    public void executeFile(CodeEditorFrame editor, Integer index){
        if(editor.getFile() == null){
            try {
                saveFile(editor, index);
            } catch (Exception ex) {
                frame.getTextAreaOutputProgram().setText(ex.toString());
                return;
            }
        }
        
        try {
            
            ResultCriaCompiler result = CompiladorAula.init(editor.getFile(), " ");
            var logs = "";
            for(var log : result.getLogs()){
                logs = logs + log + "\n";
            }
            frame.getTextAreaSintaxTree().setText(result.getDump());
            frame.getTextAreaOutputProgram().setText(
                    (result.getError() == null ? "" : result.getError())
                    + "\n\n\n\n-----------------------\n" 
                    + logs
                    + "\n-----------------------\n" 
                    + result.getResult());
        } catch (Exception | Error ex) {
            frame.getTextAreaOutputProgram().setText(ex.toString());
        }
    }

    public void saveFile(CodeEditorFrame editor, Integer index) throws Exception {

        if (folder == null) {
            openFolder();
        }

        var content
                = editor.getValueEditor() == null
                ? "" : editor.getValueEditor();

        if (editor.getFile() == null) {
            var fileName = JOptionPane.showInputDialog(frame, "Qual o nome desse arquivo?");

            if (fileName == null || fileName.isEmpty()) {
                fileName = "Sem Titulo.noia";
            }
            File newFile = null;
            Integer count = 1;
            while (true) {
                newFile = new File(folder.getPath() + "\\" + fileName);
                if (newFile.exists()) {
                    fileName = count.toString() + " Sem Titulo.noia";
                    count++;
                } else {
                    break;
                }
            }

            saveContentInFile(content, newFile);
            editor.setFile(newFile);
            frame.getTabbedCodeEditor().setTitleAt(index, fileName);
            frame.setTreeFolder(folder);
        } else {

            saveContentInFile(content, editor.getFile());
        }
    }

    private void saveContentInFile(String content, File file) throws Exception {
        var fileWriter = fileManager.getFileWriterByFile(file);
        fileManager.addContent(content, fileWriter);
    }

}
