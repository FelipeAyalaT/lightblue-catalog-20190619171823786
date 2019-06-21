package catalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="items")
public class Inventory{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String description;
	
	@NotNull
	private int price;
	
	private String img_alt;
	
	@NotNull
	private String img;
	
	@NotNull
	private int stock;
	
	 public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getDescription() {
    return description;
  }
  
  public void setDescription(String value) {
    this.description = value;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int value) {
    this.price = value;
  }
  
  public String getImg() {
	  return img;
  }
  
  public void setImg(String img) {
	  this.img = img;
  }

  public String getImgAlt() {
    return img_alt;
  }
  
  public void setImgAlt(String img_alt) {
    this.img_alt = img_alt;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int value) {
    this.stock = value;
  }
  
	public Inventory () {};
	
	public Inventory (long id) {
		this.id = id;
	};
	
	public Inventory (String name, String description, int price, String img_alt, String img, int stock) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.img_alt = img_alt;
		this.img = img;
		this.stock = stock;
	};
	
	public String toString()
	{
		StringBuilder sb =new StringBuilder();
		sb.append("{\n");
		sb.append(String.format("\t\"id\": %s,\n",this.id));
		sb.append(String.format("\t\"name\": %s,\n",this.name));
		sb.append(String.format("\t\"description\": %s,\n",this.description));
		sb.append(String.format("\t\"price\": %s,\n",this.price));
		sb.append(String.format("\t\"img_alt\": %s,\n",this.img_alt));
		sb.append(String.format("\t\"img\": %s,\n",this.img));
		sb.append(String.format("\t\"stock\": %s,\n",this.stock));
		sb.append("}");
		return sb.toString();
	}
}