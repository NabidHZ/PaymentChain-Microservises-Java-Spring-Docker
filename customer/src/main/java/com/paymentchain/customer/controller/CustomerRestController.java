package com.paymentchain.customer.controller;

import com.paymentchain.customer.entities.Customer;
import com.paymentchain.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //indica que la clase es un controlador REST y que sus métodos devuelven directamente JSON o XML como respuesta.
@RequestMapping("/customer") //Esto define la URL
class CustomerRestController {

    @Autowired //Inyecta la dependencia del repositorio
    CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> list() {
        return customerRepository.findAll();
    }//Devulve todos los clientes

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);//Devuelve el cliente con el id especificado
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//Si no encuentra el cliente con el id especificado, devuelve un error 404
        }
    }//Devuelve un cliente por id

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Customer input) {//El @PutMapping indica que este método maneja solicitudes HTTP PUT
        Optional<Customer> optionalcustomer = customerRepository.findById(id); //Busca el cliente por id
        if (optionalcustomer.isPresent()) {
            Customer newcustomer = optionalcustomer.get();
            newcustomer.setName(input.getName());
            newcustomer.setPhone(input.getPhone());
            Customer save = customerRepository.save(newcustomer);
            return new ResponseEntity<>(save, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }//El @PathVariable indica que el valor de "id" se obtiene de la URL, mientras que @RequestBody indica que el valor de "input" se obtiene del cuerpo de la solicitud HTTP.

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Customer input) {
        Customer save = customerRepository.save(input);
        return ResponseEntity.ok(save);
    }//Expone enpoint HTTP POST para crear un nuevo cliente
    //@RequestBody Customer input: Indica que el cuerpo de la solicitud HTTP se deserializa automáticamente a un objeto Customer y se pasa como parámetro input al método.


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
