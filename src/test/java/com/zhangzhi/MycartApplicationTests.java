package com.zhangzhi;

import com.github.pagehelper.PageInfo;
import com.zhangzhi.annotation.Pagable;
import com.zhangzhi.entity.Employee;
import com.zhangzhi.entity.MyUser;
import com.zhangzhi.entity.Permission;
import com.zhangzhi.entity.Salary;
import com.zhangzhi.service.ActivityService;
import com.zhangzhi.service.EmployeeService;
import com.zhangzhi.service.PermissionService;
import com.zhangzhi.view.SalaryView;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class MycartApplicationTests {

    @Autowired
    private ActivityService activityService;

@Autowired
private PermissionService permissionService;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public  void userTest()  {
//        测试一下添加的方法
        MyUser myUser = new MyUser();
        myUser.setPassword("45613");
        myUser.setLoginName("123124");
        myUser.setName("123456");
        myUser.setBirthday(new Date());
        myUser.setSex(1);
        Employee employee = new Employee();
        employee.setMobile("123456");
        employee.setDepartment("123");
        employee.setEntry_date(new Date());
        int i = employeeService.insertUser(myUser, employee);
        System.out.println(i);
    }

    @Test
    public  void selectsa() {
        SalaryView salaryView = new SalaryView();
        salaryView.setName("aaa");
        PageInfo<SalaryView> salaryViewPageInfo = employeeService.selectSalary(salaryView);
        System.out.println(salaryViewPageInfo);


    }

        @Test
    public  void insertSalory()  {
        Salary salary = new Salary();
        salary.setUid(22);
        salary.setSalary_base(new BigDecimal(20));
        salary.setSalary_subsidy(new BigDecimal(20));
        salary.setSalary_bonus(new BigDecimal(20));
        salary.setSalary_extra(new BigDecimal(20));
        employeeService.insertSalary(salary);
    }
























}
