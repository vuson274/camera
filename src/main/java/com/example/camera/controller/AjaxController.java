package com.example.camera.controller;

import com.example.camera.model.Order;
import com.example.camera.model.Product;
import com.example.camera.model.SessionCart;
import com.example.camera.service.OrderService;
import com.example.camera.service.ProductService;
import com.example.camera.service.UserSevice;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;

@RestController
public class AjaxController {
    @Autowired
    ProductService productService;
    @Autowired
    UserSevice userSevice;

    @Autowired
    OrderService orderService;
    @GetMapping("/productDetail")
    public ResponseEntity<Product> detailProduct(@RequestParam("id") Integer id) {
        Optional<Product> product = productService.findById(id);
        String name = product.get().getName();
        String mainImage = product.get().getMainImage();
        Float price = product.get().getPrice();
        Float salePrice = product.get().getSalePrice();
        String des = product.get().getDescription();
        Product detailProduct = new Product(id, name, mainImage, price, des, salePrice);
        return new ResponseEntity<>(detailProduct, HttpStatus.OK);
    }

    @GetMapping("/searchProduct")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam("name") String name) {
        List<Product> products = productService.findByNameLike(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/likeProduct")
    public ResponseEntity<Product> likeProduct(ModelMap modelMap, @RequestParam("id") Integer id, HttpSession session) {
        HashMap<Integer, Product> likeItems = (HashMap<Integer, Product>) session.getAttribute("myLikeItems");
        if (likeItems == null) {
            likeItems = new HashMap<>();
        }
        Product likeProduct = productService.findById(id).get();
        if (likeProduct != null) {
            if (!likeItems.containsKey(id)) {
                likeItems.put(id, likeProduct);
            }
        }
        session.setAttribute("myLikeItems", likeItems);
        session.setAttribute("myLikeNum", likeItems.size());
        return new ResponseEntity<>(likeProduct, HttpStatus.OK);
    }

    @GetMapping("/delLikeProduct")
    public boolean delLikePro(@RequestParam("id") Integer id, HttpSession session) {
        HashMap<Integer, Product> likeItems = (HashMap<Integer, Product>) session.getAttribute("myLikeItems");
        if (likeItems == null) {
            likeItems = new HashMap<>();
        }
        if (likeItems.containsKey(id)) {
            likeItems.remove(id);
        }
        session.setAttribute("myLikeItems", likeItems);
        session.setAttribute("myLikeNum", likeItems.size());
        return true;
    }

    @GetMapping("/admin/filter")
    public ResponseEntity<List<Double>> filter(@RequestParam("from_date") Date from_date, @RequestParam("to_date") Date to_date) {
        Double countPro = (double) productService.findByCreateAtBetween(from_date, to_date).size();
        Double countUser = (double) userSevice.findUserByCreateAtBetween(from_date, to_date).size();
        Double countOrder = (double) orderService.findByCreateAtBetween(from_date, to_date).size();
        Double total = (double) 0;
        for (Order order : orderService.findByCreateAtBetween(from_date, to_date)) {
            total += order.getTotalPrice();
        }
        List<Double> count = new ArrayList<>();
        count.add(countPro);
        count.add(countUser);
        count.add(countOrder);
        count.add(total);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/addCart")
    public boolean addCart(ModelMap modelMap, @RequestParam("id") Integer id, HttpSession session) {
        HashMap<Integer, SessionCart> cartItems = (HashMap<Integer, SessionCart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product pro = productService.findById(id).get();
        if (pro != null) {
            if (cartItems.containsKey(id)) {
                SessionCart item = cartItems.get(id);
                item.setProducts(pro);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(id, item);
            } else {
                SessionCart item = new SessionCart();
                item.setProducts(pro);
                item.setQuantity(1);
                cartItems.put(id, item);

            }
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartNum", cartItems.size());
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        return true;
    }

    public double totalPrice(HashMap<Integer, SessionCart> cartItems) {
        Double total = (double) 0.f;
        for (Map.Entry<Integer, SessionCart> list : cartItems.entrySet()) {
            total += list.getValue().getProducts().getPrice() * list.getValue().getQuantity();
        }
        return total;
    }

    @GetMapping("/delCart")
    public boolean delCart(@RequestParam("id") Integer id, HttpSession session){
        HashMap<Integer, SessionCart> cartItems = (HashMap<Integer, SessionCart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(id)) {
            cartItems.remove(id);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartNum", cartItems.size());
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        return true;
    }

    @GetMapping("/updateCart")
    public boolean updateCart( @RequestParam("id") Integer id, @RequestParam("qty") Integer qty, HttpSession session){
        HashMap<Integer, SessionCart> cartItems = (HashMap<Integer, SessionCart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product pro = productService.findById(id).get();
        if (cartItems.containsKey(id)) {
            SessionCart item = cartItems.get(id);
            item.setProducts(pro);
            qty = qty > 0 ? qty : 1;
            item.setQuantity(qty);
            cartItems.put(id, item);
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartNum", cartItems.size());
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        return true;
    }
}
