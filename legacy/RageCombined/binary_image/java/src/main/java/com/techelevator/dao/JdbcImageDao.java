package com.techelevator.dao;

import com.techelevator.model.Image;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcImageDao implements ImageDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcImageDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Image getById(int id){
        final String query = "SELECT image_id, data, mediatype FROM images WHERE image_id =?";
        SqlRowSet srs = this.jdbcTemplate.queryForRowSet(query, id);
        Image image = null;
        if(srs.next()){
            image = toImage(srs);
        }
        return image;
    }

    @Override
    public boolean exists(int id){
        final String query ="SELECT 1 FROM images where image_id = ?";
        SqlRowSet srs = this.jdbcTemplate.queryForRowSet(query,id);
        return srs.next();
    }

    @Override
    public Image save(Image image, int userid){
        if(image.getId() >0){
            this.update(image);
            return image;
        }else {
            return this.saveNew(image,userid);
        }
    }

    @Override
    public List<Integer> getImagesForUser (int userId) {
        List<Integer> imageIdList = new ArrayList<>();
        final String query = "SELECT image_id FROM images WHERE user_id = ?";
        SqlRowSet srs = this.jdbcTemplate.queryForRowSet(query, userId);
        while (srs.next()){
            imageIdList.add(srs.getInt("image_id"));
        }
        return imageIdList;
    }


    private Image saveNew(Image image, int userId){
        final String query = "INSERT INTO images (data, mediatype, user_id) VALUES (?,?,?) RETURNING image_id";
        Integer newId = this.jdbcTemplate.queryForObject(query,
                Integer.class,
                (Object) image.getData(),
                image.getMediatype(),
                userId);

        return getById(newId);
    }

    private void update(Image image){
        final String query = "UPDATE images SET data = ?, mediatype = ? WHERE image_id = ?";
        this.jdbcTemplate.update(query, (Object) image.getData(), image.getMediatype(), image.getId());
    }

    private Image toImage(SqlRowSet rs){
        return new Image(rs.getInt("image_id"),
                (byte[]) rs.getObject("data"),
                rs.getString("mediatype"));
    }
}
