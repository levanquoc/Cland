package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constants.GlobalConstant;
import edu.vinaenter.constants.URLConstant;
import edu.vinaenter.model.Category;
import edu.vinaenter.service.CatService;
import edu.vinaenter.util.PageUitl;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_CAT)
public class AdminCategoryController {
	@Autowired
	private CatService catService;

	@Autowired
	MessageSource messageSource;

	@GetMapping({URLConstant.INDEX,URLConstant.INDEX_PAGE})

	public String index(ModelMap model, @PathVariable(required = false) Integer page,@RequestParam(required = false) String searchname) {
		int offset=PageUitl.getOffset(page);
		int totalRow=catService.getTotalRow();
		int numberOfPage=PageUitl.getTotalPage(totalRow);
		model.addAttribute("currentPage", page);
		model.addAttribute("numberOfPage",numberOfPage);
		if(searchname==null) {
			List<Category> catList = catService.getAll(offset,GlobalConstant.TOTAL_ROW);
			model.addAttribute("catList", catList);

			return "admin.cat.index";
		}
		List<Category> catList = catService.getAll(offset,GlobalConstant.TOTAL_ROW,searchname);
		model.addAttribute("catList", catList);

		return "admin.cat.index";
	}

	@GetMapping(URLConstant.ADD)
	public String add() {
		return "admin.cat.add";
	}

	@PostMapping(URLConstant.ADD)
	public String add(@Valid @ModelAttribute Category cat,BindingResult rs, RedirectAttributes rd) {
		if(rs.hasErrors()) {
			return "admin.cat.add";
		}
		if (catService.save(cat) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}
		return "admin.cat.add";
	}

	@GetMapping(URLConstant.DELETE)
	public String del(@PathVariable int id) {
		if (catService.del(id) > 0) { 
			return "redirect:/admin/cat/index";
		}
		return "redirect:/admin/cat/index";
	}
	
	@GetMapping(URLConstant.EDIT)
	public String edit(@PathVariable int id, Category cat, ModelMap model) {
		if (catService.findById(id) != null) {
			cat = catService.findById(id);
			model.addAttribute("cat", cat);
			return "admin.cat.edit";
		}
		return "redirect:/admin/cat/index";
	}

	@PostMapping(URLConstant.EDIT)
	public String edit( @ModelAttribute Category cat, RedirectAttributes rd) {

		if (catService.update(cat) > 0) {

			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}

		 
		return "redirect:/admin/cat/index";
	}
	
}
