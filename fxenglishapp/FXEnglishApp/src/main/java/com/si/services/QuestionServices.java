/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.si.services;

import com.si.pojo.Choice;
import com.si.pojo.JdbcUtils;
import com.si.pojo.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionServices {
    public List<Question> getQuestions(int num) throws SQLException {
        List<Question> result = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareCall("SELECT * FROM question ORDER BY rand() LIMIT ?");
            stm.setInt(1, num);
            
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
                result.add(q);
            }
            return result;
        }
    }
    
    
    public List<Question> getQuestions(String kw) throws SQLException {
        List<Question> result = new ArrayList<>();
        try(Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm = conn.prepareCall("SELECT * FROM question WHERE content like concat('%', ?, '%') ORDER BY id desc");
            stm.setString(1, kw);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
                result.add(q);
            }
        return result;
    }
}
    
    
    public void InsertQuestions(Question q, List<Choice> choices) throws SQLException {
        try(Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO question(id, content, category_id) VALUES(?, ?, ?)";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, q.getId());
            stm.setString(2, q.getContent());
            stm.setInt(3, q.getCategoryId());
            int k = stm.executeUpdate();
            
            for(var c: choices) {
                sql = "INSERT INTO choice(id, content, is_correct, question_id) VALUES(?, ?, ?, ?)";
                PreparedStatement stm2 = conn.prepareCall(sql);
                stm2.setString(1, c.getId());
                stm2.setString(2, c.getContent());
                stm2.setBoolean(3, c.isCorrect());
                stm2.setString(4, c.getQuestionId());
                int l = stm2.executeUpdate();
            }
            
            conn.commit();
            
        }
    }
        
    public void deleteQuestion(String id) throws SQLException {
        try(Connection conn = JdbcUtils.getConn()) {
           conn.setAutoCommit(false);
           String sql = "DELETE FROM question WHERE id=?";
           PreparedStatement stm = conn.prepareCall(sql);
           stm.setString(1, id);
           int l = stm.executeUpdate();
           
           conn.commit();
        }
    }
}
