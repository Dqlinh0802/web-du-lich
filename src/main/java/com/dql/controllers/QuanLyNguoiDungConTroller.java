/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dql.controllers;

import com.dql.service.NguoiDungService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Acer
 */
@Controller
public class QuanLyNguoiDungConTroller {
    
    @Autowired
    private NguoiDungService nguoiDungService;
    
//    //phan quyen cho nhan vien va admin

    
    
    @RequestMapping("/nhanVien/nguoiDungs")
    public String quanLyNguoiDung (Model model,
            @RequestParam(required = false) Map<String , String> params) {
        
        //co thì lấy k có thì lấy 1
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("dsNguoiDung", this.nguoiDungService.dsNguoiDung(params.get("taiKhoan"), page));
        model.addAttribute("slNguoiDung", this.nguoiDungService.slNguoiDung());
        
        return "quanLyNguoiDung";
    }
    
    @GetMapping("/khongTimThay")
    public String khongTimThay(){
        return "khongTimThay";
    }
}
