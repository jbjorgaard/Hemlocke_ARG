package test;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import test.Person.Name;

/**
 * @author bill Mar 31, 2011
 */
public class NameTypeHandler implements TypeHandler {
	@Override public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, ((Name)parameter).value);
	}
	@Override public Object getResult(ResultSet rs, String columnName) throws SQLException {
		return new Name(rs.getString(columnName));
	}
	@Override public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return new Name(cs.getString(columnIndex));
	}
}
