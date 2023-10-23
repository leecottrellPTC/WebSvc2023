package com.leecottrell;

import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.LinkedNode;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ObjectMapper mapper = new ObjectMapper();


        Recipe pbj = new Recipe();
         Recipe pbj2 = new Recipe();
        pbj.setRecipeName("Peanut Butter and Jelly");
        pbj.setCalories(189);
        pbj.setAllergyWarning(true);

        pbj.setIngredients(Arrays.asList("2 pieces of bread", "Peanut Butter", "Jelly"));

        Map<String, String> theSteps = new HashMap(){
            {
            put("Step 1", "Put bread on plate");
            put("Step 2", "Spread jelly on on piece of bread");
            put("Step 3", "Spread peanut butter on other piece of bread");
            put("Step 4", "Put the pieces of bread together, jelly and peanut butter inside");
            }
        };
        pbj.setSteps(theSteps);

        pbj2 = pbj;
        List<Recipe> recipeList = new ArrayList<Recipe>();
        recipeList.add(pbj);
        recipeList.add(pbj2);
        //recipeList.add(pbj);

        try{
            //String JSON = mapper.writeValueAsString(pbj);
            //String JSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pbj);

            String JSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pbj);

            System.out.println(recipeList);
            
        }
        catch(JsonProcessingException jpe){
              System.out.println("JSON failed "+ jpe.toString());  
        }

    }
}
