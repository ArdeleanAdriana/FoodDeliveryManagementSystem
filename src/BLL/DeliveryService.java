package BLL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DL.FileWriiter;
import DL.Serializator;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {
	private Account account;

	Serializator s = new Serializator();
	public ArrayList<Account> userList = new ArrayList<Account>();
	public ArrayList<MenuItem> meniu = new ArrayList<MenuItem>();
	private HashMap<Order, ArrayList<MenuItem>> orders = new HashMap<Order, ArrayList<MenuItem>>();
	HashSet<MenuItem> meniu2 = new HashSet<MenuItem>();

	public DeliveryService() {
		userList = (ArrayList<Account>) s.deserializare("file.txt");
		meniu = (ArrayList<MenuItem>) s.deserializare("fileMenu.txt");
		orders = (HashMap<Order, ArrayList<MenuItem>>) s.deserializare("fileOrder.txt");

	}
	
	public void isWellFormed() {
		if(orders!=null)
			assert meniu!=null :"Null";
	}

	public ArrayList<Account> getUser() {
		return userList;
	}
	@Override
	public void addUser(Account a) {
		assert a!=null :"Null object";
		userList.add(a);
		Serializator s = new Serializator();
		s.serializare("file.txt", userList);
	}

	public void showUser() {

		for (Account z : userList) {
			System.out.println(z.getUsername() + ", " + z.getPassword() + ", " + z.getId() + "\n");

		}
		System.out.println("\n");
		System.out.println(userList.size());
	}
	@Override
	public void addProduct(MenuItem a) {
		assert a!=null :"Null object";
		meniu.add(a);

		Serializator s = new Serializator();
		s.serializare("fileMenu.txt", meniu);
	}

	public void showProduct() {

		for (MenuItem z : meniu) {
			System.out.println(z.getTitle() + ", " + z.getRating() + ", " + z.getCalories() + ", " + z.getProtein()
					+ ", " + z.getFat() + ", " + z.getSodium() + ", " + z.getPrice() + "\n");

		}
		System.out.println("\n");
		System.out.println(meniu.size());
	}
	@Override
	public void editMenuItem(String title, float rating, int calories, int protein, int fat, int sodium, float price) {
		assert title!=null :"Null title";
		MenuItem m = searchByName(title);
		m.setPrice(price);
		m.setRating(rating);
		m.setCalories(calories);
		m.setProtein(protein);
		m.setFat(fat);
		m.setSodium(sodium);
		Serializator s = new Serializator();
		s.serializare("fileMenu.txt", meniu);
	}
	@Override
	public MenuItem searchByName(String title) {
		assert title!=null :"Null title";
		for (MenuItem a : meniu) {
			if (title.equals(a.getTitle()))
				return a;
		}
		return null;

	}
	@Override
	public void deleteMenuItem(String str) {
		assert str!=null :"Null";
		MenuItem x = null;
		for (MenuItem m : meniu)
			if (str.equals(m.getTitle()))
				x = m;
		meniu.remove(x);
		Serializator s = new Serializator();
		s.serializare("fileMenu.txt", meniu);
	}
	@Override
	public void addInComposit(MenuItem m, MenuItem n) {
		assert n!=null :"Null object";
		m.add(n);
		m.computePrice();
		m.computeCalories();
		m.computeFat();
		m.computeSodium();
		m.computeProtein();
		m.computeRating();
	}

	public JTable showTable(ArrayList<MenuItem> me) {
		JTable tabel = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		String[] header = { "Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price" };
		Object[][] info = new Object[me.size()][header.length];
		int i = 0;

		for (MenuItem m : me) {
			info[i][0] = m.getTitle();
			info[i][1] = m.getRating();
			info[i][2] = m.getCalories();
			info[i][3] = m.getProtein();
			info[i][4] = m.getFat();
			info[i][5] = m.getSodium();
			info[i][6] = m.getPrice();
			i++;
		}
		tabel = new JTable(info, header);

		return tabel;
	}

	public static <T> Predicate<T> distinct(Function<? super T, ?> NameExtractor) {
		Set<Object> s = ConcurrentHashMap.newKeySet();
		return p -> s.add(NameExtractor.apply(p));
	}
	
	@Override
	public void importBaseProducts() {
		Function<String, BaseProduct> mapToItem = (line) -> {

			String[] l = line.split(",");

			BaseProduct item = new BaseProduct();
			item.setTitle(l[0]);
			item.setRating(Float.parseFloat(l[1]));
			item.setCalories(Integer.parseInt(l[2]));
			item.setProtein(Integer.parseInt(l[3]));
			item.setFat(Integer.parseInt(l[4]));
			item.setSodium(Integer.parseInt(l[5]));
			item.setPrice(Float.parseFloat(l[6]));

			return item;
		};

		ArrayList<BaseProduct> products;
		String inputFilePath = "C:\\Users\\Adriana Ardelean\\eclipse-workspace\\FoodDelivery\\products.csv";
		File inputF = new File(inputFilePath);
		InputStream inputFS = null;
		try {
			inputFS = new FileInputStream(inputF);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
		products = (ArrayList<BaseProduct>) br.lines().skip(1).map(mapToItem).filter(distinct(m -> m.getTitle()))
				.collect(Collectors.toList());
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		meniu2.addAll(products);

		meniu.addAll(meniu2);
		assert meniu!=null :"Null";
		Serializator s = new Serializator();
		s.serializare("fileMenu.txt", meniu);
	}

	public ArrayList<MenuItem> getMeniu() {
		return meniu;
	}

	public HashMap<Order, ArrayList<MenuItem>> getOrders() {
		return orders;
	}

	@Override
	public void AddOrder(Order ord, ArrayList<MenuItem> items) {
		assert ord!=null :"Null object";
		orders.put(ord, items);
		
		
		String str="Comanda ";
		str+=ord.getOrderId()+" s a plasat de catre clientul  "+ord.getClientId()+" si a comandat: ";
		for(MenuItem i : items)
			str+=i.getTitle() + ", ";
		str+= "la data ";
		str+=ord.getDate();
		str+="\n";
		setChanged();
		notifyObservers(str);
		Serializator s = new Serializator();
		s.serializare("fileOrder.txt", orders);
	}
	@Override
	public void report1(int startHour, int endHour) {
		assert startHour <25 :"Nu exista";
		assert endHour <25 :"Nu exista";
		ArrayList<Order> ok = new ArrayList<Order>();
		List<Order> orders2 = orders.keySet().stream().filter(o -> o.getDate().getHour() >= startHour)
				.filter(o1 -> o1.getDate().getHour() < endHour).collect(Collectors.toList());
		ok.addAll(orders2);
		String mesaj = new String("");
		for (Order o : ok) {
			mesaj=mesaj +o.getOrderId() + ", " + o.getClientId() + ", " + o.getDate() + "\n";
			System.out.println(o.getOrderId() + ", " + o.getClientId() + ", " + o.getDate() + "\n");

		}
		FileWriiter f= new FileWriiter();
		f.fisier("r1.txt",mesaj);
	}
	@Override
	public void report2(int nrTimes) {
		assert nrTimes >0 :"err";
		ArrayList<MenuItem> ok = new ArrayList<MenuItem>();
		ArrayList<MenuItem> products = new ArrayList<MenuItem>();
		for (Map.Entry<Order, ArrayList<MenuItem>> entry : orders.entrySet()) {
			products.addAll(entry.getValue());
		}
		ok = (ArrayList<MenuItem>) products.stream().filter(t -> Collections.frequency(products, t) >= nrTimes)
				.distinct().collect(Collectors.toList());
		String mesaj = new String("");
		for (MenuItem o : ok) {
			mesaj=mesaj + o.getTitle() + ", " + o.getRating() + ", " + o.getCalories() + ", " + o.getProtein()
			+ ", " + o.getFat() + ", " + o.getSodium() + ", " + o.getPrice() + "\n";
			System.out.println(o.getTitle() + "\n");
		}
		FileWriiter f= new FileWriiter();
		f.fisier("r2.txt",mesaj);
	}
	@Override
	public void report3(int nrTimes, Double amount) {
		assert nrTimes >0 :"err";
		assert amount >0 :"err";
		List<Account> ok = userList.stream()
				.filter(client -> orders.keySet().stream()
						.filter(order -> order.getClientId() == client.getId() && orders.get(order).stream()
								.mapToDouble(MenuItem::computePrice).reduce(0, Double::sum) >= amount)
						.count() >= nrTimes)
				.collect(Collectors.toList());
		String mesaj = new String("");
		for (Account o : ok) {
			mesaj=mesaj+o.getUsername()+ "\n";
			System.out.println(o.getUsername() + "\n");

		}
		FileWriiter f= new FileWriiter();
		f.fisier("r3.txt",mesaj);
	}
	
	@Override
	public void report4(int date) {
		assert date <32 :"err";
		List<MenuItem> products = new ArrayList<>();
		orders.keySet().stream().filter(order -> order.getDate().getDayOfMonth() == (date))
				.map(order -> orders.get(order)).forEach(products::addAll);
		Map<MenuItem, Integer> count = new HashMap<>();
		products.stream()
				.forEach(menuItem -> count.put(menuItem, count.get(menuItem) == null ? 1 : count.get(menuItem) + 1));
		Set<MenuItem> productsSet = new HashSet<>();
		productsSet.addAll(products);
		String mesaj = new String("");
		for (MenuItem product : productsSet) {
			mesaj=mesaj+count.get(product) + " , " + product.getTitle() + " \n";
			System.out.println(count.get(product) + " , " + product.getTitle() + " \n");
		}
		FileWriiter f= new FileWriiter();
		f.fisier("r4.txt",mesaj);
	}

}
