/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DemoServices;
import com.si.pojo.Question;
import com.si.services.QuestionServices;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
/**
 *
 * @author admin
 */
public class TestCases {
     private static QuestionServices s = new QuestionServices();
    
    @Test
    public void testCategoryIsNotNull() throws SQLException {
        List<Question> questions = s.getQuestions(2);
        for (var q: questions)
            Assertions.assertTrue(q.getCategoryId() > 0);
    }
    
//    @Test
//    public void testChoices() throws SQLException {
//        List<Question> questions = s.getQuestions(5);
//        for (var q: questions) {
//            q.setChoices(s.getChoices(q.getId()));
//            Assertions.assertTrue(q.getChoices().size() == 4);
//        }
//    }
}
