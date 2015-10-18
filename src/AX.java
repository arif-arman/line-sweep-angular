class AX {
	private int coord;
	private int segment;
	private boolean start;

	public AX(int coord, int segment, boolean start) {
		// TODO Auto-generated constructor stub
		this.coord = coord;
		this.segment = segment;
		this.start = start;
	}
	
	int getCoord() {
		return coord;
	}
	
	boolean getStart() {
		return start;
	}
	
	int getSegment() {
		return segment;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = coord + " " + segment + " " + start;
		return s;
	}

}