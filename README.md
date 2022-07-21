# exerciseTech

This is a sample project that converts numbers from 1 - 3999 to Roman numerals. 

principle:
I broke my number down into thousands, hundreds, tens and units. 
I converted each part into a Roman numeral using the same principle (function ordonate()).
Example: to write 6, we will use 5 ->V and 1 - I. Same for writing 60 and 600 except that we will have respectively 50 ->L + 10-> X and 500-> D + 100->C. 
So by establishing the rules of writing for the units, we will be able to use them for the ten, the hundred. 

 The method ordonate(ArrayList<String> tableau, int i) defines the rules for conversion to Roman numerals
	// It takes a table containing ( I, V, X) or (X,L,C) or (C, D, M) in order and i which define the case and the rule to apply.
	// it returns Roman numerals.
  
   The method concatenate(String letter, int n) will concatenate n times letter EX: concatenate ("I", 3) -> III
  
 The method numeral(int value)  will handle the different cases of going from thousand to unit
//	and concatenating.
	
  
  


