package manikandan.laptop.com;
import java.sql.Connection;
import java.sql.Statement;
public class computer {
    private String uname;
    private String name;
    private String model_name;
    private int price;
    private String processor_type;
    private String id;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProcessor_type() {
        return processor_type;
    }

    public void setProcessor_type(String processor_type) {
        this.processor_type = processor_type;
    }
    
  

    @Override
	public String toString() {
		return "computer [uname=" + uname + ", name=" + name + ", model_name=" + model_name + ", price=" + price
				+ ", processor_type=" + processor_type + ", id=" + id + "]";
	}

	public void setId(String gtid) {
	        String namePrefix = (name.length() >= 2) ? name.substring(0, 2).toUpperCase() : "";
	        String brandPrefix = (uname.length() >= 2) ? uname.substring(0, 2).toUpperCase() : "";
	        this.id = namePrefix + brandPrefix;
	    }

	public Object getId() {
		return id;
	}
}
