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
    
    /**
     * Kiểm tra số nguyên.
     * @param id số nhận vào
     * @return kết quả
     */
    public static boolean checkINT(String id) {
        char[] arr = id.toCharArray();
        for (char x : arr) {
            if (x < '0' || x >'9') {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Kiểm tra số điện thoại.
     * số bắt đầu từ0
     * 10 số
     * không quá 5 số 0
     * @param phone sdt kiểm tra
     * @return 
     */
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
    
    /**
     * Kiểm tra from của birthday.
     * @param birthday
     * @return 
     */
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

    /**
     * Tính hợp lý của ngày.
     * @param day ngày
     * @param month tháng
     * @param year năm
     * @return 
     */
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

    /**
     * Kiểm tra năm nhuận.
     * @param year biến kiểm tra
     * @return 
     */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    /**
     * Kiểm tra tên tài khoản.
     * chữ thường và sau đó là số
     * @param name
     * @return 
     */
    public static boolean checkAccount(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }

        return name.matches("[a-z0-9]+");
    }
    
    /**
     * Kiểm tra email.
     * chữ thường, chữ hoa và số + "@" + đuối chuẩn
     * @param email
     * @return 
     */
    public static boolean checkEmail(String email) {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    
            if (email == null) {
                return false;
            }

            return email.matches(emailRegex);
    }
    
    /**
     * Check username.
     * bắt đầu bằng chữ rồi mới cho phép số
     * @param userName
     * @return 
     */
    public static boolean checkUserName(String userName) {
            String userNameRegex = "^[a-zA-Z](?:[a-zA-Z0-9_]{1,10}[a-zA-Z0-9])?$";

            if (userName == null) {
                return false;
            }

            return userName.matches(userNameRegex);
    }
    
    /**
     * Kiểm tra tên người dùng có dấu.
     * Kí tự đầu không dấu.
     * @param fullName
     * @return 
     */
    public static boolean checkFullName(String fullName) {
        // Regular Expression cho fullName hợp lệ (hỗ trợ tiếng Việt)
        String fullNameRegex = "^[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯỲÝỴỶỸẰẮẲẴẶẦẤẨẪẬÈÉÊỀẾỂỄỆÙÚỦỤỲÝỴỶỸ]"
                             + "[a-zàáâãèéêìíòóôõùúăđĩũơưỳýỵỷỹầấẩẫậèéêềếểễệùúủụỳýỵỷỹ]*"
                             + "(\\s[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯỲÝỴỶỸẰẮẲẴẶẦẤẨẪẬÈÉÊỀẾỂỄỆÙÚỦỤỲÝỴỶỸ]"
                             + "[a-zàáâãèéêìíòóôõùúăđĩũơưỳýỵỷỹầấẩẫậèéêềếểễệùúủụỳýỵỷỹ]*)*$";

        // Kiểm tra nếu fullName là null hoặc rỗng
        if (fullName == null || fullName.trim().isEmpty()) {
            return false;
        }

        return fullName.matches(fullNameRegex);
    }

    
    
}


