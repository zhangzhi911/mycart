package com.zhangzhi.mapper;

import com.zhangzhi.entity.Employee;
import com.zhangzhi.entity.Salary;
import com.zhangzhi.view.SalaryView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    //    添加员工
    int insertEmployee(Employee employee);

    //    删除员工
    int DeleteEmployee(List<Integer> id);

    //员工列表
    List<Employee> selectEmployee(Employee employee);

    //员工单条
    Employee selectByEmployee(Integer id);

    //    添加工资条
    int insertSalary(Salary salary);

    //    工资列表
    List<SalaryView> selectSalary(SalaryView salary);
}