package net.kum.starter.controller;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.kum.starter.model.Customer;

@CrossOrigin(value="http://localhost:4200")
@RestController
public class RestAPIs {

	
	private Map<Long, Customer> customers = new HashMap<Long, Customer>(){
		
		private static final long serialVersionUID = 1L;
 
		{
	        put(1L, new Customer(1L, "Joe", "Thomas", 36));
	        put(2L, new Customer(2L, "Peter", "Smith", 18));
	        put(3L, new Customer(3L, "Lauren", "Taylor", 31));
	        put(4L, new Customer(4L, "Mary", "Taylor", 24));
	        put(5L, new Customer(5L, "David", "Moore", 25));
	        put(6L, new Customer(6L, "Holly", "Davies", 27));
	        put(7L, new Customer(7L, "Michael", "Brown", 45));
	    }
	};
	
	@GetMapping(value="/api/customers")
	public List<Customer> getAll(){
		List<Customer> results = customers.entrySet().stream()
									.map(entry -> entry.getValue())
									.collect(Collectors.toList());
		return results;
	}
	
	@GetMapping(value="/api/customers/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		System.out.println(id);
		return customers.get(id);
	}
	
	@PostMapping(value="/api/customers")
	public Customer postCustomer(@RequestBody Customer customer) {
		Entry<Long, Customer> maxByKey = customers.entrySet().stream()
											.reduce((curr, nxt) -> curr.getKey() > nxt.getKey() ? curr : nxt)
											.get();
		Long nextId = (long) (maxByKey.getKey()+1);
		customer.setId(nextId);
		customers.put(nextId,customer);
		return customer;
	}
	
	@PutMapping(value="/api/customers")
	public void putCustomer(@RequestBody Customer customer) {
		customers.replace(customer.getId(), customer);
	}
	
	@DeleteMapping(value="/api/customers/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customers.remove(id);
	}
	
}
