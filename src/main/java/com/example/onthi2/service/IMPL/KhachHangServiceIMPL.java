package com.example.onthi2.service.IMPL;

import com.example.onthi2.model.KhachHang;
import com.example.onthi2.responsitory.KhachHangRespon;
import com.example.onthi2.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceIMPL implements KhachHangService {
    @Autowired
    KhachHangRespon khachHangRespon;

    @Override
    public Page<KhachHang> findAll(int page) {
        Pageable pageable = PageRequest.of(page, 2);
        return khachHangRespon.findAll(pageable);
    }

    @Override
    public List<KhachHang> tatCa() {
        return khachHangRespon.findAll();
    }

    @Override
    public void add(KhachHang khachHang) {
        khachHangRespon.save(khachHang);
    }

    @Override
    public void delete(String ma) {
        khachHangRespon.deleteById(ma);
    }

    @Override
    public Page<KhachHang> timTen(String ten, String hang, int page) {
        Pageable pageable = PageRequest.of(page, 2);
        return khachHangRespon.findKhachHangsByTenKhachHangContainsIgnoreCaseAndHangKhachHang_MaHang(ten,hang,pageable);
    }

    @Override
    public Page<KhachHang> timMa(String ten, String hang, int page) {
        Pageable pageable = PageRequest.of(page, 2);
        return khachHangRespon.findKhachHangsByMaKhachHangContainsIgnoreCaseAndHangKhachHang_MaHang(ten,hang,pageable);
    }

    @Override
    public Page<KhachHang> timSDT(String ten, String hang, int page) {
        Pageable pageable = PageRequest.of(page, 2);
        return khachHangRespon.findKhachHangsBySoDienThoaiContainsIgnoreCaseAndHangKhachHang_MaHang(ten,hang,pageable);
    }
}
