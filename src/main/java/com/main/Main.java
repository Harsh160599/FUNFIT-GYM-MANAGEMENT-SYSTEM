package com.main;

import java.sql.Connection;

import org.apache.jasper.compiler.NewlineReductionServletWriter;

import com.Operation.BatchOperation;
import com.connection.DbConnection;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		Connection connection=DbConnection.getConnection();
	}

}
