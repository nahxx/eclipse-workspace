package com.varxyz.cafe.menu.web;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoveMenuCommand {
	private List<Long> deleteList;
}
