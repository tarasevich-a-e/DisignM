package ru.design.meduza;

import com.google.gson.Gson;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by taras_000 on 24.06.2016.
 */
public class Zapros {
    Statement statement;
    ArrayList<Record_veshi> record_veshis;
    Record_veshi record_vesh;

    public Zapros() {
    }
    public String getJSON(String str, Connection connection, ServletContext servletContext){
        //Получаем данные из БД и складываем в коллекцию
        record_veshis = new ArrayList<Record_veshi>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                record_veshis.add(new Record_veshi(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("type_v"),
                        resultSet.getString("type"),
                        resultSet.getInt("cost"),
                        resultSet.getString("discribe"),
                        resultSet.getString("size"),
                        resultSet.getString("color"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("like"),
                        resultSet.getString("link")
                ));
            }
            //Узнаем количество записей в таблице с выбранными покупками(корзина)
            ResultSet resultSet1= statement.executeQuery("SELECT COUNT(*) FROM meduzatk_veshi.t_cart");
            int chet_cart = 0;
            if (resultSet1.next()) {
                chet_cart = resultSet1.getInt(1);
            }
            servletContext.setAttribute("chcart", chet_cart);
            //-----------------------------------------------------------------
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //---------------------------------------------------------------------------------
        //Преобразуем коллекцию в массив данных JSON для предачи в работу в AngularJS
        Gson gson = new Gson();
        String json = gson.toJson(record_veshis);
        return json;
    }

    public Record_veshi getRecord(String str, Connection connection, ServletContext servletContext){
        //Получаем данные из БД и складываем в коллекцию
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while(resultSet.next()) {
                record_vesh = new Record_veshi(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("type_v"),
                        resultSet.getString("type"),
                        resultSet.getInt("cost"),
                        resultSet.getString("discribe"),
                        resultSet.getString("size"),
                        resultSet.getString("color"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("like"),
                        resultSet.getString("link"));
            }
            //Узнаем количество записей в таблице с выбранными покупками(корзина)
            ResultSet resultSet1= statement.executeQuery("SELECT COUNT(*) FROM meduzatk_veshi.t_cart");
            int chet_cart = 0;
            if (resultSet1.next()) {
                chet_cart = resultSet1.getInt(1);
            }
            servletContext.setAttribute("chcart", chet_cart);
            //-----------------------------------------------------------------
            } catch (SQLException e) {
                e.printStackTrace();
        }
        //---------------------------------------------------------------------------------
        //Отправляем коллекцию
        return record_vesh;
    }

    public void addTovarToCart(Record_veshi record_vesh, Connection connection){
        //Добавляем покупку в корзину
        try {
            statement = connection.createStatement();
            String str_query = "INSERT INTO meduzatk_veshi.t_cart (`id`, `name`, `type_v`, `type`, `cost`, `discribe`, `size`, `color`, `quantity`, `like`, `link`) " +
                    "VALUE (" +
                    record_vesh.getId() +
                    ",\"" + record_vesh.getName() + "\"" +
                    ",\"" + record_vesh.getType_v() + "\"" +
                    ",\"" + record_vesh.getType() + "\"" +
                    "," + record_vesh.getCost() +
                    ",\"" + record_vesh.getDiscribe() + "\"" +
                    ",\"" + record_vesh.getSize() + "\"" +
                    ",\"" + record_vesh.getColor() + "\"" +
                    ",0" +  /*"," + record_vesh.getQuantity() +*/
                    "," + record_vesh.getLike() +
                    ",\"" + record_vesh.getLink() + "\"" +
                    ")";
            statement.executeUpdate(str_query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
