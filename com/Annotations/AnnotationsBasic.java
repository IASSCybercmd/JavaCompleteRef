package com.Annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

//An annotation type declaration.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
    String str();
    int val();
}

/**
 * This function show the basic of Annotations.
 */
public class AnnotationsBasic {
        //Annotate a method
        @MyAnno(str = "Annotation example", val = 100)
        public static void myMeth(){
            AnnotationsBasic obj = new AnnotationsBasic();

            //obtain the annotation for this method & display the values of the memebers.
            try{
                //First, get a class object that represents this class.
                Class<?> c = obj.getClass();

                //Now get a method object that represents this method.
                Method m = c.getMethod("myMeth");
            }
        }
    
}
