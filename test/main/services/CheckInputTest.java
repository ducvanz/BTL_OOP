/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main.services;

import BTL_OOP.main.services.CheckInput;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ngothuyet
 */
public class CheckInputTest {
    
   CheckInput check ;
    public CheckInputTest() {
        check = new CheckInput();
    }

    @Test
    public void testCheckINT() {
        assertEquals(true,check.checkINT("2"));
        assertEquals(true,check.checkINT("3"));
        assertEquals(false,check.checkINT("ewgvs"));
    }

    @Test
    public void testCheckNumberPhone() {
        assertEquals(true,check.checkNumberPhone("0325349605"));
        assertEquals(true,check.checkNumberPhone("0325349605"));
        assertEquals(false,check.checkNumberPhone("032534605"));
    }

    @Test
    public void testCheckBirthday1() {
        assertEquals(true,check.checkBirthday("30/04/2005"));
    }
    
    @Test
    public void testCheckBirthday2() {
        assertEquals(true,check.checkBirthday("2005-09-07"));
    }

    @Test
    public void testIsValidDate1() {
        assertEquals(true,check.isValidDate(30,04,2005));
        assertEquals(false,check.isValidDate(30,02,2005));
    }
    
    @Test
    public void testIsValidDate2() {
        assertEquals(false,check.isValidDate(35,02,2005));
    }

    @Test
    public void testCheckAccount1() {
        assertEquals(false,check.checkAccount("NgoThuyet"));
    }
    
    @Test
    public void testCheckAccount2() {
        assertEquals(true, check.checkAccount("vanne"));
    }
    
    @Test
    public void testCheckAccount3() {
        assertEquals(true, check.checkAccount("vanne231"));
    }

    @Test
    public void testCheckEmail1() {
        assertEquals(false, check.checkEmail("ducvan2745"));
    }
    
    @Test
    public void testCheckEmail12() {
        assertEquals(true, check.checkEmail("anc@vnu.edu.vn"));
    }

    @Test
    public void testCheckEmail13() {
        assertEquals(true, check.checkEmail("ducvan2745@gmail.com"));
    }

    @Test
    public void testCheckUserName1() {
        assertEquals(true, check.checkUserName("vanne123"));
    }

    @Test
    public void testCheckFullName1() {
        assertEquals(true, check.checkFullName("Nguyễn Minh Phúc"));
    }
    
    @Test
    public void testCheckFullName2() {
        assertEquals(false, check.checkFullName("abhbd"));
    }
    
    @Test
    public void testCheckFullName3() {
        assertEquals(false, check.checkFullName("nguyen minh anh 9"));
    }
    
    @Test
    public void testCheckFullName4() {
        assertEquals(true, check.checkFullName("Nguyễn Lê Anh Tài"));
    }
    
    @Test
    public void testCheckFullName5() {
        assertFalse(check.checkFullName("nguyễn văn a"));
    }
    
    @Test
    public void testCheckFullName6() {
        assertFalse(check.checkFullName("Nguyễn VĂn MiNh"));
    }
    
}
