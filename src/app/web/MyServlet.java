package app.web;

import app.Config;
import app.model.Account;
import app.model.Card;
import app.storage.Storage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class MyServlet extends HttpServlet {
    private final Storage storage = Config.get().getStorage();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String id = request.getParameter("id");
       String outerId = request.getParameter("outerId");
       String number = request.getParameter("number");
       String balance = request.getParameter("balance");
       Card card = new Card(id, Integer.parseInt(number), outerId, BigDecimal.valueOf(Float.parseFloat(balance)));
       storage.saveCard(card);
       response.sendRedirect("Sber");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String action = request.getParameter("action");

        if (action == null) {
            request.setAttribute("clientList", storage.getAllClientsSorted());
            request.getRequestDispatcher("client.jsp").forward(request, response);
            return;
        }

        switch (action) {
            case "showAccount":
                List<Account> list = new ArrayList();
                for (int i = 0; i < storage.getAllAccountsSorted().size(); i++) {
                    if (storage.getAllAccountsSorted().get(i).getClient_id().equals(id)) {
                        list.add(storage.getAllAccountsSorted().get(i));
                    }
                }
                request.setAttribute("accountList", list);
                request.getRequestDispatcher("account.jsp").forward(request, response);
                break;
            case "showCard":
                List<Card> list1 = new ArrayList();
                for (int i = 0; i < storage.getNumberOfCards(); i++) {
                    if (storage.getAllCardsSorted().get(i).getAccount_id().equals(id)) {
                        list1.add(storage.getAllCardsSorted().get(i));
                    }
                }
                request.setAttribute("cardList", list1);
                request.setAttribute("accountId", list1.get(0).getAccount_id().toString());
                request.getRequestDispatcher("card.jsp").forward(request, response);
                break;
            case "addCard":
                String cardId = UUID.randomUUID().toString();
                request.setAttribute("id", cardId);
                request.setAttribute("outerId", id);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
            default:
                request.getRequestDispatcher("client.jsp").forward(request, response);
        }



    }


}
