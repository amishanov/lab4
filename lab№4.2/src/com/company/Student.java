package com.company;

public class Student {
    private String firstName;
    private String lastName;
    private int recBookNum;
    private String birthDate;
    private String phoneNumber;
    private String enrollmentDate;
    private String groupNumber;
    Student(){

    }
    Student(String fn,String ln,int rbn,String bd, String pn, String ed, String gn)throws Exception{try{
        firstName=fn; lastName=ln; recBookNum=rbn; birthDate=bd; phoneNumber=pn; enrollmentDate=ed; groupNumber=gn;}
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public String[] checkRecBook(int recBookNum) {
        if (this.recBookNum == recBookNum)
            return new String[] {firstName, lastName};
        return null;
    }
    public boolean checkOneDate(Student s){
        if (this.enrollmentDate.equals(s.enrollmentDate))
            return true;
        return false;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getRecBookNum() {
        return recBookNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setRecBookNum(int recBookNum) {
        this.recBookNum = recBookNum;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
