public class GhostCharacter extends Character {
		public GhostCharacter(String newName) {
			super(newName);
		}
		@Override
		public void damagedBy(Weapon w) {
			System.out.println("Whoosh! Your " + w + " passes through without harm.");
		}
		@Override
		public String toString() {
			return "[ghost character: " + name + "]";
		}
	}
	
	