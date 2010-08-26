
public class Character {
	protected String name;
	public Character(String newName) {
		name = newName;
	}
	public void damagedBy(Weapon w) {
		System.out.println(this + " was damaged by " + w);
	}
	@Override
	public String toString() {
		return "[character: " + name+"]";
	}
	public void boppedBy(PropWeapon p) {
		// TODO Auto-generated method stub
		
	}
}

