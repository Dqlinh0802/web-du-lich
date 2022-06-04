/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dql.service;

import com.dql.pojos.NguoiDung;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Acer
 */
public interface NguoiDungService extends UserDetailsService{
    boolean themSuaNguoiDung(NguoiDung nguoiDung);
    List<NguoiDung> danhSachNguoiDung(String taiKhoan);
    NguoiDung layNguoiDungId(int nguoiDungId);
    List<NguoiDung> layNguoiDungTaiKhoan(String taiKhoan);
    List<NguoiDung> dsNguoiDung(String taiKhoan, int page);
    long slNguoiDung();
    boolean xoaNguoiDung(int id);
}
