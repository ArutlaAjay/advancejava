package com.cg.BiteBeeFoodApplication40.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cg.BiteBeeFoodApplication40.entity.Admin;
import com.cg.BiteBeeFoodApplication40.entity.User;
import com.cg.BiteBeeFoodApplication40.loginCredentials.AdminLogin;
import com.cg.BiteBeeFoodApplication40.loginCredentials.UserLogin;
import com.cg.BiteBeeFoodApplication40.service.AdminServices;
import com.cg.BiteBeeFoodApplication40.service.OrderServices;
import com.cg.BiteBeeFoodApplication40.service.ProductServices;
import com.cg.BiteBeeFoodApplication40.service.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
private UserServices userServices;	

	@Autowired
	private AdminServices adminServices;
	
	@Autowired
	private ProductServices productServices;
	
	@Autowired
	private OrderServices orderServices;
	
	/* ================= ADMIN LOGIN ================= */

    @PostMapping("/adminLogin")
    public String adminLogin(@ModelAttribute AdminLogin login,
                             Model model,
                             HttpSession session) {

        if (adminServices.validateAdminCredentials(
                login.getEmail(), login.getPassword())) {

            session.setAttribute("admin", login.getEmail());
            return "redirect:/admin/services";
        }

        model.addAttribute("error", "Invalid email or password");
        return "Login";
    }

    /* ================= USER LOGIN ================= */

    @PostMapping("/userLogin")
    public String userLogin(@ModelAttribute UserLogin login,
                            Model model,
                            HttpSession session) {

        if (userServices.validateLoginCredentials(
                login.getUserEmail(), login.getUserPassword())) {

            User user = userServices.getUserByEmail(login.getUserEmail());
            session.setAttribute("loggedUser", user);
            return "redirect:/products";
        }

        model.addAttribute("error2", "Invalid email or password");
        return "Login";
    }

    /* ================= ADMIN DASHBOARD ================= */

    @GetMapping("/admin/services")
    public String adminDashboard(Model model, HttpSession session) {

        if (session.getAttribute("admin") == null) {
            return "redirect:/Login";
        }

        model.addAttribute("users", userServices.getAllUser());
        model.addAttribute("admins", adminServices.getAll());
        model.addAttribute("products", productServices.getAllProducts());
        model.addAttribute("orders", orderServices.getOrders());

        return "Admin_Page";
    }

    /* ================= ADD ADMIN ================= */

    @GetMapping("/addAdmin")
    public String addAdminPage(Model model) {
        model.addAttribute("admin", new Admin());
        return "Add_Admin";
    }

    @PostMapping("/addingAdmin")
    public String saveAdmin(@ModelAttribute Admin admin) {
        adminServices.addAdmin(admin);
        return "redirect:/admin/services";
    }

    /* ================= UPDATE ADMIN (FIXED) ================= */

    @GetMapping("/updateAdmin/{id}")
    public String updateAdminPage(@PathVariable int id, Model model) {

        Admin admin = adminServices.getAdmin(id);
        model.addAttribute("admin", admin);

        return "Update_Admin";
    }

    @PostMapping("/updatingAdmin/{id}")
    public String updateAdmin(@PathVariable int id,
                              @ModelAttribute Admin admin) {

        adminServices.update(admin, id);
        return "redirect:/admin/services";
    }

    /* ================= DELETE ADMIN ================= */

    @GetMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable int id) {
        adminServices.delete(id);
        return "redirect:/admin/services";
    }

	
	
}
