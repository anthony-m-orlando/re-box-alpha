package com.techelevator.dao;

import com.techelevator.model.Image;

import java.util.List;

public interface ImageDao {
    Image getById(int id);
    Image save(Image image, int userId);
    boolean exists(int id);
    List<Integer> getImagesForUser(int userId);
}
