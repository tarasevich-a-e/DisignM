package ru.design.meduza;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by taras_000 on 30.06.2016.
 */
public class EmailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String,String> map = (HashMap<String,String>) getServletContext().getAttribute("hashMapProp");
        Sender sender = new Sender(map.get("EMusernameFrom"), map.get("EMpassFrom"));
        String str_text = "";
        String str_zag = "";
        if(request.getParameter("type").equals("podpiska")) {
            str_zag = "Новый подписчик";
            str_text = "Добрый день, Ксения Евгеньевна.\n\n\tПосетитель Вашего сайта с почтовым ящиком: " +
                    request.getParameter("mail") +
                    "\nпросит добавить его почту в список подписчиков на Ваши новости.\n\nПисьмо с сайта " + request.getRequestURL();
        }
        if(request.getParameter("type").equals("zacaz")) {
            str_zag = "Новый заказ";
            str_text = "Добрый день, Ксения Евгеньевна.\n\n\tПосетитель Вашего сайта с почтовым ящиком: " +
                    request.getParameter("mail") +
                    "\nотправил заказ на следующие товары:" +
                    "\nТовар №1" +
                    "\nТовар №2" +
                    "\nТовар №3" +
                    "\n\nПисьмо с сайта http://meduz-a.tk";
        }
        sender.send(str_zag,str_text,map.get("EMusernameFrom"),map.get("EMusernameTo"));
    }
}
