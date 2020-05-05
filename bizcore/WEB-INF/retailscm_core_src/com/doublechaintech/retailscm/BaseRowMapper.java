
package com.doublechaintech.retailscm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import org.springframework.jdbc.core.RowMapper;

public abstract class BaseRowMapper<T> implements RowMapper<T> {

	public final T mapRow(ResultSet rs, int rowNumber) throws SQLException {
		return internalMapRow(rs, rowNumber);
	}
	protected DateTime convertToDateTime(Date date){
		DateTime dateTime = new DateTime();
		dateTime.setTime(date.getTime());
		return dateTime;
	}
	protected Images convertToImages(String dataInDb) {
		return Images.fromString(dataInDb);
	}
	protected abstract T internalMapRow(ResultSet rs, int rowNumber) throws SQLException;
	

	protected String readFullClob(ResultSet rs, String columnName, int rowNumber) throws IOException, SQLException {

		Clob clobObject = (Clob) rs.getObject(columnName);
		final StringBuilder sb = new StringBuilder();

		final Reader reader = clobObject.getCharacterStream();
		final BufferedReader br = new BufferedReader(reader);
		int b = br.read();
		
		while (eof() != b) {
			sb.append((char) b);
			b = br.read();
		}
		br.close();
		return sb.toString();

	}
	protected String readPartialClob(ResultSet rs, String columnName, int rowNumber, int lengthLimit) throws IOException, SQLException {

		Clob clobObject = (Clob) rs.getObject(columnName);
		final StringBuilder sb = new StringBuilder();

		final Reader reader = clobObject.getCharacterStream();
		final BufferedReader br = new BufferedReader(reader);
		int b = br.read();
		int length = 0;
		while (eof() != b) {
			sb.append((char) b);
			length++;
			if(length >= lengthLimit){
				break;
			}
			b = br.read();
		}
		br.close();
		return sb.toString();

	}
	protected final int eof(){
		return -1;
	}

}

















