
import com.si.junittest.DemoServices;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class TestCases {
    
    @Test
    public void test1() {
        int x = 10;
        int input = 3;
        double expectedOutput = 1000;
        double actualOutput = DemoServices.Power(x, input);
        
        Assert.assertEquals(expectedOutput, actualOutput);
        
    }
    
    @Test
    public void test2() {
        int x = 10;
        int input = -3;
        double expectedOutput = 0.001;
        double actualOutput = DemoServices.Power(x, input);
        
        Assertions.assertEquals(expectedOutput, actualOutput);
        
    }
    
    @Test
    public void test3() {
        int x = 10;
        int input = 0;
        double expectedOutput = 1;
        double actualOutput = DemoServices.Power(x, input);
        
        Assertions.assertEquals(expectedOutput, actualOutput);
        
    }
    
    @Test
    public void test4() {
        int x = 10;
        int input = 1;
        double expectedOutput = 10;
        double actualOutput = DemoServices.Power(x, input);
        
        Assertions.assertEquals(expectedOutput, actualOutput);
        
    }
    
    @Test
    public void test5() {
        int x = 10;
        int input = -1;
        double expectedOutput = 0.1;
        double actualOutput = DemoServices.Power(x, input);
        
        Assertions.assertEquals(expectedOutput, actualOutput);
        
    }
    
    @Test
    public void test6() {
        int x = 0;
        int input = 0;
        double expectedOutput = 1;
        double actualOutput = DemoServices.Power(x, input);
        
        Assertions.assertEquals(expectedOutput, actualOutput);
        
    }
    
    @Test
    public void test7() {
        int x = 0;
        int input = -10;
        double expectedOutput = 0;
        double actualOutput = DemoServices.Power(x, input);
        
        Assertions.assertEquals(expectedOutput, actualOutput);
        
    }
    
    @Test
    public void test8() {
        int x = 0;
        int input = 10;
        double expectedOutput = 0;
        double actualOutput = DemoServices.Power(x, input);
        
        Assertions.assertEquals(expectedOutput, actualOutput);
        
    }
    @ParameterizedTest
    @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
    public void test(double num, int n){
        
    }
}
