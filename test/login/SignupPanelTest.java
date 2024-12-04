/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BTL_OOP.test.login;

import BTL_OOP.main.ui.login.SignupPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ngothuyet
 */
public class SignupPanelTest {
    
    private JTextField nameTextField;
    private JTextField msvTextField;
    private JTextField userAccountTextField;
    private JPasswordField passwordTextField;
    private JPanel mainPanel;

    private SignupPanel signupController;
    public SignupPanelTest() {
    }

   
    @Test 
    public void testSignupButtonActionPerformed() {
        nameTextField.setText("Nguyen Van A");
        msvTextField.setText("12345");
        userAccountTextField.setText("validUser");
        passwordTextField.setText("validPassword123");

        // Gọi hàm kiểm tra
        JButton signupButton = new JButton("Sign Up");

        // Tạo một ActionEvent giả lập
        ActionEvent event = new ActionEvent(signupButton, ActionEvent.ACTION_PERFORMED, "SignUpButtonPressed");
        signupController.invokeSignupButtonActionPerformed(event);

        // Kiểm tra giao diện đã chuyển đổi
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        IllegalArgumentException assertThrows = assertThrows(IllegalArgumentException.class, () -> layout.show(mainPanel, "loginPanel"));
    }
    
}
