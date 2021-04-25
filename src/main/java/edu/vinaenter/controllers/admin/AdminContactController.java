package edu.vinaenter.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.vinaenter.constants.GlobalConstant;
import edu.vinaenter.constants.URLConstant;
import edu.vinaenter.model.Contact;
import edu.vinaenter.service.ContactService;
import edu.vinaenter.util.PageUitl;

@Controller
@RequestMapping(value = URLConstant.URL_ADMIN_CONTACT)
public class AdminContactController {
	@Autowired
	private ContactService contactService;

	@Autowired
	MessageSource messageSource;

	@GetMapping({URLConstant.INDEX,URLConstant.INDEX_PAGE})

	public String index(ModelMap model,@PathVariable(required = false) Integer page,@RequestParam(required = false) String searchname) {
		int offset=PageUitl.getOffset(page);
		int totalRow=contactService.getTotalRow();
		int numberOfPage=PageUitl.getTotalPage(totalRow);
		model.addAttribute("numberOfPage", numberOfPage);
		model.addAttribute("currentPage", page);
		if(searchname==null) {
			List<Contact> contactList = contactService.getAll(offset,GlobalConstant.TOTAL_ROW);
			model.addAttribute("contactList", contactList);
			return "admin.contact.index";
		}
		List<Contact> contactList = contactService.getByName(offset,GlobalConstant.TOTAL_ROW,searchname);
		model.addAttribute("contactList", contactList);
		return "admin.contact.index";
	}

	@GetMapping(URLConstant.DELETE )
	public String del(@PathVariable int id) {
		
		if (contactService.del(id) > 0) {
			return "redirect:/admin/contact/index";
		}
		return "redirect:/admin/contact/index";
	}
	
	
	@GetMapping("/search")
	public String search() {
		System.out.println("Ở đây rồi nè");
		return "redirect:/admin/cat/index" ;
	}
}
