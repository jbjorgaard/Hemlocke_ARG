package test;

import java.sql.SQLException;
import java.sql.Statement;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.JdbcType;
import test.Person.Name;
import dataswarm.mybatis.SqliteDataSource;

/**
 * @author bill Mar 15, 2011
 */
public class Main {
	private static Mapper m;

	public static void main(String[] args) throws SQLException {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, new SqliteDataSource("sqlite://tmp/test2"));
		Configuration configuration = new Configuration(environment);
		configuration.setCacheEnabled(true);
		configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
		configuration.setUseColumnLabel(true);
		configuration.getTypeHandlerRegistry().register(Name.class, JdbcType.VARCHAR, new NameTypeHandler());
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		SqlSession session = sqlSessionFactory.openSession();
		configuration.addMapper(Mapper.class);

		try {
			Statement st = session.getConnection().createStatement();
			for (String stmt : Mapper.CREATE_TABLES) {
				st.execute(stmt);
			}
			session.commit(true);
			st.close();
			m = session.getMapper(Mapper.class);
			Person fred = insertPerson(new Person("fred", "123 Elm Street"));
			Person joe = insertPerson(new Person("joe", "555 Phonebook Terrace"));
			Person mary = insertPerson(new Person("mary", "1313 Mockingbird Lane"));
			m.insertFriend(fred, joe);
			m.insertFriend(fred, mary);
			m.insertFriend(joe, mary);
			Person fred2 = m.getPersonByName("fred");
			System.out.println(fred2);
			System.out.println("fred1: " + fred + ", fred2: " + fred2 + ", fred3: " + fred2.friends.get(0).friends.get(0).hashCode());
			session.commit(true);
		} finally {
			session.close();
		}
	}

	private static Person insertPerson(Person p) {
		m.insertPersonNoId(p);
		p.id = m.getLastPersonId();
		return p;
	}
}
