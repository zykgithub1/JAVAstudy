package cn.zyk.domain;

import java.util.Date;

public class Empp {
    private  Integer id;
    private  String ename;
    private  Integer job_Id;
    private  Integer mrg;
    private Date joinDate;
    private Double salary;
    private Double bonus;
    private Integer dept_id;

    public Empp() {
    }

    @Override
    public String toString() {
        return "Empp{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", job_Id=" + job_Id +
                ", mrg=" + mrg +
                ", joinDate=" + joinDate +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", dept_id=" + dept_id +
                '}';
    }

    public Empp(Integer id, String ename, Integer job_Id, Integer mrg, Date joinDate, Double salary, Double bonus, Integer dept_id) {
        this.id = id;
        this.ename = ename;
        this.job_Id = job_Id;
        this.mrg = mrg;
        this.joinDate = joinDate;
        this.salary = salary;
        this.bonus = bonus;
        this.dept_id = dept_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob_Id(Integer job_Id) {
        this.job_Id = job_Id;
    }

    public void setMrg(Integer mrg) {
        this.mrg = mrg;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Integer getId() {
        return id;
    }

    public String getEname() {
        return ename;
    }

    public Integer getJob_Id() {
        return job_Id;
    }

    public Integer getMrg() {
        return mrg;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public Double getSalary() {
        return salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public Integer getDept_id() {
        return dept_id;
    }
}
