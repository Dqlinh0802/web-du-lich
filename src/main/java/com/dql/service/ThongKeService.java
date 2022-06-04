/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dql.service;

import com.dql.pojos.Tour;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface ThongKeService {
//    List<Object[]> doanhThuTheoTour(Date ngayBD, Date ngayKT);
    List<Object[]> doanhThuTheoTour(Date ngayBD);
    List<Tour> soLuongTour();
}
