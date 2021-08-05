package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection connection) {
        this.conn = connection;
    }

    @Override
    public void insert(Department obj) {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO department\n" +
                            "(Name)\n" +
                            "VALUES\n" +
                            "(?)", Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, obj.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected error! No rows affected.");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE department\n" +
                            "SET Name = ?\n" +
                            "WHERE Id = ?");

            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "DELETE FROM department\n" +
                            "WHERE Id = ?"
            );

            st.setInt(1, id);

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM department WHERE Id = ?");

            st.setInt(1, id);

            rs = st.executeQuery();
            if (rs.next()) {
                Department dep = new Department();
                dep.setName(rs.getString("Name"));
                dep.setId(rs.getInt("Id"));
                return dep;
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM department ORDER BY Name");

            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();

            while (rs.next()) {
                Department dp = new Department();
                dp.setId(rs.getInt("Id"));
                dp.setName(rs.getString("Name"));
                list.add(dp);
            }
            return list;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
