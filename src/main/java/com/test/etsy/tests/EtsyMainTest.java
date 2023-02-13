package com.test.etsy.tests;

import com.test.etsy.pages.EtsyMainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyMainTest extends EtsyTestBase {
    @Parameters({"itemName","13","iphone","iphoneCase"})

    @Test
    public void caseTextValidation(String itemName,String thirteen,String iphone,String iphoneCase){
        EtsyMainPage case13Page=new EtsyMainPage(driver);
        case13Page.searchCase(itemName,thirteen,iphone,iphoneCase);
    }

}
