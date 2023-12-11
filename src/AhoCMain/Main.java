package AhoCMain;
//import java.util.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Main 
{
	
	public static ArrayList<String> patterns = new ArrayList<>();
	public static String text = "";
	
	public static void main(String[] args) 
	{
	
		
        
        Scanner inputStr = new Scanner(System.in);
		String intString="";
		int menu=0;
		
		while(!"6".equals(intString)) 
		{
			System.out.println("=========================");
			System.out.println("Выберите желаемое действие.");
			System.out.println("Введите номер требуемой операции и нажмите Enter:");
			System.out.println("1. Добавить ключевое слово.");
			System.out.println("2. Ввести строку.");
			System.out.println("3. Поиск.");
			System.out.println("4. Вывести ключевые слова.");
			System.out.println("5. Очистить ключевые слова.");
			System.out.println("6. Выход.");

			intString = inputStr.next();
	        
	        try 
	        {
	            menu = Integer.parseInt(intString);
	        } 
	        
	        catch (NumberFormatException e)
	        {
	            System.out.println("Неверный ввод / Выход за пределы диапазона");
	        } 
	        
	        
	        switch(menu)
	        {
		        case 1:
		        	// Добавить ключевое слово
		        	Adding();
		        	break;
		        case 2:
		        	// Ввести строку
		        	AddText();
		        	break;
		        case 3:
		        	// Поиск
		        	Search();
		        	break;
		        case 4:
		        	// Вывести ключевые слова
		        	Outputing();
		        	break;
		        case 5:
		        	// Очистить ключевые слова
		        	removing();
		        	break;
		        case 6:
		        	// выход
		        	System.out.println("Программа завершена");
		        	System.exit(menu);
		        	break;
		              
	        }

		}
    }
	
	
	public static void Adding()
	{
		System.out.println("==> Добавление ключевого слова <==");
		
			Scanner scan = new Scanner(System.in);
			String intString = "";
			
			System.out.println("Введите слово и нажмите Enter:");	
			
			
			intString = scan.nextLine();
			
			patterns.add(intString);
			System.out.println("Вы добавили:");
			System.out.println(intString);
	}
		
	
	
	
	public static void Outputing()
	{
		System.out.println("==> Вывод ключевых слов <==");
		
		if(patterns.size() == 0)
			System.out.println("Ключевые слова отсутствуют");
		else {
		for(int i = 0; i < patterns.size(); i++)
			System.out.println(patterns.get(i));
		}
	}
	
	
	public static void removing()
	{
		System.out.println("==> Очистка ключевых слов <==");
		
		if(patterns.size() == 0)
			System.out.println("Ключевые слова отсутствуют");
		else {
			patterns.clear();
			System.out.println("Ключевые слова очищенны");
		}
			
	}
	
	public static void AddText()
	{
		System.out.println("==> Ввод строки <==");
		
		Scanner scan = new Scanner(System.in);
		String intString = "";
		
		System.out.println("Введите строку и нажмите Enter:");	
				
		intString = scan.nextLine();
		
		text = intString;
		System.out.println("Вы ввели:");
		System.out.println(text);
	}
	
	
	public static void Search()
	{
		System.out.println("==> Поиск <==");
		
		if (patterns.size() == 0) {
			System.out.println("Ошибка, добавте ключевые слова");
			return;
		}
		if (text == "") {
			System.out.println("Ошибка, добавте строку");
			return;
		}
		String[] AxoPatterns = new String[patterns.size()];
		
		for(int i = 0; i < patterns.size(); i ++)
		{
			AxoPatterns[i] = patterns.get(i);
			
		}
		
		String[][] result = AhoCorasick.searchAhoCorasick(text, AxoPatterns);
	
		if (result == null) {
			System.out.println("Совпадений не найдено");
			return;
		}
		else {
			for(int i = 0; i < result.length; i++)
				System.out.println("Подстрока " + result[i][0] + " найдена в позиции " + result[i][1]);
		}
		
	}
			
	
	
	
}