/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dql.service.impl;

import com.dql.pojos.Tour;
import com.dql.repository.ThongKeRepository;
import com.dql.service.ThongKeService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer
 */
@Service
public class ThongKeServiceImpl implements ThongKeService{

    @Autowired
    private ThongKeRepository thongKeRepository;
    
    
    @Override
    public List<Object[]> doanhThuTheoTour(Date ngayBD) {
        return this.thongKeRepository.doanhThuTheoTour(ngayBD);
    }

    @Override
    public List<Tour> soLuongTour() {
        return this.thongKeRepository.soLuongTour();
    }
    
}
