package cn.edu.webexperience4springboot.mapper;

import cn.edu.webexperience4springboot.pojo.SortData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DatabaseMapper {
    @Select("SELECT * FROM sortArray")
    public List<SortData> getAll();
    @Insert("INSERT INTO sortArray(ori_array,sorted_array,date,method,algorithm) values(#{ori_array},#{sorted_array},#{date},#{method},#{algorithm})")
    public void insert(SortData sortData);
}
