package it.objectmethod.worldmapboot.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.objectmethod.worldmapboot.domain.Nation;

public class NationMapper implements RowMapper<Nation> {

	@Override
	public Nation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Nation nation = new Nation();
		nation.setCountrycode(rs.getString("Code"));
		nation.setName(rs.getString("Name"));
		return nation;
	}

}
