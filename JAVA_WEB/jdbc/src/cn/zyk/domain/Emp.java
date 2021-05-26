package cn.zyk.domain;

import java.util.Date;

/*
封装Emp的javaBea
 */
public class Emp {
    private  int id;
    private  String ename;
    private  int job_Id;
    private  int mrg;
    private Date joinDate;
    private double salary;
    private double bonus;
    private int dept_id;

    public Emp(int id, String ename, int job_Id, int mrg, Date joinDate, double salary, double bonus, int dept_id) {
        this.id = id;
        this.ename = ename;
        this.job_Id = job_Id;
        this.mrg = mrg;
        this.joinDate = joinDate;
        this.salary = salary;
        this.bonus = bonus;
        this.dept_id = dept_id;
    }

    public int getId() {
        return id;
    }

    public String getEname() {
        return ename;
    }

    public int getJob_Id() {
        return job_Id;
    }

    public int getMrg() {
        return mrg;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob_Id(int job_Id) {
        this.job_Id = job_Id;
    }

    public void setMrg(int mrg) {
        this.mrg = mrg;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
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
}
