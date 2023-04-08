package controller;


import dao.PatientRepoImpl;
import model.Patient;
import model.PatientStatEntry;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import view.QuanLyBenhAnView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class QuanLyBenhAnController {
    public static final String COUNT_ROW_KEY = "Số lần khám";
    private PatientRepoImpl patientRepo;
    private QuanLyBenhAnView view;

    public QuanLyBenhAnController(QuanLyBenhAnView view) {
        this.view = view;
        this.patientRepo = new PatientRepoImpl();
    }

    public QuanLyBenhAnView getView() {
        return view;
    }

    public void setView(QuanLyBenhAnView view) {
        this.view = view;
    }


    public void search(String name) {

        List<Patient> patients = patientRepo.findModelByNameLike(name);


        DefaultTableModel model = (DefaultTableModel) view.jTable.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < patients.size(); i++) {
            row[0] = patients.get(i).getMaBaoHiem();
            row[1] = patients.get(i).getTenBenhNhan();
            row[2] = patients.get(i).getQueQuan();
            row[3] = patients.get(i).getChuanDoan();
            row[4] = patients.get(i).getNhomMau();
            row[5] = patients.get(i).getNgayVaoVien();
            row[6] = patients.get(i).getNgayRaVien();
            model.addRow(row);

        }
        view.jTable.setModel(model);
    }

    public void addPatient() {
        if (view.textFieldMaSoBaoHiem.getText().equals(" ") || view.textFieldTenBenhNhan.getText().equals(" ")
                || view.textFieldQueQuan.getText().equals(" ") || view.textField_ChuanDoan.getText().equals(" ")
                || view.textFieldNhomMau.getText().equals(" ") || view.dateChooserNgayVaoVien.equals(" ")
                || view.dateChooserNgayRaVien.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Not null");
        } else {
            try {
                Patient model = new Patient(view.textFieldMaSoBaoHiem.getText(),
                        view.textFieldTenBenhNhan.getText(),
                        view.textFieldQueQuan.getText(),
                        view.textField_ChuanDoan.getText(),
                        view.textFieldNhomMau.getText(),
                        view.dateChooserNgayVaoVien.getDate(),
                        view.dateChooserNgayRaVien.getDate()
                );

                int rs = patientRepo.addModel(model);

                view.insertJTable();
                if (rs >= 1) {
                    JOptionPane.showMessageDialog(null, rs + " Đã được thêm vào bảng thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi thêm vào bảng");
                }
            } catch (Exception eac) {
                eac.printStackTrace();
            }
            view.textFieldMaSoBaoHiem.setText("");
            view.textFieldTenBenhNhan.setText("");
            view.textFieldQueQuan.setText("");
            view.textField_ChuanDoan.setText("");
            view.textFieldNhomMau.setText("");
            view.dateChooserNgayVaoVien.setDate(Calendar.getInstance().getTime());
            view.dateChooserNgayRaVien.setDate(Calendar.getInstance().getTime());
        }
    }

    public void deletePatient() {

        if (view.textFieldMaSoBaoHiem.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Not null");
        } else {
            boolean success = patientRepo.deleteModelByID(view.textFieldMaSoBaoHiem.getText().trim());
            view.insertJTable();
            if (success) {
                JOptionPane.showMessageDialog(null, "Xóa bệnh nhân thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa bệnh nhân không thành công");
            }

            view.textFieldMaSoBaoHiem.setText("");
            view.textFieldTenBenhNhan.setText("");
            view.textFieldQueQuan.setText("");
            view.textField_ChuanDoan.setText("");
            view.textFieldNhomMau.setText("");
            view.dateChooserNgayVaoVien.setDate(Calendar.getInstance().getTime());
            view.dateChooserNgayRaVien.setDate(Calendar.getInstance().getTime());
        }
    }

    public void updatePartient() {
        if (view.textFieldMaSoBaoHiem.getText().equals(" ") || view.textFieldTenBenhNhan.getText().equals(" ")
                || view.textFieldQueQuan.getText().equals(" ") || view.textField_ChuanDoan.getText().equals(" ")
                || view.textFieldNhomMau.getText().equals(" ") || view.dateChooserNgayVaoVien.equals(" ")
                || view.dateChooserNgayRaVien.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Not null");
        } else {
            Patient patient = new Patient(
                    view.textFieldMaSoBaoHiem.getText(),
                    view.textFieldTenBenhNhan.getText(),
                    view.textFieldQueQuan.getText(),
                    view.textField_ChuanDoan.getText(),
                    view.textFieldNhomMau.getText(),
                    view.dateChooserNgayVaoVien.getDate(),
                    view.dateChooserNgayRaVien.getDate()
            );
            int rs = patientRepo.updateModel(patient.getMaBaoHiem(), patient);
            view.insertJTable();
            if (rs >= 1) {
                JOptionPane.showMessageDialog(null, rs + " Chỉnh sửa thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi");
            }
            view.textFieldMaSoBaoHiem.setText("");
            view.textFieldTenBenhNhan.setText("");
            view.textFieldQueQuan.setText("");
            view.textField_ChuanDoan.setText("");
            view.textFieldNhomMau.setText("");
            view.dateChooserNgayVaoVien.setDate(Calendar.getInstance().getTime());
            view.dateChooserNgayRaVien.setDate(Calendar.getInstance().getTime());

        }

    }

    static final List<String> ALL_MONTH_NAME = Arrays.asList(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    );

    public void updateChart() {
        List<PatientStatEntry> patientStatEntries = patientRepo.countGroupByMonth();

        DefaultCategoryDataset barChartDate = new DefaultCategoryDataset();

        // init empty month
        for (String e : ALL_MONTH_NAME) {
            barChartDate.setValue(0, COUNT_ROW_KEY, e);
        }

        // fill data
        for (PatientStatEntry e : patientStatEntries) {
            int monthIndex = e.getMonth();
            String monthName = ALL_MONTH_NAME.get(monthIndex - 1);
            barChartDate.setValue(e.getCount(), COUNT_ROW_KEY, monthName);
        }

        JFreeChart barJfreeChart = ChartFactory.createBarChart("Thống kê", "Tháng", "Số lượng", barChartDate, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barchartCatagory = barJfreeChart.getCategoryPlot();
        barchartCatagory.setRangeGridlinePaint(Color.ORANGE);

        ChartPanel barChartPanel = new ChartPanel(barJfreeChart);
        view.jPanelThongKe.removeAll();
        view.jPanelThongKe.add(barChartPanel);
        view.jPanelThongKe.revalidate();
        view.jPanelThongKe.repaint();

    }
}
