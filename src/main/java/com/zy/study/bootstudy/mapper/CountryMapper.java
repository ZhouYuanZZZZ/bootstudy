package com.zy.study.bootstudy.mapper;

import com.zy.study.bootstudy.entity.Country;
import com.zy.study.bootstudy.entity.CountryExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CountryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbggenerated Sun Aug 27 01:16:37 CST 2017
     */
    int countByExample(CountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbggenerated Sun Aug 27 01:16:37 CST 2017
     */
    int deleteByExample(CountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbggenerated Sun Aug 27 01:16:37 CST 2017
     */
    int deleteByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbggenerated Sun Aug 27 01:16:37 CST 2017
     */
    int insert(Country record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbggenerated Sun Aug 27 01:16:37 CST 2017
     */
    int insertSelective(Country record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbggenerated Sun Aug 27 01:16:37 CST 2017
     */
    List<Country> selectByExample(CountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbggenerated Sun Aug 27 01:16:37 CST 2017
     */
    Country selectByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbggenerated Sun Aug 27 01:16:37 CST 2017
     */
    int updateByExampleSelective(@Param("record") Country record, @Param("example") CountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbggenerated Sun Aug 27 01:16:37 CST 2017
     */
    int updateByExample(@Param("record") Country record, @Param("example") CountryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbggenerated Sun Aug 27 01:16:37 CST 2017
     */
    int updateByPrimaryKeySelective(Country record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table country
     *
     * @mbggenerated Sun Aug 27 01:16:37 CST 2017
     */
    int updateByPrimaryKey(Country record);
}