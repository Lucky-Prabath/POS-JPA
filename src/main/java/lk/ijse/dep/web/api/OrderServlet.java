package lk.ijse.dep.web.api;

import lk.ijse.dep.web.AppInitializer;
import lk.ijse.dep.web.business.custom.OrderBO;
import lk.ijse.dep.web.dto.OrderDTO;
import lk.ijse.dep.web.exception.HttpResponseException;
import lk.ijse.dep.web.exception.ResponseExceptionUtil;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/
@WebServlet(urlPatterns = "/api/v1/orders")
public class OrderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            super.service(req, resp);
        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        final EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        try {
            OrderDTO dto = jsonb.fromJson(req.getReader(), OrderDTO.class);

            if (dto.getOrderId() == null || dto.getOrderId().trim().isEmpty() || dto.getOrderDate() == null || dto.getOrderDetails().isEmpty()) {
                throw new HttpResponseException(400, "Invalid order details", null);
            }

            OrderBO orderBO = AppInitializer.getContext().getBean(OrderBO.class);
            orderBO.setEntityManager(em);
            orderBO.placeOrder(dto);
            resp.setStatus(HttpServletResponse.SC_CREATED);
        } catch (SQLIntegrityConstraintViolationException exp) {
            throw new HttpResponseException(400, "Duplicate entry", exp);
        } catch (JsonbException exp) {
            exp.printStackTrace();
            throw new HttpResponseException(400, "Failed to read the JSON", exp);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }

    }
}

