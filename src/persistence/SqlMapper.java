package persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import test.Person;

public class SqlMapper {

	public interface SqlMapper {
		public static String[] CREATE_TABLES = {
			"create table if not exists brains (id integer primary key, owner varchar(128), type int);",
			"create table if not exists things (id integer primary key, name varchar(128), type int, description varchar(128), shortdesc varchar(128), brain int, location int);",
			"create table if not exists contents (owner int, contents int);",
			"create table links (location int, link int, name varchar(128));"
		};
/* need to go over this... */		
//		@Select("select id as id, name as name, addr as addr from person where name = #{name}")
//		@Results({
//			@Result(property="id", id=true),
//			@Result(property="name", column="NaMe", jdbcType=JdbcType.VARCHAR),
//			@Result(property="friends", column="id", many=@Many(select="getFriendsById"))
//		})
//		Person getPersonByName(String name);
//		
//		@Select("select person.id as id, name as name, addr as addr, ord as ord from friends, person where person1 = #{id} and person2 = person.id order by ord")
//		@Results({
//			@Result(property="id", id=true),
//			@Result(property="name", column="name", jdbcType=JdbcType.VARCHAR),
//			@Result(property="friends", column="id", many=@Many(select="getFriendsById"))
//		})
//		List<Person> getFriendsById(long id);
//
//		@Select("select person.id as id, name as name, addr as addr from friends, person where person1 = (select id from person where name = #{name}) and person2 = person.id")
//		@Results({
//			@Result(property="id", id=true),
//			@Result(property="name", column="name", jdbcType=JdbcType.VARCHAR),
//			@Result(property="friends", column="id", many=@Many(select="getFriendsById"))
//		})
//		List<Person> getFriends(String name);
//
//		@Select("select max(id) from person")
//		int getLastPersonId();
//
//		@Insert("insert into person (id, name, addr) values (#{id}, #{name,jdbcType=VARCHAR}, #{addr})")
//		void insertPerson(Person person);
//
//		@Insert("insert into person (name, addr) values (#{name,jdbcType=VARCHAR}, #{addr})")
//		void insertPersonNoId(Person person);
//
//		@Insert("insert into friends (person1, person2) values (#{person1.id}, #{person2.id})")
//		void insertFriend(@Param("person1") Person p1, @Param("person2") Person p2);
//
//		@Insert("update person set name = #{name,jdbcType=VARCHAR}, addr = #{addr} where id = #{id}")
//		void updatePerson(Person p);
	}
		
}
