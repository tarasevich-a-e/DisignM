package ru.design.meduza; /**
 * Created by taras_000 on 13.06.2016.
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.sql.*;
import java.util.ArrayList;

public class InitListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    ServletContext context = null;
    //private static final long serialVersionUID = 1L;
    private final String USERNAME = "root";
    private final String PASS = "root";
    private final String URL = "jdbc:mysql://localhost:3306/meduzatk_veshi";

    Connection connection = null;
    Statement statement = null;

    public void contextInitialized(ServletContextEvent sce) {
        //Инициализация БД, контекста и передача соединения через контекст
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL, USERNAME, PASS);
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM meduzatk_veshi.t_cart where id > 0");
            context = sce.getServletContext();
            context.setAttribute("connection", connection);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Коннект!!!!!!!!!");
        /*
        //Получение данных из БД для предачи в контекст
        ArrayList<Record_veshi> record_veshi = new ArrayList<Record_veshi>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM db_veshi.t_bruki");
            //Формируем записи объекта для передачи в JSP
            while (resultSet.next()){
                record_veshi.add(new Record_veshi(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getString("type"),
                resultSet.getInt("cost"),resultSet.getString("discribe"),resultSet.getInt("size"),resultSet.getInt("color"),
                resultSet.getInt("quantity"), resultSet.getInt("like"), resultSet.getString("link")));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("БД не подгружена!");
            e.printStackTrace();
        }
        context.setAttribute("record_veshi",record_veshi);
        */
    }

    public void contextDestroyed(ServletContextEvent sce) {
        if (connection!=null){
            try {
               connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Дисконнект!!!!!!!!!");
        }
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
