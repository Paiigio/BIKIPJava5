package com.example.onthi2.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "HangKhachHang")
@Entity
@Data
public class HangKhachHang {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String maHang;
    private String tenHang;
}
