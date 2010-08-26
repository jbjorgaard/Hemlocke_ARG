public class SlashingWeapon extends Weapon {
		public SlashingWeapon(String newWeapon) {
			super(newWeapon);
		}

		public void hit(Character c){
			System.out.println(this + " is about to slash " + c);
			c.damagedBy(this);
		}
	}
	
	