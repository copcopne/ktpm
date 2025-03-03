package com.si.fxenglishapp;

import com.si.pojo.Question;
import com.si.services.QuestionServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

public class PrimaryController implements Initializable{
    
    @FXML private Text questionCntTxt;
    @FXML private Text answerATxt;
    @FXML private Text answerBTxt;
    @FXML private Text answerCTxt;
    @FXML private Text answerDTxt;
    @FXML private RadioButton rdoA;
    @FXML private RadioButton rdoB;
    @FXML private RadioButton rdoC;
    @FXML private RadioButton rdoD;
    private int currentIdx = 0;
    private List<Question> questions;
    
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    
    public void checkHandler(ActionEvent e) {
        QuestionServices s = new QuestionServices();
    }
    
    
    private void loadQuestionsToUI(){
        Question q = this.questions.get(currentIdx);
        questionCntTxt.setText(q.getContent());
        
        if(q.getChoices() == null) {
            try {
                QuestionServices s = new QuestionServices();
                q.setChoices(s.getChoices(q.getId()));
            } catch (SQLException ex) {
                Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        answerATxt.setText(q.getChoices().get(0).toString());
        answerBTxt.setText(q.getChoices().get(1).toString());
        answerCTxt.setText(q.getChoices().get(2).toString());
        answerDTxt.setText(q.getChoices().get(3).toString());
    }
    
    
    public void NextHandler(ActionEvent e) {
        if(this.currentIdx <2) currentIdx++;
        else currentIdx = 0;
        loadQuestionsToUI();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        QuestionServices s = new QuestionServices();
        try {
            this.questions = s.getQuestions(3);
            loadQuestionsToUI();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
