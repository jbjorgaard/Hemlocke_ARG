public class BlobCharacter extends Character {

		public BlobCharacter(String newName) {
			super(newName);
		}
		@Override
		public void damagedBy(Weapon w) {
			System.out.print("squish! ");
			super.damagedBy(w);
		}
		@Override
		public String toString() {
			return "[blob character: " + name+"]";
		}
	}
	
	