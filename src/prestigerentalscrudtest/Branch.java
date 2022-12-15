/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prestigerentalscrudtest;

/**
 *
 * @author Chidera
 */
public class Branch {
    private int branchnum;
    private String address;
    private String phonenum;
    
    public Branch(int branchnum, String address, String phonenum) {
        this.branchnum = branchnum;
        this.address = address;
        this.phonenum = phonenum;
    }

    public int getBranchnum() {
        return branchnum;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenum() {
        return phonenum;
    }
}

