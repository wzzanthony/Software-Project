package test.test;

import java.sql.Connection;

import test.util.ConnectionFactory;

public class ConnectionFactoryTest {

	public static void main(String[] args) throws Exception{
		ConnectionFactory cf=ConnectionFactory.getInstance();
		Connection conn=cf.makeConnection();
		System.out.println(conn.getAutoCommit());
	}

}
