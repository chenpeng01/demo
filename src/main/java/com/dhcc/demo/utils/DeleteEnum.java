/**
 * Copyright (c) 2008-2015 by DHCC
 * All rights reserved.
 */

package com.dhcc.demo.utils;

/**
 * 
 * @author <a href="mailto:cp@dhcc.com.cn">cp</a>
 * @date 2015-4-3
 */
public enum DeleteEnum {
    UNDELETE(0),DELETE(1),ALL(2);
    
    private final int value;
    
    public int getValue() {
        return value;
    }

    private DeleteEnum(int value) {
        this.value = value;
    }
}
