package it.objectmethod.worldmapboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.worldmapboot.dao.INationDao;
import it.objectmethod.worldmapboot.domain.Nation;

@Controller
public class NationsController {

	@Autowired
	INationDao nationDao;

	@RequestMapping("/")
	public String getIndex(ModelMap model) {

		List<String> continenti = new ArrayList<String>();

		try {
			continenti = nationDao.getAllContinent();
		} catch (Exception e) {

			e.printStackTrace();
		}

		model.addAttribute("result", continenti);

		return "Continenti";
	}

	@RequestMapping("/nation")
	public String getIndex(ModelMap model, @RequestParam(value = "continent", required = false) String continent,
			HttpSession session) {
		List<Nation> nazioni = null;

		if (continent == null) {
			continent = (String) session.getAttribute("continent");
		} else {
			session.setAttribute("continent", continent);
		}

		try {
			nazioni = nationDao.getAllNation(continent);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("result", nazioni);

		return "Nazioni";
	}

}
