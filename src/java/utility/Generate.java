/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.UUID;

/**
 *
 * @author pv
 */
public class Generate {
    public String generateResetToken() {
        String uuid = UUID.randomUUID().toString(); 
        return uuid;
    }
    public static void main(String[] args) {
        System.out.println(new Generate().generateResetToken());
    }
}
