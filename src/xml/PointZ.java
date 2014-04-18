package xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013Äê12ÔÂ17ÈÕ
 * @author Ì·Ïè
 * @version 1.0
 */
@XmlRootElement
public class PointZ extends Point{
	
	private int z;

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "PointZ [z=" + z + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointZ other = (PointZ) obj;
		if (z != other.z)
			return false;
		return true;
	}
	
	
	
}
