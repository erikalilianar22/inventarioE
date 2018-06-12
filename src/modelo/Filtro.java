/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Filtro {
    private int id;
    private String codigo;
    private String marca;
    private int stock;
    private boolean existencia;
    
    public Filtro(){
    }
    
    public Filtro(int id, String codigo, String marca, int stock, boolean exitencia){
        this.id=id;
        this.marca=marca;
        this.stock=stock;
        this.existencia=exitencia;
        this.codigo=codigo;
    }
    
    public Filtro(String codigo, String marca, int stock, boolean exitencia){
        this.codigo=codigo;
        this.marca=marca;
        this.stock=stock;
        this.existencia=existencia;
    }
    
    public Filtro(String marca, int stock, boolean existencia){
        this.marca=marca;
        this.stock=stock;
        this.existencia=existencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public int getStock() {
        return stock;
    }

    public boolean getExistencia() {
        return existencia;
    }
    
}
