package coreclasses;
public class PropWeapon extends Weapon {
		public PropWeapon(String newWeapon) {
			super(newWeapon);
		}
		public void hit(Character c) {
			System.out.println(this + " is about to bop " + c + " and do no harm.");
			c.boppedBy(this);
		}
}
	

