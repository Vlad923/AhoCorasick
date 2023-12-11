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
			System.out.println("�������� �������� ��������.");
			System.out.println("������� ����� ��������� �������� � ������� Enter:");
			System.out.println("1. �������� �������� �����.");
			System.out.println("2. ������ ������.");
			System.out.println("3. �����.");
			System.out.println("4. ������� �������� �����.");
			System.out.println("5. �������� �������� �����.");
			System.out.println("6. �����.");

			intString = inputStr.next();
	        
	        try 
	        {
	            menu = Integer.parseInt(intString);
	        } 
	        
	        catch (NumberFormatException e)
	        {
	            System.out.println("�������� ���� / ����� �� ������� ���������");
	        } 
	        
	        
	        switch(menu)
	        {
		        case 1:
		        	// �������� �������� �����
		        	Adding();
		        	break;
		        case 2:
		        	// ������ ������
		        	AddText();
		        	break;
		        case 3:
		        	// �����
		        	Search();
		        	break;
		        case 4:
		        	// ������� �������� �����
		        	Outputing();
		        	break;
		        case 5:
		        	// �������� �������� �����
		        	removing();
		        	break;
		        case 6:
		        	// �����
		        	System.out.println("��������� ���������");
		        	System.exit(menu);
		        	break;
		              
	        }

		}
    }
	
	
	public static void Adding()
	{
		System.out.println("==> ���������� ��������� ����� <==");
		
			Scanner scan = new Scanner(System.in);
			String intString = "";
			
			System.out.println("������� ����� � ������� Enter:");	
			
			
			intString = scan.nextLine();
			
			patterns.add(intString);
			System.out.println("�� ��������:");
			System.out.println(intString);
	}
		
	
	
	
	public static void Outputing()
	{
		System.out.println("==> ����� �������� ���� <==");
		
		if(patterns.size() == 0)
			System.out.println("�������� ����� �����������");
		else {
		for(int i = 0; i < patterns.size(); i++)
			System.out.println(patterns.get(i));
		}
	}
	
	
	public static void removing()
	{
		System.out.println("==> ������� �������� ���� <==");
		
		if(patterns.size() == 0)
			System.out.println("�������� ����� �����������");
		else {
			patterns.clear();
			System.out.println("�������� ����� ��������");
		}
			
	}
	
	public static void AddText()
	{
		System.out.println("==> ���� ������ <==");
		
		Scanner scan = new Scanner(System.in);
		String intString = "";
		
		System.out.println("������� ������ � ������� Enter:");	
				
		intString = scan.nextLine();
		
		text = intString;
		System.out.println("�� �����:");
		System.out.println(text);
	}
	
	
	public static void Search()
	{
		System.out.println("==> ����� <==");
		
		if (patterns.size() == 0) {
			System.out.println("������, ������� �������� �����");
			return;
		}
		if (text == "") {
			System.out.println("������, ������� ������");
			return;
		}
		String[] AxoPatterns = new String[patterns.size()];
		
		for(int i = 0; i < patterns.size(); i ++)
		{
			AxoPatterns[i] = patterns.get(i);
			
		}
		
		String[][] result = AhoCorasick.searchAhoCorasick(text, AxoPatterns);
	
		if (result == null) {
			System.out.println("���������� �� �������");
			return;
		}
		else {
			for(int i = 0; i < result.length; i++)
				System.out.println("��������� " + result[i][0] + " ������� � ������� " + result[i][1]);
		}
		
	}
			
	
	
	
}