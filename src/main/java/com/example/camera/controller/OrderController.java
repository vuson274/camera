package com.example.camera.controller;

import com.example.camera.config.AES;
import com.example.camera.model.*;
import com.example.camera.service.CustomerService;
import com.example.camera.service.EmailService;
import com.example.camera.service.OrderDetailService;
import com.example.camera.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.*;

@Controller
public class OrderController {
    @Autowired
    EmailService emailService;
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    @PostMapping("/order")
    public String Order(@ModelAttribute("Customer") Customer customer, @RequestParam("note") String note, HttpSession session, RedirectAttributes attributes){
        HashMap<Integer, SessionCart> cartItems = (HashMap<Integer, SessionCart>) session.getAttribute("myCartItems");
        Date creatAt = new Date(System.currentTimeMillis());
        String secretKey = String.valueOf(creatAt.getTime());
        String orderCode = AES.encrypt(customer.getPhone(), secretKey);
        try{
            Customer customer1 = new Customer();
            customer1.setName(customer.getName());
            customer1.setPhone(customer.getPhone());
            customer1.setEmail(customer.getEmail());
            customer1.setAddress(customer.getAddress());
            customer1.setCreateAt(creatAt);
            customerService.save(customer1);
            Order orders = new Order();
            orders.setCustomer(customer1);
            orders.setTotalPrice((Double) session.getAttribute("myCartTotal"));
            orders.setNote(note);
            orders.setKeyToken(orderCode);
            orders.setPayMethod(1);
            orders.setCreateAt(creatAt);
            orders.setStatus(1);
            orderService.save(orders);
            for (Map.Entry<Integer, SessionCart> list : cartItems.entrySet()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrder(orders);
                orderDetail.setProduct(list.getValue().getProducts());
                orderDetail.setQuantity(list.getValue().getQuantity());
                orderDetail.setPrice(list.getValue().getProducts().getPrice());
                orderDetail.setTotal(list.getValue().getProducts().getPrice() * list.getValue().getQuantity());
                orderDetail.setCreatAt(creatAt);
                orderDetailService.save(orderDetail);
            }
            attributes.addFlashAttribute("message", "Đặt hàng thành công");
        } catch (Exception e) {
            attributes.addFlashAttribute("messageError", "Đặt hàng thất bại");
        }
        emailService.sendMail(customer.getEmail(), customer.getName(), customer.getAddress(), customer.getPhone(), orderCode);
        session.removeAttribute("myCartItems");
        session.removeAttribute("myCartNum");
        session.removeAttribute("myCartTotal");

        return "redirect:/home";
    }

    @GetMapping("/admin/order")
    public String listOrder(ModelMap modelMap){
        modelMap.addAttribute("listOrder", orderService.findAllByOrderByIdDesc());
        return "listOrder";
    }

    @GetMapping("/order_detail/{id}")
    public String orderDetail(ModelMap modelMap, @PathVariable Integer id){
        modelMap.addAttribute("orderDetail", orderDetailService.findOrderDetail(id));
        List<OrderDetail> list =  orderDetailService.findOrderDetail(id);
        int count = 0;
        for (OrderDetail orderDetail: list) {
            count += orderDetail.getQuantity();
        }
        modelMap.addAttribute("count", count);
        modelMap.addAttribute("total", orderService.findById(id).get().getTotalPrice());
        list.remove(0);
        modelMap.addAttribute("list", list);
        return "orderDetail";
    }
}
