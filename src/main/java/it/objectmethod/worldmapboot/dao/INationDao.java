package it.objectmethod.worldmapboot.dao;


import java.util.List;

import it.objectmethod.worldmapboot.domain.Nation;

public interface INationDao {
	
	public List<String> getAllContinent();
	public List<Nation> getAllNation(String continent);
	public List<Nation> getAllNations();
}
