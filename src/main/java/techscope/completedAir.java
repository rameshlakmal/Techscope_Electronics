package techscope;

import java.util.Date;

public class completedAir {

	private int raID;
	private int cID;
	private String company;
	private Date date;
	private String description;
	private String spare;
	private int qty;
	private float cost;
	private String type;
	private Date comDate;

public completedAir(int raID, int cID, String company, Date date, String description, String spare, int qty, float cost, String type, Date comDate) {
		super();
		this.raID = raID;
		this.cID = cID;
		this.company = company;
		this.date = date;
		this.description = description;
		this.spare = spare;
		this.qty = qty;
		this.cost = cost;
		this.type = type;
		this.comDate = comDate;
		
		System.out.println(qty);
	}

	public int getRaID() {
		return raID;
	}

	public int getcID() {
		return cID;
	}

	public String getCompany() {
		return company;
	}

	public Date getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public String getSpare() {
		return spare;
	}

	public int getQty() {
		return qty;
	}

	public float getCost() {
		return cost;
	}
	
	public String getType() {
		return type;
	}
	
	public Date getComDate() {
		return comDate;
	}
}
