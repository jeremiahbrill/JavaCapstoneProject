package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcCategoryDao implements CategoryDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcCategoryDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> allCategories = new ArrayList<>();
		String sqlSelectAllCategories = "Select * from Category";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllCategories	);
		while(results.next()) {
			allCategories.add(mapRowToCategory(results));
		}
		return allCategories;
	}
	
	private Category mapRowToCategory(SqlRowSet row) {
		Category category = new Category();
		category.setId(row.getInt("category_id"));
		category.setName(row.getString("name"));
		category.setPresentationText(row.getString("presentation_text"));
		return category;
		
	}
 
}
