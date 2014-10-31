/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.dundee.computing.aec.instagrim.stores;

import com.datastax.driver.core.utils.Bytes;

import java.nio.ByteBuffer;

/**
 *
 * @author Administrator
 */
public class Com {

    private String com;
    
  //  public void Com() {

  //  }
    public void setCom(String comment){
        this.com=comment;
    }
    public String getCom(){
        return com;
    }

}
