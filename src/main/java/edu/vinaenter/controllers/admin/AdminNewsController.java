package edu.vinaenter.controllers.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.vinaenter.constants.GlobalConstant;
import edu.vinaenter.constants.URLConstant;
import edu.vinaenter.model.Category;
import edu.vinaenter.model.News;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.NewsService;
import edu.vinaenter.util.FileUtil;
import edu.vinaenter.util.PageUitl;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_NEWS)
public class AdminNewsController {
	@Autowired
	private NewsService newsService;
	@Autowired
	private CatService catService;

	@GetMapping({URLConstant.INDEX,URLConstant.INDEX_PAGE})
	public String index(ModelMap model,@PathVariable(required =false) Integer page,@RequestParam(required = false) String searchname) {		
		int offset=PageUitl.getOffset(page);
		int totalRow=newsService.getTotalRow();
		int numberOfPage=PageUitl.getTotalPage(totalRow);
		model.addAttribute("numberOfPage",numberOfPage);
		model.addAttribute("currentPage", page);
		if(searchname==null) {
			List<News> newsList = newsService.getAll(offset,GlobalConstant.TOTAL_ROW);		
			model.addAttribute("newsList", newsList);
			return "admin.news.index";
		}
		List<News> newsList = newsService.getByName(offset,GlobalConstant.TOTAL_ROW,searchname);		
		model.addAttribute("newsList", newsList);
		return "admin.news.index";
	}
	

	@GetMapping(URLConstant.ADD)
	public String add(ModelMap model) {
		List<Category> listCat = catService.getAll();
		model.addAttribute("listCat", listCat);
		return "admin.news.add";
	}

	@PostMapping(URLConstant.ADD)

	public String add(@Valid @ModelAttribute News news,BindingResult rs, @RequestParam("file") MultipartFile file, ModelMap model,
			HttpServletRequest request) {
		if(rs.hasErrors()) {
			List<Category> listCat = catService.getAll();
			model.addAttribute("listCat", listCat);
			return "admin.news.add";
		}
		String fileName=FileUtil.upload(file,request);
		news.setPicture(fileName);
		
	
	
		if(newsService.save(news)>0) {
			return "redirect:/admin/news/index";
		}
		
		return "redirect:/admin/news/index";
	}
	@GetMapping(URLConstant.DELETE)
	public String del(@PathVariable int id) {
		if(newsService.del(id)>0){
			return "redirect:/admin/news/index";
		}
		return "redirect:/admin/news/index";
	}
	@GetMapping(URLConstant.EDIT)
	public String edit(@PathVariable int id,ModelMap model) {
		News news=newsService.findById(id);
		List<Category> listCat=catService.getAll();
		model.addAttribute("news", news);
		model.addAttribute("listCat", listCat);
		return "admin.news.edit";
	}
	@PostMapping(URLConstant.EDIT)
	public String edit(@ModelAttribute("news") News news,@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		String fileName=FileUtil.upload(file, request);
		News oldNews=newsService.findById(news.getLid());
		if(fileName.isEmpty()) {
			fileName=oldNews.getPicture();
		}
		news.setPicture(fileName);
		if(newsService.update(news)>0) {
			return "redirect:/admin/news/index";
		}
		return "redirect:/admin/news/index";
	}
}
