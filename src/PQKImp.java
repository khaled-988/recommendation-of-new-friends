public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> {
	private Pair<P, T>[] arr;
	private int size,cur;
	private int head;
	private int back;
	@SuppressWarnings("unchecked")
	public PQKImp(int k) {
		arr=(Pair<P, T>[])new Pair[k];
		size=k;
		cur=0;
		this.head = 0;
		this.back = 0;
	}
	
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return cur;
	}

	@Override
	public void enqueue(P pr, T e) {
		try {
		Pair<P, T> tmp=new Pair<P, T>(pr, e);
		
		if (cur==0) {
			arr[back] = tmp;
			back = (back + 1) % size;
		}else {
			boolean f=false;
			Pair<P, T> tmp1=null;
			boolean g=true;
			for (int i=0;i<cur;i++) {
				P check=arr[i].first;
				if (pr.compareTo(check) == 1 && f==false) {
					 //tmp1=arr[i];
					//tmp1=tmp;
					f=true;
					
				      /* for(int ii = 0; ii < cur; ii++){ */   
				            int j;
				            Pair<P, T> last;
				            //Stores the last element of array    
				            last = arr[arr.length-1];    
				            
				            for(j = arr.length-1; j > i; j--){    
				                //Shift element of array by one    
				                arr[j] = arr[j-1];    
				            }    
				            //Last element of array will be added to the start of array.    
				           // arr[0] = last;    
				            arr[i]=tmp;
				            g=false;
				        
				}
			}
				if (false)
				arr[back]=tmp1;
				else if(cur<size && g)
					arr[cur]=tmp;
				back = (back + 1) % size;
		}
		if (cur<size)
		cur++;
		
		Pair<P, T> temp=new Pair<P, T>(pr, e);
		 for (int i = 0; i < cur; i++) 
	        {
	            for (int j = i + 1; j < cur; j++) 
	            {
	                if (arr[i].first.compareTo(arr[j].first)==-1) 
	                {
	                    temp = arr[i];
	                    arr[i] = arr[j];
	                    arr[j] = temp;
	                }
	            }
	        }
		}catch (Exception ee) {
			// TODO: handle exception
		}
	}

	@Override
	public Pair<P, T> serve() {
		try {
		if (cur==0)
			return new Pair<P,T>(null, null);
		Pair<P, T> data = arr[0];
		for (int i=0;i<cur-1;i++) {
			arr[i]=arr[i+1];
		}
		head = (head + 1) % size;
		
		
		cur--;
		return data;
		}catch (Exception e) {
			return new Pair<P,T>(null, null);
			// TODO: handle exception
		}
	}
	
}
