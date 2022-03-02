package com.example.spring_course_boot.dao;



import com.example.spring_course_boot.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override

    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//
//        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
//

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {

//        Session session = entityManager.unwrap(Session.class);
//
//        session.saveOrUpdate(employee);

        entityManager.merge(employee);
    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee emp = session.get(Employee.class, id);

        Employee emp = entityManager.find(Employee.class, id);


            return emp;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee " + "where id =:empId");
//        query.setParameter("empId", id);
//        query.executeUpdate();
        Query query = entityManager.createQuery("delete from Employee " + "where id =:empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }


}
