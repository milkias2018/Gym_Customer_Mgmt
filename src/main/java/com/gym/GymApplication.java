package com.gym;

import com.gym.dao.AddressJpaDao;
import com.gym.dao.CustomerDao;
import com.gym.dao.SubscriptionJpaDao;
import com.gym.dao.UserRepository;
import com.gym.entity.Address;
import com.gym.entity.Customer;
import com.gym.entity.Subscription;
import com.gym.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class GymApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(GymApplication.class);

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private AddressJpaDao addressJpaDao;
    @Autowired
    private SubscriptionJpaDao subscriptionJpaDao;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(GymApplication.class, args);
        logger.info("Hello from main class");
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        customerDao.save(new Customer("19901212-5456", "first_name", "mid_namn", "last_name", "074875544", 5, "2018-02-05"));
        addressJpaDao.save((new Address(customerDao.getCustomerByPersonNummer("19901212-5456"), "john street", 6, 1401, "SE-101", "municip", "City01", "Country01")));
        subscriptionJpaDao.save(new Subscription(customerDao.getCustomerByPersonNummer("19901212-5456"), "Premium", "12 months", 399, true, "Aktiv"));
        userRepository.save(new User("user", "$2y$12$1Le1E5.NCjX1mSL5T4jwOuaJ1OivlAnJp7PoM1FXdjLpNvMFDXQHq", "USER"));
        userRepository.save(new User("admin", "$2y$12$hPrPMO/m8ZthTVtMpusMg.MH4yb.TvQAnNz7LAXlzZk5E8o1K5tFW", "ADMIN"));
        logger.info("Customer from command line runner");
    }
}