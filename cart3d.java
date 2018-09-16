public class cart3d extends cart2d{
	protected double z;		// z coordinate

	// constructor
	public cart3d(){
		super();
		z = 0;
	}

	// constructor
	public cart3d ( double x, double y, double z) {
        super(x,y);
        this.z=z;
    }

    // constructor
	public cart3d (cart3d a) {
        super(a);
        this.z = a.z;
    }

    // set z-coordinate
    public void setZ(double o){
		z=o;
	}

	// get z coordinate
	public double getz(){
		return(z);
	}

	// return string representation of cart3d object
	public String toString(){
		return ("(" + x + "," + y + "," + z + ")");
	}

	// check equality of this and num
	public boolean equal(cart3d num){
		return (cart2d.equal(num,this)&& num.z==this.z);
	}

	// scale this by factor e
	public void scale(double e){
		super.scale(e);
		this.z *= e;
	}

	// move x, y & z coordinate by a, b, c
	public void translation(double a, double b, double d){
		super.translation(a,b);
		this.z += d;
	}

	// reflect this over x-axis
	public void reflectx(){
		super.reflectx();
		if(this.z!=0)
			this.z *= -1;
	}

	// reflect this over y-axis
	public void reflecty(){
		super.reflecty();
		if(this.z!=0)
			this.z *= -1;
	}

	// reflect this over z-axis
	public void reflectz(){
		super.reflecto();
	}

	// reflect this over origin
	public void reflecto(){
		super.reflecto();
		if (this.z!=0)
			this.z *= -1;
	}

	// return the distance betwwen this and e
	public double distance(cart3d e){
		return(Math.sqrt((x-e.x)*(x-e.x) + (y-e.y)*(y-e.y) + (z-e.z)*(z-e.z)));
	}

	// return the midpoint betwen this and e
	public cart3d midpoint(cart3d e){
		cart3d c = new cart3d();
		c.x = (this.x+e.x)/2;
		c.y = (this.y+e.y)/2;
		c.z = (this.z+e.z)/2;
		return(c);
	}

	// return area enclosed between this, a, b
	public double area(cart3d a, cart3d b){
		double q = this.distance(a);
		double w = this.distance(b);
		double e = a.distance(b);
		double s = (q+w+e)/2;
		return(Math.sqrt(s*(s-q)*(s-w)*(s-e)));
	}

	// return angle between a and b
	public double angle(cart3d a, cart3d b){
		double q = this.distance(a);
		double w = this.distance(b);
		double e = a.distance(b);
		double theta = Math.acos(((q*q)+(w*w)-(e*e))/(2*q*w))*180/Math.PI;
		return(theta);
	}
}

