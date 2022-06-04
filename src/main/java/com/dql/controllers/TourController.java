/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dql.controllers;

import com.dql.pojos.Tour;
import com.dql.service.BinhLuanService;
import com.dql.service.NguoiDungService;
import com.dql.service.TourService;
import com.dql.utils.PdfDoanhThu;
import com.dql.validator.TourValidator;
import com.dql.validator.WebAppValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Acer
 */
@Controller
public class TourController {

    @Autowired
    private TourService tourService;
    @Autowired
    private BinhLuanService binhLuanService;
//    @Autowired
//    private TourValidator tourValidator;
//
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(tourValidator);
//    }

    //Map dung để hứng tên của hình trên clou
    //lấy String img để lưu tên
    //@Valid chi khi past het thi Tour moi duoc nhan
    //het vi pham moi cho lam BindingResult bao vi pham vao day het
    @PostMapping("/nhanVien/themSuaTour")
    public String post(Model model,
            @ModelAttribute(value = "tour") Tour tour) {
//        if(!result.hasErrors()){
        if (this.tourService.themHoacSua(tour) == true) {
            return "redirect:/dsTour";
        } else {
            model.addAttribute("errMsg", "Có lỗi rồi!!!");
        }
//        }
        //neu that bai thi no dung o tour
        return "themSuaTour";
    }

    //phan quyen cho admin
    @GetMapping("/nhanVien/themSuaTour")
    public String danhSach(Model model,
            @RequestParam(name = "tourId", defaultValue = "0") int tourId) {
        if (tourId > 0) // cập nhật
        {
            model.addAttribute("tour", this.tourService.layTourId(tourId));
        } else {
            model.addAttribute("tour", new Tour());//thêm
        }
        return "themSuaTour";
    }

    @GetMapping("/chiTietTour/{tourId}")
    public String chiTietTour(Model model,
            @PathVariable(value = "tourId") int tourId,
            @RequestParam(required = false) Map<String, String> params) {

        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        model.addAttribute("tour", this.tourService.layTourId(tourId));
        model.addAttribute("binhLuans", this.binhLuanService.layBinhLuansTour2(tourId, page));
        model.addAttribute("slBinhLuan", this.binhLuanService.slBinhLuan(tourId));

        return "chiTietTour";
    }

}
