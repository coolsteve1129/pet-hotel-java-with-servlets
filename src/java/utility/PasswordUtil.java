/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Base64;

/**
 *
 * @author hecks
 */
public class PasswordUtil implements Serializable {

 public PasswordUtil(){
     
    }
 
// public static String saltPassword(String password) throws NoSuchAlgorithmException{
//     String salt = getSalt();
//     return password + salt;
// }
 public static String getSalt(){
     Random r = new SecureRandom();
     byte[] saltBytes = new byte[32];
     r.nextBytes(saltBytes);
     return Base64.getEncoder().encodeToString(saltBytes);
 }
 public static String generatePassword(){
        String charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_-+!@#$%";
        String password = "";
        int start = 0;
        int stop = 0;
        int minLength = 8;
        
        for (int i = 0; i <= minLength; i++) {
                // get a random character from the chars string
                start = getRandomNumber(charSet.length());
                stop = start + 1;
                password += charSet.substring(start, stop);
        }        
        return password;
    }
    private static int getRandomNumber(int maxValue){
        double randomNumber;
        randomNumber = Math.floor(Math.random() * maxValue);
        
        return (int)randomNumber;
    }
    public static String hashPassword(String password)throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] mdArray = md.digest();
        StringBuilder sb = new StringBuilder(mdArray.length * 2);
        for (byte b : mdArray){
            int v = b & 0xff;
            if(v < 16){
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();   
    }
    }
