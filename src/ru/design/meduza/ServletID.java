package ru.design.meduza;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by taras_000 on 24.06.2016.
 */
public class ServletID extends HttpServlet {
    Statement statement;
    ArrayList<Record_veshi> record_veshis;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        System.out.println("Мы в ServletID");
        //---------------------------------------------------------------------------------
        //выбираем какую БД подключать
        String str = ""; //Для SQL запросов
        if(request.getParameter("Bruki") != null){
            str = "SELECT * FROM meduzatk_veshi.t_bruki WHERE id = '"+request.getParameter("Bruki")+"'";
        }
        if(request.getParameter("Majki") != null){
            str = "SELECT * FROM meduzatk_veshi.t_majki WHERE id = '"+request.getParameter("Majki")+"'";
        }
        if(request.getParameter("Kofti") != null){
            str = "SELECT * FROM meduzatk_veshi.t_kofti WHERE id = '"+request.getParameter("Kofti")+"'";
        }
        if(request.getParameter("Svitshoti") != null){
            str = "SELECT * FROM meduzatk_veshi.t_svit WHERE id = '"+request.getParameter("Svitshoti")+"'";
        }
        //---------------------------------------------------------------------------------
        //Создаем соединение с БД
        Connection connection = (Connection) getServletContext().getAttribute("connection");
        Zapros zapros = new Zapros();
        //Получаем данные из БД и складываем в коллекцию(коллекцию преобразуем в JSON)
        request.setAttribute("ojson", zapros.getJSON(str, connection, request.getServletContext()));
        //Передаем количество покупок в корзине
        request.setAttribute("chcart",request.getServletContext().getAttribute("chcart"));
        //---------------------------------------------------------------------------------
        request.getRequestDispatcher("veshi.jsp").forward(request,response);
    }
}
