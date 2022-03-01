package Presentation;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import BLL.Account;
import BLL.BaseProduct;
import BLL.CompositeProduct;
import BLL.DeliveryService;
import BLL.MenuItem;
import BLL.Order;

public class Controller {

	private View view;
	private AdministratorView adminView;
	private ClientView clientView;
	private EmployeeView employeeView;
	private ArrayList<Account> userList = new ArrayList<Account>();
	private ArrayList<MenuItem> itemInOrder = new ArrayList<MenuItem>();
	private ArrayList<MenuItem> meniu = new ArrayList<MenuItem>();
	private HashMap<Order, ArrayList<MenuItem>> orders;
	private Account account;
	private MenuItem menuItem;
	private BaseProduct baseProduct;
	private CompositeProduct compositeProduct;
	private AddProductView addProductView;
	private AddCompositeProductView addCompositeProductView;
	private DeleteEditProductView deleteEditProductView;
	private ShowProductsView showProductsView;
	private SearchView searchView;
	private OrderView orderView;
	private Report1View report1View;
	private Report2View report2View;
	private Report3View report3View;
	private Report4View report4View;
	DeliveryService deliveryService;
	int id = 0;
	int idOrder = 0;

	public Controller(View view, AdministratorView adminView, ClientView clientView,EmployeeView employeeView, AddProductView addProductView,
			AddCompositeProductView addCompositeProductView, DeleteEditProductView deleteEditProductView,
			ShowProductsView showProductsView, SearchView searchView, OrderView orderView, Report1View report1View,
			Report2View report2View, Report3View report3View, Report4View report4View,
			DeliveryService deliveryService) {
		this.employeeView=employeeView;
		this.view = view;
		this.adminView = adminView;
		this.clientView = clientView;
		this.addProductView = addProductView;
		this.deliveryService = deliveryService;
		this.addCompositeProductView = addCompositeProductView;
		this.deleteEditProductView = deleteEditProductView;
		this.showProductsView = showProductsView;
		this.searchView = searchView;
		this.orderView = orderView;
		this.report1View = report1View;
		this.report2View = report2View;
		this.report3View = report3View;
		this.report4View = report4View;
		deliveryService.addObserver(employeeView);
		deliveryService.isWellFormed();
		this.view.getLogin().addActionListener(e -> {
			if (view.role() == 2 && view.getUsername().equals("Adriana") && view.getPassword().equals("1234")) {
				adminView.setVisible(true);
			}
			if (view.role() == 1 && view.getUsername().equals("e") && view.getPassword().equals("1")) {
				employeeView.setVisible(true);
			}

			if (view.role() == 0) {
				userList = deliveryService.getUser();
				for (Account a : userList) {
					System.out.println(a.getUsername() + " , " + a.getId());
					if (a.getUsername().equals(view.getUsername()) && a.getPassword().equals(view.getPassword())) {
						account = a;
						clientView.setVisible(true);
					}
				}
			}

		});

		this.view.getRegister().addActionListener(e -> {
			if (view.role() == 0) {
				userList = deliveryService.getUser();
				id = userList.size();
				id++;
				account = new Account(view.getUsername(), view.getPassword(), id);
				deliveryService.addUser(account);
				deliveryService.showUser();
			}
		});

		this.adminView.getAddProducts().addActionListener(e -> {
			addProductView.setVisible(true);
		});
		this.clientView.getSearchProducts().addActionListener(e -> {
			searchView.setVisible(true);
		});

		this.searchView.searchBtn().addActionListener(e -> {
			meniu = deliveryService.getMeniu();
			ArrayList<MenuItem> ok1 = new ArrayList<MenuItem>();
			int x = searchView.tableField();

			if (x == 1) {
				List<MenuItem> meniuS1 = meniu.stream()
						.filter(item -> item.getTitle().equals(searchView.getTitleInput()))
						.collect(Collectors.toList());
				ok1.addAll(meniuS1);
			}

			if (x == 2) {
				List<MenuItem> meniuS1 = meniu.stream()
						.filter(item -> item.getRating() == Float.parseFloat(searchView.getRatingInput()))
						.collect(Collectors.toList());

				ok1.addAll(meniuS1);
			}

			if (x == 3) {
				List<MenuItem> meniuS1 = meniu.stream()
						.filter(item -> item.getCalories() == Integer.parseInt(searchView.getCaloriesInput()))
						.collect(Collectors.toList());

				ok1.addAll(meniuS1);
			}

			if (x == 4) {
				List<MenuItem> meniuS1 = meniu.stream()
						.filter(item -> item.getProtein() == Integer.parseInt(searchView.getProteinInput()))
						.collect(Collectors.toList());

				ok1.addAll(meniuS1);
			}

			if (x == 5) {
				List<MenuItem> meniuS1 = meniu.stream()
						.filter(item -> item.getFat() == Integer.parseInt(searchView.getFatInput()))
						.collect(Collectors.toList());
				ok1.addAll(meniuS1);
			}
			if (x == 6) {
				List<MenuItem> meniuS1 = meniu.stream()
						.filter(item -> item.getSodium() == Integer.parseInt(searchView.getSodiumInput()))
						.collect(Collectors.toList());
				ok1.addAll(meniuS1);
			}
			if (x == 7) {
				List<MenuItem> meniuS1 = meniu.stream()
						.filter(item -> item.getPrice() == Float.parseFloat(searchView.getPriceInput()))
						.collect(Collectors.toList());
				ok1.addAll(meniuS1);
			}

			createTable(ok1);
		});

		this.adminView.getImportProducts().addActionListener(e -> {
			deliveryService.importBaseProducts();
		});
		this.addProductView.addBtn().addActionListener(e -> {
			try {

				float rating = Float.parseFloat(addProductView.getRatingInput());
				int calories = Integer.parseInt(addProductView.getCaloriesInput());
				int protein = Integer.parseInt(addProductView.getProteinInput());
				int fat = Integer.parseInt(addProductView.getFatInput());
				int sodium = Integer.parseInt(addProductView.getSodiumInput());
				float price = Float.parseFloat(addProductView.getPriceInput());
				String title = addProductView.getTitleInput();

				// rating = Integer.parseInt(addProductView.getRatingInput());
				baseProduct = new BaseProduct(title, rating, calories, protein, fat, sodium, price);
				deliveryService.addProduct(baseProduct);
			} catch (Exception ex) {
				System.out.println("nu se poate adauga produsul");
			}
		});

		this.addProductView.addCompositeBtn().addActionListener(e -> {
			addCompositeProductView.setVisible(true);
		});

		this.adminView.getDeleteProducts().addActionListener(e -> {
			deleteEditProductView.setVisible(true);
		});
		this.adminView.getShowProducts().addActionListener(e -> {
			JFrame tabelP = new JFrame("Products");
			meniu = deliveryService.getMeniu();
			JTable tabel = deliveryService.showTable(meniu);

			JScrollPane scroll = new JScrollPane(tabel);
			tabelP.add(scroll);
			tabelP.setBounds(400, 250, 600, 400);
			tabelP.setVisible(true);
			// deliveryService.showProduct();
		});
		this.clientView.getShowProductsClient().addActionListener(e -> {
			JFrame tabelP = new JFrame("Products");
			meniu = deliveryService.getMeniu();
			JTable tabel = deliveryService.showTable(meniu);
			JScrollPane scroll = new JScrollPane(tabel);
			tabelP.add(scroll);
			tabelP.setBounds(400, 250, 600, 400);
			tabelP.setVisible(true);
			// deliveryService.showProduct();
		});

		this.clientView.getOrder().addActionListener(e -> {
			orderView.setVisible(true);

		});
		this.orderView.getAddPBtn().addActionListener(e -> {
			String title = orderView.getInput();
			if (deliveryService.searchByName(title) == null)
				System.out.println("Nu exista produsul");
			else {
				MenuItem m = deliveryService.searchByName(title);
				itemInOrder.add(m);
			}

		});
		this.orderView.getOrderBtn().addActionListener(e -> {
			orders = deliveryService.getOrders();
			idOrder = orders.size();
			idOrder++;
			Order order = new Order(idOrder, account.getId(), LocalDateTime.now());

			deliveryService.AddOrder(order, itemInOrder);
			System.out.println(order.getOrderId() + ", " + order.getClientId() + " ," + order.getDate() + "\n");
			for (MenuItem z : itemInOrder) {
				System.out.println(z.getTitle() + "\n");

			}
			float price = 0.0f;
			for (MenuItem i : itemInOrder) {
				price += i.computePrice();
			}
			orderView.setPret(price);
			try {
				FileWriter myWriter = new FileWriter("bill.txt");
				myWriter.write(
						"Order with id " + order.getOrderId() + " for client " + order.getClientId() + " in total of "
								+ price + " on date: " + order.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE)
								+ " on hour: " + order.getDate().format(DateTimeFormatter.ISO_LOCAL_TIME) + "\n");
				for (MenuItem z : itemInOrder) {
					myWriter.write(z.getTitle() + "\n");

				}
				myWriter.close();
			} catch (Exception ex) {
				System.out.println("An error occurred.");
				ex.printStackTrace();
			}

			itemInOrder.removeAll(itemInOrder);

		});
		this.deleteEditProductView.deleteBtn().addActionListener(e -> {
			String title = deleteEditProductView.getDeletedTitle();
			deliveryService.deleteMenuItem(title);
			// deliveryService.showProduct();
		});

