package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private ScenarioContext scenarioContext;

	public TestContext() {
		scenarioContext = new ScenarioContext();
		webDriverManager = new WebDriverManager();
	}

	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}
