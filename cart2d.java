public class cart2d{

	protected double x;	    // x coordinate	
	protected double y;		// y coordinate

	// constructor
	public cart2d(){
		x = 0;
		y = 0;
	}

	// constructor
	public cart2d (double x, double y) {
        this.x = x;
        this.y = y;
    }

    // constructor
	public cart2d (cart2d a) {
        this.x = a.x;
        this.y = a.y;
    }

    // set x-coordinate
    public void setX(double o){
		x=o;
	}

	// set y-coordinate
	public void setY(double o){
		y=o;
	}

	// get x-coordinate
	public double getX(){
		return(x);
	}

	// get y-coordinate
	public double getY(){
		return(y);
	}

	// return string representation of cart2d object
	public String toString(){
		return("(" + x + "," + y + ")");
	}

	// check equality of this and num
	public boolean equal(cart2d num){
		return (num.x==this.x && num.y==this.y);
	}

	// static method to check equality of num and num1
	public static boolean equal(cart2d num, cart2d num1){
		return (num.x==num1.x && num.y==num1.y);
	}

	// scale this by factor e
	public void scale(double e){
		this.x *= e;
		this.y *= e;
	}

	// move x & y coordinates of this by a, b
	public void translation(double a, double b){
		this.x += a;
		this.y += b;
	}

	// reflect this over x-axis
	public void reflectx(){
		if(this.y!=0)
			this.y *= -1;
	}

	// reflect this over y-axis
	public void reflecty(){
		if(this.x!=0)
			this.x *= -1;
	}

	// reflect this over origin
	public void reflecto(){
		if (this.x!=0)
			this.x *= -1;
		if (this.y!=0)
			this.y *= -1;
	}

	// returns the distance between this and e
	public double distance(cart2d e){
		return(Math.sqrt((this.x-e.x)*(this.x-e.x) + (this.y-e.y)*(this.y-e.y)));
	}

	// returns the midpoint between this and e
	public cart2d midpoint(cart2d e){
		cart2d c = new cart2d();
		c.x = (this.x+e.x)/2;
		c.y = (this.y+e.y)/2;
		return(c);
	}

	// returns the slope of this and e
	public double slope(cart2d e){
		return((this.y-e.y)/(this.x-e.x));
	}

	// rotate this across origin by angle e
	public void rotationo(double e){
		double x,y;
		e = e*Math.PI/180;
		x = this.x * Math.cos(e) - this.y * Math.sin(e);
		y = this.x * Math.sin(e) + this.y * Math.cos(e);
		this.x = x;
		this.y = y;
	}

	// rotate this across point z by angle e
	public void rotationp(cart2d z, double e){
		double x1 = this.x - z.x;
		double y1 = this.y - z.y;
		e = e*Math.PI/180;
		double x2 = x1 * Math.cos(e) - y1 * Math.sin(e);
		double y2 = x1 * Math.sin(e) + y1 * Math.cos(e);

		this.x = x2 + z.x;
		this.y = y2 + z.y;
	}

	// return area enclosed between this, a and b
	public double area(cart2d a, cart2d b){
		double q = this.distance(a);
		double w = this.distance(b);
		double e = a.distance(b);
		double s = (q+w+e)/2;
		return(Math.sqrt(s*(s-q)*(s-w)*(s-e)));
	}

	// return angle between a and b
	public double angle(cart2d a, cart2d b){
		double q = this.distance(a);
		double w = this.distance(b);
		double e = a.distance(b);
		double theta = Math.acos(((q*q)+(w*w)-(e*e))/(2*q*w));
		return(theta);
	}

	// return the intersection point when a perpendicular line is drawn from 
	// this to line ab
	public cart2d perpendicular(cart2d a, cart2d b){
		cart2d c = new cart2d();
		double q = a.slope(b);
		double w = a.y - a.x*q;
		double e = -1/q;
		double r = this.y+this.x/q;
		c.x = (r-w)/(q-e);
		c.y = q*c.x + w;
		return(c);
	}

	// return polar radius of this.
	public double prad() {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }

    
    // return the angle of this in polar coordinates.
    public double theta() {
        return Math.atan2(this.y, this.x);
    }
}