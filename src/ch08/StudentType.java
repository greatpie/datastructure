package ch08;

/**
 * 练习题8-4-2 学生信息类
 */
public class StudentType {
    private int SNo;        //学号
    private String name;       //姓名
    private String gender;     //性别
    private String classes;    //班级
    private String telephone;  //电话

    public int getSNo() {
        return SNo;
    }

    public void setSNo(int SNo) {
        this.SNo = SNo;
    }

    

    
    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public StudentType(int SNo,String name, String gender, String classes, String telephone) {
        this.SNo = SNo;
        this.name = name;
        this.gender = gender;
        this.classes = classes;
        this.telephone = telephone;
    }
     public StudentType(String[] St) {
     //   this.SNo = St[0];
        this.name = St[0];
        this.gender = St[1];
        this.classes = St[2];
        this.telephone = St[3];
    }
  public String toString() { //覆盖toString()方法
        return name +","+gender+","+classes+","+telephone;
    }



}
