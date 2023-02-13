package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
//    @DataProvider(name ="loginFunctionality")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"Ahmet","Mehmet"},
//                {"Mahmut","Ayse"},
//                {"Zeynep","Ayse"},
//                {"Osman","Fatma"},
//                {"Abdu","Baran"}
//        };
//    }
//    @Test(dataProvider = "loginFunctionality")
//    public void positiveLogin1(String username,String password){
//
//        System.out.println("login1 "+ username+" "+password);
//    }
    @Test(dataProvider = "loginFunctionality",dataProviderClass = DataProviderAllData.class)
    public void positiveLogin(String username,String password){

        System.out.println("login "+username+password);
    }
//
//    @Test
//    public void positiveLogin2(){
//        String username="Mahmut";
//        String password="Nurdin";
//        System.out.println("login2"+ username+password);
//    }
//    @Test
//    public void positiveLogin3(){
//        String username="Zeynep";
//        String password="Ayse";
//        System.out.println("login3"+ username+password);
//    }
//    @Test
//    public void positiveLogin4(){
//        String username="Osman";
//        String password="Fatma";
//        System.out.println("login4"+ username+password);
//    }
//    @Test
//    public void positiveLogin5(){
//        String username="Abdu";
//        String password="Baran";
//        System.out.println("login5"+ username+password);
//    }
}
