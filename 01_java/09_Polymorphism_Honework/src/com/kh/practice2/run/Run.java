package com.kh.practice2.run;

import com.kh.practice2.model.vo.*;

public class Run {

	public static void main(String[] args) {
		SmartPhone[] phone = new SmartPhone[2];
		
		  
		  //  ������  �ε�����  GalaxyNote9, V40  ��ü  ����  (�⺻������  �̿�) -->  ������
		   phone[0] = new GalaxyNote9();
		   phone[1] = new V40();
		  // for����  �̿��Ͽ�  phone  ��ü�迭��  ���  �ε�����  ����. 
		
		
		  for(int i=0; i < phone.length; i++) {
				  phone[i].printMaker();
				  phone[i].makeacall();
				  phone[i].takeacall();
				  phone[i].touch();
				  phone[i].charge();
				  phone[i].picture();
				  System.out.println();
			  }
		  }
		   // printMaker()  ȣ�� 
		   // makeaCall()  ȣ�� 
		   // takeaCall()  ȣ�� 
		   // touch()  ȣ�� 
		   // charge()  ȣ�� 
		   // picture()  ȣ��    
		   //System.out.println(); //  ��  ��  ��� 
		   
		
		
		


}
