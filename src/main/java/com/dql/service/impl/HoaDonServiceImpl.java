/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dql.service.impl;

import com.dql.pojos.GioHang;
import com.dql.repository.HoaDonRepository;
import com.dql.service.HoaDonService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer
 */
@Service
public class HoaDonServiceImpl implements HoaDonService{
    @Autowired
    private HoaDonRepository hoaDonRepository;
    
    @Override
    public boolean themHoaDon(Map<Integer, GioHang> gioHang, int id, String tinhTrang) {
        if(gioHang != null)
            return this.hoaDonRepository.themHoaDon(gioHang, id, tinhTrang);
        return false;
    }
    
}
