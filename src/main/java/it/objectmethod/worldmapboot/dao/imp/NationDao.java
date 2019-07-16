package it.objectmethod.worldmapboot.dao.imp;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.objectmethod.worldmapboot.dao.INationDao;
import it.objectmethod.worldmapboot.domain.Nation;
import it.objectmethod.worldmapboot.domain.mapper.NationMapper;

@Service
public class NationDao extends NamedParameterJdbcDaoSupport implements INationDao {
	
	@Autowired
	public NationDao(DataSource dataSource)
	{
		super();
		setDataSource(dataSource);
	}


	@Override
	public List<Nation> getAllNation(String continent) {

		List<Nation> getallnation = null;
		String sql = "SELECT * FROM country WHERE Continent = ?";
		getallnation = getJdbcTemplate().query(sql, new Object[] { continent }, new NationMapper());

		return getallnation;
	}

	@Override
	public List<Nation> getAllNations() {

		List<Nation> getallnations = null;
		String sql = "SELECT DISTINCT Name,Code FROM country";
		getallnations = getJdbcTemplate().query(sql, new NationMapper());

		return getallnations;
	}

	@Override
	public List<String> getAllContinent() {

		List<String> continents = null;
		String sql = "SELECT DISTINCT Continent FROM country";
		continents = getJdbcTemplate().queryForList(sql, String.class);

		return continents;

	}

}
