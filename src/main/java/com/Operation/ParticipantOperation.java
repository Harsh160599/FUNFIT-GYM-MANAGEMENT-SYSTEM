package com.Operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.application.Participant;
import com.connection.DbConnection;

public class ParticipantOperation {

    Connection connection = null;
    private PreparedStatement pstmt;

    public ParticipantOperation() throws Exception {
        connection = DbConnection.getConnection();
    }

    public String addNewParticipant(Participant par) throws SQLException {
        String res = "Err";
        try {
            pstmt = connection.prepareStatement("INSERT INTO Participant VALUES(?,?,?,?,?)");
            pstmt.setInt(1, par.getId());
            pstmt.setString(2, par.getName());
            pstmt.setString(3, par.getEmail());
            pstmt.setString(4, par.getPhoneNumber());
            pstmt.setInt(5, par.getBatchId());

            int ch = pstmt.executeUpdate();
            if (ch >= 1)
                res = "Success";

        } catch (Exception e) {
            res = "Err";
            System.out.println(e);
        }
        return res;
    }
    public List<Participant> getAllParticipants() throws SQLException {
        List<Participant> participants = new ArrayList<>();

        try(  PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Participant");
            ResultSet resultSet = pstmt.executeQuery();) {
          
            while (resultSet.next()) {
                Participant part = new Participant();
                part.setId(resultSet.getInt("id"));
                part.setName(resultSet.getString("name"));
                part.setEmail(resultSet.getString("email"));
                part.setPhoneNumber(resultSet.getString("phoneNumber"));
                part.setBatchId(resultSet.getInt("batchId"));
                participants.add(part);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return participants;
    }
    
    public String updateParticipant(Participant part) throws SQLException {
        String res = "Err";
        try {
            pstmt = connection.prepareStatement("UPDATE Participant SET name=?, email=?, phoneNumber=?, batchId=? WHERE id=?");
          
            pstmt.setString(1, part.getName());
            pstmt.setString(2, part.getEmail());
            pstmt.setString(3, part.getPhoneNumber());
            pstmt.setInt(4, part.getBatchId());
            pstmt.setInt(5, part.getId());
            int ch = pstmt.executeUpdate();
            if (ch >= 1)
                res = "Success";

        } catch (Exception e) {
            res = "Err";
            System.out.println(e);
        }
        return res;
    }
    public List<Integer> getAllParticipantIds() throws SQLException {
        List<Integer> patIds = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement("SELECT id FROM Participant");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int patId = resultSet.getInt("id");
               patIds.add(patId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return patIds;
    }
    
    public String deleteParticipant(int id) throws SQLException {
        String res = "Err";
       try {
    	   PreparedStatement pstmt = null;
           pstmt = connection.prepareStatement("Delete from Participant where id=?");
   		pstmt.setInt(1, id);
   		int ch = pstmt.executeUpdate();
   		if(ch>=1)
   			res = "Success";
   		
	} catch (Exception e) {
		// TODO: handle exception
		res = "Err";
		System.out.println(e);
	}
	return res;
}
}
