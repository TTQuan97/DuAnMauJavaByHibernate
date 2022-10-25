/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author trant
 */
public class SanPhamViewModel {

    private String ma;
    private String ten;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(String ma, String ten) {
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

    public Object[] getDataViewSp() {
        return new Object[]{ma, ten};
    }

    @Override
    public String toString() {
        return ma;
    }
}
