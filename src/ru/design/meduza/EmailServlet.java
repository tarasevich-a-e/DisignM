package ru.design.meduza;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by taras_000 on 30.06.2016.
 */
public class EmailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Мы отправляем письмо");
        System.out.println("mail = "+ request.getParameter("mail"));
        System.out.println("type = "+ request.getParameter("type"));
        Sender sender = new Sender("shop.meduza@gmail.com", "a741852963");
        String str_text = "";
        String str_zag = "";
        if(request.getParameter("type").equals("podpiska")) {
            str_zag = "Новый подписчик";
            str_text = "Добрый день, Ксенья Евгеньевна.\n\n\tПосетитель Вашего сайта с почтовым ящиком: " +
                    request.getParameter("mail") +
                    "\nпросит добавить его почту в список подписчиков на Ваши новости.\n\nПисьмо с сайта http://meduz-a.tk";
        }
        if(request.getParameter("type").equals("zacaz")) {
            str_zag = "Новый заказ";
            str_text = "Добрый день, Ксенья Евгеньевна.\n\n\tПосетитель Вашего сайта с почтовым ящиком: " +
                    request.getParameter("mail") +
                    "\nотправил заказ на следующие товары:" +
                    "\nТовар №1" +
                    "\nТовар №2" +
                    "\nТовар №3" +
                    "\n\nПисьмо с сайта http://meduz-a.tk";
        }
        sender.send(str_zag,str_text,"shop.meduza@gmail.com","tarasevich-a-e@yandex.ru");//marsel92@mail.ru
    }
}
