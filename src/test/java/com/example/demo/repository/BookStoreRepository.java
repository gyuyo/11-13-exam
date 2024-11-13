package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.VO.BookStoreVO;
import com.example.demo.VO.BookVO;

@Mapper
public interface BookStoreRepository {
	
	@Delete("""
				TRUNCATE TABLE bookStore
			""")
	void truncateTable();
	
	@Insert("""
				INSERT INTO bookStore
					SET `name` = #{name}
			""")
	void insertStore(String name);
	
	@Select("""
				SELECT `name`
					FROM bookStore
			""")
	List<BookStoreVO> selectStore();
	
	@Update("""
				UPDATE bookStore
					SET `name` = #{name}
					WHERE id = #{id}
			""")
	void modifyStore(int id, String name);
	
	@Select("""
				SELECT title
					FROM book
			""")
	List<BookVO> selectBook();
	
	@Select("""
				SELECT b.title
					FROM book AS b
					INNER JOIN bookStore AS bs
					ON b.storeId = bs.id
					WHERE `name` = #{name}
			""")
	List<BookVO> selectKoreaBook(String name);

}
