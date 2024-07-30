import service.CustomerService;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;
import model.Customer;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create the repository implementation
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject repository into service
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        Customer customer = customerService.getCustomerById(1);

        if (customer != null) {
            System.out.println("Customer Found: ");
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
        } else {
            System.out.println("Customer not found.");
        }
    }
}