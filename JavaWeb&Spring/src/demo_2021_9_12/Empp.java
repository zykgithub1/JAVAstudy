package demo_2021_9_12;


import java.util.Date;

public class Empp {
    public Integer id;
    public String ename;
    public Integer job_id;
    public Integer mgr;
    public Date joindate;
    public Double salary;
    public Double bounds;
    public Integer dept_id;

//    public Empp(Integer id, String ename, Integer job_id, Integer mgr, Date joindate, Double salary, Double bounds, Integer dept_id) {
//        this.id = id;
//        this.ename = ename;
//        this.job_id = job_id;
//        this.mgr = mgr;
//        this.joindate = joindate;
//        this.salary = salary;
//        this.bounds = bounds;
//        this.dept_id = dept_id;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBounds() {
        return bounds;
    }

    public void setBounds(Double bounds) {
        this.bounds = bounds;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Empp{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", job_id=" + job_id +
                ", mgr=" + mgr +
                ", joindate=" + joindate +
                ", salary=" + salary +
                ", bounds=" + bounds +
                ", dept_id=" + dept_id +
                '}';
    }
}
