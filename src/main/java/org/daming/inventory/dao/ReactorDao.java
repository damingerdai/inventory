package org.daming.inventory.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

/**
 * 描述： 响应式Dao处理
 *
 * @author daming
 * @date 2018-07-14 09:56
 */
public abstract class ReactorDao {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    protected  <T>  Mono<T> get(String sql, Object[] params, ResultSetExtractor<T> rst) {
        Instant in = Instant.now();
        try {
            return Mono.justOrEmpty(getJdbcTemplate().query(sql, params, rst));
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

    protected <T> Flux<T> list(String sql, Object[] params, RowMapper<T> mapper) {
        Instant in = Instant.now();
        try {
            return Flux.fromIterable(getJdbcTemplate().query(sql, params, mapper));
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

    protected <T> Flux<T> list(String sql, RowMapper<T> mapper) {
        Instant in = Instant.now();
        try {
            return Flux.fromIterable(getJdbcTemplate().query(sql, mapper));
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

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
