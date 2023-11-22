package com.example.demo2;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ResourceBundle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.parser.JSONReaderScanner;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class HelloController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;
    @FXML
    private TextField nane;
    @FXML
    private Button button_add;

    @FXML
    private TextArea text;
    @FXML
    private TextField daten;




    @FXML
    protected void add_action() throws IOException {
        String c = nane.getText();
        String b = c + ".json";
        File a = new File("NNotes", b);
        boolean b1 = a.exists();
        if (b1 == false){
            a.createNewFile();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("NAME", c);
        jsonObject.put("NTEXT", text.getText());
        java.util.Date date2 = new java.util.Date();
        jsonObject.put("DATE OF NOTE", date2.toString());
        //JSONWriter k = new JSONWriter[].;
        //k.writeObject(jsonObject);
        System.out.println(jsonObject);
        FileWriter writer = new FileWriter(a, false);
        writer.write(jsonObject.toString());
        writer.flush();
        System.out.println(jsonObject.toString());
        }

    @FXML
    protected void delete_action() throws IOException {
        String b = nane.getText() + ".json";
        File a = new File("NNotes", b);
        a.delete();
        clear_action();
    }
    @FXML
    protected void clear_action() throws IOException {
        nane.setText("");
        text.setText("");
        java.util.Date date = new java.util.Date();
        System.out.println(date);
        daten.setText(date.toString());

    }
    @FXML
    protected void open_action() throws IOException {
        FileChooser fc = new FileChooser();
        Stage stage2 = new Stage();
        //File selectedFile = fc.showOpenDialog(stage2);
        fc.setTitle("NNotes");
        fc.setInitialDirectory(new File("NNotes\\"));
        //fc.setInitialFileName("myfile.txt");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
        File selectedFile = fc.showOpenDialog(stage2);
        if (selectedFile != null) {
            //stage2.show();
            System.out.println(selectedFile);
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
            String line;
            line = reader.readLine();
            System.out.println(line);
            JSONObject ob = null;
            ob = JSON.parseObject(line, (Type) Note.class);
            System.out.println(ob);
        }

    }


    @FXML
    void initialize() {
        java.util.Date date = new java.util.Date();
        System.out.println(date);
        daten.setText(date.toString());
    }}




