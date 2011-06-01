package dataswarm.mybatis;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import SQLite.JDBCDriver;

/**
 * @author bill Mar 18, 2011
 *
 * @param <T>
 */
public class SqliteDataSource implements DataSource {
	private String connectionURL;

	public SqliteDataSource(String connectionUrl) {
		this.connectionURL = connectionUrl;
	}
	@Override public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}
	@Override public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}
	@Override public void setLoginTimeout(int seconds) throws SQLException {
	}
	@Override public void setLogWriter(PrintWriter out) throws SQLException {
	}
	@Override public int getLoginTimeout() throws SQLException {
		return 0;
	}
	@Override public PrintWriter getLogWriter() throws SQLException {
		return new PrintWriter(System.out);
	}
	@Override public Connection getConnection(String username, String password) throws SQLException {
		return new JDBCDriver().connect(connectionURL, null);
	}
	@Override public Connection getConnection() throws SQLException {
		return new JDBCDriver().connect(connectionURL, null);
	}
}