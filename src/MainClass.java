
import BLL.DeliveryService;
import Presentation.AddCompositeProductView;
import Presentation.AddProductView;
import Presentation.AdministratorView;
import Presentation.ClientView;
import Presentation.Controller;
import Presentation.DeleteEditProductView;
import Presentation.EmployeeView;
import Presentation.OrderView;
import Presentation.Report1View;
import Presentation.Report2View;
import Presentation.Report3View;
import Presentation.Report4View;
import Presentation.SearchView;
import Presentation.ShowProductsView;
import Presentation.View;

public class MainClass {
	public static void main(String[] args) {

		View view = new View();
		AdministratorView adminView = new AdministratorView();
		ClientView clientView = new ClientView();
		DeliveryService deliveryService = new DeliveryService();
		AddProductView addProductView = new AddProductView();
		AddCompositeProductView addCompositeProductView = new AddCompositeProductView();
		DeleteEditProductView deleteEditProductView = new DeleteEditProductView();
		ShowProductsView showProductsView = new ShowProductsView();
		SearchView searchView = new SearchView();
		OrderView orderView = new OrderView();
		Report1View r1 = new Report1View();
		Report2View r2 = new Report2View();
		Report3View r3 = new Report3View();
		Report4View r4 = new Report4View();
		EmployeeView employeeView= new EmployeeView();
		Controller controller = new Controller(view, adminView, clientView, employeeView,addProductView, addCompositeProductView,
				deleteEditProductView, showProductsView, searchView, orderView, r1, r2, r3, r4, deliveryService);
		view.setVisible(true);

	}
}
