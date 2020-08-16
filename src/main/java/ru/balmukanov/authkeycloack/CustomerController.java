package ru.balmukanov.authkeycloack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
        addCustomers();
        Iterable<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("username", principal.getName());
        return "customers";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "external";
    }

    public void addCustomers() {

        Customer customer1 = new Customer();
        customer1.setAddress("1111 foo bar");
        customer1.setName("Name 1");
        customer1.setServiceRendered("Important services");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setAddress("2222 foo bar");
        customer2.setName("Name 2");
        customer2.setServiceRendered("Important services");
        customerRepository.save(customer2);

        Customer customer3 = new Customer();
        customer3.setAddress("33 foo bar");
        customer3.setName("Name 3");
        customer3.setServiceRendered("Important services");
        customerRepository.save(customer3);
    }
}
