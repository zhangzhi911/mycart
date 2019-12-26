package com.zhangzhi.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.zhangzhi.entity.Employee;
import com.zhangzhi.entity.MyUser;
import com.zhangzhi.entity.Salary;
import com.zhangzhi.entity.UserRole;
import com.zhangzhi.mapper.ActivityMapper;
import com.zhangzhi.mapper.EmployeeMapper;
import com.zhangzhi.mapper.RolePermissionMapper;
import com.zhangzhi.mapper.UserRoleMapper;
import com.zhangzhi.view.SalaryView;
import com.zhangzhi.vo.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private ActivityMapper activityMapper;
//用于MIapper

    @Autowired
    private RolePermissionMapper rolePermissionMapper;
//权限Mapper

    @Autowired
    private UserRoleMapper userRoleMapper;
//角色Mapper

    @Autowired
    private EmployeeMapper employeeMapper;
//    员工Mapper

    //员工列表
    public PageInfo<Employee> selectEmployee(Employee employee) {
        List<Employee> employees = employeeMapper.selectEmployee(employee);
        return new PageInfo<Employee>(employees);
    }

    //    添加用户
    public int insertUser(MyUser myUser, Employee employee) {

        activityMapper.insertUser(myUser);
        Integer userId = myUser.getUserId();
        System.out.println("来添加了" + userId);
        employee.setUid(userId);
        employee.setName(myUser.getName());
        employeeMapper.insertEmployee(employee);
        return userId;
    }

    //    删除用户
    public int deleteUser(List<Integer> id) {
        employeeMapper.DeleteEmployee(id);
        return activityMapper.deleteUser(id);
    }

    //    添加工资条
    public int insertSalary(Salary salary) {
        return employeeMapper.insertSalary(salary);
    }

    //    工资列表
    public PageInfo<SalaryView> selectSalary(SalaryView salary) {
        List<SalaryView> salaries = employeeMapper.selectSalary(salary);
        for (SalaryView s : salaries
        ) {
            BigDecimal multiply = s.getSalary_base().multiply(s.getSalary_bonus().multiply(s.getSalary_extra().multiply(s.getSalary_subsidy())));
            s.setTotal(multiply);
            s.setAvgtotal(multiply);
        }
        return new PageInfo<SalaryView>(salaries);
    }

}
