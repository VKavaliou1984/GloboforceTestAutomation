package com.epam.tat.webdriver.scenarios.webservices;

import org.apache.log4j.Logger;

public class WebServicesBaseTest {

    protected static final String URL = "http://services.groupkt.com/state/get/%s/%s";
    protected static final String COUNTRY = "USA";
    protected Logger logger = Logger.getLogger(getClass());
}
