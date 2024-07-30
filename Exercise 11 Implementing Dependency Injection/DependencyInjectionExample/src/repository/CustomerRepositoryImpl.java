package repository;

import model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Customer findCustomerById(int id) {
        // Simulate database access
        if (id == 1) {
            return new Customer(62, "Shrestha Paul", "shrestha.paul@example.com");
        }
        return null;
    }
}