package com.varxyz.cafe.menu.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.cafe.menu.domain.MenuCategory;
import com.varxyz.cafe.menu.domain.MenuItem;
import com.varxyz.cafe.menu.repository.CategoryDao;
import com.varxyz.cafe.menu.repository.MenuItemDao;
import com.varxyz.cafe.menu.web.MenuItemCommand;

@Service
public class MenuItemServiceImpl implements MenuItemService {
	@Autowired
	private CategoryDao cateDao;
	
	@Autowired
	private MenuItemDao menuDao;
	
	@Autowired
	private CategoryServiceImpl cateService;
	
	@Autowired
	private ServletContext servletContext;
	
    
	@Override
	public void addMenuItem(MenuItemCommand command) throws IllegalStateException, IOException {
		String cateType = command.getCategory().getCateType();
		String cateName = command.getCategory().getCateName();
		String direct = servletContext.getRealPath("/resources/images");
		MenuCategory cate = cateDao.findCategoryByTypeAndName(cateType, cateName);
		
		MenuItem menu = new MenuItem();
		menu.setMenuCategory(cate);
		menu.setName(command.getName());
		menu.setPrice(command.getPrice());
		menu.setImageUrl(command.getImageFile().getOriginalFilename());
		
		// 이미지 저장 및 경로 확인
		File saveDir = new File(direct);
//		MultipartFile imageFile = command.getImageFile();
		
		if(!saveDir.exists()) {
			saveDir.mkdir();
		}
		File destination = new File(saveDir.getPath() + File.separator + command.getImageFile().getOriginalFilename());

		command.getImageFile().transferTo(destination);
		
		// DB에 저장
		menuDao.addMenuItem(menu);
	}
	
	@Override
	public List<MenuItem> getAllMenuItems() {
		List<MenuItem> list = menuDao.findAllMenuItems();
		for(MenuItem m : list) {
			MenuCategory cate = cateService.getCategoryByCid(m.getMenuCategory().getCid());
			m.setMenuCategory(cate);
		}
		return list;
	}
	
	@Override
	public List<MenuItem> getMenuItemsByCid(long cid) {
		return menuDao.findMenuItemsByCid(cid);
	}
	
	@Override
	public MenuItem getMenuItemByMid(long mid) {
		return menuDao.findMenuItemByMid(mid);
	}

	@Override
	public void deleteMenuItemByCid(long cid) {
		menuDao.deleteMenuItemByCid(cid);
	}

	@Override
	public void deleteMenuItemByMid(long mid) {
		menuDao.deleteMenuItemByMid(mid);
	}

	@Override
	public void modifyMenuItem(MenuItemCommand command, Long mid) throws IllegalStateException, IOException {
		String cateType = command.getCategory().getCateType();
		String cateName = command.getCategory().getCateName();
		String direct = servletContext.getRealPath("/resources/images");
		MenuCategory cate = cateDao.findCategoryByTypeAndName(cateType, cateName);
		
		MenuItem menu = new MenuItem();
		menu.setMenuCategory(cate);
		menu.setName(command.getName());
		menu.setPrice(command.getPrice());
		menu.setMid(mid);

		if(command.getImageFile().getSize() == 0) {
			menu.setImageUrl("");
		} else {
			menu.setImageUrl(command.getImageFile().getOriginalFilename());
			
			// 이미지 저장 및 경로 확인
			File saveDir = new File(direct);
//			MultipartFile imageFile = command.getImageFile();
			
			if(!saveDir.exists()) {
				saveDir.mkdir();
			}
			File destination = new File(saveDir.getPath() + File.separator + command.getImageFile().getOriginalFilename());

			command.getImageFile().transferTo(destination);
		}
		
		// DB에 저장
		menuDao.modifyMenuItem(menu);
	}
}
