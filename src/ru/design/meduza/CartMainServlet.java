package ru.design.meduza;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by taras_000 on 28.06.2016.
 */
public class CartMainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Сервлет принял данные CartMainServlet");
        //Формируем запрос к БД на получение товара интересующего пользователя
        String str = "SELECT * FROM meduzatk_veshi.t_cart";
        //---------------------------------------------------------------------------------
        //Создаем соединение с БД
        Connection connection = (Connection) getServletContext().getAttribute("connection");
        Zapros zapros = new Zapros();
        //Получаем данные из БД и складываем в коллекцию(коллекцию преобразуем в JSON)
        request.setAttribute("ojson", zapros.getJSON(str, connection, request.getServletContext()));
        //Передаем количество покупок в корзине
        request.setAttribute("chcart",request.getServletContext().getAttribute("chcart"));
        //---------------------------------------------------------------------------------
        request.getRequestDispatcher("cart.jsp").forward(request, response);//
    }
}
