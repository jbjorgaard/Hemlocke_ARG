package persistence;

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

import test.Mapper;
import test.Person;
import test.Person.Name;

import dataswarm.mybatis.SqliteDataSource;

public class SqlMain {
	private static SqlMapper m;
	
	public static void main(String[] args) throws SQLException {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, new SqliteDataSource("sqlite://tmp/hemlockedb"));
		Configuration configuration = new Configuration(environment);
		configuration.setCacheEnabled(true);
		configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
		configuration.setUseColumnLabel(true);
/* I dont quite get the Name class declaration in Person in the example */
//		configuration.getTypeHandlerRegistry().register(Name.class, JdbcType.VARCHAR, new SqlNameTypeHandler());
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		SqlSession session = sqlSessionFactory.openSession();
		configuration.addMapper(SqlMapper.class);
		
		try {
			Statement st = session.getConnection().createStatement();
			for (String stmt : SqlMapper.CREATE_TABLES) {
				st.execute(stmt);
			}
			session.commit(true);
			st.close();
			m = session.getMapper(SqlMapper.class);
/* Create and insert Things into db + brains and links.  Write constructors for each */			
//			Person fred = insertPerson(new Person("fred", "123 Elm Street"));
//			Person joe = insertPerson(new Person("joe", "555 Phonebook Terrace"));
//			Person mary = insertPerson(new Person("mary", "1313 Mockingbird Lane"));
//			m.insertFriend(fred, joe);
//			m.insertFriend(fred, mary);
//			m.insertFriend(joe, mary);
//			Person fred2 = m.getPersonByName("fred");
//			System.out.println(fred2);
//			System.out.println("fred1: " + fred + ", fred2: " + fred2 + ", fred3: " + fred2.friends.get(0).friends.get(0).hashCode());
			session.commit(true);
		} finally {
			session.close();
		}
	}

/* Need to create methods in Thing to make this work */
//	private static Thing insertThing(Thing p) {
//		m.insertThingNoId(p);
//		p.id = m.getLastThingId();
//		return p;
//	}
}
