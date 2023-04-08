package model;

import java.util.Date;

public class Patient {
    private String MaBaoHiem;
    private String tenBenhNhan;
    private String queQuan;
    private String chuanDoan;
    private String nhomMau;
    private Date ngayVaoVien;
    private Date ngayRaVien;

    public Patient(String maBaoHiem, String tenBenhNhan, String queQuan, String chuanDoan, String nhomMau, Date ngayVaoVien, Date ngayRaVien) {
        MaBaoHiem = maBaoHiem;
        this.tenBenhNhan = tenBenhNhan;
        this.queQuan = queQuan;
        this.chuanDoan = chuanDoan;
        this.nhomMau = nhomMau;
        this.ngayVaoVien = ngayVaoVien;
        this.ngayRaVien = ngayRaVien;
    }

    public String getMaBaoHiem() {
        return MaBaoHiem;
    }

    public void setMaBaoHiem(String maBaoHiem) {
        MaBaoHiem = maBaoHiem;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getChuanDoan() {
        return chuanDoan;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public String getNhomMau() {
        return nhomMau;
    }

    public void setNhomMau(String nhomMau) {
        this.nhomMau = nhomMau;
    }

    public Date getNgayVaoVien() {
        return ngayVaoVien;
    }

    public void setNgayVaoVien(Date ngayVaoVien) {
        this.ngayVaoVien = ngayVaoVien;
    }

    public Date getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(Date ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "MaBaoHiem='" + MaBaoHiem + '\'' +
                ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", queQuan='" + queQuan + '\'' +
                ", chuanDoan='" + chuanDoan + '\'' +
                ", nhomMau='" + nhomMau + '\'' +
                ", ngayVaoVien=" + ngayVaoVien +
                ", ngayRaVien=" + ngayRaVien +
                '}';
    }
}
