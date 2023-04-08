package view;

import com.toedter.calendar.JDateChooser;
import connection.ConnectionManager;
import connection.sql.SQLServerConnectionManagerImpl;
import controller.QuanLyBenhAnController;
import model.Patient;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.util.*;
import java.util.Date;


public class QuanLyBenhAnView {

    public final JPanel jPanelThongKe;
    private JPanel containPane;
    public JTextField textFieldTimBenhNhan;
    public JTextField textFieldTenBenhNhan;
    private final JSeparator separatorone = new JSeparator();
    public JTable jTable;
    private JScrollPane jScrollPane;
    public JTextField textFieldMaSoBaoHiem;
    public JTextField textField_ChuanDoan;
    public JTextField textFieldQueQuan;
    public JTextField textFieldNhomMau;
    public JDateChooser dateChooserNgayVaoVien;
    public JDateChooser dateChooserNgayRaVien;
    private JTabbedPane jTabbedPane;
    private JPanel containPane2;
    private JFrame jFrame;
    private JPanel containPane3;
    private JButton jButtonThongKe;
    private QuanLyBenhAnController quanLyBenhAnController;
    protected ConnectionManager connectionManager = new SQLServerConnectionManagerImpl();


    public QuanLyBenhAnView() {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        containPane = new JPanel();
        containPane.setBounds(100, 100, 790, 647);
        containPane.setBackground(new Color(245, 222, 179));
        containPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        containPane.setLayout(null);

        jTabbedPane = new JTabbedPane();

        JLabel jLabelTimBenhNhan = new JLabel("T\u00ECm b\u1EC7nh nh\u00E2n");
        jLabelTimBenhNhan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jLabelTimBenhNhan.setBounds(10, 41, 142, 41);
        containPane.add(jLabelTimBenhNhan);

        textFieldTimBenhNhan = new JTextField();
        textFieldTimBenhNhan.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String name = textFieldTimBenhNhan.getText();
                quanLyBenhAnController.search(name);


            }
        });
        textFieldTimBenhNhan.setBounds(121, 41, 267, 41);
        containPane.add(textFieldTimBenhNhan);
        textFieldTimBenhNhan.setColumns(10);

        JLabel jLabelThongTinBenhAn = new JLabel("Th\u00F4ng tin b\u1EC7nh \u00E1n");
        jLabelThongTinBenhAn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jLabelThongTinBenhAn.setBounds(10, 92, 207, 41);
        containPane.add(jLabelThongTinBenhAn);

        JLabel jLabelTenBenhNhan = new JLabel("T\u00EAn B\u1EC7nh Nh\u00E2n");
        jLabelTenBenhNhan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jLabelTenBenhNhan.setBounds(10, 176, 108, 41);
        containPane.add(jLabelTenBenhNhan);

        textFieldTenBenhNhan = new JTextField();
        textFieldTenBenhNhan.setBounds(128, 179, 196, 38);
        containPane.add(textFieldTenBenhNhan);
        textFieldTenBenhNhan.setColumns(10);

        JLabel jLabelQueQuan = new JLabel("   Qu\u00EA qu\u00E1n");
        jLabelQueQuan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jLabelQueQuan.setBounds(401, 118, 90, 56);
        containPane.add(jLabelQueQuan);

        JLabel jLabelChuanDoan = new JLabel("Chu\u1EA9n \u0111o\u00E1n");
        jLabelChuanDoan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jLabelChuanDoan.setBounds(20, 223, 80, 56);
        containPane.add(jLabelChuanDoan);

        JLabel jLabelNgayVaoVien = new JLabel("Ng\u00E0y v\u00E0o vi\u1EC7n");
        jLabelNgayVaoVien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jLabelNgayVaoVien.setBounds(21, 277, 86, 67);
        containPane.add(jLabelNgayVaoVien);

        JLabel jLabelNgayRaVien = new JLabel("Ng\u00E0y ra vi\u1EC7n");
        jLabelNgayRaVien.setBackground(new Color(240, 230, 140));
        jLabelNgayRaVien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jLabelNgayRaVien.setBounds(401, 218, 86, 67);
        containPane.add(jLabelNgayRaVien);
        separatorone.setBounds(0, 92, 776, 2);
        containPane.add(separatorone);

        JSeparator separatortwo = new JSeparator();
        separatortwo.setBounds(10, 358, 776, 2);
        containPane.add(separatortwo);

        JLabel jLabelDanhSachBenhAn = new JLabel("Danh s\u00E1ch b\u1EC7nh \u00E1n");
        jLabelDanhSachBenhAn.setFont(new Font("Verdana", Font.PLAIN, 15));
        jLabelDanhSachBenhAn.setBounds(10, 354, 172, 56);
        containPane.add(jLabelDanhSachBenhAn);


        jTable = new JTable();
        jTable.setBounds(689, 341, -679, 118);
        jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(10, 392, 756, 126);
        containPane.add(jScrollPane);

        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = jTable.getSelectedRow();
                showData(i);
            }
        });
        JButton jButtonThem = new JButton("Th\u00EAm");
        jButtonThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                quanLyBenhAnController.addPatient();
            }

        });
        jButtonThem.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\add-2-icon.png"));
        jButtonThem.setForeground(Color.BLUE);
        jButtonThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jButtonThem.setBounds(11, 528, 151, 61);
        containPane.add(jButtonThem);

        JButton jButtonXoa = new JButton("X\u00F3a");
        jButtonXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quanLyBenhAnController.deletePatient();
            }
        });
        jButtonXoa.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Button-Delete-icon.png"));
        jButtonXoa.setForeground(Color.BLUE);
        jButtonXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jButtonXoa.setBounds(205, 528, 142, 61);

        containPane.add(jButtonXoa);

        JButton jButtonSua = new JButton("C\u1EADp nh\u1EADt");
        jButtonSua.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Apps-system-software-update-icon.png"));
        jButtonSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jButtonSua.setForeground(Color.BLUE);
        jButtonSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quanLyBenhAnController.updatePartient();
            }
        });


        jButtonSua.setBounds(389, 528, 151, 61);
        containPane.add(jButtonSua);

        JButton jButtonHuy = new JButton("H\u1EE7y");
        jButtonHuy.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Actions-edit-cancel-icon.png"));
        jButtonHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jButtonHuy.setForeground(Color.BLUE);
        jButtonHuy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldMaSoBaoHiem.setText("");
                textFieldTenBenhNhan.setText("");
                textFieldQueQuan.setText("");
                textField_ChuanDoan.setText("");
                textFieldNhomMau.setText("");
                dateChooserNgayVaoVien.setDate(Calendar.getInstance().getTime());
                dateChooserNgayRaVien.setDate(Calendar.getInstance().getTime());
            }
        });
        jButtonHuy.setBounds(594, 528, 146, 61);
        containPane.add(jButtonHuy);

        JLabel jLabelNhomMau = new JLabel("Nh\u00F3m m\u00E1u");
        jLabelNhomMau.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jLabelNhomMau.setBounds(411, 184, 80, 27);
        containPane.add(jLabelNhomMau);

        JButton jButtonThoat = new JButton("Tho\u00E1t");
        jButtonThoat.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\close-icon.png"));
        jButtonThoat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        jButtonThoat.setForeground(Color.BLUE);
        jButtonThoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jButtonThoat.setBounds(483, 41, 224, 41);
        containPane.add(jButtonThoat);

        JLabel jLabelMaSoBaoHiem = new JLabel("M\u00E3 s\u1ED1 b\u1EA3o hi\u1EC3m");
        jLabelMaSoBaoHiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jLabelMaSoBaoHiem.setBounds(10, 131, 115, 30);
        containPane.add(jLabelMaSoBaoHiem);

        textFieldMaSoBaoHiem = new JTextField();
        textFieldMaSoBaoHiem.setColumns(10);
        textFieldMaSoBaoHiem.setBounds(128, 127, 196, 38);
        containPane.add(textFieldMaSoBaoHiem);

        textField_ChuanDoan = new JTextField();
        textField_ChuanDoan.setColumns(10);
        textField_ChuanDoan.setBounds(128, 234, 196, 38);
        containPane.add(textField_ChuanDoan);

        textFieldQueQuan = new JTextField();
        textFieldQueQuan.setColumns(10);
        textFieldQueQuan.setBounds(497, 123, 210, 41);
        containPane.add(textFieldQueQuan);

        textFieldNhomMau = new JTextField();
        textFieldNhomMau.setColumns(10);
        textFieldNhomMau.setBounds(497, 176, 210, 41);
        containPane.add(textFieldNhomMau);

        dateChooserNgayVaoVien = new JDateChooser();
        dateChooserNgayVaoVien.setBounds(128, 288, 196, 41);
        containPane.add(dateChooserNgayVaoVien);

        dateChooserNgayRaVien = new JDateChooser();
        dateChooserNgayRaVien.setBounds(497, 234, 210, 45);
        containPane.add(dateChooserNgayRaVien);


        containPane2 = new JPanel();
        containPane2.setBackground(new Color(245, 222, 179));
        containPane2.setLayout(null);
        containPane2.setLayout(null);

        JLabel jLabelQuanLyBenhAn = new JLabel("QU\u1EA2N L\u00DD B\u1EC6NH \u00C1N");
        jLabelQuanLyBenhAn.setForeground(Color.WHITE);
        jLabelQuanLyBenhAn.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\42491-hospital-icon (1).png"));
        jLabelQuanLyBenhAn.setFont(new Font("Times New Roman", Font.BOLD, 30));
        jLabelQuanLyBenhAn.setBounds(233, 10, 400, 82);
        containPane2.add(jLabelQuanLyBenhAn);

        JLabel jLabelNguoiQuanLy = new JLabel("Ng\u01B0\u1EDDi qu\u1EA3n l\u00FD");
        jLabelNguoiQuanLy.setForeground(Color.WHITE);
        jLabelNguoiQuanLy.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Monitor-icon.png"));
        jLabelNguoiQuanLy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jLabelNguoiQuanLy.setBounds(510, 550, 222, 82);
        containPane2.add(jLabelNguoiQuanLy);

        JLabel jLabelTenNguoiQuanLy = new JLabel("Tr\u1EA7n Th\u1ECB Th\u00E0nh");
        jLabelTenNguoiQuanLy.setForeground(Color.WHITE);
        jLabelTenNguoiQuanLy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        jLabelTenNguoiQuanLy.setBounds(550, 610, 179, 61);
        containPane2.add(jLabelTenNguoiQuanLy);

        JLabel jLabelDoctorIcon = new JLabel("");
        jLabelDoctorIcon.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\doctor-hospital-icon.png"));
        jLabelDoctorIcon.setBounds(120, 150, 722, 316);
        containPane2.add(jLabelDoctorIcon);

        JLabel jLabelUserIcon = new JLabel("");
        jLabelUserIcon.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\Users-icon.png"));
        jLabelUserIcon.setBounds(101, 550, 179, 142);
        containPane2.add(jLabelUserIcon);

        containPane3 = new JPanel();
        containPane3.setBounds(100, 100, 695, 576);
        containPane3.setBackground(new Color(245, 222, 179));
        containPane3.setBorder(new EmptyBorder(5, 5, 5, 5));
        containPane3.setLayout(null);

        jButtonThongKe = new JButton("Th\u1ED1ng k\u00EA s\u1ED1 lượng kh\u00E1m theo th\u00E1ng");
        jButtonThongKe.setBounds(170, 35, 445, 73);
        jButtonThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 23));
        containPane3.add(jButtonThongKe);

        jPanelThongKe = new JPanel();
        jPanelThongKe.setBounds(20, 110, 751, 487);
        containPane3.add(jPanelThongKe);


        jButtonThongKe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quanLyBenhAnController.updateChart();
            }
        });


        insertJTable();
        jFrame.setSize(800, 800);
        jFrame.setVisible(true);


        quanLyBenhAnController = new QuanLyBenhAnController(this);
    }

    public void showDisplay() {
        jFrame.getContentPane().add(jTabbedPane);
        jFrame.setLocationRelativeTo(null);
        jTabbedPane.addTab("Màn hình chính", containPane2);
        jTabbedPane.addTab("Quản lý bệnh nhân", containPane);
        jTabbedPane.addTab("Thống kê", containPane3);

    }


    public ArrayList<Patient> arrayListBenhNhan() {
        ArrayList<Patient> patientList = null;
        patientList = new ArrayList<Patient>();
        try {
            Connection conn = connectionManager.getConnection();
            String query = "select * from benhan";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Patient patient;
            while (resultSet.next()) {
                patient = new Patient(resultSet.getString("MaBaoHiem"), resultSet.getString("TenBN"),
                        resultSet.getString("QueQuan"), resultSet.getString("ChuanDoan"), resultSet.getString("NhomMau")
                        , resultSet.getDate("NgayKham"), resultSet.getDate("NgayRaVien"));
                patientList.add(patient);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi");
        }
        return patientList;
    }

    public void insertJTable() {
        ArrayList<Patient> patientArrayList = arrayListBenhNhan();
        DefaultTableModel model = new DefaultTableModel();

        model.setRowCount(0);
        Object[] columnsName = new Object[7];
        columnsName[0] = "MaBaoHiem";
        columnsName[1] = "TenBN";
        columnsName[2] = "QueQuan";
        columnsName[3] = "ChuanDoan";
        columnsName[4] = "NhomMau";
        columnsName[5] = "NgayKham";
        columnsName[6] = "NgayRaVien";
        model.setColumnIdentifiers(columnsName);
        Object[] row = new Object[7];
        for (int i = 0; i < patientArrayList.size(); i++) {
            row[0] = patientArrayList.get(i).getMaBaoHiem();
            row[1] = patientArrayList.get(i).getTenBenhNhan();
            row[2] = patientArrayList.get(i).getQueQuan();
            row[3] = patientArrayList.get(i).getChuanDoan();
            row[4] = patientArrayList.get(i).getNhomMau();
            row[5] = patientArrayList.get(i).getNgayVaoVien();
            row[6] = patientArrayList.get(i).getNgayRaVien();
            model.addRow(row);
        }
        jTable.setModel(model);

    }

    public void showData(int index) {
        textFieldMaSoBaoHiem.setText(arrayListBenhNhan().get(index).getMaBaoHiem());
        textFieldTenBenhNhan.setText(arrayListBenhNhan().get(index).getTenBenhNhan());
        textFieldQueQuan.setText(arrayListBenhNhan().get(index).getQueQuan());
        textField_ChuanDoan.setText(arrayListBenhNhan().get(index).getChuanDoan());
        textFieldNhomMau.setText(arrayListBenhNhan().get(index).getNhomMau());
        dateChooserNgayVaoVien.setDate(arrayListBenhNhan().get(index).getNgayVaoVien());
        dateChooserNgayRaVien.setDate(arrayListBenhNhan().get(index).getNgayRaVien());
    }
}

