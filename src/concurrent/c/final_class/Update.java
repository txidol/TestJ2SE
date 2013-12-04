package concurrent.c.final_class;


import concurrent.a.iexample.IObjBuilder;

/**
 * <p>Copyright:Copyright(c)2013</p>
 * <p>Company:Mopon</p>
 * <p>Description: </p>
 * @date 2013Äê12ÔÂ3ÈÕ
 * @author Ì·Ïè
 * @version 1.0
 */
public class Update implements Comparable<Update> {
	private final Author author;
	private final String updateText;
	 private final long createTime;
	 
	private Update(Builder builder_){
		author = builder_.author;
		updateText = builder_.updateText;
		createTime = builder_.createTime;
	}
	
	public Author getAuthor() {
		return author;
	}

	public String getUpdateText() {
		return updateText;
	}

	public static class Builder implements IObjBuilder<Update>{
		private Author author;
		private String updateText;		
		 public long createTime;
		 
		public Builder author(Author author_){
			author = author_;
			return this;
		}
		
		public Builder updateText(String updateText_){
			updateText = updateText_;
			return this;
		}
		
		public Builder createTime(long createTime_) {
		      createTime = createTime_;
		      return this;
		    }
		
		@Override
		public Update build() {			
			return new Update(this);
		}	
	}
	
	  public int compareTo(Update other_) {
		    if (null == other_)
		      throw new NullPointerException();

		    return (int) (other_.createTime - this.createTime);
		  }

	
	  @Override
	  public boolean equals(Object obj) {
	    if (this == obj)
	      return true;
	    if (obj == null)
	      return false;
	    if (getClass() != obj.getClass())
	      return false;
	    Update other = (Update) obj;
	    if (author == null) {
	      if (other.author != null)
	        return false;
	    } else if (!author.equals(other.author))
	      return false;
	    if (createTime != other.createTime)
	      return false;
	    if (updateText == null) {
	      if (other.updateText != null)
	        return false;
	    } else if (!updateText.equals(other.updateText))
	      return false;
	    return true;
	  }

	  @Override
	  public String toString() {
	    return "Update [author=" + author + ", updateText=" + updateText
	        + ", createTime=" + createTime + "]";
	  }
}
