package edu.vinaenter.controllers.cland;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.vinaenter.constants.GlobalConstant;
import edu.vinaenter.constants.URLConstant;
import edu.vinaenter.model.Category;
import edu.vinaenter.model.Contact;
import edu.vinaenter.model.News;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.ContactService;
import edu.vinaenter.service.NewsService;
import edu.vinaenter.util.PageUitl;

@Controller
public class ClandController {
	@Autowired
	private CatService catService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private ContactService contactService;

	@GetMapping({ URLConstant.HOME, URLConstant.HOME_PAGE })
	public String index(@PathVariable(required = false) Integer page, @RequestParam(required = false) String namesearch,
			ModelMap model) {
		int offset = PageUitl.getOffset(page);
		int totalRow = newsService.totalRow();

		int numberOfpage = PageUitl.getTotalPage(totalRow);

		model.addAttribute("numberOfpage", numberOfpage);
		List<Category> listCat = catService.getAll();
		model.addAttribute("listCat", listCat);

		if (namesearch == null) {
			List<News> newsList = newsService.getAll(offset, GlobalConstant.TOTAL_ROW);
			model.addAttribute("newsList", newsList);
			return "cland.index";
		}
		List<News> newsList = newsService.getByName(offset, GlobalConstant.TOTAL_ROW, namesearch);
		model.addAttribute("newsList", newsList);
		return "cland.index";
	}

	@GetMapping({URLConstant.CATEGORY,URLConstant.CATEGORY_PAGE})
	public String cat(@PathVariable("cid") int cid, ModelMap model,@RequestParam(required = false) String namesearch,@PathVariable(required = false) Integer page) {
		List<Category> listCat = catService.getAll();
		model.addAttribute("listCat", listCat);
		int offset=PageUitl.getOffsetCategory(page);
		if(namesearch==null) {
			List<News> newsList=newsService.getByCategory(offset,GlobalConstant.TOTAL_ROW_CATEGORY,cid);
			model.addAttribute("newsList", newsList);
			return "cland.cat";
		}
		
		List<News> newsList=newsService.getByCategoryByName(offset,GlobalConstant.TOTAL_ROW_CATEGORY,cid,namesearch);
		model.addAttribute("newsList", newsList);
		
		return "cland.cat";
	}

	@GetMapping("contact")
	public String contact(ModelMap model) {
		List<Category> listCat = catService.getAll();
		model.addAttribute("listCat", listCat);
		return "cland.contact";
	}

	@PostMapping("contact")
	public String contact(@ModelAttribute("contact") Contact contact, ModelMap model) {
		List<Category> listCat = catService.getAll();
		model.addAttribute("listCat", listCat);
		
		if (contactService.save(contact) > 0) {
			return "cland.contact";
		}
		return "cland.contact";
	}

	@GetMapping(URLConstant.DETAIL)
	public String detail(@PathVariable(required = true) int lid,ModelMap model) {
		List<Category> listCat = catService.getAll();
		News news=newsService.findById(lid);
		model.addAttribute("listCat", listCat);
		model.addAttribute("news", news);
		return "cland.detail";
	}

}
