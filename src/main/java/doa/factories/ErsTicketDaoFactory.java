package doa.factories;

import doa.dao.ErsTicketDao;
import doa.impl.ErsTicketDaoImpl;

public class ErsTicketDaoFactory {
    private static ErsTicketDao ersTicketDao;

    private ErsTicketDaoFactory() {}

    public static ErsTicketDao getErsTicketDao() {
        if (ersTicketDao == null) {
            ersTicketDao = new ErsTicketDaoImpl();
        }
        return ersTicketDao;
    }
}
