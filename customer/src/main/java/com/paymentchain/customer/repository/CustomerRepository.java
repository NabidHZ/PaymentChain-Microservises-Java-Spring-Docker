package com.paymentchain.customer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.paymentchain.customer.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Long> { //Utiliza long porque la primarikey de Customr es long

    //Estar interfaz me permite guradar y mandar datos , sin la necesidad de escribir esos metoddos

    //Dentro de JpaRepository ya estan los metodos  CRUD que seran heredados por esta interfaz y los que usen esta interfaz
}
