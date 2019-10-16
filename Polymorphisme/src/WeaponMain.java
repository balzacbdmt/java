
public class WeaponMain {
	public static void main(String[] args) {
		WeaponStore store = new WeaponStore();
		store.price(new Axe());
		store.price(new Weapon(22));
		
	}
}
