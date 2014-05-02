package trusty.issue.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import trusty.issue.service.api.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public String getUserNameBySteamId(String id) {
		String[] tmpid = id.substring(6).split(":");
		long temp = Long.valueOf(tmpid[1]) + Long.valueOf(tmpid[2]) * 2 + 76561197960265728L;
		RestTemplate rest = new RestTemplate();
		String response = rest.getForObject("http://steamcommunity.com/profiles/"+temp, String.class);
		Matcher m = Pattern.compile("<title>Steam Community :: .+</title>").matcher(response);
		if(m.find()) {
			response = m.group();
			response = response.replace("<title>Steam Community :: ", "");
			response = response.replace("</title>", "");
			return response;
		}
		return null;
	}
}
