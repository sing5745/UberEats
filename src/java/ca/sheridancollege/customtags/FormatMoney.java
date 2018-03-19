/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.customtags;

import java.io.IOException;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import javax.servlet.jsp.tagext.*;


public class FormatMoney extends SimpleTagSupport {
    
    private String money;

    public FormatMoney() {
    }

    public void setMoney(String money) {
        this.money = money;
    }
    
    
    
    @Override
    public void doTag() throws JspException, IOException{
    JspWriter out = getJspContext().getOut();
    
    DecimalFormat df = new DecimalFormat("#,###,##0.00");
    
    String formattedNumber = df.format(Double.parseDouble(money));
     out.println("$" + formattedNumber); 
    }
}
