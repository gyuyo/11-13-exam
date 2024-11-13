package com.example.demo.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookRepository {

	@Delete("""
				TRUNCATE TABLE book
			""")
	void truncateTable();
	
	@Insert("""
				INSERT INTO book
					SET title = #{title}
						, author = #{author}
						, storeId = #{storeId}
			""")
	void insertBook(String title, String author, int storeId);
	
	@Delete("""
				DELETE FROM book
					WHERE author = #{author}
			""")
	void deleteBook(String author);
}
