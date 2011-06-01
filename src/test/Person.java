package test;

import java.util.ArrayList;

/**
 * @author bill Mar 16, 2011
 */
public class Person {
	public long id;
	public Name name;
	public String addr;
	public ArrayList<Person> friends = new ArrayList<Person>();

	public static class Name {
		public String value;

		public Name(String n) {
			value = n;
		}
		@Override public String toString() {
			return value;
		}
	}

	/**
	 * needed for simple configuration of MyBatis
	 */
	public Person() {}
	/**
	 * For convenience -- doesn't assign an id
	 * @param name
	 * @param addr
	 */
	public Person(String name, String addr) {
		this.name = new Name(name);
		this.addr = addr;
	}
	@Override public String toString() {
		StringBuffer buf = new StringBuffer("Person(id: ");
		boolean first = true;

		buf.append(id).append(", name: ").append(name).append(", addr: ").append(addr).append(", friends: [");
		for (Person friend : friends) {
			if (first) {
				first = false;
			} else {
				buf.append(", ");
			}
			buf.append(friend.name);
		}
		buf.append("], hashCode: " + hashCode() + ")");
		return buf.toString();
	}
}
