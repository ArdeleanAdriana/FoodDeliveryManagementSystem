package BLL;

import java.util.ArrayList;
import java.util.Iterator;

public class CompositeProduct extends MenuItem {
	private String title;
	private float rating;
	private int calories;
	private int protein;
	private int fat;
	private int sodium;
	private float price;
	private ArrayList<MenuItem> list = new ArrayList<MenuItem>();

	public CompositeProduct(String title) {
		super(title, 0, 0, 0, 0, 0, 0);
	}

	public float computePrice() {
		float x = 0;
		Iterator<MenuItem> menuItemIterator = list.iterator();
		while (menuItemIterator.hasNext()) {
			MenuItem menuItem = menuItemIterator.next();
			x += menuItem.getPrice();
		}
		super.setPrice(x);
		return x;
	}

	@Override
	public  float computeRating() {
			int x = 0;
			int i=0;
			Iterator<MenuItem> menuItemIterator = list.iterator();
			while (menuItemIterator.hasNext()) {
				MenuItem menuItem = menuItemIterator.next();
				x += menuItem.getRating();
				i++;
			}
			super.setRating(x/i);
			return x;
		}
	
	
    @Override
	public  int computeCalories(){
    	int x = 0;		
		Iterator<MenuItem> menuItemIterator = list.iterator();
		while (menuItemIterator.hasNext()) {
			MenuItem menuItem = menuItemIterator.next();
			x += menuItem.getCalories();
		}
		super.setCalories(x);
		return x;
    }
    @Override
	public  int computeProtein(){
    	int x = 0;		
		Iterator<MenuItem> menuItemIterator = list.iterator();
		while (menuItemIterator.hasNext()) {
			MenuItem menuItem = menuItemIterator.next();
			x += menuItem.getProtein();
		}
		super.setProtein(x);
		return x;
    }
    @Override
	public  int computeFat(){
    	int x = 0;		
		Iterator<MenuItem> menuItemIterator = list.iterator();
		while (menuItemIterator.hasNext()) {
			MenuItem menuItem = menuItemIterator.next();
			x += menuItem.getFat();
		}
		super.setFat(x);
		return x;
    }
    @Override
	public  int computeSodium(){
    	int x = 0;		
		Iterator<MenuItem> menuItemIterator = list.iterator();
		while (menuItemIterator.hasNext()) {
			MenuItem menuItem = menuItemIterator.next();
			x += menuItem.getSodium();
		}
		super.setSodium(x);
		return x;
    }
	
	
	public void setPrice(float price) {
		super.setPrice(price);
	}
	
	public void setRating(float rating) {
        super.setRating(rating);
    }
    
    public void setCalories(int calories) {
        super.setCalories(calories);
    }
    
    public void setProtein(int protein) {
        super.setProtein(protein);
    }
    
    public void setFat(int sodium) {
        super.setFat(fat);
    }
    
    public void setSodium(int sodium) {
        super.setSodium(fat);
    }

	@Override
	public void add(MenuItem p) {
		list.add(p);
	}
}
