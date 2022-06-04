/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dql.service.impl;

import com.dql.repository.NguoiDatTourRepository;
import com.dql.service.NguoiDatTourService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer
 */
@Service
public class NguoiDatTourServiceImpl implements NguoiDatTourService{

    @Autowired
    private NguoiDatTourRepository nguoiDatTourRepository;
    
    @Override
    public List<Object[]> dsTourDuocDat(String tenTour, int page) {
        return this.nguoiDatTourRepository.dsTourDuocDat(tenTour, page);
    }

    @Override
    public long slTourDuocDat() {
        return this.nguoiDatTourRepository.slTourDuocDat();
    }

    @Override
    public List<Object[]> dsChiTietDat(int id) {
        return this.nguoiDatTourRepository.dsChiTietDat(id);
    }
    
}
