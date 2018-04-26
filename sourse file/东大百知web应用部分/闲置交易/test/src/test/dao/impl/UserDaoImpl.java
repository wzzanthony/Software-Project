package test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.dao.UserDao;
import test.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(Connection conn, User user) throws SQLException {
		PreparedStatement ps=conn.prepareCall("INSERT INTO tbl_user(name,password,email) VALUES(?,?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.execute();
	}

	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		String updateSql="UPDATE tbl_user SET name=?,password=?,email=? WHERE id=?";
		PreparedStatement ps=conn.prepareStatement(updateSql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setLong(4, id);
		ps.execute();
	}

	@Override
	public void delete(Connection conn, User user) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("DELETE FROM tbl_user WHERE id=?");
		ps.setLong(1, user.getId());
		ps.execute();

	}

}
