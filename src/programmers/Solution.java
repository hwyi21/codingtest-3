package programmers;

public class Solution {

	public static String solution(String p) {
	        String answer = "";
	        StringBuilder sb = new StringBuilder();
	        if(p.isEmpty()) {
	        	answer= "";
	        }else {
	        	sb.append(a(p));
	        }
	        answer=sb.toString();
	        System.out.println(answer);
	        return answer;
	    }

	//***** Ʋ�� ���ڿ��� ���
	//�Ϻ��� ���ڿ� �� �ڸ� ()�� ���� �� ��ȣ �ȿ� Ʋ�� ���ڿ� v�� ����Լ��� �ݺ�
	// ( + v + ) ������ �Ϻ��� ���ڿ����� �Ǿհ� �ڸ� �� ������ ���ڿ��� ��ȣ ������ �ٲپ� ( + v + ) �ڿ� �߰� 
	//ex1)  )()()(
	//1. �Ϻ��� ���ڿ� )(  v = )()(   =>(+v+) 
	// 2. �Ϻ��� ���ڿ� )(  v=")("   =>((+v+ ))
	//3. ((()))
	//ex2)  ()))((
	//1. �Ϻ��� ���ڿ� () v=))(( =>()+v
	//2. �Ϻ��� ���ڿ� ))((  v="" => ()()+������ ���ڿ�)( �� ��ȣ ������ �ٲ� () 
	public static String a(String p) {
		int left = 0;
        int right = 0;
        
        StringBuilder sb = new StringBuilder();
        StringBuilder a = new StringBuilder();
        
        
        for(int i=0; i<p.length(); i++) {
        	if(p.charAt(i)=='(') {
        		left++;
        		sb.append("(");
        	}else {
        		right++;
        		sb.append(")");
        	}
        	if(left==right) {
        		String w = sb.toString();
        		String v = p.substring(i+1, p.length());
        		
        		boolean correct = isCollect(w);
        		if(v.equals("")&&correct) {
        			a.append(w);
        			return a.toString();
        		}else if(!v.equals("")&&correct) {
        			a.append(w);
        			return a+a(v);
        		}else if(!correct&&!v.equals("")){
        			a.append("(");
        			a.append(a(v));
        			a.append(")");
        			for(int j=1; j<w.length()-1; j++) {
        				if(w.charAt(j)=='(') {
        					a.append(")");
        				}else if(w.charAt(j)==')'){
        					a.append("(");
        				}
        			}   			
        			return a.toString();
        		}else if(!correct&&v.equals("")) {
        			a.append("(");
        			a.append(")");
        			for(int j=1; j<w.length()-1; j++) {
        				if(w.charAt(j)=='(') {
        					a.append(")");
        				}else if(w.charAt(j)==')'){
        					a.append("(");
        				}
        			}   			
        			return a.toString();
        		}
        	}
        }
        return a.toString();
	}
	
	//�ùٸ� ���ڿ� �Ǵ�
	public static boolean isCollect(String w) {
		int count=0;
		for(int i=0; i<w.length(); i++) {
			if(w.charAt(i)=='(') {
				count++;
			}else {
				count--;
			}
			if(count<0) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		solution(")()()(");
	}

}
