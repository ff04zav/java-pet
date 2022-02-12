package com.google.ff04zav.db.mysql;

import java.sql.SQLException;

public class DaoException extends RuntimeException {

	public DaoException(SQLException e) {
		super(e);
	}
}
