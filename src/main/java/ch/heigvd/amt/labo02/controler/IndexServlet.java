package ch.heigvd.amt.labo02.controler;

import ch.heigvd.amt.labo02.business.ICounterManager;
import sun.awt.Mutex;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {

    @EJB
    ICounterManager counterManager;

    private Integer count = 0;
    private Mutex mutex = new Mutex();
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mutex.lock();
        count = count + 1;
        mutex.unlock();

        req.setAttribute("title", "Index page");
        req.setAttribute("count", count.toString());
        req.setAttribute("id", counterManager.getId());
        req.setAttribute("staticCount", counterManager.increment());
        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }
}
