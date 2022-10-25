/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author trant
 */
public class NsxViewModel {

    private String ma;
    private String ten;

    public NsxViewModel() {
    }

    public NsxViewModel(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Object[] getDataViewNsx() {
        return new Object[]{ma, ten};
    }

    @Override
    public String toString() {
        return ten;
    }
}
