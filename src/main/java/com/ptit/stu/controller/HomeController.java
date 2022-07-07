/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.controller;

import com.ptit.stu.entity.AccountEntity;
import com.ptit.stu.entity.EvaluationEntity;
import com.ptit.stu.entity.OrderDetailEntity;
import com.ptit.stu.entity.OrderEntity;
import com.ptit.stu.entity.UserEntity;
import com.ptit.stu.entity.dto.AccountDTO;
import com.ptit.stu.entity.dto.EvaluationDTO;
import com.ptit.stu.entity.dto.UserDTO;
import com.ptit.stu.service.AccountService;
import com.ptit.stu.service.EvaluationService;
import com.ptit.stu.service.OrderService;
import com.ptit.stu.service.UserService;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dovan
 */
@Controller
public class HomeController {

    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    EvaluationService evaluationService;
    @Autowired
    public JavaMailSender emailSender;

    @GetMapping("")
    public String home() {
        return "home";
    }

    @GetMapping("/products/catalog/{id}")
    public String products() {
        return "products";
    }

    @GetMapping("/products/search/{value}")
    public String search() {
        return "products";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginS(@RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session, Model model) {
        AccountEntity a = accountService.findByUsername(username);
        try {
            if (a != null) {
                if (a.getPassword().equals(ConvertPasswordMD5.convertHashToString(password))) {
                    session.setAttribute("USERID", a.getUser().getId());
                    session.setAttribute("ACCOUNTID", a.getId());
                    session.setAttribute("USERNAME", username);
                    session.setAttribute("USERTYPE", a.getType());
                    model.addAttribute("LOGINSUCCESS", "Xin chào " + username);
                    return "home";
                }
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("LOGINFAIL", "Tên tài khoản hoặc mật khẩu không chính xác");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("ACCOUNTID");
        session.removeAttribute("USERID");
        session.removeAttribute("USERNAME");
        session.removeAttribute("USERTYPE");
        return "home";
    }

    @GetMapping("/change-password")
    public String viewChangePassword() {
        return "change_password";
    }

    @PostMapping("/change-password")
    public String changePassword(
            @RequestParam("oldpass") String oldpass,
            @RequestParam("pass") String pass,
            HttpSession session, Model model) {
        AccountEntity a = accountService.findById((Integer) session.getAttribute("ACCOUNTID")).get();
        try {
            if (a != null) {
                if (a.getPassword().equals(ConvertPasswordMD5.convertHashToString(oldpass))) {
                    a.setPassword(ConvertPasswordMD5.convertHashToString(pass));
                    accountService.save(a);
                    model.addAttribute("OK", "Đổi mật khẩu thành công");
                    session.removeAttribute("ACCOUNTID");
                    session.removeAttribute("USERID");
                    session.removeAttribute("USERNAME");
                    session.removeAttribute("USERTYPE");
                    return "login";
                } else {
                    model.addAttribute("ERROR", "Mật khẩu mới không trùng khớp với mật khẩu cũ");
                    return "change_password";
                }
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "change_password";
    }

    @GetMapping("/product/{id}")
    public String product(Model model, @PathVariable Integer id) {
        List<EvaluationEntity> le = evaluationService.getEvaluationByProduct(id);
        List<EvaluationDTO> l = new ArrayList<>();
        int sum = 0, count = 0;
        for (EvaluationEntity ee : le) {
            l.add(EvaluationDTO.convetToEvaluationDTO(ee));
            count++;
            sum += ee.getPoint();
        }
        double point = 5.0;
        if (count != 0) {
            point = sum * 1.0 / count;
        }
        point = (double) Math.round(point * 10) / 10;
        model.addAttribute("POINT", point);
        model.addAttribute("RATE", l);
        return "product_detail";
    }

    @GetMapping("/sign-up")
    public String signup() {
        return "sign_up";
    }

    @PostMapping("/sign-up")
    public String signupS(@RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("name") String name,
            @RequestParam("birth") String birth,
            @RequestParam("gender") String gender,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            Model model) {
        try {
            boolean gt = true;
            if (gender.equals("0")) {
                gt = false;
            }
            Date date = new SimpleDateFormat("yyyy-mm-dd").parse(birth);
            UserDTO userDTO = new UserDTO(null, name, gt, date, address, phone, email);
            if (accountService.findByUsername(username) != null) {
                model.addAttribute("USER", userDTO);
                model.addAttribute("SIGNUPFAIL", "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác");
                return "sign_up";
            }
            UserEntity userEntity = UserDTO.convertToUserEntity(userDTO);
            userService.save(userEntity);
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setUser(userEntity.getId());
            accountDTO.setUsername(username);
            accountDTO.setPassword(ConvertPasswordMD5.convertHashToString(password));
            accountService.save(new AccountDTO().convertToAccountEntity(accountDTO));
            model.addAttribute("SIGNSUCCESS", "Đăng ký tài khoản thành công, vui lòng đăng nhập");
            return "login";
        } catch (ParseException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("SIGNUPFAIL", "Lỗi, vui lòng đăng ký lại");
        return "sign_up";
    }

    @GetMapping("/info-user")
    public String infoU() {
        return "info_account";
    }

    @GetMapping("/infor-order")
    public String infoOd() {
        return "info_order";
    }

    @GetMapping("/update-user/{id}")
    public String viewUpdateUser(Model model, @PathVariable Integer id) {
        UserEntity ue = userService.findById(id).get();
        model.addAttribute("USER", ue);
        return "update_user";
    }

    @PostMapping("/update-user")
    public String updateUser(@RequestParam("name") String name,
            @RequestParam("birth") String birth,
            @RequestParam("gender") String gender,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("address") String address,
            @RequestParam("idS") Integer id,
            Model model) {
        UserEntity ue = userService.findById(id).get();
        try {
            boolean gt = true;
            if (gender.equals("0")) {
                gt = false;
            }
            Date date = new SimpleDateFormat("yyyy-mm-dd").parse(birth);
            ue.setName(name);
            ue.setBirth(date);
            ue.setGender(gt);
            ue.setPhone(phone);
            ue.setEmail(email);
            ue.setAddress(address);
            userService.save(ue);
        } catch (ParseException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "info_account";
    }

    @GetMapping("/rate/{id}")
    public String viewRate(@PathVariable Integer id, Model model) {
        model.addAttribute("ORDER", id);
        return "rate";
    }

    @PostMapping("/rate")
    public String rate(@RequestParam("idA") Integer idA,
            @RequestParam("idO") Integer idO,
            @RequestParam("point") Integer point,
            @RequestParam("message") String message) {
        OrderEntity od = orderService.findById(idO).get();
        od.setStatus(4);
        orderService.save(od);
        AccountEntity a = accountService.findById(idA).get();
        for (OrderDetailEntity ode : od.getOrderDetails()) {
            EvaluationEntity ee = new EvaluationEntity(null, point, message, a, ode.getProduct());
            evaluationService.save(ee);
        }
        return "info_order";
    }

    @GetMapping("/forgot-password")
    public String viewForgotPass() {
        return "forgot_password";
    }

    @PostMapping("/forgot-password")
    public String forgotPass(@RequestParam("username") String username,
            @RequestParam("email") String email,
            Model model) {
        AccountEntity a = accountService.findByUsername(username);
        if (a == null) {
            model.addAttribute("ERROR", "Vui lòng kiểm tra lại tên đăng nhập");
            return "forgot_password";
        }
        if (!a.getUser().getEmail().equals(email)) {
            model.addAttribute("ERROR", "Vui lòng kiểm tra lại địa chỉ email");
            return "forgot_password";
        }
        //Tạo mk mới
        String[] st = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Random generator = new Random();
        String pass = "";
        for(int i=0; i<8; i++){
            pass += st[generator.nextInt(62)];
        }
        System.out.println(pass);
        try {
            a.setPassword(ConvertPasswordMD5.convertHashToString(pass));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        accountService.save(a);
        //Gửi mail cấp lại mk
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("[ESHOP] Cap lai mat khau");
        message.setText("Xin chao " + a.getUser().getName() + ", mat khau moi cua ban la: "+pass);
        emailSender.send(message);
        model.addAttribute("OK", "Mật khẩu mới đã được gửi đến email của bạn");
        return "login";
    }
}
