package ru.design.meduza;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by taras_000 on 13.06.2016.
 */
public class MainServlet extends HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HashMap<String,String> map = (HashMap<String,String>)getServletContext().getAttribute("hashMapProp");
        //---------------------------------------------------------------------------------
        //выбираем какую БД подключать
        String str = ""; //Для SQL запросов
        if(request.getParameter("t_bruki") != null){
            str = "SELECT * FROM " + map.get("bd_name") + ".t_bruki";
        }
        if(request.getParameter("t_majki") != null){
            str = "SELECT * FROM " + map.get("bd_name") + ".t_majki";
        }
        if(request.getParameter("t_kofti") != null){
            str = "SELECT * FROM " + map.get("bd_name") + ".t_kofti";
        }
        if(request.getParameter("t_svitshot") != null){
            str = "SELECT * FROM " + map.get("bd_name") + ".t_svit";
        }

        //---------------------------------------------------------------------------------
        //Создаем соединение с БД
        Connection connection = (Connection) getServletContext().getAttribute("connection");
        Zapros zapros = new Zapros();

        //Получаем данные из БД и складываем в коллекцию(коллекцию преобразуем в JSON)
        request.setAttribute("ojson", zapros.getJSON(map.get("bd_name"), str, connection, request.getServletContext()));
        //Передаем количество покупок в корзине
        request.setAttribute("chcart",request.getServletContext().getAttribute("chcart"));
        //---------------------------------------------------------------------------------
        request.getRequestDispatcher("t_veshi.jsp").forward(request, response);//
    }

}
