package rikkei.ra.model.dao;

import rikkei.ra.config.Constatnt.*;
import rikkei.ra.model.entity.Product;
import rikkei.ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements IGenericDAO<Product, Integer> {
    @Override
    public List<Product> findAll() {
        Connection connection = ConnectionDB.getConnection();
        List<Product> products = new ArrayList<>();

        try {
            PreparedStatement pstm = connection.prepareStatement(productQuery.FIND_ALL.getQuery());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setId(rs.getInt("productId"));
                product.setName(rs.getString("productName"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));

                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return products;
    }

    @Override
    public Boolean save(Product product) {
        Connection connection = ConnectionDB.getConnection();

        try {
            PreparedStatement pstm = connection.prepareStatement(productQuery.ADD_NEW.getQuery());

            pstm.setString(1, product.getName());
            pstm.setString(2, product.getDescription());
            pstm.setDouble(3, product.getPrice());

            int check = pstm.executeUpdate();

            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public Product findById(Integer id) {
        Connection connection = ConnectionDB.getConnection();
        Product product = new Product();

        try {
            PreparedStatement pstm = connection.prepareStatement(productQuery.FIND_ONE.getQuery());
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                product.setId(rs.getInt("productId"));
                product.setName(rs.getString("productName"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return product;
    }

    @Override
    public Boolean update(Product product, Integer id) {
        Connection connection = ConnectionDB.getConnection();

        try {
            PreparedStatement pstm = connection.prepareStatement(productQuery.UPDATE.getQuery());

            pstm.setString(1, product.getName());
            pstm.setString(2, product.getDescription());
            pstm.setDouble(3, product.getPrice());
            pstm.setInt(4, id);

            int check = pstm.executeUpdate();

            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        Connection connection = ConnectionDB.getConnection();

        try {
            PreparedStatement pstm = connection.prepareStatement(productQuery.DELETE.getQuery());
            pstm.setInt(1, id);

            int check = pstm.executeUpdate();

            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ConnectionDB.closeConnection(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return false;
    }
}
