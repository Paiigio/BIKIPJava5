package com.example.onthi2.service;

import com.example.onthi2.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KhachHangService {
    Page<KhachHang> findAll(int page);
    List<KhachHang> tatCa();
    void add(KhachHang khachHang);
    void delete(String ma);
    Page<KhachHang> timTen(String ten,String hang,int page);
    Page<KhachHang> timMa(String ten,String hang,int page);
    Page<KhachHang> timSDT(String ten,String hang,int page);
}
