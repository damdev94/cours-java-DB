package com.company.core.tennis.repository;

import com.company.core.tennis.DataSourceProvider;
import com.company.core.tennis.entity.Score;

import javax.sql.DataSource;
import java.sql.*;

public class ScoreRepositoryImpl {

    public void create (Score score){

        Connection conn = null;

        try {
            DataSource dataSource = DataSourceProvider.getSingleDataSourceInstance();

            conn = dataSource.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO SCORE_VAINQUEUR (`MATCH`, SET_1, SET_2, SET_3, SET_4, SET_5) VALUES (?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setLong(1, score.getMatch().getId());
            preparedStatement.setByte(2, score.getSet1());
            preparedStatement.setByte(3, score.getSet2());
            preparedStatement.setByte(4, score.getSet3());
            if(score.getSet4() == null){
                preparedStatement.setNull(5, Types.TINYINT);
            }else {
                preparedStatement.setByte(5, score.getSet4());
            }
            if(score.getSet5() == null){
                preparedStatement.setNull(6, Types.TINYINT);
            }else {
                preparedStatement.setByte(6, score.getSet5());
            }

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            if(rs.next()){
                score.setId(rs.getLong(1));
            }

            System.out.println("Score crée");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
