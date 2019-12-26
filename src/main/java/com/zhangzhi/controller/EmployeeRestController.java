package com.zhangzhi.controller;

import com.github.pagehelper.PageInfo;
import com.zhangzhi.annotation.Pagable;
import com.zhangzhi.entity.Employee;
import com.zhangzhi.entity.Goods;
import com.zhangzhi.entity.MyUser;
import com.zhangzhi.entity.Salary;
import com.zhangzhi.service.ActivityService;
import com.zhangzhi.service.EmployeeService;
import com.zhangzhi.service.GoodsService;
import com.zhangzhi.view.SalaryView;
import com.zhangzhi.vo.UserException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private EmployeeService employeeService;

    //    员工
    @Pagable
    @RequestMapping("/rest/employ/list")
    public PageInfo<Employee> list(Employee employee) {
        return employeeService.selectEmployee(employee);
    }


    //    添加用户和员工
    @RequestMapping("/rest/employ/save")
    public UserException save(MyUser myUser, Employee employee) {
        employeeService.insertUser(myUser, employee);
        return UserException.success();
    }

    //    删除用户和员工
    @RequestMapping("/rest/employ/delete")
    public UserException delete(@RequestParam("uids") List<Integer> goodsId) {
        employeeService.deleteUser(goodsId);
        return UserException.SUCCESS;
    }

    //    添加工资表
    @RequestMapping("/rest/Salary/save")
    public UserException insertSalary(Salary salary) {
        employeeService.insertSalary(salary);
        return UserException.SUCCESS;
    }


    //    工资列表
    @Pagable
    @RequestMapping("/rest/Salary/list")
    public   PageInfo<SalaryView> selectSalary(SalaryView salary) {
        return employeeService.selectSalary(salary);
    }


}
