/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DemoServices;
import com.si.pojo.Category;
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
    @Test
    public void CategoryNotNull() throws SQLException {
        QuestionServices s = new QuestionServices();
        List<Question> inputList = s.getQuestions(0);
        boolean expectedOutput = true;
    }
}
