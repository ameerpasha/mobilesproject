package com.niit.frontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.mobilebackend.dao.ICategoryDao;
import com.niit.mobilebackend.dao.IProductDao;
import com.niit.mobilebackend.dao.ISupplierDao;
import com.niit.mobilebackend.model.Category;
import com.niit.mobilebackend.model.Product;
import com.niit.mobilebackend.model.Supplier;

@Controller
public class AdminController {
	
	@Autowired
	ICategoryDao categoryDao;
	
	@Autowired
	Category category;
	
	@Autowired
	Product product;
	
	@Autowired
	IProductDao productDao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	ISupplierDao supplierDao;
	
	@ModelAttribute
	public Category returnObject1() {
		return new Category();
	}
	
	@ModelAttribute("product")
	public Product returnObject3() {
		return new Product();
	}
	
	@ModelAttribute
	public Supplier returnObject2() {
		return new Supplier();
	}
	
	//----------Category operations-------------------------------
	 @RequestMapping("/AddCategory")
	 public ModelAndView ShowAddCategory(Model model) {
		 ModelAndView mv=new ModelAndView("AddCategory");
		model.addAttribute("categoryList",categoryDao.getCategories());
		 System.out.println("added category detailsin controller");
		 return mv;
	 }
	 @RequestMapping(value="/addcat",method=RequestMethod.POST)
	 public String addCate(@ModelAttribute("category") Category cate) {
		 if(cate.getCatid()==0) {
			 categoryDao.saveCategory(cate);
			 System.out.println("adding of new category in controller");
			 
		 
		 }
		 else
		 {
			 categoryDao.saveCategory(category);
			 System.out.println("adds up update method of category in controller");
		 }
		 return "redirect:/AddCategory";
	 }
	//------------product operations-------------------...............
	 @RequestMapping("/AddProduct")
	 public ModelAndView showProduct(Model model)
	 {
		 ModelAndView m=new ModelAndView("AddProduct");
		 model.addAttribute("categoryList",categoryDao.getCategories());
		 model.addAttribute("supplierList",supplierDao.list());
		 model.addAttribute("productList",productDao.list( ));
		 return m;
	 }
	 @RequestMapping(value="/addprod",method =RequestMethod.POST)
	 public String ShowAddProduct(@Valid @ModelAttribute("product") Product prod,Model model,BindingResult result,HttpServletRequest request) throws IOException{
		 System.out.println(prod.getProdname());
		 System.out.println("image uploaded");
		 System.out.println("myproduct controller called");
		 MultipartFile image=prod.getImg();
		 Path path;
		 path=Paths.get("C:/Users/MD.AMEERPASHA/git/mobilesfront/src/main/Webapp/pics/" + prod.getProdname() + ".jpg");
		 System.out.println("Path=" + path);
		 System.out.println("file name" + prod.getImg().getOriginalFilename());
		 if(image !=null && !image.isEmpty());
		 {
			 try
			 {
				 image.transferTo(new File(path.toString()));
				 System.out.println("image saved in" + path.toString());
			 }
			 catch(Exception e) {
				 e.printStackTrace();
				 System.out.println("image not saved");
			 }
		 }
		 if(prod.getProdid() ==0)
		 {
			 productDao.saveProduct(prod);
		 }
		 else
		 {
			 productDao.saveProduct(prod);
			 return "AddProduct";
		 }
		 HttpSession session=request.getSession(false);
		 String username=(String)session.getAttribute("loggedInUser");
		 model.addAttribute("productList", productDao.list());
		 model.addAttribute("categoryList",categoryDao.getCategories());
		 model.addAttribute("supplierList", supplierDao.list());
		return "AddProduct";
		 
	 }
	 
	///-------------------supplier operations--------
	 /*@RequestMapping("/AddSupplier")
	 public String showSupplier()
	 {
		 return "AddSupplier";
	 }*/
	 @RequestMapping("/AddSupplier")
	 public ModelAndView ShowAddSupplier(Model model) {
		 ModelAndView mv=new ModelAndView("AddSupplier");
		 
		 model.addAttribute("supplierList",supplierDao.list());
		 System.out.println("added supplier details in controller");
		 return mv;
	 }

}