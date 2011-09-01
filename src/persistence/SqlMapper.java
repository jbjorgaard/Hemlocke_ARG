package persistence;

import hello.domain.Thing;
import hello.presentation.Brain;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import test.Person;

public interface SqlMapper {
	public static String[] CREATE_TABLES = {
		"create table if not exists things (key INTEGER, type INTEGER, name TEXT, shortdesc TEXT, description TEXT, brain INTEGER, location INTEGER)",
		"create table if not exists brains (key INTEGER, owner INTEGER)",
		"create table if not exists thing_contents (thing INTEGER, content INTEGER)",
		"create table if not exists thing_links (thing INTEGER, links INTEGER)"
	};
	@Insert("insert into things (key, type, name, shortdesc, description, brain, location) values (#{key}, #{type}, #{name}, #{shortdesc}, #{description}, #{brain}, #{location})")
	void insertThing(Thing thing);
	
	@Insert("insert into brains (key, owner) values (#{key}, #{owner})")
	void insertBrain(Brain brain);
	
	@Insert("insert into thing_contents (thing, content) values (#{location}, #{key}")
	void insertContent(Thing thing);
	
	@Insert("insert into thing_links (thing1, thing2) values (#{thing1.key}, #{thing2.key}")
	void insertLink(@Param("thing1") Thing t1, @Param("thing2") Thing t2);
	
	@Select("select id as id, name as name")
	@Results({
		@Result(property="id", id=true),
		@Result(property="name", column="name", jdbcType=JdbcType.VARCHAR)
	})
	Thing getThingByName(@Param("name") String name);
	
	@Select("select things.id as id, name as name, addr as addr, ord as ord from friends, person where person1 = #{id} and person2 = person.id order by ord")
	@Results({
		@Result(property="id", id=true),
		@Result(property="name", column="name", jdbcType=JdbcType.VARCHAR),
		@Result(property="friends", column="id", many=@Many(select="getFriendsById"))
	})
	List<Person> getFriendsById(long id);

	@Select("select person.id as id, name as name, addr as addr from friends, person where person1 = (select id from person where name = #{name}) and person2 = person.id")
	@Results({
		@Result(property="id", id=true),
		@Result(property="name", column="name", jdbcType=JdbcType.VARCHAR),
		@Result(property="friends", column="id", many=@Many(select="getFriendsById"))
	})
	List<Person> getFriends(String name);

	@Select("select max(id) from person")
	int getLastPersonId();

	@Insert("update person set name = #{name,jdbcType=VARCHAR}, addr = #{addr} where id = #{id}")
	void updatePerson(Person p);
}