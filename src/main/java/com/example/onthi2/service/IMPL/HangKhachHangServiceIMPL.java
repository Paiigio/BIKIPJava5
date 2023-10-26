package com.example.onthi2.service.IMPL;

import com.example.onthi2.model.HangKhachHang;
import com.example.onthi2.responsitory.HangKhachHangRespon;
import com.example.onthi2.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangKhachHangServiceIMPL implements HangKhachHangService {
    @Autowired
    HangKhachHangRespon hangKhachHangRespon;

    @Override
    public List<HangKhachHang> findALL() {
        return hangKhachHangRespon.findAll();
    }
}
