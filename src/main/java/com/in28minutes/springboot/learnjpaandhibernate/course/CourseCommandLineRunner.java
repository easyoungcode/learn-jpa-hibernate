package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository jpaRepository;

    @Autowired
    private CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseSpringDataJpaRepository.save(new Course(1, "Learn AWS Now!", "in28"));
        courseSpringDataJpaRepository.save(new Course(2, "Learn DEV Now!", "in28"));
        courseSpringDataJpaRepository.save(new Course(3, "Learn SQL Now!", "in28"));
        courseSpringDataJpaRepository.deleteById(2l);

        //System.out.println(courseSpringDataJpaRepository.findById(1l));
        //System.out.println(courseSpringDataJpaRepository.findById(3l));

        System.out.println(courseSpringDataJpaRepository.findAll());
        System.out.println(courseSpringDataJpaRepository.count());

        System.out.println(courseSpringDataJpaRepository.findByAuthor("in28"));
        System.out.println(courseSpringDataJpaRepository.findByName("Learn AWS Now!"));
    }
}
