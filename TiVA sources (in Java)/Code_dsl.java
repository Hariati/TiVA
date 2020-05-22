

import java.util.ArrayList;
import java.util.List;

public class Code_dsl {
	public String sb;
	public List<String> aspect;
	public String weave;
	
	public Code_dsl() {
		super();
		this.sb = "";
		this.aspect = new ArrayList<String>();
		this.weave = "";
	}

	@Override
	public String toString() {
		return "Code_dsl [sb=" + sb + ", aspect=" + aspect + ", weave=" + weave + "]";
	}
	
	

}
