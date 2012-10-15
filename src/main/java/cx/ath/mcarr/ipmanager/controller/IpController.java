package cx.ath.mcarr.ipmanager.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cx.ath.mcarr.ipmanager.domain.HostInfo;

/**
 * 
 * @author mcarr
 *
 */
@Controller
@RequestMapping("/ip")
public class IpController {

	@Autowired
	HostInfoDao hostInfoDao;
	
	@RequestMapping(value="/{currentIp}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String currentIp, ModelMap model) {
 
		System.out.println("current IP: " + currentIp);
		
		int rows = -1;
		try {
			rows = hostInfoDao.addIp(currentIp);
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			e.printStackTrace();
		}
		System.out.println(rows + " inserted.");
		
		model.addAttribute("ipaddress", currentIp);
		return "ip";
 
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getAll(ModelMap model) {
		
		List<HostInfo> ipList = null;
		try {
			ipList = hostInfoDao.getIpHistory();
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			e.printStackTrace();
		}
		model.addAttribute("ipList", ipList);
		
		return "list";
 
	}
}
