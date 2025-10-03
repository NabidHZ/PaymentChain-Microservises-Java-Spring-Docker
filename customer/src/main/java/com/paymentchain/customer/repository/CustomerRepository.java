package com.paymentchain.customer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.paymentchain.customer.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Long> { //Utiliza long porque la primarikey de Customr es long

    //Estar interfaz me permite guradar y mandar datos a la base de datos


}
