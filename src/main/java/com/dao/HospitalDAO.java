package com.dao;

import java.sql.*;
import java.util.*;
import com.model.Patient;

public class HospitalDAO {

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/HOSPITAL",
            "root",
            "@Radhe_Radhe@"
        );
    }

    public void addPatient(Patient p) throws Exception {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO Patients VALUES (?,?,?,?,?,?,?)");

        ps.setInt(1, p.getPatientId());
        ps.setString(2, p.getPatientName());
        ps.setInt(3, p.getAge());
        ps.setString(4, p.getGender());
        ps.setString(5, p.getAdmissionDate());
        ps.setString(6, p.getAilment());
        ps.setString(7, p.getAssignedDoctor());

        ps.executeUpdate();
        con.close();
    }

    public List<Patient> getAllPatients() throws Exception {
        List<Patient> list = new ArrayList<>();

        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Patients");

        while (rs.next()) {
            Patient p = new Patient();
            p.setPatientId(rs.getInt("PatientID"));
            p.setPatientName(rs.getString("PatientName"));
            p.setAge(rs.getInt("Age"));
            p.setGender(rs.getString("Gender"));
            p.setAdmissionDate(rs.getString("AdmissionDate"));
            p.setAilment(rs.getString("Ailment"));
            p.setAssignedDoctor(rs.getString("AssignedDoctor"));
            list.add(p);
        }

        con.close();
        return list;
    }

    public void deletePatient(int id) throws Exception {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM Patients WHERE PatientID=?");

        ps.setInt(1, id);
        ps.executeUpdate();

        con.close();
    }

    public void updatePatient(Patient p) throws Exception {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "UPDATE Patients SET PatientName=?, Age=?, Gender=?, AdmissionDate=?, Ailment=?, AssignedDoctor=? WHERE PatientID=?");

        ps.setString(1, p.getPatientName());
        ps.setInt(2, p.getAge());
        ps.setString(3, p.getGender());
        ps.setString(4, p.getAdmissionDate());
        ps.setString(5, p.getAilment());
        ps.setString(6, p.getAssignedDoctor());
        ps.setInt(7, p.getPatientId());

        ps.executeUpdate();
        con.close();
    }

    public List<Patient> getPatientsByDoctor(String doctor) throws Exception {
        List<Patient> list = new ArrayList<>();

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Patients WHERE AssignedDoctor=?");

        ps.setString(1, doctor);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Patient p = new Patient();
            p.setPatientId(rs.getInt("PatientID"));
            p.setPatientName(rs.getString("PatientName"));
            p.setAge(rs.getInt("Age"));
            p.setGender(rs.getString("Gender"));
            p.setAdmissionDate(rs.getString("AdmissionDate"));
            p.setAilment(rs.getString("Ailment"));
            p.setAssignedDoctor(rs.getString("AssignedDoctor"));
            list.add(p);
        }

        con.close();
        return list;
    }

    public List<Patient> getPatientsByAilment(String ailment) throws Exception {
        List<Patient> list = new ArrayList<>();

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Patients WHERE Ailment=?");

        ps.setString(1, ailment);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Patient p = new Patient();
            p.setPatientId(rs.getInt("PatientID"));
            p.setPatientName(rs.getString("PatientName"));
            p.setAge(rs.getInt("Age"));
            p.setGender(rs.getString("Gender"));
            p.setAdmissionDate(rs.getString("AdmissionDate"));
            p.setAilment(rs.getString("Ailment"));
            p.setAssignedDoctor(rs.getString("AssignedDoctor"));
            list.add(p);
        }

        con.close();
        return list;
    }

    public List<Patient> getPatientsByDate(String from, String to) throws Exception {
        List<Patient> list = new ArrayList<>();

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Patients WHERE AdmissionDate BETWEEN ? AND ?");

        ps.setString(1, from);
        ps.setString(2, to);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Patient p = new Patient();
            p.setPatientId(rs.getInt("PatientID"));
            p.setPatientName(rs.getString("PatientName"));
            p.setAge(rs.getInt("Age"));
            p.setGender(rs.getString("Gender"));
            p.setAdmissionDate(rs.getString("AdmissionDate"));
            p.setAilment(rs.getString("Ailment"));
            p.setAssignedDoctor(rs.getString("AssignedDoctor"));
            list.add(p);
        }

        con.close();
        return list;
    }

    public boolean isPatientIdExists(int id) throws Exception {
        boolean exists = false;

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT PatientID FROM Patients WHERE PatientID=?"
        );

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            exists = true;
        }

        con.close();
        return exists;
    }
}