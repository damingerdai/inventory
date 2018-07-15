package org.daming.inventory.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 * 描述：
 *
 * @author daming
 * @date 2018-07-10 20:47
 */
public abstract class BaseDao {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    protected  <T> T get(String sql, Object[] params, ResultSetExtractor<T> rst) {
        Instant in = Instant.now();
        try {
            return getJdbcTemplate().query(sql, params, rst);
        } catch (DataAccessException ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        } finally {
            logger.error("sql: {} , spend time: {}", sql, Duration.between(in, Instant.now()).toMillis());
        }
    }

    protected <T> List<T> list(String sql, Object[] params, RowMapper<T> mapper) {
        Instant in = Instant.now();
        try {
            return getJdbcTemplate().query(sql, params, mapper);
        } catch (DataAccessException ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        } finally {
            logger.error("sql: {} , spend time: {}", sql, Duration.between(Instant.now(), in).toMillis());
        }
    }

    protected <T> List<T> list(String sql, RowMapper<T> mapper) {
        Instant in = Instant.now();
        try {
            return getJdbcTemplate().query(sql, mapper);
        } catch (DataAccessException ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        } finally {
            logger.error("sql: {} , spend time: {}", sql, Duration.between(in, Instant.now()).toMillis());
        }
    }

    protected KeyHolder add(String sql, Object[] params) {
        Instant in = Instant.now();
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql);
                for(int i=0; i < params.length; i++) {
                    ps.setObject(i+1, params[i]);
                }
                return ps;
            }, keyHolder);
            return keyHolder;
        } catch (DataAccessException ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        } finally {
            logger.error("sql: {} , spend time: {}", sql, Duration.between(in, Instant.now()).toMillis());
        }
    }

    protected boolean insert(String sql, Object[] params) {
        Instant in = Instant.now();
        try {
             getJdbcTemplate().update(sql, params);
             return true;
        } catch (DataAccessException ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        } finally {
            logger.error("sql: {} , spend time: {}", sql, Duration.between(in, Instant.now()).toMillis());
        }
    }

    protected int execute(String sql, Object[] params) {
        Instant in = Instant.now();
        try {
            return getJdbcTemplate().update(sql, params);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            throw ex;
        } finally {
            logger.error("sql: {} , spend time: {}", sql, Duration.between(in, Instant.now()).toMillis());
        }
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
