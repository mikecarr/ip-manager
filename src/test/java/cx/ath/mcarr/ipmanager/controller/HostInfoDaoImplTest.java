package cx.ath.mcarr.ipmanager.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ReflectionUtils;

import cx.ath.mcarr.ipmanager.domain.HostInfo;

@RunWith(MockitoJUnitRunner.class)
public class HostInfoDaoImplTest {

	private static final String IP_ADDRESS = "192.168.1.500";
	HostInfoDaoImpl hostInfoDao = null;
	JdbcTemplate jdbcTemplate = null;
	
	@Before
	public void setUp() throws Exception {
		hostInfoDao = new HostInfoDaoImpl();
		jdbcTemplate = Mockito.mock(JdbcTemplate.class);
		ReflectionTestUtils.setField(hostInfoDao,"jdbcTemplate", jdbcTemplate);
	}

	@Test
	public void testAddIp() {
		final Object[] ipArr = new Object[]{IP_ADDRESS};
		final int[] intArr = new int[] {12};
		
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.eq(ipArr),Mockito.eq(intArr))).thenReturn(5);
		
		int rows = hostInfoDao.addIp(IP_ADDRESS);
		assertEquals(5, rows);
		
	}
	
	@Test
	public void testGetAll() {
		
		List<HostInfo> expectedIpList = createIpList();
		
		Mockito.when(jdbcTemplate.query(Mockito.anyString(),Mockito.any(BeanPropertyRowMapper.class))).thenReturn(expectedIpList);
		List<HostInfo> ipList = hostInfoDao.getIpHistory();
		
		//assertEquals(5, ipList.size());
		
	}

	private List<HostInfo> createIpList() {
		List<HostInfo> hostInfoList = new ArrayList<HostInfo>();
		
		int a=0;
		while( a < 5){
			HostInfo hostInfo = new HostInfo();
			hostInfo.setId(a);
			hostInfo.setDate_rec(new Date());
			hostInfo.setIpaddress(IP_ADDRESS);
			a++;
		}
		
		return hostInfoList;
	}

}
