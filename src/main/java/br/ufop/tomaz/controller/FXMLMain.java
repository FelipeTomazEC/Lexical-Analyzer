package br.ufop.tomaz.controller;

import br.ufop.tomaz.Main;
import br.ufop.tomaz.model.Lexeme;
import br.ufop.tomaz.model.Lexical_Analyzer;
import br.ufop.tomaz.model.Token;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class FXMLMain implements Initializable {

    @FXML private MenuBar menubar;
    @FXML private JFXTextArea codeTextArea;
    @FXML private JFXButton btnAnalyze;
    @FXML private JFXButton btnClear;
    @FXML private TableView<Lexeme> tokensTable;
    @FXML private TableColumn<Lexeme, Integer> lineCol;
    @FXML private TableColumn<Lexeme, Token> tokenCol;
    @FXML private TableColumn<Lexeme, String> attributeCol;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lineCol.setCellValueFactory(new PropertyValueFactory<>("line"));
        tokenCol.setCellValueFactory(new PropertyValueFactory<>("token"));
        attributeCol.setCellValueFactory(new PropertyValueFactory<>("value"));

        btnAnalyze.disableProperty().bind(codeTextArea.textProperty().isEmpty());
        btnClear.disableProperty().bind(codeTextArea.textProperty().isEmpty());
    }

    @FXML
    private void loadFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pick a file");
        String userHome = System.getProperty("user.home");
        fileChooser.setInitialDirectory(new File(userHome));
        File file = fileChooser.showOpenDialog(Main.stage.getOwner());
        if(file != null){
            Files.lines(file.toPath(), Charset.forName("UTF-8"))
                    .forEach(line -> codeTextArea.appendText(line.concat("\n")));
        }
    }

    @FXML
    private void clearCodeArea(){
        codeTextArea.setText("");
        tokensTable.getItems().clear();
    }

    @FXML
    private void analyze(){
        String [] lines = codeTextArea.getText().split("\n");
        Map<Integer, String> code = new HashMap<>();
        boolean lock = true; // To ignore multiple lines comments

        for(int i = 0; i < lines.length; i++){
            String line = lines[i];
            if(!line.strip().startsWith("//") && lock && !line.strip().startsWith("/*") && !line.isBlank())
                code.put(i+1, line);
            if(line.strip().startsWith("/*"))
                lock = false;
            if(line.strip().endsWith("*/"))
                lock = true;
        }

        List<Lexeme> lexemes = new Lexical_Analyzer().analyzeCode(code);
        tokensTable.setItems(FXCollections.observableList(lexemes));
    }
}
