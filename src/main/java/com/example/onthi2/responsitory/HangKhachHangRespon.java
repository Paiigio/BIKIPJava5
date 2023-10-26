package com.example.onthi2.responsitory;

import com.example.onthi2.model.HangKhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangKhachHangRespon extends JpaRepository<HangKhachHang,String> {

}
