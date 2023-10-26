package com.example.onthi2.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "KhachHang")
@Entity
@Data
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String maKhachHang;
    @ManyToOne
    @JoinColumn( name = "HangKhachHang")
    private HangKhachHang hangKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private Boolean gioiTinh;
}
