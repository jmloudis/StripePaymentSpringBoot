package com.example.paymentproject.controller;

import com.example.paymentproject.model.CheckoutForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PaymentController {

    @Value("${stripe.public.key}")
    private String stripePublicKey;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("checkoutForm", new CheckoutForm());
        return "/index";
    }

    @PostMapping("/")
    public String checkout(@ModelAttribute @Valid CheckoutForm checkoutForm, BindingResult bindingResult, Model model){
    if (bindingResult.hasErrors()){
        return "/index";
    }
    model.addAttribute("stripePublicKey", stripePublicKey);
    return "redirect:/checkout";
    }

//    @GetMapping("/checkout")
//    public String checkoutPage(Model model){
//        model.addAttribute("stripePublicKey", stripePublicKey);
//        return "/checkout";
//    }

    @GetMapping("/home")
    public String returnHome(Model model){
        return "redirect:/index";
    }

}
