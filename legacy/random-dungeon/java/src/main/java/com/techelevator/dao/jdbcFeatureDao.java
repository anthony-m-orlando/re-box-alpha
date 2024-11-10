package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Feature;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class jdbcFeatureDao implements FeatureDao {

        private JdbcTemplate jdbcTemplate;

        public jdbcFeatureDao(DataSource dataSource) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }

        @Override
        public Feature getFeatureById(int featureId) {
            Feature feature = new Feature();
            String sql = "SELECT feature_id, feature_name, feature_image_path, feature_description FROM feature WHERE feature_id = ?";
            try {
                SqlRowSet results = jdbcTemplate.queryForRowSet(sql, featureId);
                if (results.next()) {
                    feature = mapRowToFeature(results);
                }
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            }

            return feature;
        }

        @Override
        public Feature getRandomFeature() {
            Feature feature = new Feature();
            String sql = "SELECT feature_id, feature_name, feature_image_path, feature_description FROM feature ORDER BY RANDOM() LIMIT 1";
            try {
                SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
                if (results.next()) {
                    feature = mapRowToFeature(results);
                }
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            }

            return feature;
        }

        @Override
        public List<Feature> getAllFeatures() {
            List<Feature> features = new java.util.ArrayList<>();
            String sql = "SELECT feature_id, feature_name, feature_image_path, feature_description FROM feature";
            try {
                SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
                while (results.next()) {
                    features.add(mapRowToFeature(results));
                }
            } catch (CannotGetJdbcConnectionException e) {
                throw new DaoException("Unable to connect to server or database", e);
            }

            return features;
        }
        private Feature mapRowToFeature(SqlRowSet results) {
            Feature feature = new Feature();
            feature.setFeatureId(results.getInt("feature_id"));
            feature.setFeatureName(results.getString("feature_name"));
            feature.setFeatureDescription(results.getString("feature_description"));
            feature.setImageName(results.getString("feature_image_path"));
            return feature;
        }
}
