package com.aaa.controller;

import com.aaa.entity.*;
import com.aaa.service.LadminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/liao")
public class LadminController {

    @Autowired
    private LadminService ladminService;

    // 查询科室
    @PostMapping("/selDepartment")
    @ResponseBody
    public List<Departments> selDepartment(@RequestBody(required = false) Departments departments) {
        return ladminService.selDepartment(departments);
    }

    // 查询医生
    @PostMapping("/selDoctor")
    @ResponseBody
    public List<Doctor> selDoctor(@RequestBody(required = false) Doctor doctor) {
        return ladminService.selDoctor(doctor);
    }

    // 查询床位
    @PostMapping("/selBed")
    @ResponseBody
    public List<Bed> selBed(@RequestBody(required = false) Bed bed) {
        return ladminService.selBed(bed);
    }

    // 新增入院登记
    @PostMapping("/addRegister")
    @ResponseBody
    public String addRegister(Register register) {
        int result = ladminService.addRegister(register);
        return result > 0 ? "success" : "fail";
    }

    // 查询入院登记
    @RequestMapping("/selRegister")
    @ResponseBody
    public List<Register> selRegister(Register register) {
        return ladminService.selRegister(register);
    }

    // 更新床位
    @PostMapping("/updBed")
    @ResponseBody
    public String updBed(Register register) {
        int result = ladminService.updBed(register);
        return result > 0 ? "success" : "fail";
    }

    // 查询医保折扣
    @PostMapping("/selDis")
    @ResponseBody
    public List<Moneytype> selDis() {
        return ladminService.selDis();
    }

    // 查询门诊信息
    @RequestMapping("/selDoor")
    @ResponseBody
    public List<Register> selDoor() {
        return ladminService.selDoor();
    }

    // 转院
    @PostMapping("/updZ")
    @ResponseBody
    public String updZ(Register register) {
        int result = ladminService.updZ(register);
        return result > 0 ? "success" : "fail";
    }

    // 转科
    @PostMapping("/updKe")
    @ResponseBody
    public String updKe(Register register) {
        int result = ladminService.updKe(register);
        return result > 0 ? "success" : "fail";
    }

    // 页面跳转到入院登记
    @GetMapping("/admin")
    public String toAdminPage() {
        return "liao/admin";
    }
} 