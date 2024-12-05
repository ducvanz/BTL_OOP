/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP.main.ui.manage;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Admin
 */
public interface EditImage {
        /**
     * set kích thước cho icon trong jlabel
     * @param label 
     * @param width
     * @param height 
     */
    default void resizeLabelIcon(JLabel label, int width, int height) {
        ImageIcon icon = (ImageIcon) label.getIcon(); // Lấy icon đã đặt qua phần Design
        if (icon != null) {
            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(scaledImage)); 
            
            label.setHorizontalTextPosition(SwingConstants.LEFT);
        }
    }
    
        /**
     * Set kích thước cho icon ở trong nút.
     * @param button nút
     * @param width rộng ảnh
     * @param height image
     */
    default void resizeButtonIcon(JButton button, int width, int height) {
        ImageIcon icon = (ImageIcon) button.getIcon(); // Lấy icon đã đặt qua phần Design
        if (icon != null) {
            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledImage)); 
            
            button.setHorizontalTextPosition(SwingConstants.LEFT);
        }
    }
    
}