		this.deleteEditProductView.editBtn().addActionListener(e -> {
			try {

				float rating = Float.parseFloat(deleteEditProductView.getEditedRating());
				int calories = Integer.parseInt(deleteEditProductView.getEditedCalories());
				int protein = Integer.parseInt(deleteEditProductView.getEditedProtein());
				int fat = Integer.parseInt(deleteEditProductView.getEditedFat());
				int sodium = Integer.parseInt(deleteEditProductView.getEditedSodium());
				float price = Float.parseFloat(deleteEditProductView.getEditedPrice());
				String title = deleteEditProductView.getEditedTitle();

				deliveryService.editMenuItem(title, rating, calories, protein, fat, sodium, price);
				// deliveryService.showProduct();
				// rating = Integer.parseInt(addProductView.getRatingInput());

			} catch (Exception ex) {
				System.out.println("nu se poate adauga produsul");
			}

		});

		this.addCompositeProductView.addBPBtn().addActionListener(e -> {

			MenuItem m = deliveryService.searchByName(addCompositeProductView.getCPtitle());
			if (m == null) {
				compositeProduct = new CompositeProduct(addCompositeProductView.getCPtitle());
				deliveryService.addProduct(compositeProduct);
				m = deliveryService.searchByName(addCompositeProductView.getCPtitle());
			}
			MenuItem n = deliveryService.searchByName(addCompositeProductView.getBPTitle());
			deliveryService.addInComposit(m, n);
			deliveryService.showProduct();
		});
		this.adminView.getReport1().addActionListener(e -> {
			report1View.setVisible(true);
		});
		this.adminView.getReport2().addActionListener(e -> {
			report2View.setVisible(true);
		});
		this.adminView.getReport3().addActionListener(e -> {
			report3View.setVisible(true);
		});
		this.adminView.getReport4().addActionListener(e -> {
			report4View.setVisible(true);
		});
		this.report1View.getR1().addActionListener(e -> {
			deliveryService.report1(report1View.oraS(), report1View.oraE());
		});
		this.report2View.getR2().addActionListener(e -> {
			deliveryService.report2(report2View.getNr());
		});
		this.report3View.getR3().addActionListener(e -> {
			deliveryService.report3(report3View.getNumberOfTimes(), report3View.getAmount());
		});
		this.report4View.getR4().addActionListener(e -> {
			deliveryService.report4(report4View.getDay());
		});

	}

	public void createTable(ArrayList<MenuItem> a) {
		JFrame tabelP = new JFrame("Frame");
		JTable tabel = deliveryService.showTable(a);
		JScrollPane scroll = new JScrollPane(tabel);
		tabelP.add(scroll);
		tabelP.setBounds(400, 250, 600, 400);
		tabelP.setVisible(true);
	}

}
