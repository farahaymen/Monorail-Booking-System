/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monorailbookingsystem;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Hanin
 */
public class AccountException extends Exception{
    String error= "Account doesn't exist";
    public AccountException(){
//        final JPanel panel = new JPanel();
//             JOptionPane.showMessageDialog(panel,error, "Error", JOptionPane.ERROR_MESSAGE);
      System.out.println(error);
    }
    
}
