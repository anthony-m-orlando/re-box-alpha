package com.techelevator.dao;

import com.techelevator.model.Profession;
import java.util.List;

public interface ProfessionDao {
    List<Profession> getAllProfessions();
    Profession getProfessionById(int id);
}
