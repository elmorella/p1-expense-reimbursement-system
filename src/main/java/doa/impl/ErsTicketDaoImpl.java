package doa.impl;

import doa.dao.ErsTicketDao;
import model.ErsTicket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateConf;

import java.util.List;

public class ErsTicketDaoImpl implements ErsTicketDao {
    private final SessionFactory sessionFactory = HibernateConf.getSessionFactory();

    @Override
    public void addTicket(ErsTicket ticket) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
    }

    @Override
    public ErsTicket getTicketById(int id) {
        Transaction transaction = null;
        ErsTicket ticket = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            ticket = session.get(ErsTicket.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
        return ticket;
    }

    @Override
    public List<ErsTicket> getAllTickets() {
        Transaction transaction = null;
        List<ErsTicket> tickets = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            tickets = session.createQuery("from ers_tickets").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
        return tickets;
    }

    @Override
    public List<ErsTicket> getAllOpenTickets() {
        Transaction transaction = null;
        List<ErsTicket> tickets = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            tickets = session.createQuery("from ers_tickets where status='pending'").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
        return tickets;
    }

    @Override
    public List<ErsTicket> getAllClosedTickets() {
        Transaction transaction = null;
        List<ErsTicket> tickets = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            tickets = session.createQuery("from ers_tickets where status='resolved'").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
        return tickets;
    }

    @Override
    public List<ErsTicket> getTicketsByEmpIdAndStatus(int empId, String status) {
        Transaction transaction = null;
        List<ErsTicket> tickets = null;
        String query = "from ers_tickets where emp_id='" + empId + "' AND status='" + status + "'";
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            tickets = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
        return tickets;

    }

    @Override
    public void updateTicket(ErsTicket ticket) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
    }
}
