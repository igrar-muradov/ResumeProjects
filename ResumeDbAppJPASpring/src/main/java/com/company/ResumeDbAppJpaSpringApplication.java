package com.company;

import com.company.dao.impl.UserRepository;
import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class ResumeDbAppJpaSpringApplication {

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userDao;

    public static void main(String[] args) {
        SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner run() {
//        CommandLineRunner clr = new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                List<User> list = userDao.getAll(null, null, null);
//
//                User u = list.get(0);
//                System.out.println(u);
//            }
//        };
//        return clr;
//    }

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<User> list = userRepository.findAll();
                System.out.println(list);

                list = userRepository.findAll(Sort.by(Sort.Order.desc("id")));
                System.out.println(list);;

                User uu = userRepository.findByEmail("sarkhanrasullu@gmail.com");
                System.out.println(uu);
            }
        };
        return clr;
    }
}
