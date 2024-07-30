package repository;

import model.Customer;

public interface CustomerRepository {
    Customer findCustomerById(int id);
}