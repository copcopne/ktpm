/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.si.fxenglishapp;

import com.si.pojo.Category;
import com.si.pojo.Choice;
import com.si.pojo.Question;
import com.si.services.CategoryServices;
import com.si.services.QuestionServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class FXQuestionsController implements Initializable {
    
    
    @FXML private ComboBox<Category> cbCates;
    @FXML private TableView<Question> tbQuestion;
    @FXML private TextField txtSearch;
    @FXML private RadioButton rdoA;
    @FXML private RadioButton rdoB;
    @FXML private RadioButton rdoC;
    @FXML private RadioButton rdoD;
    @FXML private TextField txtA;
    @FXML private TextField txtB;
    @FXML private TextField txtC;
    @FXML private TextField txtD;
    @FXML private TextArea txtConent;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategoryServices c = new CategoryServices();
        
        try {
            this.cbCates.setItems(FXCollections.observableList(c.getCategories()));
        } catch (SQLException ex) {
            Logger.getLogger(FXQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.loadColumns();
        this.loadTableData("");
        this.txtSearch.textProperty().addListener((e) -> {
            loadTableData(txtSearch.getText());
        });
    }    
    
    
    public void loadTableData(String kw) {
        try {
            QuestionServices s = new QuestionServices();
            this.tbQuestion.setItems(FXCollections.observableList(s.getQuestions(kw)));
        } catch (SQLException ex) {
            Logger.getLogger(FXQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadColumns() {
        TableColumn colContent = new TableColumn("Nội dung câu hỏi");
        colContent.setCellValueFactory(new PropertyValueFactory("content"));
        colContent.setPrefWidth(400);
        
        TableColumn colCate = new TableColumn("Danh mục");
        colCate.setCellValueFactory(new PropertyValueFactory("categoryId"));
        
        this.tbQuestion.getColumns().addAll(colContent, colCate);
    }
    public void InsertHandler(ActionEvent e) {
        Question q = new Question(UUID.randomUUID().toString(),txtConent.getText()
                , cbCates.getSelectionModel().getSelectedItem().getId());
        Choice c1 = new Choice(UUID.randomUUID().toString(), txtA.getText(), rdoA.isSelected(), q.getId());
        Choice c2 = new Choice(UUID.randomUUID().toString(), txtB.getText(), rdoB.isSelected(), q.getId());
        Choice c3 = new Choice(UUID.randomUUID().toString(), txtC.getText(), rdoC.isSelected(), q.getId());
        Choice c4 = new Choice(UUID.randomUUID().toString(), txtD.getText(), rdoD.isSelected(), q.getId());
        List<Choice> choices = new ArrayList<>();
        choices.add(c1);
        choices.add(c2);
        choices.add(c3);
        choices.add(c4);
        
        QuestionServices s = new QuestionServices();
        try {
            s.InsertQuestions(q, choices);
            this.loadTableData("");
        } catch (SQLException ex) {
            Logger.getLogger(FXQuestionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
