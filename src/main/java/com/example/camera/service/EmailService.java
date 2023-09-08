package com.example.camera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendMail(String to, String name, String address, String phone, String orderCode){
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true,"UTF-8");
            messageHelper.setTo(to);
            messageHelper.setSubject("Thông báo đơn hàng");
            String htmlContent = " <div class=\"container\">\n" +
                    "    <div class=\"row\">\n" +
                    "        <div class=\"col-md-12\">\n" +
                    "            <div>\n" +
                    "                <h3 style=\"text-align: center;\">Cám ơn bạn đã đặt hàng tại Moon Light!</h3>\n" +
                    "                <p>Xin chào "+name+",<br>\n" +
                    "                    Moon Light đã nhận được yêu cầu đặt hàng của bạn và đang xử lý nhé. Bạn sẽ nhận được thông báo tiếp theo khi đơn hàng đã sẵn sàng được giao. <br>\n" +
                    "\n" +
                    "                    *Lưu ý nhỏ cho bạn: Bạn chỉ nên nhận hàng khi trạng thái đơn hàng là “Đang giao hàng” và nhớ kiểm tra Mã đơn hàng, Thông tin người gửi và Mã vận đơn để nhận đúng kiện hàng nhé.\n" +
                    "                </p><br>\n" +
                    "                 <p>\n" +
                    "                    <span class=\"fa fa-map-marker\">Đơn hàng được giao đến</span><br>\n" +
                    "                    Tên: "+name+"<br>\n" +
                    "                    Địa chỉ nhà: "+address+"<br>\n" +
                    "                    Điện thoại: "+phone+" <br>\n" +
                    "                    Email: "+to+" <br>\n" +
                    "                    Mã đơn hàng: "+orderCode+" <br>\n" +
                    "                 </p>\n" +
                    "            </div>\n" +
                    "        </div>\n";
            messageHelper.setText(htmlContent, true);
        };
        javaMailSender.send(messagePreparator);
    }
}
