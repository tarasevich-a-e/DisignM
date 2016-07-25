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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;

public class InitListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    ServletContext context = null;
    //private static final long serialVersionUID = 1L;
    private final String USERNAME = "root";
    private final String PASS = "root";
    private final String URL = "jdbc:mysql://localhost:3306/";

    Connection connection = null;
    Statement statement = null;

    public void contextInitialized(ServletContextEvent sce) {
        getProperty(sce.getServletContext());
        HashMap<String,String> map = (HashMap<String,String>)sce.getServletContext().getAttribute("hashMapProp");
        //Инициализация БД, контекста и передача соединения через контекст
        try {
            Class.forName(map.get("driver")).newInstance();
            connection = DriverManager.getConnection(map.get("URL") + map.get("bd_name"), map.get("USERNAME"), map.get("PASS"));
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM " + map.get("bd_name") + ".t_cart where id > 0");
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

    public void getProperty(ServletContext servletContext) {

        String path_config = servletContext.getRealPath("config.properties");
        FileInputStream fileInputStream = null;
        Properties properties = new Properties();
        HashMap<String,String> hashMapProp = new HashMap<String,String>();

        try {

            fileInputStream = new FileInputStream(path_config);
            properties.load(fileInputStream);
            hashMapProp.put("email",properties.getProperty("email"));
            hashMapProp.put("driver",properties.getProperty("driver"));
            hashMapProp.put("bd_name",properties.getProperty("bd_name"));
            hashMapProp.put("URL",properties.getProperty("URL"));
            hashMapProp.put("USERNAME",properties.getProperty("USERNAME"));
            hashMapProp.put("PASS",properties.getProperty("PASS"));
            hashMapProp.put("EMusernameFrom",properties.getProperty("EMusernameFrom"));
            hashMapProp.put("EMpassFrom",properties.getProperty("EMpassFrom"));
            hashMapProp.put("EMusernameTo",properties.getProperty("EMusernameTo"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        servletContext.setAttribute("hashMapProp", hashMapProp);
    }
}
