package cx.ath.mcarr.ipmanager.domain;

import java.util.Date;

public class HostInfo {

	private long id;
	
	private Date date_rec;
	
	private String ipaddress;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate_rec() {
		return date_rec;
	}

	public void setDate_rec(Date date_rec) {
		this.date_rec = date_rec;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Override
	public String toString() {
		return "HostInfo [id=" + id + ", date_rec=" + date_rec + ", ipaddress="
				+ ipaddress + "]";
	}
	
	
}
