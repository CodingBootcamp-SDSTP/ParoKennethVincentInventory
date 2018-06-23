package src;
import java.util.ArrayList;

public class InventoryCollection
{
	ArrayList<Inventory> inventory;

	public InventoryCollection() {
		inventory = new ArrayList<Inventory>();
	}

	public void addInventory(Inventory i) {
		inventory.add(i);
	}

	public void removeInventory(Inventory i) {
		inventory.remove(i);
	}

	public ArrayList<Inventory> getAllInventory() {
		return(inventory);
	}

	public Inventory getInventoryByIndex(int n) {
		return(inventory.get(n));
	}

	public int getInventoryCount() {
		return(inventory.size());
	}
}
