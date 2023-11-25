package com.example.demo2;

import com.alibaba.fastjson.JSONObject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.alibaba.fastjson.JSON.parseObject;


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
    private TextArea list;


    @FXML
    protected void add_action() throws IOException {
        String c = nane.getText();
        String b = c + ".json";
        File a = new File("NNotes", b);
        boolean b1 = a.exists();
        if (b1 == false) {
            a.createNewFile();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", c);
        jsonObject.put("ntext", text.getText());
        java.util.Date date2 = new java.util.Date();
        jsonObject.put("dateOfNote", date2.toString());
        System.out.println(jsonObject);
        FileWriter writer = new FileWriter(a, false);
        writer.write(jsonObject.toJSONString());
        writer.flush();
        System.out.println(jsonObject.toString());
        lst();
    }

    @FXML
    protected void delete_action() throws IOException {
        String b = nane.getText() + ".json";
        File a = new File("NNotes", b);
        a.delete();
        clear_action();
        lst();
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
            String line = reader.readLine();
            System.out.println(line);

            Note objectFromJsonString = parseObject(line, Note.class);
            System.out.println("Object from String: " + objectFromJsonString);
            //Note obj = JSON.parseObject(line.strip(), Note.class);
            nane.setText(objectFromJsonString.getName());
            text.setText(objectFromJsonString.getNtext());
            daten.setText(objectFromJsonString.getDateOfNote());
            System.out.println(objectFromJsonString);

            // Получение значений полей из объекта
            //String name = objectFromJsonString.get(0).toString();
            //System.out.println(name);
            //int age = jsonObject.getIntValue("age");
            //String city = jsonObject.getString("city");
            //System.out.println(name);

        }

    }

    private void lst()

    {
        File dir = new File("NNotes");
        ArrayList<String> list4 = new ArrayList<>();
        for (File item : dir.listFiles()) {
            System.out.println(item.getName());
            list.setText(list.getText()+ "\n" + item.getName());
            list4.add(item.getName() + "\n");
        }
    }


    @FXML
    void initialize() {
        java.util.Date date = new java.util.Date();
        System.out.println(date);
        daten.setText(date.toString());
        lst();
    }}




