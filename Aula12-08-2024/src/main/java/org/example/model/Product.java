package org.example.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product implements Entity{

    private int id;
    private int productTypeId;
    private String description;
    private double value;

    public Product(int id, int productTypeId, String description, double value) {
        this.id = id;
        this.productTypeId = productTypeId;
        this.description = description;
        this.value = value;
    }

    public Product(ResultSet rs) throws SQLException {
        super();
        this.id = rs.getInt("id");
        this.description = rs.getString("description");
        this.value = rs.getDouble("value");
    }

    public int getId() {
        return id;
    }

    public int getProductType() {
        return productTypeId;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product() {
    }

    @Override
    public Entity constructFromResultSet(ResultSet rs) throws SQLException{
        return new Product(rs);
    }

    @Override
    public PreparedStatement prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, getProductType());
        preparedStatement.setString(2, getDescription());
        preparedStatement.setDouble(2, getValue());
        return preparedStatement;
    }
}

