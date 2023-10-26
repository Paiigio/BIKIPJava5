package com.example.onthi2.responsitory;


import com.example.onthi2.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRespon extends JpaRepository<KhachHang,String> {
    Page<KhachHang> findAll(Pageable pageable);
    Page<KhachHang> findKhachHangsByMaKhachHangContainsIgnoreCaseAndHangKhachHang_MaHang(String ten,String hang,Pageable pageable);
    Page<KhachHang> findKhachHangsByTenKhachHangContainsIgnoreCaseAndHangKhachHang_MaHang(String ten,String hang,Pageable pageable);
    Page<KhachHang> findKhachHangsBySoDienThoaiContainsIgnoreCaseAndHangKhachHang_MaHang(String ten,String hang,Pageable pageable);
}
