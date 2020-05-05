package com.skynet.infrastructure;


import java.util.List;


public class BaseGraphService implements GraphService {


	
	

	
	protected void checkType(String type)
	{
		

		//the first char must be alphabets
		String trimedType = type.trim();
		if(trimedType.isEmpty()){
			throw new IllegalArgumentException("protected void checkType(String type): type is not allowed to be empty after trimed");
		}
		char firstChar = trimedType.charAt(0);//safe here, empty is checked;
		if(!Character.isLetter(firstChar)){
			throw new IllegalArgumentException("protected void checkType(String type): first char '"+firstChar+"' must be alphabets");
		}
		
		for(char ch: type.toCharArray()){
			if(Character.isDigit(ch)){
				continue;
			}
			if(Character.isLetter(ch)){
				continue;
			}
			throw new IllegalArgumentException("Character '"+ch+"' in " + type + " is not allowed to be other character except letter and digit");
			
		}
	}

	@Override
	public List<String[]> relationsOf(String projectName, String fromLabel, String fromId,
			String toLable, String toId) {
		// TODO Auto-generated method stub
		return null;
	}

}
