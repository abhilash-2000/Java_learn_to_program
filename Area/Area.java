import java.lang.Math;
class Area{
	public static void main(String args[]){
	double[] arr = {-13,8,
		-8,-6,
		5,-2,
		2,10
		
	   };
		int x=arr.length;
		Coord[] obja = new Coord[x/2];
		for(int i = 0; i < arr.length; i=i+2){
			if(i<arr.length-1){
				obja[i/2] = new Coord(arr[i],arr[i+1]);
			}
		}
		double perim=0.0;
		for (int i = 0; i < obja.length-1; i++) {
			double p=obja[i].calcperim(obja[i+1]);
			perim=perim+p;
		}
		double s = obja[obja.length-1].calcperim(obja[0]);
		perim=perim+s;
		System.out.println(perim);
	}
}
class Coord{
	double l;
	double b;
	Coord(double x,double y){
		l=x;
		b=y;
	}
	double calcperim(Coord a){
		if(l==a.l){
			if(b<=0 && a.b>=0){
				double r=(-b)+a.b;
				return r;
			}
			else if(b>=0 && a.b<=0){
				double r=(b)+(-a.b);
				return r;
			}
			else if(b<=0 && a.b<=0){
				if(b>=a.b){
					double r=(-b)-(-a.b);
					return r;
				}
				else{
					double r=(-a.b)-(-b);
					return r;
				}
			}
			else{
				if(b>=a.b){
					double r=(b)-(a.b);
					return r;
				}
				else{
					double r=(a.b)-(b);
					return r;
				}
			}
		}
		else if(b==a.b){
			if(l<=0 && a.l>=0){
				double r=(-l)+a.l;
				return r;
			}
			else if(l>=0 && a.l<=0){
				double r=(l)+(-a.l);
				return r;
			}
			else if(l<=0 && a.l<=0){
				if(l>=a.l){
					double r=(-l)-(-a.l);
					return r;
				}
				else{
					double r=(-a.l)-(-l);
					return r;
				}
			}
			else{
				if(l>=a.l){
					double r=(l)-(a.l);
					return r;
				}
				else{
					double r=(a.l)-(l);
					return r;
				}
			}
		}
		else{
			Coord third = new Coord(l,a.b);
			double q=this.calcperim(third);
			double w=a.calcperim(third);
			double e= (q*q)+(w*w);
			double r= Math.sqrt(e);
			return r;
		}

	}
}
		
