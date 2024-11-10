package com.techelevator.dao;

import com.techelevator.model.Species;
import java.util.List;

public interface SpeciesDao {
        List<Species> getAllSpecies();

        public Species getSpeciesById(int speciesId);
}
