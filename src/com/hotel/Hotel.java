/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.hotel;

import com.view.VentanaPrincipal;

/**
 *
 * @author agusm
 */
public class Hotel {

    public static void main(String[] args) {
        try{Class.forName("com.mysql.cj.jdbc.Driver");}
        catch (Exception e){
            System.out.println(e);
        }
        new VentanaPrincipal().setVisible(true);
    }
}