package org.lzjay.weixin.menu.service;

import org.lzjay.weixin.menu.domain.SelfMenu;

public interface SelfMenuService {

	SelfMenu getMenu();

	void save(SelfMenu selfMenu);

}

