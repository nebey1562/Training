package com.litmus7.userregisterationsystem.dao;

import static com.litmus7.userregisterationsystem.util.AppConstants.CHECK_SQL;
import static com.litmus7.userregisterationsystem.util.AppConstants.INSERT_SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.litmus7.userregisterationsystem.dto.User;
import com.litmus7.userregisterationsystem.exception.DBConnectionException;
import com.litmus7.userregisterationsystem.exception.UserAlreadyExistsException;
import com.litmus7.userregisterationsystem.exception.UserRegistrationException;
import com.litmus7.userregisterationsystem.util.DBUtil;

public class UserDAO {

    /**
     * Saves a new user to the database after validation.
     *
     * @param user the User object to be saved
     * @throws UserRegistrationException if a validation or persistence error occurs
     * @throws DBConnectionException if the database connection fails
     */
    public void saveUser(User user) throws UserRegistrationException, DBConnectionException {
        try (Connection connection = DBUtil.getConnection()) {

            try (PreparedStatement checkStmt = connection.prepareStatement(CHECK_SQL)) {
                checkStmt.setString(1, user.getEmail());
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        throw new UserAlreadyExistsException("A user with this email already exists.");
                    }
                }
            }

            try (PreparedStatement insertStmt = connection.prepareStatement(INSERT_SQL)) {
                insertStmt.setString(1, user.getUsername());
                insertStmt.setInt(2, user.getAge());
                insertStmt.setString(3, user.getEmail());
                insertStmt.setString(4, user.getPassword());
                insertStmt.executeUpdate();
            }

        } catch (UserAlreadyExistsException e) {
            throw new UserRegistrationException(e.getMessage(), e);
        } catch (Exception e) {
            throw new UserRegistrationException("An error occurred while registering user.", e);
        }
    }
}
