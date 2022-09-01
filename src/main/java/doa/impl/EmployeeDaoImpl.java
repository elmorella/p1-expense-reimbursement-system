package doa.impl;

import doa.dao.EmployeeDao;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateConf;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private final SessionFactory sessionFactory = HibernateConf.getSessionFactory();

    @Override
    public void addEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        Transaction transaction = null;
        Employee employee = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
        return employee;
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        Transaction transaction = null;
        Employee employee = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            String query = "from Employee where email = " + "'" + email + "'";
            employee = (Employee) session.createQuery(query).list().get(0);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Transaction transaction = null;
        List<Employee> employees = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            employees = session.createQuery("from Employee").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }

    }

    @Override
    public void deleteEmployeeById(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee == null)
                System.out.println("Employee: " + id + " does not exist");
            else {
                session.delete(employee);
                System.out.println("Employee deleted successfully!");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
    }
}
