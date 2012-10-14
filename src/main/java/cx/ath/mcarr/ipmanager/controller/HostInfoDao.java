package cx.ath.mcarr.ipmanager.controller;

import java.util.List;

import cx.ath.mcarr.ipmanager.domain.HostInfo;

/**
 * 
 * @author mcarr
 *
 */
public interface HostInfoDao {

	public int addIp(String ip);
	
	public List<HostInfo> getIpHistory();
}
