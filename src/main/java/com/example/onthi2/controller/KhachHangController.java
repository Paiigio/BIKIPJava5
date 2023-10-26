package com.example.onthi2.controller;

import com.example.onthi2.model.KhachHang;
import com.example.onthi2.service.HangKhachHangService;
import com.example.onthi2.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    HangKhachHangService hangKhachHangService;
    @GetMapping("/hien-thi")
    private String hienThi(Model model, @RequestParam(value = "page",defaultValue = "0") int page){
        Page<KhachHang> list = khachHangService.findAll(page);
        model.addAttribute("list",list);
        model.addAttribute("s",new KhachHang());
        model.addAttribute("list_Hang",hangKhachHangService.findALL());
        model.addAttribute("listHang",hangKhachHangService.findALL());
        return "index";
    }
    @GetMapping("/delete/{maKhachHang}")
    private String Delete(@PathVariable("maKhachHang") String ma,Model model){
        khachHangService.delete(ma);
        Page<KhachHang> list = khachHangService.findAll(0);
        model.addAttribute("list",list);
        model.addAttribute("s",new KhachHang());
        model.addAttribute("list_Hang",hangKhachHangService.findALL());
        model.addAttribute("listHang",hangKhachHangService.findALL());
        return "index";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("s") KhachHang khachHang,Model model){
        int check=0;
        if(khachHang.getTenKhachHang().isEmpty()){
            model.addAttribute("loiten","Không được để trôngs tên");
            check=1;
        }
        if(khachHang.getSoDienThoai().isEmpty()){
            model.addAttribute("loisdt","Không được để trôngs sdt");

            check=1;
        }
        for (KhachHang k: khachHangService.tatCa()
             ) {
            if(k.getSoDienThoai().equals(khachHang.getSoDienThoai())){
                check=1;
                model.addAttribute("loisdt","Không đc trùng số đt");

            }
        }
        if(check==0){
            khachHangService.add(khachHang);
            model.addAttribute("ThongBao","Thêm thành công");
            model.addAttribute("list",khachHangService.findAll(0));
            model.addAttribute("listHang",hangKhachHangService.findALL());
            model.addAttribute("list_Hang",hangKhachHangService.findALL());
            model.addAttribute("s",new KhachHang());
            return "index";
        }

        model.addAttribute("list",khachHangService.findAll(0));
        model.addAttribute("listHang",hangKhachHangService.findALL());
        model.addAttribute("list_Hang",hangKhachHangService.findALL());
        model.addAttribute("s",khachHang);
        return "index";
    }
    @GetMapping("/search")
    private String timKiem(@RequestParam("ten") String ten,@RequestParam("hang") String hang,
                           @RequestParam(value = "page",defaultValue = "0") int page,Model model){
        if(ten.isEmpty()||hang.isEmpty()){
            model.addAttribute("list",khachHangService.findAll(0));
        }
        Page<KhachHang> ketQua=khachHangService.timMa(ten,hang,page);
        if(ketQua.isEmpty()){
            ketQua=khachHangService.timTen(ten,hang,page);
        }
        if(ketQua.isEmpty()){
            ketQua=khachHangService.timSDT(ten,hang,page);
        }
        if(ketQua.isEmpty()){
            model.addAttribute("ThongBao","không có kt quả");
            Page<KhachHang> list = khachHangService.findAll(page);
            model.addAttribute("list",list);
            model.addAttribute("s",new KhachHang());
            model.addAttribute("list_Hang",hangKhachHangService.findALL());
            model.addAttribute("listHang",hangKhachHangService.findALL());
        }

        model.addAttribute("list",ketQua);
        model.addAttribute("s",new KhachHang());
        model.addAttribute("list_Hang",hangKhachHangService.findALL());
        model.addAttribute("listHang",hangKhachHangService.findALL());
        return "index";
    }
}
