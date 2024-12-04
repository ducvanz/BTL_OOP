/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BTL_OOP.test.publicc;

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
        assertEquals(false,check.checkNumberPhone("0325349605"));
        assertEquals(true,check.checkNumberPhone("032534605"));
    }

    @Test
    public void testCheckBirthday() {
        assertEquals(false,check.checkBirthday("30/04/2005"));
    }

    @Test
    public void testIsValidDate() {
        assertEquals(true,check.isValidDate(30,04,2005));
        assertEquals(false,check.isValidDate(30,02,2005));
    }

    @Test
    public void testCheckAccount() {
        assertEquals(true,check.checkAccount("NgoThuyet"));
    }
}
