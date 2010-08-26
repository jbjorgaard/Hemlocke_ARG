public class Weapon {
		private String type;
		public Weapon(String newWeapon) {
			type = newWeapon;
		}
		public void hit(Character c){
			System.out.println(this + " is about to hit " + c);
			c.damagedBy(this);
		}
		@Override
		public String toString() {
			return "[weapon: " + type +"]";
		}
		public static void main(String[] args) {
			Weapon w = new Weapon("toothpick");
			Weapon s = new SlashingWeapon("spoon");
			Weapon p = new PropWeapon("rubber duck");
			Character c = new BlobCharacter("JimBob");
			Character d = new Character("BillyBob");
			Character g = new GhostCharacter("Casper");
			
			w.hit(d);
			s.hit(c);
			p.hit(g);
		}
}
	
	