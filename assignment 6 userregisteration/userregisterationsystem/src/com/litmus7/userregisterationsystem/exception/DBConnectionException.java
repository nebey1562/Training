package com.litmus7.userregisterationsystem.exception;

import java.sql.SQLException;

public class DBConnectionException extends Exception {

	public DBConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

}
