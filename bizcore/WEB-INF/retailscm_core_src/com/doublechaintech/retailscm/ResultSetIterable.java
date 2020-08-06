package com.doublechaintech.retailscm;

import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ResultSetIterable<T> implements Iterable<T> {
    private final Connection connection;
    private final PreparedStatement preparedStatement;
    private final ResultSet rs;
    private final RowMapper<T> rowMapper;

    public ResultSetIterable(Connection pConnection, PreparedStatement pPreparedStatement, ResultSet rs, RowMapper<T> pRowMapper) {
        this.connection = pConnection;
        this.preparedStatement = pPreparedStatement;
        this.rs = rs;
        this.rowMapper = pRowMapper;
    }

    private boolean resultSetHasNext() {
        try {
            boolean next = rs.next();
            if (!next) {
                release();
            }
            return next;
        } catch (SQLException e) {
            //you should add proper exception handling here
            release();
            throw new RuntimeException(e);
        }
    }


    private void release() {
        System.out.println("release jdbc resources");
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            boolean hasNext = resultSetHasNext();
            int rowNum = 0;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public T next() {
                T result = null;
                try {
                    result = rowMapper.mapRow(rs, rowNum++);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                hasNext = resultSetHasNext();
                return result;
            }
        };
    }

    //adding stream support based on an iteratable is easy
    public Stream<T> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }
}


