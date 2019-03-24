/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import logic.Entities.HouseInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dennis
 */
public class Calculator {

    private int largeBrickLength = 4;
    private int mediumBrickLength = 2;
    private int smallBrickLength = 1;
    
    private double largeBrickPrice = 3.0;
    private double mediumBrickPrice = 2.0;
    private double smallBrickPrice = 1.0;
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        HouseInfo hi = new HouseInfo(20, 20, 20);
        System.out.println(calc.calculateHouse(hi));
        System.out.println(calc.calculatePrice(hi));
    }
    
    /**
     *
     * @param houseInfo
     * @return
     */
    public List<Integer> calculateLayerOne(HouseInfo houseInfo) {
        List<Integer> brickList = new ArrayList();
        int houseLength = houseInfo.getLength();
        int houseWidth = houseInfo.getWidth() - 4;

        int largeBrickQuantity = 0;
        int mediumBrickQuantity = 0;
        int smallBrickQuantity = 0;
        
        if(houseLength > 0){
            
        while (houseLength >= largeBrickLength) {
            largeBrickQuantity++;
            houseLength -= largeBrickLength;
        }
        
        while(houseLength >= mediumBrickLength){
            mediumBrickQuantity++;
            houseLength -= mediumBrickLength;
        }
        
        while(houseLength >= smallBrickLength){
            smallBrickQuantity++;
            houseLength -= smallBrickLength;
        }
        
        }
       
        if(houseWidth > 0){
            
        
        while(houseWidth >= largeBrickLength){
            largeBrickQuantity++;
            houseWidth -= largeBrickLength;
        }
                
        while(houseWidth >= mediumBrickLength){
            mediumBrickQuantity++;
            houseWidth -= mediumBrickLength;
        }
        
        while(houseWidth >= smallBrickLength){
            smallBrickQuantity++;
            houseWidth -= smallBrickLength;
        }
        
        }
        
        smallBrickQuantity *= 2;
        mediumBrickQuantity *= 2;
        largeBrickQuantity *= 2;
        
        
        brickList.add(smallBrickQuantity);
        brickList.add(mediumBrickQuantity);
        brickList.add(largeBrickQuantity);
        
        return brickList;
        
    }
    
    /**
     *
     * @param houseInfo
     * @return
     */
    public List<Integer> calculateLayerTwo(HouseInfo houseInfo){
        List<Integer> brickList = new ArrayList();
        int houseLength = houseInfo.getLength() -4;
        int houseWidth = houseInfo.getWidth();
        
        int largeBrickQuantity = 0;
        int mediumBrickQuantity = 0;
        int smallBrickQuantity = 0;
        
        if(houseLength > 0){
        
        while (houseLength >= largeBrickLength) {
            largeBrickQuantity++;
            houseLength -= largeBrickLength;
        }
        
        while(houseLength >= mediumBrickLength){
            mediumBrickQuantity++;
            houseLength -= mediumBrickLength;
        }
        
        while(houseLength >= smallBrickLength){
            smallBrickQuantity++;
            houseLength -= smallBrickLength;
        }
        
        }
        
        
        if(houseWidth > 0){
        while(houseWidth >= largeBrickLength){
            largeBrickQuantity++;
            houseWidth -= largeBrickLength;
        }
        
        while(houseWidth >= mediumBrickLength){
            mediumBrickQuantity++;
            houseWidth -= mediumBrickLength;
        }
        
        while(houseWidth >= smallBrickLength){
            smallBrickQuantity++;
            houseWidth -= smallBrickLength;
        }
        
        }
        smallBrickQuantity *= 2;
        mediumBrickQuantity *= 2;
        largeBrickQuantity *= 2;
        
        brickList.add(smallBrickQuantity);
        brickList.add(mediumBrickQuantity);
        brickList.add(largeBrickQuantity);
        
        return brickList;      
        
        
    }
    
    /**
     *
     * @param houseInfo
     * @return
     */
    public List<Integer> calculateHouse(HouseInfo houseInfo){
        List<Integer> brickList = new ArrayList();
        List<Integer> layerOne = calculateLayerOne(houseInfo);
        List<Integer> layerTwo = calculateLayerTwo(houseInfo);
        
        int smallBrickLayerOne = layerOne.get(0);
        int mediumBrickLayerOne = layerOne.get(1);
        int largeBrickLayerOne = layerOne.get(2);
        
        int smallBrickLayerTwo = layerTwo.get(0);
        int mediumBrickLayerTwo = layerTwo.get(1);
        int largeBrickLayerTwo = layerTwo.get(2);
        
        int houseHeight = houseInfo.getHeight();
        int count = 1;
        
        int smallBrickQuantity = 0;
        int mediumBrickQuantity = 0;
        int largeBrickQuantity = 0;
        
        
        if(houseHeight == 1){
            return layerOne;
        }
        
        if(houseHeight % 2 == 0){
            
            int temp = houseHeight / 2;
            
            smallBrickQuantity += smallBrickLayerOne * temp;
            mediumBrickQuantity += mediumBrickLayerOne * temp;
            largeBrickQuantity += largeBrickLayerOne * temp;
            smallBrickQuantity += smallBrickLayerTwo * temp;
            mediumBrickQuantity += mediumBrickLayerTwo * temp;
            largeBrickQuantity += largeBrickLayerTwo * temp;
        }
        if(houseHeight % 2 != 0){
            
            int temp = ( houseHeight - 1 ) / 2;
            
            
            smallBrickQuantity += smallBrickLayerOne * ( temp + 1 );
            mediumBrickQuantity += mediumBrickLayerOne * ( temp + 1 );
            largeBrickQuantity += largeBrickLayerOne * ( temp + 1 );
            smallBrickQuantity += smallBrickLayerTwo * temp;
            mediumBrickQuantity += mediumBrickLayerTwo * temp;
            largeBrickQuantity += largeBrickLayerTwo * temp;
            
        }
        
       
        
        brickList.add(smallBrickQuantity);
        brickList.add(mediumBrickQuantity);
        brickList.add(largeBrickQuantity);
        
        return brickList;
    }
    
    /**
     *
     * @param houseInfo
     * @return
     */
    public double calculatePrice(HouseInfo houseInfo){
        List<Integer> brickList = calculateHouse(houseInfo);
        
        double price = 0;
        
        double smallBrickQuantity = brickList.get(0) * smallBrickPrice;
        double mediumBrickQuantity = brickList.get(1) * mediumBrickPrice;
        double largeBrickQuantity = brickList.get(2) * largeBrickPrice;
        
        price += smallBrickQuantity + mediumBrickQuantity + largeBrickQuantity;
        
        return price;        
        
    }
    

}
