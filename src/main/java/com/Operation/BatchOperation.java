package com.Operation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.application.Batch;
import com.connection.DbConnection;
public class BatchOperation {
	Connection connection=null;
	private PreparedStatement pstmt;
	public BatchOperation()throws Exception{
		connection=DbConnection.getConnection();// call get conection using class name as it is static DbConnecion
	}
	public String AddNewBatch(Batch batch)  throws SQLException   // return type of method is string 
	{
		String reString="Err";
		try {
			pstmt=connection.prepareStatement("insert into Batch values(?,?,?)");
			pstmt.setInt(1, batch.getId());
			pstmt.setString(2, batch.getName());
			pstmt.setString(3,batch.getTime());
			
			int ch= pstmt.executeUpdate();
			if(ch>=1)
			{
				reString="Success";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return reString;
	}
	public List<Batch>  ViewAllBatch() throws SQLException
	{
		List<Batch>  batchList = new ArrayList<>();
		Batch batch = null;
		try(PreparedStatement pstmt= connection.prepareStatement("Select * from Batch");
				ResultSet batchset = pstmt.executeQuery();) {
			
			while(batchset.next())
			{
				batch = new Batch();
				 batch.setId(batchset.getInt("id"));
				batch.setName(batchset.getString("name"));
				batch.setTime(batchset.getString("time"));
				batchList.add(batch);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
            throw e;
		}
		return batchList;
	}
	public String UpdateBatch(Batch batch) throws SQLException
	{
		String res = "Err";
		try {
			pstmt = connection.prepareStatement("Update Batch set name=? , time=? where id=?");
			pstmt.setString(1,batch.getName());
			pstmt.setString(2, batch.getTime());
			pstmt.setInt(3,batch.getId());
			int ch = pstmt.executeUpdate();
			if(ch>=1)
				res = "Success";
			
		} catch (Exception e) {
			res = "Err";
			System.out.println(e);
		}
		return res;
	}
	public List<Integer> getAllBatchIds() throws SQLException {
        List<Integer> batchIds = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement("SELECT id FROM Batch");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int batchId = resultSet.getInt("id");
                batchIds.add(batchId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return batchIds;
    }
	public String DeleteBatch(int id) throws SQLException
	{
		String res = "Err";
		try {
			pstmt = connection.prepareStatement("Delete from Batch where id=?");
			pstmt.setInt(1, id);
			int ch = pstmt.executeUpdate();
			if(ch>=1)
				res = "Success";
			
		} catch (Exception e) {
			res = "Err";
			System.out.println(e);
		}
		return res;
	}

}
