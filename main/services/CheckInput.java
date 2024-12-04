/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP.main.services;


/**
 *
 * @author Admin
 */
// class này chỉ check biểu thức và kiểu dữ liệu không liên quan đến db
public class CheckInput {
    
    public static boolean checkINT(String id) {
        char[] arr = id.toCharArray();
        for (char x : arr) {
            if (x < '0' || x >'9') {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkNumberPhone(String phone) {
        char[] arr = phone.toCharArray();
        if (arr.length != 10 || arr[0] != '0') {
            return false;
        }
        
        int count = 0;
        for (char c : arr) {
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
            
            if (c == '0') {
                count ++;
            }
        }
        
        if (count >= 5) {
            return false;
        }
        
        return true;
    }
    
    public static boolean checkBirthday(String birthday) {
            String[] arr = birthday.split("/");
            if (arr.length != 3) {
                return false;
            }

            int day, month, year;

            try {
                day = Integer.parseInt(arr[0]);
                month = Integer.parseInt(arr[1]);
                year = Integer.parseInt(arr[2]);
            } catch(Exception e) {
                return false;
            }
        return isValidDate(day, month, year);

    }


    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysInMonth[1] = 29; 
        }

        return day >= 1 && day <= daysInMonth[month - 1];
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    public static boolean checkAccount(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }

        return name.matches("[a-z0-9]+");
    }
    
    public static boolean checkEmail(String email) {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    
            if (email == null) {
                return false;
            }

            return email.matches(emailRegex);
    }
    
    public static boolean checkUserName(String userName) {
            String userNameRegex = "^[a-zA-Z](?:[a-zA-Z0-9_]{1,10}[a-zA-Z0-9])?$";

            if (userName == null) {
                return false;
            }

            return userName.matches(userNameRegex);
    }
    
    public static boolean checkFullName(String fullName) {
        // Regular Expression cho fullName hợp lệ
        String fullNameRegex = "^[A-Z][a-z]*(?:\\s[A-Z][a-z]*)*$";

        // Kiểm tra nếu fullName là null hoặc rỗng
        if (fullName == null || fullName.trim().isEmpty()) {
            return false;
        }

        return fullName.matches(fullNameRegex);
    }

    
    
}


