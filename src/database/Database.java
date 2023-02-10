package database;

import java.sql.*;

public class Database {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/text_encryptions";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "0000";

    private Connection connection;

    public Database() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void createRow(int id, String encryptedText, String decryptedText, String key) {
        try {
            String sql = "INSERT INTO text_encryption (id, incrypted_text, decrypted_text, key) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, encryptedText);
            statement.setString(3, decryptedText);
            statement.setString(4, key);

            int rowsInserted = statement.executeUpdate();
            System.out.println("Number of rows inserted: " + rowsInserted);
        } catch (SQLException e) {
            System.out.println("Error inserting data into the table: " + e.getMessage());
        }
    }

    public void readRow(int id) {
        try {
            String sql = "SELECT * FROM text_encryption WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("incrypted_text: " + resultSet.getString("incrypted_text"));
                System.out.println("decrypted_text: " + resultSet.getString("decrypted_text"));
                System.out.println("key: " + resultSet.getString("key"));
            }
        } catch (SQLException e) {
            System.out.println("Error reading data from the table: " + e.getMessage());
        }
    }

    public void readAllRows() {
        try {
            String sql = "SELECT * FROM text_encryption";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("incrypted_text: " + resultSet.getString("incrypted_text"));
                System.out.println("decrypted_text: " + resultSet.getString("decrypted_text"));
                System.out.println("key: " + resultSet.getString("key"));
                System.out.println("-------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error reading all data from the table: " + e.getMessage());
        }
    }

    public void updateRow(int id, String encryptedText, String decryptedText, String key) {
        try {
            String sql = "UPDATE text_encryption SET incrypted_text = ?, decrypted_text = ?, key = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, encryptedText);
            statement.setString(2, decryptedText);
            statement.setString(3, key);
            statement.setInt(4, id);

            int rowsUpdated = statement.executeUpdate();
            System.out.println("Number of rows updated: " + rowsUpdated);
        } catch (SQLException e) {
            System.out.println("Error updating data in the table: " + e.getMessage());
        }
    }

    public void deleteRow(int id) {
        try {
            String sql = "DELETE FROM text_encryption WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            System.out.println("Number of rows deleted: " + rowsDeleted);
        } catch (SQLException e) {
            System.out.println("Error deleting data from the table: " + e.getMessage());
        }
    }
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing the database connection: " + e.getMessage());
        }
    }



}



