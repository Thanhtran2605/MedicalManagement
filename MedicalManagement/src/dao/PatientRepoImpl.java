package dao;

import connection.sql.SQLServerConnectionManagerImpl;
import model.Patient;
import model.PatientStatEntry;
import utils.DateUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientRepoImpl extends IBaseRepository<Patient> {

    public PatientRepoImpl() {
        connectionManager = new SQLServerConnectionManagerImpl();
    }

    public List<Patient> findModelByNameLike(String name) {
        List<Patient> patientArrayList = new ArrayList<Patient>();
        try {
            Connection conn = connectionManager.getConnection();
            String query = "select * from benhan where TenBN like  N'%" + name + "%'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Patient patient;
            while (resultSet.next()) {
                patient = new Patient(resultSet.getString("MaBaoHiem"), resultSet.getString("TenBN"), resultSet.getString("QueQuan"), resultSet.getString("ChuanDoan"), resultSet.getString("NhomMau"), resultSet.getDate("NgayKham"), resultSet.getDate("NgayRaVien"));
                patientArrayList.add(patient);
            }
        } catch (Exception ear) {
            ear.printStackTrace();
        }
        return patientArrayList;
    }

    public List<PatientStatEntry> countGroupByMonth() {
        List<PatientStatEntry> result = new ArrayList<>();
        try {
            Connection conn = connectionManager.getConnection();
            String query = "select MONTH(A.NgayKham) as _month, count(*) as _count from benhan as A group by MONTH(A.NgayKham)";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            PatientStatEntry entry;
            while (resultSet.next()) {
                int month = resultSet.getInt("_month");
                int count = resultSet.getInt("_count");
                entry = new PatientStatEntry(month, count);
                result.add(entry);
            }
        } catch (Exception ear) {
            ear.printStackTrace();
        }

        return result;
    }

    @Override
    public int addModel(Patient model) {
        try {
            Connection conn = connectionManager.getConnection();
            String query = "insert into benhan (MaBaoHiem,TenBN,QueQuan,ChuanDoan,NhomMau,NgayKham,NgayRaVien) values (?,?,?,?,?,?,?)";
            PreparedStatement prepared = conn.prepareStatement(query);
            prepared.setString(1, model.getMaBaoHiem());
            prepared.setString(2, model.getTenBenhNhan());
            prepared.setString(3, model.getQueQuan());
            prepared.setString(4, model.getChuanDoan());
            prepared.setString(5, model.getNhomMau());
            prepared.setDate(6, DateUtils.convertUtilDate2SqlDate(model.getNgayVaoVien()));
            prepared.setDate(7, DateUtils.convertUtilDate2SqlDate(model.getNgayRaVien()));
            int rs = prepared.executeUpdate();

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean deleteModelByID(String id) {
        try {
            String query = "delete from benhan where MaBaoHiem=?";
            Connection conn = connectionManager.getConnection();
            PreparedStatement prepared = conn.prepareStatement(query);
            prepared.setString(1, id);
            int res = prepared.executeUpdate();
            return res != 0;
        } catch (Exception ecs) {
            ecs.printStackTrace();
        }
        return false;
    }

    @Override
    public int updateModel(String id,Patient model) {

        Connection conn = connectionManager.getConnection();
        try {
            String query = "update benhan set TenBN=?,QueQuan=?, ChuanDoan=?, NhomMau= ?,NgayKham=?,NgayRaVien=? where  MaBaoHiem=?";
            PreparedStatement prepared = conn.prepareStatement(query);
            prepared.setString(7, model.getMaBaoHiem());
            prepared.setString(1, model.getTenBenhNhan());
            prepared.setString(2, model.getQueQuan());
            prepared.setString(3, model.getChuanDoan());
            prepared.setString(4, model.getNhomMau());
            prepared.setDate(5, DateUtils.convertUtilDate2SqlDate(model.getNgayVaoVien()));
            prepared.setDate(6, DateUtils.convertUtilDate2SqlDate(model.getNgayRaVien()));
            int rs = prepared.executeUpdate();
            return rs;
        } catch (Exception erc) {
            erc.printStackTrace();
        }

        return 0;
    }
}

