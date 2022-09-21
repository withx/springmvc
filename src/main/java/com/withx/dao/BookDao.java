package com.withx.dao;

import com.withx.domain.BookVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {

    @Insert("insert into tb_book(name,price)values(#{name},#{price})")
    void save(BookVO book);
    @Delete("delete from tb_book where id = #{id} ")
    void delete(Integer id);
    @Update("update tb_book set name = #{name} , price = #{price} where id = #{id} ")
    void update(BookVO book);
    @Select("select * from tb_book")
    List<BookVO> findAll();
    @Select("select * from tb_book where id = #{id} ")
    BookVO findById(Integer id);
}
