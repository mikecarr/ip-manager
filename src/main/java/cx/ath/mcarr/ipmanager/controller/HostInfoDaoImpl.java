package cx.ath.mcarr.ipmanager.controller;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cx.ath.mcarr.ipmanager.domain.HostInfo;

/**
 * 
 * @author mcarr
 *
 */
@Service
public class HostInfoDaoImpl implements HostInfoDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String insertSql =
	         "INSERT INTO hostinfo (ipaddress)" +
	         "VALUES (?)";

	public int addIp(String ip) {
		
		// define query arguments
    	Object[] params = new Object[] { ip };

    	// define SQL types of the arguments
    	int[] types = new int[] { Types.VARCHAR};

    	// execute insert query to insert the data
    	// return number of row / rows processed by the executed query
    	int row = jdbcTemplate.update(insertSql, params, types);
    	System.out.println(row + " row inserted.");

    	return row;
		
	}

	
	public List<HostInfo> getIpHistory() {
		String sql = "select * from hostinfo order by date_rec desc";
	    List<HostInfo> ipList  = jdbcTemplate.query(sql, new BeanPropertyRowMapper(HostInfo.class));
	    return ipList;
	}


	
}
