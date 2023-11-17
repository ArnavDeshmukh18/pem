import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import static java.sql.DriverManager.getConnection;

public class Expense {
    private Long expenseId=System.currentTimeMillis();
    Long categoryId;

    Long amount;
    Date date;
    String description;


    String url = "jdbc:mysql://localhost:3306/expense";  // Root connection, no database specified
    String dbuser = "root";
    String password = "Virat@18";


    public Expense() {
    }

    public Expense(Long categoryId, Long amount, Date date, String description) {
        this.categoryId = categoryId;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void addExpenseToDb(User user) {
        try (Connection connection = getConnection(url, dbuser, password)) {
            String query = "INSERT INTO expenses (user_id, category_id,description,price) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, user.userId);
            statement.setInt(2, Math.toIntExact(categoryId));
            statement.setString(3,description);
            statement.setInt(4, Math.toIntExact(amount));

            statement.executeUpdate();
            System.out.println("Expense Added !!!" );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}


//
//    CREATE TABLE expenses (
//       expense_id INT AUTO_INCREMENT PRIMARY KEY,
//                 user_id INT,
//            category_id INT,
//                description VARCHAR(255),
//                date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//                 price DECIMAL(10, 2),
//            FOREIGN KEY (user_id) REFERENCES users(id),
//                FOREIGN KEY (category_id) REFERENCES category(categoryId));