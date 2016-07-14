package ru.design.meduza;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by taras_000 on 27.06.2016.
 */
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Сервлет принял данные CartServlet");
        //Формируем запрос к БД на получение товара интересующего пользователя
        String str = "";
        if(request.getParameter("Bruki") != null){
            str = "SELECT * FROM meduzatk_veshi.t_bruki WHERE id = " + request.getParameter("Bruki");
        }
        if(request.getParameter("Majki") != null){
            str = "SELECT * FROM meduzatk_veshi.t_majki WHERE id = '" + request.getParameter("Majki") + "'";
        }
        if(request.getParameter("Kofti") != null){
            str = "SELECT * FROM meduzatk_veshi.t_kofti WHERE id = '" + request.getParameter("Kofti") + "'";
        }
        if(request.getParameter("Svitshoti") != null){
            str = "SELECT * FROM meduzatk_veshi.t_svit WHERE id = '" + request.getParameter("Svitshoti") + "'";
        }
        //---------------------------------------------------------------------------------
        //Создаем соединение с БД
        Connection connection = (Connection) getServletContext().getAttribute("connection");
        Zapros zapros = new Zapros();

        zapros.addTovarToCart(zapros.getRecord(str,connection, request.getServletContext()), connection);
    }
}
