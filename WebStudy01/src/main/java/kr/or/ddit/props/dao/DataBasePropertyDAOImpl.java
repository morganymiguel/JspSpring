package kr.or.ddit.props.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.props.vo.PropertyVO;

public class DataBasePropertyDAOImpl implements PropertyDAO {

	@Override
	public PropertyVO selectProperty(String propertyName) {
		
		
		//쿼리문이 아니고 단순한 text면 공격을 막을 수 있다.
		String sql = "SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION FROM DATABASE_PROPERTIES";
				sql += " WHERE PROPERTY_NAME = ? ";
		PropertyVO propertyVO = null;
		
		String[] headers = null;
		
		try(
			Connection oracleConn = ConnectionFactory.getConnection();
			PreparedStatement oracleStmt = oracleConn.prepareStatement(sql);
			//prepared는 동적으로 바꿀수없다. ?는 쿼리 파라미터.
		) {
			oracleStmt.setString(1, propertyName);
			ResultSet rs = oracleStmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			headers = new String[count];
			for(int i = 1; i <= count; i++){
				headers[i-1] = rsmd.getColumnName(i);
			}
			if(rs.next()){
				propertyVO = new PropertyVO();
				propertyVO.setPropertyName(rs.getString("PROPERTY_NAME"));
				propertyVO.setPropertyValue(rs.getString("property_value"));
				propertyVO.setDescription(rs.getString("DESCRIPTION"));
			}
			return propertyVO;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<PropertyVO> selectProperties() {
		
		String sql = "SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION FROM DATABASE_PROPERTIES";
		
		List<PropertyVO> dataList = new ArrayList<>();
		String[] headers = null;
		
		
		try(
			Connection oracleConn = ConnectionFactory.getConnection();
			Statement oracleStmt = oracleConn.createStatement();
		) {
			ResultSet rs = oracleStmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			headers = new String[count];
			for(int i = 1; i <= count; i++){
				headers[i-1] = rsmd.getColumnName(i);
			}
			while(rs.next()){
				PropertyVO vo = new PropertyVO();
				dataList.add(vo);
				vo.setPropertyName(rs.getString("PROPERTY_NAME"));
				vo.setPropertyValue(rs.getString("property_value"));
				vo.setDescription(rs.getString("DESCRIPTION"));
			}
			return dataList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertProperty(PropertyVO propertyVO) {
		if(1==1)
			throw new RuntimeException("해당 뷰는 insert대상이 아님.");
	}

}
