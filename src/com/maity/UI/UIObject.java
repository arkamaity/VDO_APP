package com.maity.UI;

import com.maity.datamodel.PageSession;

public interface UIObject {

	public void updateLanguage(PageSession pageSession);
	public void updateLanguage(String language);
	public void generateUI();
}
